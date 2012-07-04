package de.kp.ames.web.client.action.tree;

import de.kp.ames.web.client.action.ActionImpl;
import de.kp.ames.web.client.core.tree.Tree;

public class TreeCreateImpl extends ActionImpl {
	
	/*
	 * Reference to tree
	 */
	protected Tree tree;
	
	public TreeCreateImpl(Tree tree) {
		this.tree = tree;
	}

}
