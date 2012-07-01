package de.kp.ames.web.client.function.group.grid;
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
import de.kp.ames.web.client.function.group.menu.CategoryGridMenuHandlerImpl;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class CategoryGridImpl extends GridImpl {
	
	/**
	 * Constructor
	 */
	public CategoryGridImpl() {
		super(ServiceConstants.COMMUNITY_SERVICE_ID);
		
		/*
		 * Create data source
		 */
		this.createGridDS();

		/*
		 * Add menu handler
		 */
		this.addMenuHandler(new CategoryGridMenuHandlerImpl(this));
		
	}

	/**
	 * Create data source
	 */
	private void createGridDS() {

		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Category);
		
		this.createScGridDS(attributes);
		this.setDataSource(dataSource);
		
	}
	
}
