package de.kp.ames.web.client.fnc.access.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.access.data
 *  Module: AccessGridImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #access #client #data #fnc #grid #web
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

import com.smartgwt.client.types.ExpansionMode;
import de.kp.ames.web.client.core.grid.RemoteGridImpl;
import de.kp.ames.web.client.fnc.access.handler.AccessGridMenuHandlerImpl;
import de.kp.ames.web.client.model.AccessorObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.client.model.remote.RemoteFactory;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class AccessGridImpl extends RemoteGridImpl {
	
	/**
	 * Constructor
	 * 
	 * @param type
	 * @param item (optional) references a certain accessor
	 */
	public AccessGridImpl(String type, String item) {
		super(ServiceConstants.ACCESS_SERVICE_ID);

		/*
		 * Set a detail field for an AccessorObject as for
		 * a RemoteObject no such field is supported
		 */
		if (type.equals(ClassificationConstants.FNC_ID_Accessor)) {	

			this.setCanExpandRecords(true);
			this.setExpansionMode(ExpansionMode.DETAIL_FIELD);

			this.setDetailField(JaxrConstants.RIM_DESC);

		}
		
		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();		
		attributes.put(MethodConstants.ATTR_TYPE, type);
		
		/*
		 * An item references a certain accessor and is a MUST for
		 * get requests to retrieve remote objects
		 */
		if (item != null) attributes.put(MethodConstants.ATTR_ITEM, item);

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
		 * Add Menu Handler
		 */
		AccessGridMenuHandlerImpl menuHandler = new AccessGridMenuHandlerImpl(this);
		menuHandler.setParams(attributes);

		this.addMenuHandler(menuHandler);

	}

	/**
	 * @return
	 */
	private DataObject createDataObject() {
		/*
		 * Distinguish between accessor and remote object
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
			return RemoteFactory.getRemoteObject(type);
			
		}
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		/*
		 * The description field is NULL for RemoteObjects
		 */
		return null;		
	}
	
}
