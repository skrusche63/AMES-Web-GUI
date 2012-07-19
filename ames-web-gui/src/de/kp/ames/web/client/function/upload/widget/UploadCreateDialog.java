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

		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {
		// TODO
	}	

}
