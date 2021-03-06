package de.kp.ames.web.client.fnc.user.action;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.user.action
 *  Module: UserRoleImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #fnc #role #user #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.action.grid.GridRoleImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.user.UserController;

public class UserRoleImpl extends GridRoleImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public UserRoleImpl(Grid grid, Record record) {	
		super(grid, record);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();

		final UserRoleImpl self = this;		
		UserController controller = new UserController();
		
		controller.doRole(attributes, record, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.doAfterRole(jValue);
			}
		});

	}

}
