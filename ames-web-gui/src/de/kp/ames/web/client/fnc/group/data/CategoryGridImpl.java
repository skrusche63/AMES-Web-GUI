package de.kp.ames.web.client.fnc.group.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.group.data
 *  Module: CategoryGridImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #category #client #data #fnc #grid #group #web
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
import de.kp.ames.web.client.model.CategoryObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class CategoryGridImpl extends RemoteGridImpl {
	
	/**
	 * Constructor
	 */
	public CategoryGridImpl(String item) {
		super(ServiceConstants.COMMUNITY_SERVICE_ID);

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();

		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Category);
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
		
	}

	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new CategoryObject();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return JaxrConstants.RIM_DESC;
	}

}
