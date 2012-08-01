package de.kp.ames.web.client.fnc.dms.widget;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.core.slot.data.SlotGridImpl;

public class DmsFormImpl extends FormImpl {

	public enum FormAction {
		CREATE, EDIT, GET
	};

	private static String SLOTS = "Slots";
	
	/*
	 * Form dimensions for proper rendering
	 */
	private static int FORM_WIDTH  = 512;
	private static int FORM_HEIGHT = 532;

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
		 * Dimensions
		 */
		this.setWidth(FORM_WIDTH);
		this.setHeight(FORM_HEIGHT);

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
		
		scForm.setColWidths(60, 320);
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
		 * Create Tabs
		 */
		VLayout layout = new VLayout();
		layout.setShowEdges(false);
		
		layout.setWidth(480);
		
		layout.setLayoutMargin(16);
		layout.setLayoutTopMargin(0);
		
		TabSet tabSet = createTabSet();
		
		tabSet.setWidth(480);
		tabSet.setHeight(320);

		/*
		 * Build SlotGrid
		 */
		tabSet.addTab(createSlotTab());
				
		wrapper.setMembers(scForm, layout);
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

	/**
	 * Create layout component for slots
	 * 
	 * @return
	 */
	private Tab createSlotTab() {
		
		/*
		 * Build SlotGrid
		 */
		slotGrid = new SlotGridImpl();

        Tab tab = new Tab();   	
        tab.setWidth(80);

        tab.setTitle(SLOTS);
 
        /*
         * Tab content
         */
        tab.setPane(slotGrid);
		return tab;
		
	}

}
