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

import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.ns.widget.NsCreateDialog;

public class NsWidget {

	/**
	 * Constructor
	 */
	public NsWidget() {
	}

	/**
	 * @param attributes
	 * @param afterSendActivity
	 */
	public void doCreate(HashMap<String,String> attributes, final Activity afterSendActivity) {

		/*
		 * Create dialog
		 */
		NsCreateDialog createDialog = new NsCreateDialog();
		
		/*
		 * Provide request specific information
		 */
		createDialog.setParams(attributes);
		createDialog.addSendActivity(afterSendActivity);
		
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
		// TODO
	}

	/**
	 * Edit namespace
	 * 
	 * @param attributes
	 * @param node
	 * @param afterSendActivity
	 */
	public void doEdit(HashMap<String,String> attributes, TreeNode node, final Activity afterSendActivity) {
		// TODO
	}

	/**
	 * Get namespace
	 * 
	 * @param attributes
	 * @param node
	 */
	public void doGet(HashMap<String,String> attributes, TreeNode node) {
		// TODO
	}

}
