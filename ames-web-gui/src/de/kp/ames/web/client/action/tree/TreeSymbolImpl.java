package de.kp.ames.web.client.action.tree;
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

import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.action.ActionImpl;
import de.kp.ames.web.client.core.tree.Tree;
import de.kp.ames.web.client.fnc.symbol.event.SymbolEventManager;

public class TreeSymbolImpl extends ActionImpl {
	
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
	public TreeSymbolImpl(Tree tree, TreeNode node) {
		this.tree = tree;
		this.node = node;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {
		
		/*
		 * Convert node
		 */
		HashMap<String,String> attributes = new HashMap<String,String>();
		String keys[] = this.node.getAttributes();
		
		for (String key:keys) {
			attributes.put(key, node.getAttributeAsString(key));
		}

		SymbolEventManager.getInstance().onSymbolSelected(attributes);
		
	}

}
