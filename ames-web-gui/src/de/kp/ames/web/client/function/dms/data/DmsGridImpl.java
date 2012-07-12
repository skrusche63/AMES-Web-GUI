package de.kp.ames.web.client.function.dms.data;
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
import de.kp.ames.web.client.function.dms.handler.DmsGridMenuHandlerImpl;
import de.kp.ames.web.client.model.DocumentObject;
import de.kp.ames.web.client.model.ImageObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class DmsGridImpl extends GridImpl {

	/**
	 * Constructor
	 * 
	 * @param type
	 * @param item
	 */
	public DmsGridImpl(String type) {
		super(ServiceConstants.DMS_SERVICE_ID);		

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, type);

		/*
		 * Create data object
		 */
		this.dataObject = createDataObject();

		/*
		 * Create data source
		 */
		this.createScGridDS();

		/*
		 * Create grid fields
		 */
		this.setFields(createGridFields());
		
		/*
		 * Add menu handler and also provide request
		 * specific parameters for later use
		 */
		DmsGridMenuHandlerImpl menuHandler = new DmsGridMenuHandlerImpl(this);
		menuHandler.setParams(attributes);
		
		this.addMenuHandler(menuHandler);

	}

	/**
	 * @return
	 */
	private DataObject createDataObject() {
		
		/*
		 * Distinguish between documemts & images
		 */
		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Document)) {			
			/*
			 * Create data fields for document grid
			 */
			return new DocumentObject();
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Image)) {
			/*
			 * Create data fields for image grid
			 */
			return new ImageObject();
			
		}

		return null;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return JaxrConstants.RIM_DESC;
	}

}