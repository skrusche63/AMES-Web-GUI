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
import com.smartgwt.client.data.fields.DataSourceImageField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

import de.kp.ames.web.client.model.external.ExternalObject;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.shared.constants.JsonConstants;

public class GraphicObject extends ExternalObject {

	/**
	 * Constructor
	 */
	public GraphicObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createDataFieldsAsArray()
	 */
	public DataSourceField[] createDataFieldsAsArray() {

		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

	    /*
		 * Name (without label)
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_NAME));

	    /*
		 * Url (without label)
		 */
	    fields.add(new DataSourceImageField(JsonConstants.J_URL));

		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);
	
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createViewerFieldsAsArray()
	 */
	public DetailViewerField[] createViewerFieldsAsArray() {

		ArrayList<DetailViewerField> fields = new ArrayList<DetailViewerField>();

	    /*
		 * Url (without label)
		 */
	    fields.add(new DetailViewerField(JsonConstants.J_URL));

	    /*
		 * Name (without label)
		 */
	    DetailViewerField nameField = new DetailViewerField(JsonConstants.J_NAME);
	    nameField.setCellStyle(GuiStyles.X_SYMBOL_NAME);  

	    fields.add(nameField);

		return (DetailViewerField[])fields.toArray(new DetailViewerField [fields.size()]);

	}
}
