package de.kp.ames.web.client.fnc.map.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.map.data
 *  Module: LayerGridImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #data #fnc #grid #layer #map #web
 * </SemanticAssist>
 *
 */

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
import de.kp.ames.web.client.core.grid.RemoteGridImpl;
import de.kp.ames.web.client.fnc.map.handler.LayerGridRecordHandlerImpl;
import de.kp.ames.web.client.model.LayerObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class LayerGridImpl extends RemoteGridImpl {
	
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
		attributes = new HashMap<String,String>();
		
		attributes.put(MethodConstants.ATTR_ENDPOINT, endpoint);
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Layer);

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
		 * Add record handler
		 */
		LayerGridRecordHandlerImpl recordHandler = new LayerGridRecordHandlerImpl(this);
		
		this.addRecordHandler(recordHandler);

	}

	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new LayerObject();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return null;
	}

}
