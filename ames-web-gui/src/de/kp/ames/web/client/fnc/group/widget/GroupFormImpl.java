package de.kp.ames.web.client.fnc.group.widget;

import java.util.Set;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

import de.kp.ames.web.client.core.form.DefaultFormImpl;
import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.fnc.group.data.CategoryGridImpl;
import de.kp.ames.web.client.model.party.GroupNameObject;
import de.kp.ames.web.client.model.party.PostalObject;
import de.kp.ames.web.client.model.party.TelephoneObject;

public class GroupFormImpl extends FormImpl {
	/*
	 * Form dimensions for proper rendering
	 */
	private static int FORM_WIDTH  = 512;
	private static int FORM_HEIGHT = 352;
	
	
	private static String CATEGORY         = "Categories";
	private static String GROUP_NAME       = "Name";
	private static String POSTAL_ADDRESS   = "Address";
	private static String TELEPHONE_NUMBER = "Telephone";
	
	/*
	 * Reference to GroupName
	 */
	private DefaultFormImpl groupName;
	
	/*
	 * Reference to PostalAddress
	 */
	private DefaultFormImpl postalAddress;
	
	/*
	 * Reference to Telephone Number
	 */
	private DefaultFormImpl telephoneNumber;
	
	/**
	 * Constructor
	 */
	public GroupFormImpl() {

		/*
		 * Dimensions
		 */
		this.setWidth(FORM_WIDTH);
		this.setHeight(FORM_HEIGHT);

		/*
		 * Create Tabs
		 */
		VLayout layout = new VLayout();
		layout.setShowEdges(false);
		
		layout.setLayoutMargin(16);
		
		TabSet tabSet = createTabSet();
		
		tabSet.setWidth(480);
		tabSet.setHeight(320);

		/*
		 * Build person name
		 */
		tabSet.addTab(createGroupNameTab());
		
		/*
		 * Build postal address
		 */
		tabSet.addTab(createPostalAddressTab());

		/*
		 * Build telephone number
		 */
		tabSet.addTab(createTelephoneNumberTab());

		layout.addMember(tabSet);
		this.setMembers(layout);
		
	}

	/**
	 * @return
	 */
	private Tab createTelephoneNumberTab() {
		/*
		 * Build Telephone Number Form
		 */
		telephoneNumber = new DefaultFormImpl(new TelephoneObject());

        Tab tab = new Tab();   	
        tab.setWidth(80);

        tab.setTitle(TELEPHONE_NUMBER);
 
        /*
         * Tab content
         */
        tab.setPane(telephoneNumber);
		return tab;
		
	}

	/**
	 * @return
	 */
	private Tab createPostalAddressTab() {
		/*
		 * Build Postal Address Form
		 */
		postalAddress = new DefaultFormImpl(new PostalObject());

        Tab tab = new Tab();   	
        tab.setWidth(80);

        tab.setTitle(POSTAL_ADDRESS);
 
        /*
         * Tab content
         */
        tab.setPane(postalAddress);
		return tab;

	}

	/**
	 * @return
	 */
	private Tab createGroupNameTab() {
		/*
		 * Build Group Name Form
		 */
		groupName = new DefaultFormImpl(new GroupNameObject());

        Tab tab = new Tab();   	
        tab.setWidth(80);

        tab.setTitle(GROUP_NAME);
 
        /*
         * Tab content
         */
        tab.setPane(groupName);
		return tab;

	}	

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#addFormData(com.google.gwt.json.client.JSONValue)
	 */
	public void addFormData(JSONValue jValue) {

		JSONObject jForm = jValue.isObject();
		Set<String> keys = jForm.keySet();
		
		FormItem formItem = null;
		
		for (String key:keys) {
			
			String val = jForm.get(key).isString().stringValue();
			
			/*
			 * Try group name
			 */
			formItem = groupName.getField(key);
			if (formItem != null) formItem.setValue(val);
			
			/*
			 * Try postal address
			 */
			formItem = postalAddress.getField(key);
			if (formItem != null) formItem.setValue(val);

			/*
			 * Try telephone number
			 */
			formItem = telephoneNumber.getField(key);
			if (formItem != null) formItem.setValue(val);
			
		}
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#getFormData()
	 */
	public String getFormData() {
		
		JSONObject jForm = new JSONObject();

		FormItem[] fields = null;

		/*
		 * Group name
		 */
		fields = groupName.getFields();
		for (FormItem field:fields) {
			
			String key = field.getName();
			String val = (String)field.getValue();
			
			if (val == null) val = "";
			jForm.put(key, new JSONString(val));
			
		}

		/*
		 * Postal Address
		 */
		fields = postalAddress.getFields();
		for (FormItem field:fields) {
			
			String key = field.getName();
			String val = (String)field.getValue();
			
			if (val == null) val = "";
			jForm.put(key, new JSONString(val));
			
		}

		/*
		 * Telephone Number
		 */
		fields = telephoneNumber.getFields();
		for (FormItem field:fields) {
			
			String key = field.getName();
			String val = (String)field.getValue();
			
			if (val == null) val = "";
			jForm.put(key, new JSONString(val));
			
		}

		return jForm.toString();
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#doEnter()
	 */
	public void doEnter() {
		if (this.formHandler != null) this.formHandler.doSend();
	}

}
