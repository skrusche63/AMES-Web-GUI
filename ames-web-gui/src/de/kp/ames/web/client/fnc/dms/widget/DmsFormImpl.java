package de.kp.ames.web.client.fnc.dms.widget;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.core.slot.data.SlotGridImpl;

public class DmsFormImpl extends FormImpl {

	public enum FormAction {
		CREATE, EDIT, GET
	};
	
	/*
	 * Reference to SlotGrid
	 */
	private SlotGridImpl slotGrid;

	/**
	 * Constructor
	 * 
	 * @param action
	 */
	public DmsFormImpl(FormAction action) {

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
		
		wrapper.setMembers(scForm, slotGrid);
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
		// TODO
		
		/*
		 * Assign slot data
		 */
		// TODO
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		// TODO
		return null;
	}

}
