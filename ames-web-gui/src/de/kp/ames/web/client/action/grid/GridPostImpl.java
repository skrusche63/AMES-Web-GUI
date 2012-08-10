package de.kp.ames.web.client.action.grid;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.action.grid
 *  Module: GridPostImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #grid #post #web
 * </SemanticAssist>
 *
 */


import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import de.kp.ames.web.client.action.ActionImpl;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.grid.Grid;

public class GridPostImpl extends ActionImpl {

	/*
	 * Reference to Grid
	 */
	protected Grid grid;
	
	/*
	 * Reference to Record
	 */
	protected Record record;
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public GridPostImpl(Grid grid, Record record) {	
		this.grid = grid;
		this.record = record;
	}

	/**
	 * A typical after post activity (may be overridden)
	 * 
	 * @param jValue (server response)
	 */
	public void doAfterPost(JSONValue jValue) {

		this.registerResponse(jValue);
		if (this.isSuccess()) {					
			/*
			 * Project specific response
			 */
			
		} else {
			/*
			 * Fail message
			 */
			String message = this.getMessage();
			SC.say(GUIGlobals.APP_TITLE + ": Request Error", message);		

		}

	}

}
