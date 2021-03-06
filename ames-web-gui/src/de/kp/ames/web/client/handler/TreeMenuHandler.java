package de.kp.ames.web.client.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.handler
 *  Module: TreeMenuHandler
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #handler #menu #tree #web
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

import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.core.tree.Tree;

public interface TreeMenuHandler {

	/**
	 * @param node
	 */
	public void doOpen(TreeNode node);

	/**
	 * @return
	 */
	public MenuItem[] createMenuItems(TreeNode node);

	/**
	 * @param key
	 * @return
	 */
	public String getParam(String key);

	/**
	 * @return
	 */
	public HashMap<String,String> getParams();
	
	/**
	 * @param tree
	 */
	public void setTree(Tree tree);
	
	/**
	 * @param key
	 * @param value
	 */
	public void setParam(String key, String value);

	/**
	 * @param params
	 */
	public void setParams(HashMap<String,String> params);

}
