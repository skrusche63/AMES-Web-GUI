package de.kp.ames.web.client.model;
/**
 *	Copyright 2012 Dr. Krusche & Partner PartG
 *
 *	AMES-Web-GUI is free software: you can redistribute it and/or 
 *	modify it under the terms of the GNU General Public License 
 *	as published by the Free Software Foundation, either version 3 of 
 *	the License, or (at your option) any later version.
 *
 *	AMES- Web-GUI is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 *  See the GNU General Public License for more details. 
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this software. If not, see <http://www.gnu.org/licenses/>.
 *
 */

import java.util.ArrayList;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.core.grid.GridFieldFactory;
import de.kp.ames.web.client.model.core.RegistryObject;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class GroupObject extends RegistryObject {

	/**
	 * Constructor
	 */
	public GroupObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryObject#createDataFieldsAsArray()
	 */
	public DataSourceField[] createDataFieldsAsArray() {
		
		ArrayList<DataSourceField> fields = createDataFieldsAsList();
		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);
				
	}

	public ArrayList<DataSourceField> createDataFieldsAsList() {

		ArrayList<DataSourceField> fields = super.createDataFieldsAsList();

		/*
		 * Postal address (without label)
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_ADDRESS));

		/*
		 * Email address
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_EMAIL, LabelConstants.MAIL_LABEL));
	
		/* 
		 * Telephone number (without label)
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_PHONE));
 	
		/*
		 * Primary contact (without label)
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_CONTACT));
	
	    return fields;
	    
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryObject#createGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();

		/*
		 * User icon
		 */
		fields.add(GridFieldFactory.createRimIconField());

		/*
		 * User name
		 */
		fields.add(GridFieldFactory.createRimNameField("*"));
		
		return fields;
		
	}
	
	/**
	 * A helper method to convert a JSON representation
	 * of a group object into a html string
	 * 
	 * @param jValue
	 * @return
	 */
	public String toHtml(JSONValue jValue) {
		// TODO
		return null;
	}
	
}
