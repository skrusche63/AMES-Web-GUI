package de.kp.ames.web.client.function.rule.data;
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
import de.kp.ames.web.client.model.RuleObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class RuleGridImpl extends GridImpl {

	/**
	 * Constructor
	 * 
	 * @param type
	 * @param item
	 */
	public RuleGridImpl(String type, String item) {
		super(ServiceConstants.RULE_SERVICE_ID);

		/*
		 * Register data
		 */
		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, type);

		if (item != null) attributes.put(MethodConstants.ATTR_ITEM, item);

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
		
	}

	/**
	 * @param attributes
	 * @return
	 */
	private DataObject createDataObject(HashMap<String,String> attributes) {
		return new RuleObject();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		// TODO
		return null;
	}

}
