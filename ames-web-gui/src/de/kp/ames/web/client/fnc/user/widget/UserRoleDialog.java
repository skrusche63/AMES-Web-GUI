package de.kp.ames.web.client.fnc.user.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.user.widget
 *  Module: UserRoleDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #dialog #fnc #role #user #web #widget
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.client.core.widget.dialog.ApplyGridDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.role.RoleService;
import de.kp.ames.web.client.fnc.role.data.RoleGridImpl;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

/**
 * This widget ist used to assign a set of (predefined) roles
 * to a certain affiliation between a specific user and group
 * 
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */
public class UserRoleDialog extends ApplyGridDialog {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 480;
	private static int HEIGHT = 480;

	public UserRoleDialog(GridImpl grid) {
		super(FncGlobals.ROLE_E_TITLE, FncGlobals.ROLE_E_SLOGAN, grid);
		
		/*
		 * Button handling
		 */
		this.setShowCloseButton(true);
		this.setShowMinimizeButton(true);
		
		/*
		 * Set dimensions
		 */
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		
		/*
		 * The Comm Viewer is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

		this.draw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.GridDialog#doSend()
	 */
	public void doSend() {
		
		/*
		 * Retrieve request information
		 */
		HashMap<String,String> attributes = this.grid.getAttributes();
		
		/*
		 * Retrieve roles
		 */
		JSONArray jRoles = new JSONArray();
		Record[] selected = this.grid.getSelectedRecords();
		
		for (Record record:selected) {
			String role = record.getAttributeAsString(JaxrConstants.RIM_ID);
			jRoles.set(jRoles.size(), new JSONString(role));
			
		}
		
		JSONObject jData = new JSONObject();
		jData.put(JaxrConstants.RIM_ROLE, new JSONString(jRoles.toString()));
		
		String data = jData.toString();
		
		RoleService service = new RoleService();
		service.doSubmit(attributes, data, this.sendActivity);
		
	}

	/**
	 * @param attributes
	 * @param source (affiliate)
	 * @param activity
	 */
	public static void create(HashMap<String,String> attributes, String source, Activity activity) {
		
		String target = attributes.get(MethodConstants.ATTR_ITEM);
		String type   = ClassificationConstants.FNC_ID_Role;
		
		RoleGridImpl grid = new RoleGridImpl(type, source, target);
	
		UserRoleDialog dialog = new UserRoleDialog(grid);
		
		/*
		 * Provide request specific information
		 */
		dialog.setParams(attributes);
		dialog.addSendActivity(activity);
		
	}

}
