package de.kp.ames.web.client.model;

import java.util.ArrayList;

import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.core.grid.GridFieldFactory;
import de.kp.ames.web.client.model.core.RegistryPackage;

public class RuleObject extends RegistryPackage {

	public RuleObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();

		/*
		 * Product icon
		 */
		fields.add(GridFieldFactory.createRimIconField());
		
		/*
		 * Product name
		 */
		fields.add(GridFieldFactory.createRimNameField(160));

		/*
		 * Evaluation author
		 */
		fields.add(GridFieldFactory.createRimAuthorField("*"));
		
		return fields;
		
	}

}
