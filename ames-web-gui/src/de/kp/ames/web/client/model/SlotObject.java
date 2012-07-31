package de.kp.ames.web.client.model;
/**
 *	Copyright 2012 Dr. Krusche & Partner PartG
 *
 *	AMES-Web-GUI is free software: you can redistribute it and/or 
 *	modify it under the terms of the GNU General Public License 
 *	as published by the Free Software Foundation, either version 3 of 
 *	the License, or (at your option) any later version.
 *
 *	AMES- Web-GUI is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 *  See the GNU General Public License for more details. 
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this software. If not, see <http://www.gnu.org/licenses/>.
 *
 */

import java.util.ArrayList;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
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
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();
		
		/*
		 * Key
		 */
		ListGridField keyField = new ListGridField(JaxrConstants.RIM_KEY, LabelConstants.PROPERTY_LABEL, 120);
		keyField.setType(ListGridFieldType.TEXT);
	
		keyField.setValueMap(getDefinedSlots());
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
		records.add(createNewSlot());

		return records;	
		
	}

	public ListGridRecord createNewSlot() {

		ListGridRecord newSlot = new ListGridRecord();
		
		newSlot.setAttribute(JaxrConstants.RIM_KEY, "(Property name)");
		newSlot.setAttribute(JaxrConstants.RIM_VAL, "(Property value)");

		return newSlot;
		
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
