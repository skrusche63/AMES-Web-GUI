package de.kp.ames.web.client.action.tree;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.action.ActionImpl;
import de.kp.ames.web.client.core.globals.GUIGlobals;
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

	/**
	 * A typical after edit activity (may be overridden)
	 * 
	 * @param jValue (server response)
	 */
	public void doAfterEdit(JSONValue jValue) {

		this.registerResponse(jValue);
		if (this.isSuccess()) {					
			/*
			 * Project specific business logic
			 */
		} else {
			/*
			 * Fail message
			 */
			String message = this.getMessage();
			SC.say(GUIGlobals.APP_TITLE + ": Request Error", message);		

		}

	}

}
