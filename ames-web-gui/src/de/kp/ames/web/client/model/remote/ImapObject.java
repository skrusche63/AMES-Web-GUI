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

import de.kp.ames.web.shared.constants.JsonConstants;

public class ImapObject extends RemoteObject {

	public ImapObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.remote.RemoteObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {

		ArrayList<DataSourceField> fields = super.createDataFieldsAsList();

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
