package de.kp.ames.web.client.action.grid;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;

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
	protected ListGridRecord record;
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public GridPostImpl(Grid grid, ListGridRecord record) {	
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
