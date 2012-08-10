package de.kp.ames.web.client.core.controller;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.controller
 *  Module: ControllerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #controller #core #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.grid.Grid;

public class ControllerImpl implements Controller {

	public ControllerImpl() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.Controller#doCreate(java.util.HashMap, de.kp.ames.web.client.core.grid.Grid, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doCreate(HashMap<String,String> attributes, Grid grid, Activity activity) {
		/*
		 * Must be overridden
		 */
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.Controller#doDelete(java.util.HashMap, de.kp.ames.web.client.core.grid.Grid, com.smartgwt.client.data.Record, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doDelete(HashMap<String,String> attributes, Grid grid, Record record, Activity activity) {
		/*
		 * Must be overridden
		 */
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.Controller#doView(java.util.HashMap, com.smartgwt.client.data.Record)
	 */
	public void doView(HashMap<String,String> attributes, Record record) {
		/*
		 * Must be overridden
		 */
	}

}
