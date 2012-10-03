package de.kp.ames.web.client.fnc.ns.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.ns.widget
 *  Module: NsFormImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #form #ns #web #widget
 * </SemanticAssist>
 *
 */

import java.util.ArrayList;
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

import de.kp.ames.web.client.core.clas.data.ClasGridImpl;
import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.core.slot.data.SlotGridImpl;
import de.kp.ames.web.client.model.NsObject;
import de.kp.ames.web.client.model.SlotObject;
import de.kp.ames.web.client.model.core.ConceptObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class NsFormImpl extends FormImpl {

	private static String SLOTS = "Slots";
	private static String CLAS  = "Concepts";

	/*
	 * Form dimensions for proper rendering
	 */
	private static int FORM_WIDTH  = 512;
	private static int FORM_HEIGHT = 504;
	
	/*
	 * Reference to SlotGrid
	 */
	private SlotGridImpl slotGrid;

	/*
	 * Reference to ClasGrid
	 */
	private ClasGridImpl clasGrid;

	/**
	 * Constructor
	 */
	public NsFormImpl(FormAction action) {

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
		 * Build ClasGrid
		 */
		tabSet.addTab(createClasTab());

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
				 * Form data (visible field)
				 */
				FormItem field = scForm.getField(key);
				if (field != null) field.setValue(jForm.get(key).isString().stringValue());
				
			} else if (key.equals(JaxrConstants.RIM_DESC)) {
				/*
				 * Form data (visible field)
				 */
				FormItem field = scForm.getField(key);
				if (field != null) field.setValue(jForm.get(key).isString().stringValue());

			} else if (key.equals(JaxrConstants.RIM_ID)) {
				/*
				 * Form data (hidden field)
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
				
			} else if (key.equals(JaxrConstants.RIM_CLAS)) {
				/*
				 * Classification (concept) data
				 */
				String val = jForm.get(key).isString().stringValue();
				JSONObject jClas = JSONParser.parseStrict(val).isObject();
				
				clasGrid.setClas(jClas);
				
			}
		}
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#getFormData()
	 */
	public String getFormData() {
		return getJFormData().toString();
	}

	public JSONObject getJFormData() {

		JSONObject jForm = new JSONObject();
		
		/*
		 * Hidden identifier
		 */
		String id = null;

		/*
		 * Name & description
		 */
		String name = null;
		String desc = null;
		
		FormItem[] items = scForm.getFields();
		for (FormItem item:items) {
			
			if (JaxrConstants.RIM_NAME.equals(item.getName())) {

				name = (String)item.getValue();
				if (name == null) name = "(No name provided)";
				
			} else if (JaxrConstants.RIM_DESC.equals(item.getName())) {
				desc = (String)item.getValue();
				if (desc == null) desc = "(No description provided)";
				
			} else if (JaxrConstants.RIM_ID.equals(item.getName())) {
				id = (String)item.getValue();
				
			}
			
		}
		
		jForm.put(JaxrConstants.RIM_NAME, new JSONString(name));
		jForm.put(JaxrConstants.RIM_DESC, new JSONString(desc));
		
		/*
		 * Provide hidden identifier
		 */
		if (id != null) jForm.put(JaxrConstants.RIM_ID, new JSONString(id));
		
					
		/*
		 * Classification
		 */
		JSONArray jClas = new ConceptObject().toJArray(clasGrid.getRecords());

		/*
		 * force add mandatory classification
		 */
		jClas.set(jClas.size(), new JSONString(ClassificationConstants.FNC_ID_Folder));
		
		jForm.put(JaxrConstants.RIM_CLAS, new JSONString(jClas.toString()));		

		/*
		 * Slots
		 */
		JSONObject jSlot = new SlotObject().toJObject(slotGrid.getRecords());
		jForm.put(JaxrConstants.RIM_SLOT, new JSONString(jSlot.toString()));
		
		return jForm;
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		return new NsObject().createFormItemsAsList();
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
	 * Create layout component for concepts
	 * 
	 * @return
	 */
	private Tab createClasTab() {
		
		/*
		 * Build ConceptGrid
		 */
		clasGrid = new ClasGridImpl();
		
        Tab tab = new Tab();   	
        tab.setWidth(80);

        tab.setTitle(CLAS);
 
        /*
         * Tab content
         */
        tab.setPane(clasGrid);
		return tab;
		
	}
}
