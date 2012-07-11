package de.kp.ames.web.client.function.symbol.data;
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
import com.smartgwt.client.widgets.tree.TreeGridField;

import de.kp.ames.web.client.core.tree.TreeImpl;
import de.kp.ames.web.client.function.symbol.handler.SymbolNodeHandlerImpl;
import de.kp.ames.web.client.model.SymbolObject;
import de.kp.ames.web.shared.JsonConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class SymbolTreeImpl extends TreeImpl {

	/**
	 * Constructor for either APP-6B or Icon-based
	 * graphical symbols
	 * 
	 * @param type
	 */
	public SymbolTreeImpl(String type) {
		super(ServiceConstants.SYMBOL_SERVICE_ID);
		
	    /*
	     * Set title field
	     */
	    this.setFields(new TreeGridField(TITLE)); 
	    
	    /*
	     * Create data source
	     */
	    this.createTreeDS(type);	    

	    /*
	     * Add node handler
	     */
	    SymbolNodeHandlerImpl nodeHandler = new SymbolNodeHandlerImpl(this);
	    nodeHandler.setParam(MethodConstants.ATTR_TYPE, type);
	    
	    this.addNodeHandler(nodeHandler);
	    
	}

	/**
	 * Create data source
	 * 
	 * @param type
	 */
	private void createTreeDS(String type) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, type);

		String title = JsonConstants.J_NAME;
		
		this.createScTreeDS(attributes, title);
		this.setDataSource(dataSource);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.TreeImpl#createFields(java.util.HashMap)
	 */
	public DataSourceField[] createDataFields(HashMap<String,String> attributes) {
		return new SymbolObject().createDataFieldsAsArray();

	}

}
