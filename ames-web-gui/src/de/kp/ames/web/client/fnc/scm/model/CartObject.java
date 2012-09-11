package de.kp.ames.web.client.fnc.scm.model;

import java.util.ArrayList;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.model.external.ExternalObject;



public class CartObject extends ExternalObject {

	/**
	 * Constructor
	 */
	public CartObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/* 
		 * Primary Key combinedId
		 */
		DataSourceTextField id = new DataSourceTextField("cid");
		id.setPrimaryKey(true);
	    fields.add(id);

	    /* 
		 * Suggestion
		 */
	    fields.add(new DataSourceTextField("suggest"));

		/* 
		 * Module
		 */
	    fields.add(new DataSourceTextField("choice"));
	    fields.add(new DataSourceTextField("id"));

	    
	    return fields;
	    
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();
		
		/*
		 * Suggestion
		 */
		ListGridField suggestField = new ListGridField("suggest", "Suggestion (context)", 160);
		suggestField.setType(ListGridFieldType.TEXT);
		fields.add(suggestField);
		
		/*
		 * Result choice
		 */
		ListGridField moduleField = new ListGridField("choice", "Result Choice (package)");
		moduleField.setType(ListGridFieldType.TEXT);

		fields.add(moduleField);

		return fields;
		
	}
}
