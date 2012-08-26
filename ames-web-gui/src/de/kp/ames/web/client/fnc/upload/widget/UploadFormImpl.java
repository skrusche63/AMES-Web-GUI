package de.kp.ames.web.client.fnc.upload.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.upload.widget
 *  Module: UploadFormImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #form #upload #web #widget
 * </SemanticAssist>
 *
 */


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
import de.kp.ames.web.client.core.globals.GuiConstants;
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
		
		iFrame.setWidth("1");
		iFrame.setHeight("1");
		
		iFrame.setVisible(false);
		
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
		String item = KeyGenerator.getInstance().getKey();
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
		return GuiConstants.REG_URL + "/" + ServiceConstants.UPLOAD_SERVICE_ID;
		
	}

}
