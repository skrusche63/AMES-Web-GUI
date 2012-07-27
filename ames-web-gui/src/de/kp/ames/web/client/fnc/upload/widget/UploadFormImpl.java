package de.kp.ames.web.client.fnc.upload.widget;

import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.NamedFrame;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.fields.DataSourceBinaryField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
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
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class UploadFormImpl extends FormImpl {

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
	public void doSubmit(final Activity afterSubmitActivity) {
		/*
		 * Upload uses the native form-based mechanism
		 * to transport a certain file to the server
		 */
		
		//scForm.setAction(getUri());	
		scForm.setAction("http://localhost:8080/ames/upload.htm");		
		scForm.submitForm();
		
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
	
	private Map<String,String> getRequestParams() {

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
		
		return requestMethod.toParams();
		
	}

	private DataSource createDataSource() {
		
		/*
		 * Retrieve request url
		 */
		String requestUrl = getRequestUrl();

		/*
		 * Retrieve request fields from attributes
		 */
		DataSourceField[] requestFields = createDataFields();

		DataSource ds = new DataSource() {
			  
			protected Object transformRequest(DSRequest dsRequest) {  
				dsRequest.setParams(getRequestParams());	
				return super.transformRequest(dsRequest);  
			}  

			protected void transformResponse(DSResponse response, DSRequest request, Object data) { 
				super.transformResponse(response, request, data);  
			}  
			
		};
		
		
		ds.setDataURL(requestUrl);		
		ds.setFields(requestFields);

		OperationBinding add = new OperationBinding();
		add.setOperationType(DSOperationType.ADD);
		add.setDataProtocol(DSProtocol.POSTPARAMS);

		OperationBinding update = new OperationBinding();
		update.setOperationType(DSOperationType.UPDATE);
		update.setDataProtocol(DSProtocol.POSTPARAMS);

		OperationBinding remove = new OperationBinding();
		remove.setOperationType(DSOperationType.REMOVE);
		remove.setDataProtocol(DSProtocol.POSTPARAMS);
		
		ds.setOperationBindings(add);

		
		
		return ds;
		
	}
	
	public DataSourceField[] createDataFields() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();
		
		DataSourceBinaryField uploadField = new DataSourceBinaryField();
		uploadField.setEditorType(GuiFormFactory.createScFileUploadItem(JaxrConstants.RIM_FILE, 280));
		
		fields.add(uploadField);
		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);

	}

}
