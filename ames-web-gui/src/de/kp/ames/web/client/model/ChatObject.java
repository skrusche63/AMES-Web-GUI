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

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.model.core.ExtrinsicObject;
import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.LabelConstants;

public class ChatObject extends ExtrinsicObject {

	/**
	 * Constructor
	 */
	public ChatObject() {	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtrinsicObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Timestamp
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_TIMESTAMP, LabelConstants.TIMESTAMP_LABEL));

		/*
		 * Subject
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_SUBJECT, LabelConstants.SUBJECT_LABEL));

		/*
		 * From
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_FROM, LabelConstants.FROM_LABEL));

	    return fields;

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();

		/*
		 * Timestamp
		 */
		ListGridField timestampField = new ListGridField(JaxrConstants.RIM_TIMESTAMP, LabelConstants.TIMESTAMP_LABEL, 120);
		timestampField.setType(ListGridFieldType.TEXT);
	
		fields.add(timestampField);
		
		/*
		 * Subject
		 */
		ListGridField subjectField = new ListGridField(JaxrConstants.RIM_SUBJECT, LabelConstants.SUBJECT_LABEL, 160);
		subjectField.setType(ListGridFieldType.TEXT);
	
		fields.add(subjectField);
		
		/*
		 * From
		 */	
		ListGridField fromField = new ListGridField(JaxrConstants.RIM_FROM, LabelConstants.FROM_LABEL, 160);
		fromField.setType(ListGridFieldType.TEXT);
	
		fields.add(fromField);
		
		return fields;
	
	}
	
}
