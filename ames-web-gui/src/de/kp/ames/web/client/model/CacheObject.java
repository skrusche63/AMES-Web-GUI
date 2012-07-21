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

import de.kp.ames.web.client.model.external.ExternalObject;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class CacheObject extends ExternalObject {
	
	/**
	 * Constructor
	 */
	public CacheObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createDataFields()
	 */
	public DataSourceField[] createDataFieldsAsArray() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Identifier
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_KEY, LabelConstants.KEY_LABEL));

	    /*
		 * Name
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_NAME, LabelConstants.NAME_LABEL));

	    /*
		 * Description
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_DESC, LabelConstants.DESC_LABEL));

	    /*
		 * Mimetype
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_MIME, LabelConstants.MIME_LABEL));

		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createGridFields()
	 */
	public ListGridField[] createListGridFieldsAsArray() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();

		/*
		 * Name
		 */
		ListGridField nameField = new ListGridField(JsonConstants.J_NAME, LabelConstants.NAME_LABEL, 160);
		nameField.setType(ListGridFieldType.TEXT);
		
		fields.add(nameField);

		/*
		 * Mimetype
		 */
		ListGridField mimeField = new ListGridField(JsonConstants.J_MIME, LabelConstants.MIME_LABEL, 120);
		mimeField.setType(ListGridFieldType.TEXT);

		fields.add(mimeField);

		return (ListGridField[])fields.toArray(new ListGridField [fields.size()]);

	}

}
