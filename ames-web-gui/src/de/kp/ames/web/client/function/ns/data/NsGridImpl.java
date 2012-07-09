package de.kp.ames.web.client.function.ns.data;
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

import com.smartgwt.client.data.DataSourceField;

import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class NsGridImpl extends GridImpl {

	/**
	 * Constructor
	 * 
	 * @param item
	 * @param parent
	 */
	public NsGridImpl(String item, String parent) {
		super(ServiceConstants.NAMESPACE_SERVICE_ID);

		/*
		 * Create data source
		 */
		this.createGridDS(item, parent);
		
	}

	/**
	 * @param item
	 * @param parent
	 */
	private void createGridDS(String item, String parent) {

		HashMap<String,String> attributes = new HashMap<String,String>();

		if (item != null) attributes.put(MethodConstants.ATTR_ITEM, item);
		if (parent != null) attributes.put(MethodConstants.ATTR_PARENT, parent);

		this.createScGridDS(attributes);
		this.setDataSource(dataSource);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#createFields()
	 */
	public DataSourceField[] createFields() {
		// TODO
		return null;
		
	}

}
