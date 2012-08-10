package de.kp.ames.web.client.fnc.user;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.user
 *  Module: UserController
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #controller #fnc #user #web
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
import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.fnc.user.widget.UserEditDialog;
import de.kp.ames.web.client.fnc.user.widget.UserGetViewer;
import de.kp.ames.web.client.fnc.user.widget.UserRoleDialog;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class UserController {

	/**
	 * Constructor
	 */
	public UserController() {
	}
	
	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {
		
		final UserController self = this;
		
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildEditDialog(attributes, jValue, afterSendActivity);
			}			
		};

		doGet(attributes, record, afterGetActivity);

	}

	/**
	 * @param attributes
	 * @param record
	 */
	public void doGet(final HashMap<String,String> attributes, final Record record) {

		final UserController self = this;
		
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildGetViewer(attributes, jValue);
			}			
		};

		doGet(attributes, record, afterGetActivity);
		
	}

	/**
	 * @param attributes
	 * @param record
	 * @param afterGetActivity
	 */
	private void doGet(HashMap<String,String> attributes, Record record, ActivityImpl afterGetActivity) {

		/*
		 * Prepare get request
		 */
		String format = FormatConstants.FNC_FORMAT_ID_Object;
		String item = record.getAttributeAsString(JaxrConstants.RIM_ID);
		
		/*
		 * Invoke get request
		 */
		UserService service = new UserService();
		service.doGet(format, item, afterGetActivity);
		
	}
	
	/**
	 * Manage user (affiliate) roles
	 * 
	 * @param attributes
	 * @param record
	 * @param afterSendActivity
	 */
	public void doRole(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {

		/*
		 * Prepare data
		 */
		String source = record.getAttributeAsString(JaxrConstants.RIM_ID);
		UserRoleDialog.create(attributes, source, afterSendActivity);
		
	}
		

	/**
	 * Build User Edit Dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(HashMap<String,String> attributes, JSONValue jValue, Activity afterSubmitActivity) {
		
		UserEditDialog dialog = new UserEditDialog(jValue);
		dialog.addSendActivity(afterSubmitActivity);
		
	}

	/**
	 * Build User Viewer
	 * 
	 * @param jValue
	 */
	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {
		UserGetViewer.create(attributes,  jValue);
	}
	
}
