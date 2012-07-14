package de.kp.ames.web.client.function.group.widget;

import java.util.Set;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.core.form.FormImpl;

public class GroupFormImpl extends FormImpl {

	/**
	 * Constructor
	 */
	public GroupFormImpl() {
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#addFormData(com.google.gwt.json.client.JSONValue)
	 */
	public void addFormData(JSONValue jValue) {
		
		JSONObject jForm = jValue.isObject();
		Set<String> keys = jForm.keySet();
		
		
		// fill data into prepared form items
		
	}

}
