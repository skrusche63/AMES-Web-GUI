package de.kp.ames.web.client.model.remote;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model.remote
 *  Module: DatabaseObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #database #model #object #remote #web
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;
import java.util.Set;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class DatabaseObject extends RemoteObject {

	/*
	 * Reference to database data
	 */
	private JSONObject jDatabase;
	
	public DatabaseObject() {
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();
	
		JSONArray jColumns = jDatabase.get("columns").isArray();
		for (int i=0; i < jColumns.size(); i++) {

			String colName = jColumns.get(i).isString().stringValue();
			
			ListGridField colField = new ListGridField(colName, colName);
			colField.setType(ListGridFieldType.TEXT);
			
			fields.add(colField);
			
		}

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

		JSONArray jRows = jDatabase.get("records").isArray();
		for (int i=0; i < jRows.size(); i++) {
			
			JSONObject jRow = jRows.isObject();
			ListGridRecord record = new ListGridRecord();
			
			Set<String> cols = jRow.keySet();
			for (String col:cols) {				
				record.setAttribute(col, jRow.get(col).isString().stringValue());
			}
			
			records.add(record);
			
		}

		return records;	
		
	}

	public void setDatabase(JSONObject jDatabase) {
		this.jDatabase = jDatabase;
	}
	
}
