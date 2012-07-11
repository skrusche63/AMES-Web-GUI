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

import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.client.function.access.handler.AccessGridMenuHandlerImpl;
import de.kp.ames.web.client.model.AccessorObject;
import de.kp.ames.web.client.model.RemoteObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class AccessGridImpl extends GridImpl {
	
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
		this.createScGridDS(attributes);

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

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		// TODO
		return null;
	}
	
}
