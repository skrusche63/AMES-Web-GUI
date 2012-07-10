package de.kp.ames.web.client.handler;
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

import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.core.tree.Tree;

public class TreeMenuHandlerImpl implements TreeMenuHandler {

	/*
	 * Reference to Tree
	 */
	protected Tree tree;
	
	/*
	 * Reference to parameters
	 */
	protected HashMap<String,String> params;
	
	/**
	 * Constructor
	 */
	public TreeMenuHandlerImpl() {		
	}
	
	/**
	 * Constructor
	 * 
	 * @param tree
	 */
	public TreeMenuHandlerImpl(Tree tree) {
		this.tree = tree;
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.menu.TreeMenuHandler#doOpen(com.smartgwt.client.widgets.tree.TreeNode)
	 */
	public void doOpen(TreeNode node) {
		
		/*
		 * Show menu as context menu
		 */
		Menu menu = new Menu();
		menu.showContextMenu();

		menu.setItems(createMenuItems(node));

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.menu.TreeMenuHandler#createMenuItems(com.smartgwt.client.widgets.tree.TreeNode)
	 */
	public MenuItem[] createMenuItems(TreeNode node) {
		/*
		 * Must be overridden
		 */
		return null;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.menu.TreeMenuHandler#setTree(de.kp.ames.web.client.core.tree.Tree)
	 */
	public void setTree(Tree tree) {
		this.tree = tree;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.menu.TreeMenuHandler#setParam(java.lang.String, java.lang.String)
	 */
	public void setParam(String key, String value) {
		if (this.params == null) this.params = new HashMap<String,String>();
		this.params.put(key, value);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.menu.TreeMenuHandler#getParam(java.lang.String)
	 */
	public String getParam(String key) {
		if ((this.params == null) || (this.params.containsKey(key) == false)) return null;
		return this.params.get(key);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.menu.TreeMenuHandler#getParams()
	 */
	public HashMap<String,String> getParams() {
		return this.params;
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.TreeMenuHandler#setParams(java.util.HashMap)
	 */
	public void setParams(HashMap<String,String> params) {
		this.params = params;
	}

}
