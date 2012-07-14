package de.kp.ames.web.client.function.comm.data;
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
import de.kp.ames.web.client.function.comm.handler.CommGridMenuHandlerImpl;
import de.kp.ames.web.client.model.ChatObject;
import de.kp.ames.web.client.model.MailObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class CommGridImpl extends RemoteGridImpl {

	/**
	 * Constructor
	 * 
	 * @param type
	 */
	public CommGridImpl(String type) {
		super(ServiceConstants.COMMUNICATION_SERVICE_ID);		

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
		 * Add menu handler
		 */
		CommGridMenuHandlerImpl menuHandler = new CommGridMenuHandlerImpl(this);
		menuHandler.setParam(MethodConstants.ATTR_TYPE, type);
		
		this.addMenuHandler(menuHandler);
		
	}

	/**
	 * @return
	 */
	private DataObject createDataObject() {

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Chat)) {
			/*
			 * Create data fields for chat grid
			 */
			return new ChatObject();
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Mail)) {
			/*
			 * Create data fields for document grid
			 */
			return new MailObject();
			
		}
			
		return null;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return null;
	}

}
