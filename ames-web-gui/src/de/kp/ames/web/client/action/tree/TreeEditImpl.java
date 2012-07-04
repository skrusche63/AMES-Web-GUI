package de.kp.ames.web.client.action.tree;

import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.action.ActionImpl;
import de.kp.ames.web.client.core.tree.Tree;

public class TreeEditImpl extends ActionImpl {
	
	/*
	 * Reference to tree
	 */
	protected Tree tree;
	
	/*
	 * Reference to tree node
	 */
	protected TreeNode node;
	
	public TreeEditImpl(Tree tree, TreeNode node) {
		this.tree = tree;
		this.node = node;
	}

}
