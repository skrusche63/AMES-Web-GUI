package de.kp.ames.web.client.fnc.scm.data;

import java.util.HashMap;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;

import de.kp.ames.web.client.core.grid.LocalGridImpl;
import de.kp.ames.web.client.fnc.scm.model.CartObject;
import de.kp.ames.web.client.model.core.DataObject;


public class CartGridImpl extends LocalGridImpl {

	public CartGridImpl() {
		super();

        /*
		 * Register data
		 */
		attributes = new HashMap<String,String>();

		/*
		 * Create data object
		 */
		this.dataObject = createDataObject();
				
		/*
		 * Create grid fields
		 */
		this.setFields(createGridFields());

	}

	@Override
	public String getDetailFieldName() {
		return null;
	}

	
	@Override
	public JSONArray getGridData() {
		JSONArray jData = new JSONArray();
		String[] attributes = null;
		
		RecordList recordList = this.getDataAsRecordList();
		for (int i = 0; i < recordList.getLength(); i++) {
			Record record = recordList.get(i);
			JSONObject jRecord = new JSONObject();
			if (attributes == null)
				attributes = record.getAttributes();

			for (int j = 0; j < attributes.length; j++) {
				String attribute = attributes[j];
			
				jRecord.put(attribute, new JSONString(record.getAttributeAsString(attribute)));
			}
			jData.set(i, jRecord);
		}
		
		return jData;
	}

	
	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new CartObject();
	}

	public boolean hasCombinedId(String id) {
		RecordList recordList = this.getDataAsRecordList();
		for (int i = 0; i < recordList.getLength(); i++) {
			Record record = recordList.get(i);
			if (record.getAttribute("id").equals(id))
				return true;
		}
		return false;
	}
	
	
}
