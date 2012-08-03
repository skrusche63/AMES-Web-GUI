package de.kp.ames.web.client.model.remote;

import java.util.ArrayList;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import de.kp.ames.web.shared.constants.JsonConstants;

public class DavObject extends RemoteObject {

	public DavObject() {
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.remote.RemoteObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {

		ArrayList<DataSourceField> fields = super.createDataFieldsAsList();

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
