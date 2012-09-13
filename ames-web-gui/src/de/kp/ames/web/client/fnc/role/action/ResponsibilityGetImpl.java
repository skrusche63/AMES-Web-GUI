package de.kp.ames.web.client.fnc.role.action;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.role.action
 *  Module: ResponsibilityGetImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #fnc #get #responsibility #role #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.action.grid.GridGetImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.role.RoleController;

public class ResponsibilityGetImpl extends GridGetImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public ResponsibilityGetImpl(Grid grid, Record record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();
		
		RoleController controller = new RoleController();
		controller.doGet(attributes, record);
		
	}


}
