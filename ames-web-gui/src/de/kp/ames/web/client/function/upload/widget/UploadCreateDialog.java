package de.kp.ames.web.client.function.upload.widget;

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;

public class UploadCreateDialog extends CreateFormDialog {

	private static String TITLE  = GUIGlobals.APP_TITLE + ": Upload Editor";;
	private static String SLOGAN = "Use this widget to upload files to server cache.";

	/**
	 * Constructor
	 */
	public UploadCreateDialog() {
		super(TITLE, SLOGAN);
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
