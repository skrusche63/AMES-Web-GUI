package de.kp.ames.web.client.fnc.user.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.user.data
 *  Module: UserGridImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #data #fnc #grid #user #web
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

import de.kp.ames.web.client.core.grid.RemoteGridImpl;
import de.kp.ames.web.client.fnc.user.handler.UserGridMenuHandlerImpl;
import de.kp.ames.web.client.model.UserObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class UserGridImpl extends RemoteGridImpl {

	/**
	 * Constructor is used to retrieve all
	 * registered users
	 */
	public UserGridImpl() {
		super(ServiceConstants.USER_SERVICE_ID);		

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();

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
		 * This UserGridImpl must have a MenuHandler
		 * externally provided (context-awareness)
		 */
		
	}
	
	/**
	 * Constructor is used to retrieve all
	 * users that are attached to a certain
	 * community
	 * 
	 * @param community
	 */
	public UserGridImpl(String community) {
		super(ServiceConstants.USER_SERVICE_ID);		

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_ITEM, community);

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
		UserGridMenuHandlerImpl menuHandler = new UserGridMenuHandlerImpl(this);
		menuHandler.setParams(attributes);
		
		this.addMenuHandler(menuHandler);
		
	}

	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new UserObject();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		/*
		 * Actually there is no need for a more
		 * detailed description of a user
		 */
		return null;
	}

}

