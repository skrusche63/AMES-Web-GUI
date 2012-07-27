package de.kp.ames.web.client.model;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.model.core.ExtensibleObject;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class SlotObject extends ExtensibleObject {

	/**
	 * Constructor
	 */
	public SlotObject() {
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Key (without label)	
		 */
		DataSourceTextField keyField = new DataSourceTextField(JaxrConstants.RIM_KEY);
		keyField.setValueMap(getDefinedSlots());
		
	    fields.add(keyField);
		
		/* 
		 * Val (without label)
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_VAL));

	    return fields;
	    
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();
		
		/*
		 * Key
		 */
		ListGridField keyField = new ListGridField(JaxrConstants.RIM_KEY, LabelConstants.PROPERTY_LABEL, 120);
		keyField.setType(ListGridFieldType.TEXT);
	
		fields.add(keyField);
		
		/*
		 * Value
		 */
		ListGridField valField = new ListGridField(JaxrConstants.RIM_VAL, LabelConstants.VALUE_LABEL);
		
		valField.setType(ListGridFieldType.TEXT);
		valField.setWidth("*");
		
		fields.add(valField);

		return fields;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.external.ExternalObject#createListGridRecordsAsList()
	 */
	public ArrayList<ListGridRecord> createListGridRecordsAsList() {
		
		/*
		 * Initial fill of SlotGrid
		 */
		ArrayList<ListGridRecord> records = new ArrayList<ListGridRecord>();
		
		ListGridRecord initialRecord = new ListGridRecord();
		
		initialRecord.setAttribute(JaxrConstants.RIM_KEY, "(Property name)");
		initialRecord.setAttribute(JaxrConstants.RIM_VAL, "(Property value");
		
		records.add(initialRecord);
		return records;	
		
	}

	/**
	 * A data method to convert the content of the
	 * slot representation (grid) into a JSON representation
	 * 
	 * @param records
	 * @return
	 */
	public JSONObject toJObject(ListGridRecord[] records) {
		
		JSONObject jObject = new JSONObject();
		
		for (ListGridRecord record:records) {
			/*
			 * Key
			 */
			String key = record.getAttributeAsString(JaxrConstants.RIM_KEY);

			/*
			 * Value
			 */
			String val = record.getAttributeAsString(JaxrConstants.RIM_VAL);

			jObject.put(key, new JSONString(val));
			
		}
		
		return jObject;
		
	}

	/**
	 * List of available slots
	 * 
	 * @return
	 */
	private String[] getDefinedSlots() {
		return JaxrConstants.DEFINED_SLOTS;
	}
	
}
