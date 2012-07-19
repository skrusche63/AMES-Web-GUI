package de.kp.ames.web.client.core.form;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.handler.FormHandler;

public class FormImpl extends VLayout implements Form {

	protected static String LABEL_STYLE = "x-sc-label";

	/*
	 * Reference to dynamic form
	 */
	protected DynamicForm scForm;
	
	/*
	 * Reference to Form Handler
	 */
	protected FormHandler formHandler;

	/*
	 * Request specific parameters
	 */
	protected HashMap<String,String> params;
	
	/*
	 * Reference to Form Data
	 */
	protected JSONValue jData;
	
	/*
	 * Indicate read onyl form
	 */
	protected boolean readOnly;

	/**
	 * Set a certain request specific parameter
	 * 
	 * @param key
	 * @param value
	 */
	public void setParam(String key, String value) {
		if (this.params == null) this.params = new HashMap<String,String>();
		this.params.put(key, value);
	}
	
	/**
	 * Get a certain request specific parameter
	 * 
	 * @param key
	 * @return
	 */
	public String getParam(String key) {
		if ((this.params == null) || (this.params.containsKey(key) == false)) return null;
		return this.params.get(key);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.Form#addFormData(com.google.gwt.json.client.JSONValue)
	 */
	public void addFormData(JSONValue jValue) {
		this.jData = jValue;
		/*
		 * Must be overridden
		 */
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

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.Form#createFormItemsAsArray()
	 */
	public FormItem[] createFormItemsAsArray() {
		
		ArrayList<FormItem> items = createFormItemsAsList();
		return (FormItem[])items.toArray(new FormItem [items.size()]);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.Form#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		/*
		 * Must be overridden
		 */
		return null;
	}

}
