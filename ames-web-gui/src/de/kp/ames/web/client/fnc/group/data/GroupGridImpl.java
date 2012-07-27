package de.kp.ames.web.client.fnc.group.data;
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

import de.kp.ames.web.client.core.grid.RemoteGridImpl;
import de.kp.ames.web.client.fnc.group.handler.GroupGridMenuHandlerImpl;
import de.kp.ames.web.client.model.GroupObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class GroupGridImpl extends RemoteGridImpl {

	/**
	 * Constructor is used to retrieve all
	 * registered groups
	 */
	public GroupGridImpl() {
		super(ServiceConstants.COMMUNITY_SERVICE_ID);

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Community);

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
		 * This GroupGridImpl must have a MenuHandler
		 * externally provided (context-awareness)
		 */

		
	}
	
	/**
	 * Constructor is used to retrieve all
	 * groups that are attached to a certain
	 * affiliate
	 * 
	 * @param affiliate
	 */
	public GroupGridImpl(String affiliate) {
		super(ServiceConstants.COMMUNITY_SERVICE_ID);		

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();
		
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Community);
		attributes.put(MethodConstants.ATTR_SOURCE, affiliate);

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
		 * Add menu handler
		 */
		this.addMenuHandler(new GroupGridMenuHandlerImpl(this));
		
	}

	/**
	 * @param attributes
	 * @return
	 */
	private DataObject createDataObject() {
		return new GroupObject();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		// TODO
		return null;
	}

}
