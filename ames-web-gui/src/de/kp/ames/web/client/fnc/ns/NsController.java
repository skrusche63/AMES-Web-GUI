package de.kp.ames.web.client.fnc.ns;
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
import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.ns.widget.NsCreateDialog;
import de.kp.ames.web.client.fnc.ns.widget.NsEditDialog;
import de.kp.ames.web.client.fnc.ns.widget.NsGetViewer;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
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
		 * The TreeNode references the parent node
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
	public void doDelete(final HashMap<String,String> attributes, final TreeNode node, final Activity activity) {

		SC.confirm(FncGlobals.CONFIRM_NS_DELETE, new BooleanCallback() {  
 
			public void execute(Boolean value) {  
                if (value != null && value) {  
                	/*
                	 * Delete confirmed
                	 */
                	doDeleteConfirmed(attributes, node, activity);
 
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
	public void doDeleteConfirmed(HashMap<String,String> attributes, TreeNode node, final Activity afterSendActivity) {

		/*
		 * Prepare data for delete request
		 */
		attributes.put(MethodConstants.ATTR_ITEM, node.getAttributeAsString(JaxrConstants.RIM_ID));
		
		/*
		 * Invoke delete request
		 */
		NsService service = new NsService();
		service.doDelete(attributes, afterSendActivity);

	}

	/**
	 * Edit namespace
	 * 
	 * @param attributes
	 * @param node
	 * @param afterSendActivity
	 */
	public void doEdit(final HashMap<String,String> attributes, final TreeNode node, final Activity afterSendActivity) {

		final NsController self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildEditDialog(attributes, jValue, afterSendActivity);
			}			
		};

		/*
		 * Retrieve actual version of namespace
		 */
		doGet(attributes, node, afterGetActivity);
		
	}

	/**
	 * Get namespace
	 * 
	 * @param attributes
	 * @param node
	 */
	public void doGet(final HashMap<String,String> attributes, final TreeNode node) {

		final NsController self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildGetViewer(attributes, jValue);
			}			
		};

		/*
		 * Retrieve actual version of namespace
		 */
		doGet(attributes, node, afterGetActivity);
		
	}

	/**
	 * Get namespace
	 * 
	 * @param attributes
	 * @param record
	 * @param afterGetActivity
	 */
	private void doGet(final HashMap<String,String> attributes, final TreeNode node, ActivityImpl afterGetActivity) {
		/*
		 * Prepare get request
		 */
		String format = FormatConstants.FNC_FORMAT_ID_Object;
		String item = node.getAttributeAsString(JaxrConstants.RIM_ID);

		String parent = null;
		
		/*
		 * Invoke get request
		 */
		NsService service = new NsService();
		service.doGet(format, item, parent, afterGetActivity);
		
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
