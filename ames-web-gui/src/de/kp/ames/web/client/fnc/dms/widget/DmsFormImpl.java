package de.kp.ames.web.client.fnc.dms.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.dms.widget
 *  Module: DmsFormImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #dms #fnc #form #web #widget
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
import de.kp.ames.web.client.fnc.upload.data.UploadGridImpl;
import de.kp.ames.web.client.model.DmsObject;
import de.kp.ames.web.client.model.SlotObject;
import de.kp.ames.web.client.model.core.ConceptObject;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class DmsFormImpl extends FormImpl {

	private static String SLOTS = "Slots";
	private static String CACHE = "Cache";
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

	/*
	 * Reference to UploadGrid
	 */
	private UploadGridImpl uploadGrid;
	
	/*
	 * Reference to action
	 */
	private FormAction action;

	/**
	 * Constructor
	 * @param action
	 */
	public DmsFormImpl(FormAction action) {
		this(action, null);
	}
	
	/**
	 * Constructor with explicit cache type
	 * @param action
	 */
	public DmsFormImpl(FormAction action, String cacheType) {
		
		this.action = action;
		
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
		
		/*
		 * Build UploadGrid if action is create
		 */
		if (action.equals(FormAction.CREATE)) {
			tabSet.addTab(createUploadTab(cacheType));
		}
			
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

			} else if (key.equals(JaxrConstants.RIM_CLAS)) {
				/*
				 * Classification (concept) data
				 */
				String val = jForm.get(key).isString().stringValue();
				JSONObject jClas = JSONParser.parseStrict(val).isObject();
				
				clasGrid.setClas(jClas);

			} else if (key.equals(JaxrConstants.RIM_ID)) {
				/*
				 * Id data
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
		String id = null;
		
		FormItem[] items = scForm.getFields();
		for (FormItem item:items) {
			
			if (JaxrConstants.RIM_NAME.equals(item.getName())) {
				name = (String)item.getValue();
				
			} else if (JaxrConstants.RIM_DESC.equals(item.getName())) {
				desc = (String)item.getValue();
				
			} else if (JaxrConstants.RIM_ID.equals(item.getName())) {
				id = (String)item.getValue();

			}
			
		}
		
		jForm.put(JaxrConstants.RIM_NAME, new JSONString(name));
		jForm.put(JaxrConstants.RIM_DESC, new JSONString(desc));
		
		/*
		 * RIM-Id
		 */
		if (id != null)
			jForm.put(JaxrConstants.RIM_ID, new JSONString(id));

		/*
		 * Classification
		 */
		JSONArray jClas = new ConceptObject().toJArray(clasGrid.getRecords());

		/*
		 * force add mandatory classification
		 */
		String type = this.params.get(MethodConstants.ATTR_TYPE);
		jClas.set(jClas.size(), new JSONString(type));
		
		jForm.put(JaxrConstants.RIM_CLAS, new JSONString(jClas.toString()));		

		/*
		 * Slots
		 */
		JSONObject jSlot = new SlotObject().toJObject(slotGrid.getRecords());
		jForm.put(JaxrConstants.RIM_SLOT, new JSONString(jSlot.toString()));

		
		if (action.equals(FormAction.CREATE)) {			
			/*
			 * Upload key
			 */
			jForm.put(JsonConstants.J_KEY, new JSONString(uploadGrid.getSelectedRecord().getAttributeAsString(JsonConstants.J_KEY)));
		}

		return jForm.toString();
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		return new DmsObject().createFormItemsAsList();
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

	/**
	 * Create layout component for cache selection
	 * 
	 * @return
	 */
	private Tab createUploadTab(String cacheType) {

		/*
		 * Build UploadGrid
		 */
		uploadGrid = new UploadGridImpl(cacheType);
				
        Tab tab = new Tab();   	
        tab.setWidth(80);

        tab.setTitle(CACHE);
 
        /*
         * Tab content
         */
        tab.setPane(uploadGrid);
		return tab;

	}

}
