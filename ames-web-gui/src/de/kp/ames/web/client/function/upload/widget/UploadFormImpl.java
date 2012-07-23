package de.kp.ames.web.client.function.upload.widget;

import java.util.ArrayList;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.UploadItem;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.function.globals.FncGlobals;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class UploadFormImpl extends FormImpl {
	/*
	 * Reference to label style for form items
	 */
	private static String LABEL_STYLE = "x-sc-label";

	/*
	 * Success Http Response Code
	 */
	private static final int STATUS_CODE_OK = 200;

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

		scForm.setWidth100();
		scForm.setHeight(64);

		/*
		 * Build form content from native Html; this way is used
		 * to beautify the original <input> file component
		 */
		scForm.addChild(GuiFormFactory.createScUploadHtml("", JaxrConstants.RIM_FILE, 280));

		/*
		 * Below is an alternate setup of 
		 * 
		 * scForm.setTitleSuffix(""); // default ":"
		 * 
		 * scForm.setColWidths(60, 480);
		 * scForm.setFixedColWidths(true);
		 * 
		 * scForm.setPadding(8);
		 * scForm.setTitleOrientation(TitleOrientation.LEFT);
		 * 
		 * scForm.setFields(createFormItemsAsArray());
		 * 
		 * scForm.setAutoFocus(true);
		 * scForm.setLayoutAlign(Alignment.CENTER);
		 */

		wrapper.setMembers(scForm);
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
		UploadItem uploadItem = GuiFormFactory.createScUploadItem("<b>File</b>:", JaxrConstants.RIM_FILE, LABEL_STYLE, 320);
		items.add(uploadItem);
		
		return items;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#doSubmit(de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doSubmit(final Activity afterSubmitActivity) {
		/*
		 * Upload uses the native form-based mechanism
		 * to transport a certain file to the server
		 */
		scForm.setAction(getUri());	
		scForm.submit(new DSCallback() {

			/* (non-Javadoc)
			 * @see com.smartgwt.client.data.DSCallback#execute(com.smartgwt.client.data.DSResponse, java.lang.Object, com.smartgwt.client.data.DSRequest)
			 */
			public void execute(DSResponse response, Object rawData, DSRequest request) {
				int status = response.getHttpResponseCode();
				if (status == STATUS_CODE_OK) {
					handleSuccess(afterSubmitActivity);
				
				} else {
					handleError(afterSubmitActivity);
					
				}
				
			}
			
		});
		
	}

	/**
	 * A helper method to inform the user about
	 * successful file upload
	 * 
	 * @param afterSubmitActivity
	 */
	private void handleSuccess(final Activity afterSubmitActivity) {

		JSONObject jResponse = new JSONObject();
		
		jResponse.put(JsonConstants.J_SUCCESS, JSONBoolean.getInstance(true));
		jResponse.put(JsonConstants.J_MESSAGE, new JSONString(FncGlobals.UPLOAD_SUCCESS_MESSAGE));

		afterSubmitActivity.execute(jResponse);
		
	}
	
	/**
	 * A helper method to handle server-side error
	 * 
	 * @param afterSubmitActivity
	 */
	private void handleError(final Activity afterSubmitActivity) {

		JSONObject jResponse = new JSONObject();
		
		jResponse.put(JsonConstants.J_SUCCESS, JSONBoolean.getInstance(false));
		jResponse.put(JsonConstants.J_MESSAGE, new JSONString(FncGlobals.UPLOAD_ERROR_MESSAGE));

		afterSubmitActivity.execute(jResponse);

	}
	
	/**
	 * A helper method to retrieve the form action url
	 * 
	 * @return
	 */
	private String getUri() {

		/*
		 * Build method
		 */
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_SET);

		requestMethod.setAttributes(this.params);
		
		/*
		 * Add key for cache entry
		 */

		// TODO
		
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
