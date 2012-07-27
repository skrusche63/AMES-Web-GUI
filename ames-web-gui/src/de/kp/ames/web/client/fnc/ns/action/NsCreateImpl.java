package de.kp.ames.web.client.fnc.ns.action;

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.action.tree.TreeCreateImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.tree.Tree;
import de.kp.ames.web.client.fnc.ns.NsWidget;

public class NsCreateImpl extends TreeCreateImpl {
	
	/**
	 * Constructor
	 * 
	 * @param tree
	 */
	public NsCreateImpl(Tree tree) {	
		super(tree);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();

		final NsCreateImpl self = this;
		
		NsWidget widget = new NsWidget();
		widget.doCreate(attributes, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.doAfterCreate(jValue);
			}
		});
	}

}
