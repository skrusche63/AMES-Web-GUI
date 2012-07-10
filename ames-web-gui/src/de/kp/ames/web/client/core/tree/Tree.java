package de.kp.ames.web.client.core.tree;
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
import com.smartgwt.client.widgets.grid.events.RowContextClickEvent;
import com.smartgwt.client.widgets.tree.events.NodeClickEvent;

import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.client.handler.TreeMenuHandler;
import de.kp.ames.web.client.handler.TreeNodeHandler;

public interface Tree {

	/**
	 * @param menuHandler
	 */
	public void addMenuHandler(TreeMenuHandler menuHandler);

	/**
	 * @param nodeHandler
	 */
	public void addNodeHandler(TreeNodeHandler nodeHandler);
	
	/**
	 * Event handling after right mouse click
	 * on tree entry (row)
	 * 
	 * @param event
	 */
	public void afterContextMenu(RowContextClickEvent event);

	/**
	 * @param event
	 */
	public void afterNodeClick(NodeClickEvent event);
	
	/**
	 * @return
	 */
	public DataSourceField[] createDataFields();

	/**
	 * @param attributes
	 * @return
	 */
	public DataSourceField[] createDataFields(HashMap<String,String> attributes);

	/**
	 * Create request method from attributes
	 * 
	 * @param attributes
	 * @return
	 */
	public RequestMethod createMethod(HashMap<String,String> attributes);

	/**
	 * Create Data source
	 * 
	 * @param attributes
	 */
	public void createScTreeDS(HashMap<String,String> attributes, String title);

	/**
	 * @param url
	 * @param method
	 * @param title
	 * @param fields
	 */
	public void createScTreeDS(final String url, final RequestMethod method, final String title, final DataSourceField[] fields);

	/**
	 * @return
	 */
	public String getRequestUrl();

}
