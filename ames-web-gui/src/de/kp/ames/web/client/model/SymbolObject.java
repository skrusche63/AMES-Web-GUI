package de.kp.ames.web.client.model;

import java.util.ArrayList;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.tree.TreeGridField;

import de.kp.ames.web.client.model.external.ExternalObject;
import de.kp.ames.web.shared.JsonConstants;
import de.kp.ames.web.shared.LabelConstants;

public class SymbolObject extends ExternalObject {
	
	/**
	 * Constructor
	 */
	public SymbolObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createDataFields()
	 */
	public DataSourceField[] createDataFieldsAsArray() {

		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Identifier (without label)
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_ID));

	    /*
		 * Name
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_NAME, LabelConstants.NAME_LABEL));
		
		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createTreeGridFieldsAsList()
	 */
	public ArrayList<TreeGridField> createTreeGridFieldsAsList() {

		ArrayList<TreeGridField> fields = new ArrayList<TreeGridField>();

	    /*
		 * Name
		 */
	    fields.add(new TreeGridField(JsonConstants.J_NAME, LabelConstants.NAME_LABEL));
		
		return fields;
		
	}
	
}
