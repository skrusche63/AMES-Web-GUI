package de.kp.ames.web.client.model;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model
 *  Module: SpecObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #model #object #spec #web
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.model.external.ExternalObject;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class SpecObject extends ExternalObject {
	
	/**
	 * Constructor
	 */
	public SpecObject() {
	}


	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.external.ExternalObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();
		
		/*
		 * Identifier
		 */
		ListGridField identifierField = new ListGridField(JaxrConstants.RIM_ID, 20);
		identifierField.setType(ListGridFieldType.TEXT);
	
		identifierField.setHidden(true);
		fields.add(identifierField);
		
		/*
		 * Value
		 */
		ListGridField nameField = new ListGridField(JaxrConstants.RIM_NAME, LabelConstants.NAME_LABEL);
		
		nameField.setType(ListGridFieldType.TEXT);
		nameField.setWidth("*");
		
		fields.add(nameField);

		return fields;

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.external.ExternalObject#createListGridRecordsAsList()
	 */
	public ArrayList<ListGridRecord> createListGridRecordsAsList() {
		return new ArrayList<ListGridRecord>();
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
