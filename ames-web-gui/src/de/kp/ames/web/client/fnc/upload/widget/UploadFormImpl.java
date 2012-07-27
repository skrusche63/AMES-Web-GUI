package de.kp.ames.web.client.fnc.upload.widget;

import java.util.ArrayList;
import com.google.gwt.user.client.ui.NamedFrame;
import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.form.FileUploadItem;
import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.core.util.KeyGenerator;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class UploadFormImpl extends FormImpl {

	/**
	 * Constructor
	 */
	public UploadFormImpl() {

		/*
		 * Note, that width and height used below are the result
		 * of a boring rendering process to achieve the best user
		 * experience, so be careful when changing these numbers
		 */
		VLayout wrapper = new VLayout();
		
		wrapper.setWidth100();
		wrapper.setHeight100();
		
		scForm = new DynamicForm();
		scForm.setEncoding(Encoding.MULTIPART);
		//scForm.setMethod(FormMethod.POST);

		scForm.setWidth100();
		scForm.setHeight(64);

		 
		scForm.setTitleSuffix(""); // default ":"
		 
		scForm.setColWidths(0, 340);
		scForm.setFixedColWidths(true);
		 
		scForm.setFields(createFormItemsAsArray());
		//scForm.setDataSource(createDataSource());
		
		wrapper.addMember(scForm);
		
		/*
		 * Hidden iFrame
		 */
		NamedFrame iFrame = new NamedFrame("uploadFrame");
		iFrame.setWidth("100");
		iFrame.setHeight("40");
		
		scForm.setTarget("uploadFrame");
		
		wrapper.addMember(iFrame);
		this.setMembers(wrapper);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		
		ArrayList<FormItem> items = new ArrayList<FormItem>();
		
		/*
		 * UplodItem
		 */
		FileUploadItem uploadItem = GuiFormFactory.createScFileUploadItem(JaxrConstants.RIM_FILE, 280);
		items.add(uploadItem);
		
		return items;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#doSubmit(de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doSubmit(Activity sendActivity) {
		/*
		 * Upload uses the native form-based mechanism
		 * to transport a certain file to the server
		 */
		
		scForm.setAction(getUri());	
		scForm.submitForm();
		
	}
	
	/**
	 * A helper method to retrieve the form action url
	 * 
	 * @return
	 */
	private String getUri() {

		/*
		 * Add key for cache entry
		 */
		String type = this.params.get(MethodConstants.ATTR_TYPE);
		String item = KeyGenerator.getInstance().getKey(type);

		this.params.put(MethodConstants.ATTR_ITEM, item);
		
		/*
		 * Build method
		 */
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_SET);

		requestMethod.setAttributes(this.params);
		
		/*
		 * Build request uri
		 */
		return getRequestUrl() + requestMethod.toQuery();
		
	}
		
	/**
	 * Build base request url for mulitpart request
	 * 
	 * @return
	 */
	private String getRequestUrl() {
		return CoreGlobals.REG_URL + "/" + ServiceConstants.UPLOAD_SERVICE_ID;
		
	}

}
