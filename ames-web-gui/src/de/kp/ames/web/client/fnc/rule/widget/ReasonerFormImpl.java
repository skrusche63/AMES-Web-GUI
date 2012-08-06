package de.kp.ames.web.client.fnc.rule.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.core.slot.data.SlotGridImpl;
import de.kp.ames.web.client.core.spec.data.SpecGridImpl;
import de.kp.ames.web.client.core.spec.handler.SpecGridMenuHandlerImpl;
import de.kp.ames.web.client.fnc.rule.RuleController;
import de.kp.ames.web.client.model.ReasonerObject;
import de.kp.ames.web.client.model.SlotObject;
import de.kp.ames.web.client.model.SpecObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class ReasonerFormImpl extends FormImpl {

	private static String SLOTS = "Slots";
	private static String SPECS = "Rules";
	
	/*
	 * Form dimensions for proper rendering
	 */
	private static int FORM_WIDTH  = 512;
	private static int FORM_HEIGHT = 532;
	
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
	public ReasonerFormImpl(FormAction action) {

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
		
		scForm.setColWidths(60, 320);
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
		
		/*
		 * Build SpecGrid
		 */
		tabSet.addTab(createSpecTab());
		layout.addMember(tabSet);
		
		wrapper.setMembers(scForm, layout);
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
				
			} else if (key.equals(JaxrConstants.RIM_SLOT)) {
				/*
				 * Slot data
				 */
				String val = jForm.get(key).isString().stringValue();
				JSONObject jSlots = JSONParser.parseStrict(val).isObject();
				
				slotGrid.setSlots(jSlots);
				
			} else if (key.equals(JaxrConstants.RIM_SPEC)) {
				/*
				 * Spec data
				 */
				String val = jForm.get(key).isString().stringValue();
				JSONArray jSpecs = JSONParser.parseStrict(val).isArray();
				
				specGrid.setSpecifications(jSpecs);
				
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
		jClas.set(0, new JSONString(ClassificationConstants.FNC_ID_Reasoner));
		
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
		return new ReasonerObject().createFormItemsAsList();
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

	/**
	 * Create layout component for specs
	 * 
	 * @return
	 */
	private Tab createSpecTab() {
		
		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Specification);

		specGrid = new SpecGridImpl();
		
		SpecGridMenuHandlerImpl menuHandler = new SpecGridMenuHandlerImpl();		
		menuHandler.setParams(attributes);
		
		/*
		 * The responsible controller for the handling of
		 * accessor related specification is the RuleController
		 */
		menuHandler.setController(new RuleController());
		specGrid.addMenuHandler(menuHandler);
		
        Tab tab = new Tab();   	
        tab.setWidth(80);
        
        tab.setTitle(SPECS);

        /*
         * Tab content
         */
        tab.setPane(specGrid);
		return tab;
		
	}

}