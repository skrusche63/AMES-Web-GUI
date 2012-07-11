package de.kp.ames.web.client.function.transform.data;
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
import de.kp.ames.web.client.function.transform.handler.TransformGridMenuHandlerImpl;
import de.kp.ames.web.client.model.TransformatorObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class TransformGridImpl extends GridImpl {

	/**
	 * Constructor
	 * 
	 * @param type
	 */
	public TransformGridImpl(String type) {
		super(ServiceConstants.TRANSFORM_SERVICE_ID);

		/*
		 * Register data
		 */
		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, type);

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
		 * Add menu handler
		 */
		TransformGridMenuHandlerImpl menuHandler = new TransformGridMenuHandlerImpl(this);
		menuHandler.setParam(MethodConstants.ATTR_TYPE, type);
		
		this.addMenuHandler(menuHandler);
		
	}

	/**
	 * @param attributes
	 * @return
	 */
	private DataObject createDataObject(HashMap<String,String> attributes) {
		
		/*
		 * Distinguish between transformators
		 */
		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Transformator)) {			
			/*
			 * Create fields for transformator grid
			 */
			return new TransformatorObject();
			
		}

		return null;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		// TODO
		return null;
	}

}

