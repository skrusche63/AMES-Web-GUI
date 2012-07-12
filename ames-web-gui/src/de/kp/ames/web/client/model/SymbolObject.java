package de.kp.ames.web.client.model;

import java.util.ArrayList;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import de.kp.ames.web.shared.JsonConstants;
import de.kp.ames.web.shared.LabelConstants;

public class SymbolObject extends ExternalObject {
	
	public SymbolObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createDataFields()
	 */
	public DataSourceField[] createDataFieldsAsArray() {

		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Identifier
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_ID, LabelConstants.ID_LABEL));

	    /*
		 * Name
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_NAME, LabelConstants.NAME_LABEL));
		
		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);
	
	}

	// TODO
	
}
