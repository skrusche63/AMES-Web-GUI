package de.kp.ames.web.client.function.access.widget;

import java.util.ArrayList;

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
import de.kp.ames.web.client.core.slot.SlotGridImpl;
import de.kp.ames.web.client.function.transform.data.SpecGridImpl;
import de.kp.ames.web.client.model.AccessorObject;
import de.kp.ames.web.client.model.SlotObject;
import de.kp.ames.web.client.model.SpecObject;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.JaxrConstants;

public class AccessorFormImpl extends FormImpl {

	/*
	 * Reference to SlotGrid
	 */
	private SlotGridImpl slotGrid;
	
	/*
	 * Reference to the SpecGrid
	 */
	private SpecGridImpl specGrid;

	/**
	 * Constructor
	 */
	public AccessorFormImpl() {
		
		/*
		 * Note, that width and height used below are the result
		 * of a boring rendering process to achieve the best user
		 * experience, so be careful when changing these numbers
		 */
		VLayout wrapper = new VLayout();
		
		wrapper.setWidth100();
		wrapper.setHeight100();
		
		scForm = new DynamicForm();
		scForm.setTitleSuffix(""); // default ":"
		
		scForm.setColWidths(60, 480);
		scForm.setFixedColWidths(true);
		
		scForm.setPadding(8);
		scForm.setTitleOrientation(TitleOrientation.LEFT);
		
		scForm.setWidth100();

		/*
		 * Build form fields
		 */
		scForm.setFields(createFormItemsAsArray());
		
		scForm.setAutoFocus(true);
		scForm.setLayoutAlign(Alignment.CENTER);
		
		/*
		 * Build SlotGrid
		 */
		slotGrid = new SlotGridImpl();
		
		/*
		 * Build SpecGrid
		 */
		specGrid = new SpecGridImpl();
		
		wrapper.setMembers(scForm, slotGrid, specGrid);
		this.setMembers(wrapper);

	}

	public void addFormData(JSONValue jValue) {
		/*
		 * Register form data
		 */
		this.jData = jValue;
		
		/*
		 * Assign form data
		 */
		
		/*
		 * Assign slot data
		 */
		
		/*
		 * Assign specification data
		 */
		
		
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
		jClas.set(0, new JSONString(ClassificationConstants.FNC_ID_Accessor));
		
		jForm.put(JaxrConstants.RIM_CLAS, new JSONString(jClas.toString()));		
				
		/*
		 * Slots
		 */
		JSONObject jSlot = new SlotObject().toJObject(specGrid.getRecords());
		jForm.put(JaxrConstants.RIM_SPEC, jSlot);
		
		/*
		 * Specifications
		 */
		JSONArray jSpecs = new SpecObject().toJArray(specGrid.getRecords());
		jForm.put(JaxrConstants.RIM_SPEC, new JSONString(jSpecs.toString()));
		
		return jForm.toString();
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		return new AccessorObject().createFormItemsAsList();
	}
	
}
