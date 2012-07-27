package de.kp.ames.web.client.fnc.upload.widget;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.upload.event.UploadEventManager;
import de.kp.ames.web.client.fnc.upload.event.UploadListener;
import de.kp.ames.web.shared.constants.JsonConstants;

public class UploadCreateDialog extends CreateFormDialog implements UploadListener {

	/**
	 * Constructor
	 */
	public UploadCreateDialog() {
		super(FncGlobals.UPLOAD_C_TITLE, FncGlobals.UPLOAD_C_SLOGAN);
		
		/*
		 * Dialog Title
		 */
		this.setTitle(FncGlobals.UPLOAD_TITLE);
		
		/*
		 * Dialog Dimensions
		 */
		this.setWidth(380);
		this.setHeight(320);
		
		/*
		 * No auto close
		 */
		this.setAutoClose(false);

		/*
		 * Context specific event handling
		 */
		UploadEventManager.getInstance().addUploadListener(this);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new UploadFormImpl();
		this.form.addFormHandler(this);

		/*
		 * Propagate request params
		 */
		this.form.setParams(this.getParams());		
		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {
		/*
		 * Initiate upload directly on the
		 * respective form;
		 */
		this.form.doSubmit(this.sendActivity);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#beforeRemove()
	 */
	public void beforeRemove() {
		UploadEventManager.getInstance().removeUploadListener(this);	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.upload.event.UploadListener#onSuccess()
	 */
	public void onSuccess() {

		JSONObject jResponse = new JSONObject();
		
		jResponse.put(JsonConstants.J_SUCCESS, JSONBoolean.getInstance(true));
		jResponse.put(JsonConstants.J_MESSAGE, new JSONString(FncGlobals.UPLOAD_SUCCESS_MESSAGE));

		sendActivity.execute(jResponse);
		
	}	

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.upload.event.UploadListener#onFailure()
	 */
	public void onFailure() {

		JSONObject jResponse = new JSONObject();
		
		jResponse.put(JsonConstants.J_SUCCESS, JSONBoolean.getInstance(false));
		jResponse.put(JsonConstants.J_MESSAGE, new JSONString(FncGlobals.UPLOAD_ERROR_MESSAGE));

		sendActivity.execute(jResponse);

	}	
}
