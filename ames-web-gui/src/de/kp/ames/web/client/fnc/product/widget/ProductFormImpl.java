package de.kp.ames.web.client.fnc.product.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.product.widget
 *  Module: ProductFormImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #form #product #web #widget
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;
import java.util.Set;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;
import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.model.ProductObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class ProductFormImpl extends FormImpl {

	/*
	 * Form dimensions for proper rendering
	 */
	private static int FORM_WIDTH  = 512;
	private static int FORM_HEIGHT = 300;

	public ProductFormImpl() {

		/*
		 * Dimensions
		 */
		this.setWidth(FORM_WIDTH);
		this.setHeight(FORM_HEIGHT);

		/*
		 * Note, that width and height used below are the result
		 * of a boring rendering process to achieve the best user
		 * experience, so be careful when changing these numbers
		 */
		VLayout wrapper = createVLayout(false);
		
		wrapper.setWidth100();
		wrapper.setHeight100();
		
		scForm = new DynamicForm();
		scForm.setTitleSuffix(""); // default ":"
		
		scForm.setColWidths(60, 360);
		scForm.setFixedColWidths(true);
		
		scForm.setPadding(16);
		scForm.setTitleOrientation(TitleOrientation.LEFT);
		
		scForm.setWidth100();

		/*
		 * Build form fields
		 */
		scForm.setFields(createFormItemsAsArray());
		
		scForm.setAutoFocus(true);
		scForm.setLayoutAlign(Alignment.CENTER);
		
		wrapper.setMembers(scForm);
		this.setMembers(wrapper);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#addFormData(com.google.gwt.json.client.JSONValue)
	 */
	public void addFormData(JSONValue jValue) {
		/*
		 * Register form data
		 */
		this.jData = jValue;
		JSONObject jForm = jData.isObject();
		
		Set<String> keys = jForm.keySet();
		for (String key:keys) {
			
			if (key.equals(JaxrConstants.RIM_NAME)) {
				/*
				 * Form data
				 */
				FormItem field = scForm.getField(key);
				if (field != null) field.setValue(jForm.get(key).isString().stringValue());
				
			} else if (key.equals(JaxrConstants.RIM_DESC)) {
				/*
				 * Form data
				 */
				FormItem field = scForm.getField(key);
				if (field != null) field.setValue(jForm.get(key).isString().stringValue());
				
			}
			
		}
		
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#getFormData()
	 */
	public String getFormData() {

		JSONObject jForm = new JSONObject();
		
		/*
		 * Name & description
		 */
		String name = "";
		String desc = "";
		
		FormItem[] items = scForm.getFields();
		for (FormItem item:items) {
			
			if (JaxrConstants.RIM_NAME.equals(item.getName())) {
				name = (String)item.getValue();
				
			} else if (JaxrConstants.RIM_DESC.equals(item.getName())) {
				desc = (String)item.getValue();
				
			}
			
		}
		
		jForm.put(JaxrConstants.RIM_NAME, new JSONString(name));
		jForm.put(JaxrConstants.RIM_DESC, new JSONString(desc));
		
		/*
		 * Classification
		 */
		JSONArray jClas = new JSONArray();
		jClas.set(0, new JSONString(ClassificationConstants.FNC_ID_Product));
		
		jForm.put(JaxrConstants.RIM_CLAS, new JSONString(jClas.toString()));		

		return jForm.toString();
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		return new ProductObject().createFormItemsAsList();
	}

}
