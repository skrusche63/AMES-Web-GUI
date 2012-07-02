package de.kp.ames.web.client.function.transform.grid;
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
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class TransformGridImpl extends GridImpl {

	/**
	 * Constructor
	 * 
	 * @param type
	 * @param item
	 */
	public TransformGridImpl(String type, String item) {
		super(ServiceConstants.TRANSFORM_SERVICE_ID);
		
		/*
		 * Create data source
		 */
		this.createGridDS(type, item);

	}

	/**
	 * @param type
	 * @param item
	 */
	private void createGridDS(String type, String item) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, type);

		if (item != null) attributes.put(MethodConstants.ATTR_ITEM, item);

		this.createScGridDS(attributes);
		this.setDataSource(dataSource);
		
	}
	
}

