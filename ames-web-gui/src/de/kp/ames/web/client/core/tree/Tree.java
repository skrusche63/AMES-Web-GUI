package de.kp.ames.web.client.core.tree;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.tree
 *  Module: Tree
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #tree #web
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

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.tree.TreeGridField;
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
	 * @param event
	 */
	public void afterNodeClick(NodeClickEvent event);
	
	/**
	 * @return
	 */
	public DataSourceField[] createDataFields();

	/**
	 * @return
	 */
	public TreeGridField[] createTreeGridFields();
	
	/**
	 * Create request method from attributes
	 * 
	 * @return
	 */
	public RequestMethod createMethod();

	/**
	 * Create Data source
	 */
	public void createScTreeDS();

	/**
	 * @return
	 */
	public String getRequestUrl();

	/**
	 * @param menu
	 */
	public void setMenu(Menu menu);

	/**
	 * Data Handling after tree content has changed
	 */
	public void reload();

	
	/**
	 * Remove a single attribute by key
	 */
	public void removeAttribute(String key);
}
