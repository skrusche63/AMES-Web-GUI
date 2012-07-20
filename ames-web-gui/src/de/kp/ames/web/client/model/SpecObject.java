package de.kp.ames.web.client.model;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.model.external.ExternalObject;
import de.kp.ames.web.shared.JaxrConstants;

public class SpecObject extends ExternalObject {
	
	public SpecObject() {
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.external.ExternalObject#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		/*
		 * TODO
		 */
		return null;		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.external.ExternalObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {
		/*
		 * TODO
		 */
		return null;
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.external.ExternalObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {
		/*
		 * TODO
		 */
		return null;
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.external.ExternalObject#createListGridRecordsAsList()
	 */
	public ArrayList<ListGridRecord> createListGridRecordsAsList() {
		/*
		 * TODO
		 */
		return null;		
	}

	/**
	 * A data method to convert the content of the
	 * specifications representation (grid) into a
	 * JSON representation
	 * 
	 * @param records
	 * @return
	 */
	public JSONArray toJArray(ListGridRecord[] records) {
		
		JSONArray jArray = new JSONArray();
		
		int seqNo = 0;
		for (ListGridRecord record:records) {
			
			JSONObject jObject = new JSONObject();
			/*
			 * SeqNo
			 */
			seqNo += 1;
			jObject.put(JaxrConstants.RIM_SEQNO, new JSONString(String.valueOf(seqNo)));

			/*
			 * Identifier
			 */
			jObject.put(JaxrConstants.RIM_ID, new JSONString(record.getAttributeAsString(JaxrConstants.RIM_ID)));
			
			jArray.set(jArray.size(), jObject);
			
		}
		
		return jArray;
		
	}
}
