package de.kp.ames.web.client.function.bulletin.data;
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

import java.util.HashMap;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.client.model.DataObject;
import de.kp.ames.web.client.model.PostObject;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class PostGridImpl extends GridImpl {
	
	/*
	 * Reference to data object
	 */
	private DataObject dataObject;

	/**
	 * Constructor
	 * 
	 * @param recipient
	 */
	public PostGridImpl(String recipient) {
		super(ServiceConstants.BULLETIN_SERVICE_ID);

		/*
		 * Register data
		 */
		HashMap<String,String> attributes = new HashMap<String,String>();		

		/*
		 * Create data object
		 */
		this.dataObject = createDataObject(attributes);

		/*
		 * Create data source
		 */
		this.createGridDS(recipient);

		/*
		 * Create grid fields
		 */
		this.setFields(createGridFields(attributes));

	}

	/**
	 * @param attributes
	 * @return
	 */
	private DataObject createDataObject(HashMap<String,String> attributes) {
		return new PostObject();
	}

	/**
	 * @param recipient
	 */
	private void createGridDS(String recipient) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TARGET, recipient);
		
		this.createScGridDS(attributes);
		this.setDataSource(dataSource);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#createFields(java.util.HashMap)
	 */
	public DataSourceField[] createDataFields(HashMap<String,String> attributes) {
		return this.dataObject.createDataFields();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#createGridFields(java.util.HashMap)
	 */
	public ListGridField[] createGridFields(HashMap<String,String> attributes) {
		return this.dataObject.createGridFields();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		// TODO
		return null;
	}

}
