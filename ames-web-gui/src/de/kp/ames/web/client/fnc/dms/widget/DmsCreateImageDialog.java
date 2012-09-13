package de.kp.ames.web.client.fnc.dms.widget;

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.shared.constants.ClassificationConstants;

public class DmsCreateImageDialog extends DmsCreateDialog {

	/**
	 * Constructor
	 */
	public DmsCreateImageDialog() {
		super();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new DmsFormImpl(FormAction.CREATE, ClassificationConstants.FNC_ID_Image);
		this.form.addFormHandler(this);

		return this.form;
		
	}

}
