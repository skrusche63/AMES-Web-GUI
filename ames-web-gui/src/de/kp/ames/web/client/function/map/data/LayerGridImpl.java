package de.kp.ames.web.client.function.map.data;
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

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.client.function.map.handler.LayerRecordHandlerImpl;
import de.kp.ames.web.client.model.LayerObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class LayerGridImpl extends GridImpl {
	
	/**
	 * Constructor
	 * 
	 * @param endpoint
	 * @param activity
	 */
	public LayerGridImpl(String endpoint, Activity activity) {
		super(ServiceConstants.MAP_SERVICE_ID);

		/*
		 * Register data
		 */
		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_ENDPOINT, endpoint);

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
		 * Add record handler
		 */
		LayerRecordHandlerImpl recordHandler = new LayerRecordHandlerImpl(this);
		recordHandler.setAfterLayerActivity(activity);
		
		this.addRecordHandler(recordHandler);
		
	}

	/**
	 * @param attributes
	 * @return
	 */
	private DataObject createDataObject(HashMap<String,String> attributes) {
		return new LayerObject();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return null;
	}

}
