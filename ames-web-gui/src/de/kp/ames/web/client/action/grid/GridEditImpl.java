package de.kp.ames.web.client.action.grid;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.action.grid
 *  Module: GridEditImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #edit #grid #web
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

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import de.kp.ames.web.client.action.ActionImpl;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.grid.Grid;

public class GridEditImpl extends ActionImpl {

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
	public GridEditImpl(Grid grid, Record record) {	
		this.grid = grid;
		this.record = record;
	}

	/**
	 * A typical after edit activity (may be overridden)
	 * 
	 * @param jValue (server response)
	 */
	public void doAfterEdit(JSONValue jValue) {

		this.registerResponse(jValue);
		if (this.isSuccess()) {					
			/*
			 * Update grid
			 */
			grid.reload();
		
		} else {
			/*
			 * Fail message
			 */
			String message = this.getMessage();
			SC.say(GUIGlobals.APP_TITLE + ": Request Error", message);		

		}

	}

}
