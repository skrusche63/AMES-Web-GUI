package de.kp.ames.web.client.core.form;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.layout.VLayout;

public class FormImpl extends VLayout implements Form {

	/*
	 * Reference to Form Handler
	 */
	protected FormHandler formHandler;
	
	/*
	 * Reference to Form Data
	 */
	protected JSONValue jData;
	
	/*
	 * Indicate read onyl form
	 */
	protected boolean readOnly;
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.Form#addFormData(com.google.gwt.json.client.JSONValue)
	 */
	public void addFormData(JSONValue jValue) {
		this.jData = jValue;
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.Form#getFormData()
	 */
	public String getFormData() {
		/*
		 * Must be overridden
		 */
		return null;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.Form#addFormHandler(de.kp.ames.web.client.core.form.FormHandler)
	 */
	public void addFormHandler(FormHandler formHandler) {
		this.formHandler = formHandler;
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.Form#setReadOnly(boolean)
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

}
