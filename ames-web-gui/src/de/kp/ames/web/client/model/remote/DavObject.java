package de.kp.ames.web.client.model.remote;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model.remote
 *  Module: DavObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #dav #model #object #remote #web
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

public class DavObject extends RemoteObject {

	public DavObject() {
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();
	
		/*
		 * Name
		 */
		ListGridField nameField = new ListGridField(JsonConstants.J_NAME, LabelConstants.NAME_LABEL, 160);
		nameField.setType(ListGridFieldType.TEXT);
		
		fields.add(nameField);

		/*
		 * Creation Date
		 */
		ListGridField dateField = new ListGridField(JsonConstants.J_CREATION_DATE, LabelConstants.TIMESTAMP_LABEL, 120);
		dateField.setType(ListGridFieldType.TEXT);

		fields.add(dateField);

		/*
		 * Mimetype
		 */
		ListGridField mimeField = new ListGridField(JsonConstants.J_CONTENT_TYPE, LabelConstants.MIME_LABEL);
		
		mimeField.setType(ListGridFieldType.TEXT);
		mimeField.setWidth("*");

		fields.add(mimeField);

		return fields;
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.remote.RemoteObject#createDataFieldsAsList()
	 */
	@Override
	public ArrayList<DataSourceField> createDataFieldsAsList() {

		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Name
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_NAME));

		/*
		 * Uri
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_URI));

		/*
		 * Creation Date
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_CREATION_DATE));

		/*
		 * Last Modified
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_LAST_MODIFIED));

		/*
		 * Is Folder
		 */
	    fields.add(new DataSourceBooleanField(JsonConstants.J_IS_FOLDER));

		/*
		 * Content Length
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_CONTENT_LENGTH));

		/*
		 * Content Type
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_CONTENT_TYPE));

	    return fields;

	}

}
