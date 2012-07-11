package de.kp.ames.web.client.model.core;
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

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;

import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.LabelConstants;

public class ExtrinsicObject extends RegistryObject {

	/**
	 * Constructor
	 */
	public ExtrinsicObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.RegistryObject#createDataFieldsAsArray()
	 */
	public DataSourceField[] createDataFieldsAsArray() {
		
		ArrayList<DataSourceField> fields = createDataFieldsAsList();
		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);
				
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.RegistryObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {

		ArrayList<DataSourceField> fields = super.createDataFieldsAsList();

		/*
		 * Mimetype
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_MIME, LabelConstants.MIME_LABEL));

	    return fields;
	    
	}

}
