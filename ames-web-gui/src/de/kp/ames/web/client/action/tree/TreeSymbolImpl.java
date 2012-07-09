package de.kp.ames.web.client.action.tree;

import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.action.ActionImpl;
import de.kp.ames.web.client.core.tree.Tree;

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
		// TODO: Link to Symbol Package
	}

}
