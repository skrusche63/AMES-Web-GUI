package de.kp.ames.web.client.model.remote;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model.remote
 *  Module: ImapObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #imap #model #object #remote #web
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class ImapObject extends RemoteObject {

	public ImapObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();
	
		/*
		 * Creation Date
		 */
		ListGridField dateField = new ListGridField(JsonConstants.J_DATE, LabelConstants.TIMESTAMP_LABEL, 120);
		dateField.setType(ListGridFieldType.TEXT);

		fields.add(dateField);

		/*
		 * Subject
		 */
		ListGridField subjectField = new ListGridField(JsonConstants.J_SUBJECT, LabelConstants.SUBJECT_LABEL, 160);
		subjectField.setType(ListGridFieldType.TEXT);
		
		fields.add(subjectField);


		/*
		 * From
		 */
		ListGridField fromField = new ListGridField(JsonConstants.J_FROM, LabelConstants.FROM_LABEL);
		
		fromField.setType(ListGridFieldType.TEXT);
		fromField.setWidth("*");

		fields.add(fromField);

		return fields;
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.remote.RemoteObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {

		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Identifier
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_ID));

		/*
		 * Subject
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_SUBJECT));

	    /*
		 * Date
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_DATE));

	    /*
		 * From
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_FROM));

	    /*
		 * Attachment
		 */
	    fields.add(new DataSourceBooleanField(JsonConstants.J_ATTACHMENT));
    	
	    return fields;

	}

}
