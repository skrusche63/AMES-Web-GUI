package de.kp.ames.web.client.action.tree;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.action.tree
 *  Module: TreeViewImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #tree #view #web
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

import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.action.ActionImpl;
import de.kp.ames.web.client.core.tree.Tree;

public class TreeViewImpl extends ActionImpl {
	
	/*
	 * Reference to tree
	 */
	protected Tree tree;
	
	/*
	 * Reference to tree node
	 */
	protected TreeNode node;
	
	/**
	 * Constructor
	 * 
	 * @param tree
	 * @param node
	 */
	public TreeViewImpl(Tree tree, TreeNode node) {
		this.tree = tree;
		this.node = node;
	}

}
