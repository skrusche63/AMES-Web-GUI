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

import de.kp.ames.web.shared.JsonConstants;
import de.kp.ames.web.shared.LabelConstants;

public class LayerObject extends ExternalObject {

	/**
	 * Constructor
	 */
	public LayerObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/* 
		 * Name
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_NAME, LabelConstants.NAME_LABEL));

		/* 
		 * Title
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_TITLE, LabelConstants.TITLE_LABEL));

		/* 
		 * Srs (Projection)
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_SRS, LabelConstants.SRS_LABEL));

		/* 
		 * Bounding Box 
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_BBOX, LabelConstants.BBOX_LABEL));

	    return fields;
	    
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();
		
		/*
		 * Title
		 */
		ListGridField titleField = new ListGridField(JsonConstants.J_TITLE, LabelConstants.TITLE_LABEL, 160);
		titleField.setType(ListGridFieldType.TEXT);
		
		fields.add(titleField);
		
		/*
		 * Srs (Projection)
		 */
		ListGridField srsField = new ListGridField(JsonConstants.J_SRS, LabelConstants.SRS_LABEL, 120);
		srsField.setType(ListGridFieldType.TEXT);
		
		fields.add(srsField);

		return fields;
		
	}

}
