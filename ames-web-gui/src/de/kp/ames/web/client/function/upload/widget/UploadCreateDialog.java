package de.kp.ames.web.client.function.upload.widget;

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.function.globals.FncGlobals;

public class UploadCreateDialog extends CreateFormDialog {

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

}
