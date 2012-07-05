package de.kp.ames.web.client.function.user;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.function.user.widget.UserEditDialog;
import de.kp.ames.web.client.function.user.widget.UserFormImpl;
import de.kp.ames.web.client.function.user.widget.UserGetViewer;
import de.kp.ames.web.shared.FormatConstants;
import de.kp.ames.web.shared.JaxrConstants;

public class UserWidget {

	/**
	 * Constructor
	 */
	public UserWidget() {
	}
	
	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doEdit(HashMap<String,String> attributes, ListGridRecord record, final Activity afterSubmitActivity) {
		
		final UserWidget self = this;
		
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildEditDialog(jValue, afterSubmitActivity);
			}			
		};

		doGet(attributes, record, afterGetActivity);

	}

	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doGet(HashMap<String,String> attributes, ListGridRecord record) {

		final UserWidget self = this;
		
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildGetViewer(jValue);
			}			
		};

		doGet(attributes, record, afterGetActivity);
		
	}

	/**
	 * @param attributes
	 * @param record
	 * @param afterGetActivity
	 */
	private void doGet(HashMap<String,String> attributes, ListGridRecord record, ActivityImpl afterGetActivity) {
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
	 * Build User Viewer
	 * 
	 * @param jValue
	 */
	private void buildGetViewer(JSONValue jValue) {

		UserFormImpl form = new UserFormImpl();
		form.addFormData(jValue);		
		
		new UserGetViewer(form);
		
	}
	
	/**
	 * Build User Edit Dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(JSONValue jValue, Activity afterSubmitActivity) {
		
		UserEditDialog dialog = new UserEditDialog(jValue);
		dialog.addSendActivity(afterSubmitActivity);
		
	}
	
}