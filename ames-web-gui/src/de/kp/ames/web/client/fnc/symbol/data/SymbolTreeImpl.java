package de.kp.ames.web.client.fnc.symbol.data;
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

import de.kp.ames.web.client.core.tree.TreeImpl;
import de.kp.ames.web.client.fnc.symbol.handler.SymbolNodeHandlerImpl;
import de.kp.ames.web.client.model.SymbolObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

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
	    this.createScTreeDS();	    

		/*
		 * Create tree grid fields
		 */
		this.setFields(createTreeGridFields());

	    /*
	     * Add node handler
	     */
	    SymbolNodeHandlerImpl nodeHandler = new SymbolNodeHandlerImpl(this);
	    nodeHandler.setParam(MethodConstants.ATTR_TYPE, type);
	    
	    this.addNodeHandler(nodeHandler);
	    
	}

	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new SymbolObject();
	}

}
