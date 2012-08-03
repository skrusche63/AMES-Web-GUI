package de.kp.ames.web.client.fnc.product.widget;

import java.util.ArrayList;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.fnc.ns.data.NsGridImpl;
import de.kp.ames.web.client.model.ProductObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class ProductorApplyFormImpl extends FormImpl {

	private static String NAMESPACES = "Namespaces";
	
	/*
	 * Form dimensions for proper rendering
	 */
	private static int FORM_WIDTH  = 512;
	private static int FORM_HEIGHT = 532;
	
	/*
	 * Reference to NsGrid
	 */
	private NsGridImpl nsGrid;

	/**
	 * Constructor
	 */
	public ProductorApplyFormImpl(FormAction action) {

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
		 * Build Nsrid
		 */
		tabSet.addTab(createNamespaceTab());
		
		wrapper.setMembers(scForm, layout);
		this.setMembers(wrapper);

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
		String date = "";
		
		FormItem[] items = scForm.getFields();
		for (FormItem item:items) {
			
			if (JaxrConstants.RIM_NAME.equals(item.getName())) {
				name = (String)item.getValue();
				
			} else if (JaxrConstants.RIM_DESC.equals(item.getName())) {
				desc = (String)item.getValue();

			} else if (JaxrConstants.RIM_DATE.equals(item.getName())) {
				date = (String)item.getValue();

			}
			
		}
		
		jForm.put(JaxrConstants.RIM_NAME, new JSONString(name));
		jForm.put(JaxrConstants.RIM_DESC, new JSONString(desc));
		jForm.put(JaxrConstants.RIM_DATE, new JSONString(date));
		
		/*
		 * Classification
		 */
		JSONArray jClas = new JSONArray();
		jClas.set(0, new JSONString(ClassificationConstants.FNC_ID_Product));
		
		jForm.put(JaxrConstants.RIM_CLAS, new JSONString(jClas.toString()));		
		
		return jForm.toString();
	
	}

	/**
	 * @return
	 */
	public String getSource() {
		
		Record selected = nsGrid.getSelectedRecord();
		if (selected == null) return null;
		
		return selected.getAttributeAsString(JaxrConstants.RIM_ID);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		return new ProductObject().createFormItemsAsList();
	}
	
	/**
	 * Create layout component for namespaces
	 * 
	 * @return
	 */
	private Tab createNamespaceTab() {
		
		/*
		 * Build SlotGrid
		 */
		nsGrid = new NsGridImpl();
		nsGrid.setSelectionType(SelectionStyle.SINGLE);

        Tab tab = new Tab();   	
        tab.setWidth(80);

        tab.setTitle(NAMESPACES);
 
        /*
         * Tab content
         */
        tab.setPane(nsGrid);
		return tab;
		
	}

}
