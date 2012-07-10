package de.kp.ames.web.client.function.access.data;
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
import de.kp.ames.web.client.function.access.handler.AccessGridMenuHandlerImpl;
import de.kp.ames.web.client.model.AccessorObject;
import de.kp.ames.web.client.model.DataObject;
import de.kp.ames.web.client.model.RemoteObject;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class AccessGridImpl extends GridImpl {
	
	/*
	 * Reference to data object
	 */
	private DataObject dataObject;
	
	/**
	 * Constructor
	 * 
	 * @param type
	 * @param item (optional) references a certain accessor
	 */
	public AccessGridImpl(String type, String item) {
		super(ServiceConstants.ACCESS_SERVICE_ID);
		
		/*
		 * Register data
		 */
		HashMap<String,String> attributes = new HashMap<String,String>();		
		attributes.put(MethodConstants.ATTR_TYPE, type);
		
		/*
		 * An item references a certain accessor and is a MUST for
		 * get requests to retrieve remote objects
		 */
		if (item != null) attributes.put(MethodConstants.ATTR_ITEM, item);

		/*
		 * Create data object
		 */
		this.dataObject = createDataObject(attributes);

		/*
		 * Create data source
		 */
		this.createGridDS(attributes);

		/*
		 * Create grid fields
		 */
		this.setFields(createGridFields(attributes));
		
		/*
		 * Add Menu Handler
		 */
		AccessGridMenuHandlerImpl menuHandler = new AccessGridMenuHandlerImpl(this);
		menuHandler.setParams(attributes);

		this.addMenuHandler(menuHandler);
		
	}

	/**
	 * @param attributes
	 * @return
	 */
	private DataObject createDataObject(HashMap<String,String> attributes) {
		/*
		 * Distinguish between accessor and reomte object
		 */
		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Accessor)) {			
			/*
			 * Create data fields for accessor grid
			 */
			return new AccessorObject();
			
		} else {
			/*
			 * Create data fields for remote object grid
			 */
			return new RemoteObject();
			
		}
		
	}
	
	/**
	 * @param type
	 * @param item
	 */
	private void createGridDS(HashMap<String,String> attributes) {
		
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
