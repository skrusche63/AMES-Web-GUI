package de.kp.ames.web.client.model;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.model.core.ExtrinsicObject;
import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.LabelConstants;

public class CommentObject extends ExtrinsicObject {

	/**
	 * Constructor
	 */
	public CommentObject() {
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtrinsicObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Timestamp
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_TIMESTAMP, LabelConstants.TIMESTAMP_LABEL));

		/*
		 * Subject
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_SUBJECT, LabelConstants.SUBJECT_LABEL));

		/*
		 * From
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_FROM, LabelConstants.FROM_LABEL));
		
		/*
		 * Message (without label)
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_MESSAGE));

	    return fields;

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();

		/*
		 * Timestamp
		 */
		ListGridField timestampField = new ListGridField(JaxrConstants.RIM_TIMESTAMP, LabelConstants.TIMESTAMP_LABEL, 120);
		timestampField.setType(ListGridFieldType.TEXT);
	
		fields.add(timestampField);
		
		/*
		 * Subject
		 */
		ListGridField subjectField = new ListGridField(JaxrConstants.RIM_SUBJECT, LabelConstants.SUBJECT_LABEL, 160);
		subjectField.setType(ListGridFieldType.TEXT);
	
		fields.add(subjectField);
		
		/*
		 * From
		 */	
		ListGridField fromField = new ListGridField(JaxrConstants.RIM_FROM, LabelConstants.FROM_LABEL, 160);
		fromField.setType(ListGridFieldType.TEXT);
	
		fields.add(fromField);
		
		return fields;
	
	}
	
	public String toHtml(JSONValue jValue) {
		// TODO
		return null;
	}
}
