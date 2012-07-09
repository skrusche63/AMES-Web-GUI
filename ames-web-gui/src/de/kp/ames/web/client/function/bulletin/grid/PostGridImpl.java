package de.kp.ames.web.client.function.bulletin.grid;
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

public class PostGridImpl extends GridImpl {

	/**
	 * Constructor
	 * 
	 * @param recipient
	 */
	public PostGridImpl(String recipient) {
		super(ServiceConstants.BULLETIN_SERVICE_ID);
				
		/*
		 * Create data source
		 */
		this.createGridDS(recipient);

	}

	/**
	 * @param recipient
	 */
	private void createGridDS(String recipient) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TARGET, recipient);
		
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
