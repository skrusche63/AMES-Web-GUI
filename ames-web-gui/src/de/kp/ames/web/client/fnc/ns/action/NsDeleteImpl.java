package de.kp.ames.web.client.fnc.ns.action;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.ns.action
 *  Module: NsDeleteImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #delete #fnc #ns #web
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

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.action.tree.TreeDeleteImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.tree.Tree;
import de.kp.ames.web.client.fnc.ns.NsController;

public class NsDeleteImpl extends TreeDeleteImpl {

	/**
	 * Constructor
	 * 
	 * @param tree
	 * @param node
	 */
	public NsDeleteImpl(Tree tree, TreeNode node) {
		super(tree, node);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();
		
		final NsDeleteImpl self = this;
		NsController controller = new NsController();
		
		controller.doDelete(attributes, (TreeGrid) tree, node, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				
//				tree.removeAttribute(MethodConstants.ATTR_ITEM);
//				self.doAfterDelete(jValue);				
			}
		});
		
	}

}
