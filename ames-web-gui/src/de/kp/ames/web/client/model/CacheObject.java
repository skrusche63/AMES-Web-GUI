package de.kp.ames.web.client.model;

import java.util.ArrayList;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;

import de.kp.ames.web.shared.JsonConstants;

public class CacheObject extends ExternalObject {

	public CacheObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createFields()
	 */
	public DataSourceField[] createFields() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Identifier
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_KEY, "Key"));

	    /*
		 * Name
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_NAME, "Name"));

	    /*
		 * Description
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_DESC, "Description"));

	    /*
		 * Mimetype
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_MIME, "Mimetype"));

		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);
		
	}

}
