package de.kp.ames.web.client.fnc.ns;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.ns
 *  Module: NsController
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #controller #fnc #ns #web
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
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.ns.widget.NsCreateDialog;
import de.kp.ames.web.client.fnc.ns.widget.NsEditDialog;
import de.kp.ames.web.client.fnc.ns.widget.NsGetViewer;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class NsController {

	/**
	 * Constructor
	 */
	public NsController() {
	}

	/**
	 * @param attributes
	 * @param node
	 * @param afterSendActivity
	 */
	public void doCreate(HashMap<String,String> attributes, final TreeNode node, final Activity afterSendActivity) {

		/*
		 * The TreeNode references the parent node; note, that the
		 * attributes provided here are managed by the Tree itself
		 * and used as parameters for server requests
		 */
		if (node != null) attributes.put(MethodConstants.ATTR_PARENT, node.getAttributeAsString(JaxrConstants.RIM_ID));
		NsCreateDialog.create(attributes, afterSendActivity);
		
	}

	/**
	 * Delete namespace
	 * 
	 * @param attributes
	 * @param node
	 * @param activity
	 */
	public void doDelete(final HashMap<String,String> attributes, final TreeGrid tree, final TreeNode node) {

		SC.confirm(FncGlobals.CONFIRM_NS_DELETE, new BooleanCallback() {  
 
			public void execute(Boolean value) {  
                if (value != null && value) {  
                	/*
                	 * Delete confirmed
                	 */
                	doDeleteConfirmed(attributes, tree, node);
 
                }  
            }  
        
		});

	}

	/**
	 * Delete namespace
	 * 
	 * @param attributes
	 * @param node
	 * @param afterSendActivity
	 */
	public void doDeleteConfirmed(HashMap<String,String> attributes, TreeGrid tree, TreeNode node) {

		/*
		 * Prepare data for delete request
		 */
		attributes.put(MethodConstants.ATTR_ITEM, node.getAttributeAsString(JaxrConstants.RIM_ID));
		tree.removeData(node);

	}

	/**
	 * Edit namespace
	 * 
	 * @param attributes
	 * @param node
	 * @param afterSendActivity
	 */
	public void doEdit(final HashMap<String,String> attributes, final TreeNode node, final Activity afterSendActivity) {

		/*
		 * A namespace is directly modified the DataSource mechanism
		 * of SmartGWT
		 */
		buildEditDialog(attributes, getJNode(node), afterSendActivity);
		
	}

	/**
	 * Get namespace
	 * 
	 * @param attributes
	 * @param node
	 */
	public void doGet(final HashMap<String,String> attributes, final TreeNode node) {

		/*
		 * A namespace is directly viewed using the data
		 * already present on the clinet side
		 */
		buildGetViewer(attributes, getJNode(node));
		
	}

	/**
	 * A helper method to retrieve selected data for
	 * further processing from a Node representation
	 * 
	 * @param node
	 * @return
	 */
	private JSONValue getJNode(TreeNode node) {
		/*
		 * Select data to be used
		 */
		String[] keys = {
				
				JaxrConstants.RIM_ID,
				JaxrConstants.RIM_DESC,
				JaxrConstants.RIM_NAME,
				JaxrConstants.RIM_SLOT,
				JsonConstants.J_ID
		
		};
		
		return JsonConverter.recordToJson(node, keys);
		
	}
	
	/**
	 * Build Namespace Edit Dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(HashMap<String,String> attributes, JSONValue jValue, Activity afterSendActivity) {
		NsEditDialog.create(attributes, jValue, afterSendActivity);
	}

	/**
	 * Build Namespace Viewer
	 * 
	 * @param jValue
	 */
	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {
		NsGetViewer.create(attributes, jValue);	
	}
}
