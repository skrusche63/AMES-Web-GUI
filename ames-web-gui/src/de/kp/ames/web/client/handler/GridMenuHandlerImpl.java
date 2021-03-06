package de.kp.ames.web.client.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.handler
 *  Module: GridMenuHandlerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #grid #handler #menu #web
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

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;

import de.kp.ames.web.client.core.controller.Controller;
import de.kp.ames.web.client.core.grid.Grid;

public class GridMenuHandlerImpl implements GridMenuHandler {

	/*
	 * Reference to Controller
	 */
	protected Controller controller;
	
	/*
	 * Reference to Grid
	 */
	protected Grid grid;
	
	/*
	 * Reference to parameters
	 */
	protected HashMap<String,String> params;
	
	/**
	 * Constructor
	 */
	public GridMenuHandlerImpl() {		
	}
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public GridMenuHandlerImpl(Grid grid) {
		this.grid = grid;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.GridMenuHandler#doOpen(com.smartgwt.client.data.Record)
	 */
	public void doOpen(Record record) {
		
		/*
		 * Show menu as context menu
		 */
		Menu menu = new Menu();
		menu.showContextMenu();

		menu.setItems(createMenuItems(record));
		
		/*
		 * Assign menu to underlying 
		 */
		this.grid.setMenu(menu);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.menu.GridMenuHandler#createMenuItems()
	 */
	public MenuItem[] createMenuItems(Record record) {
		/*
		 * Must be overridden
		 */
		return null;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.GridMenuHandler#setController(de.kp.ames.web.client.core.controller.Controller)
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.menu.GridMenuHandler#setGrid(de.kp.ames.web.client.core.grid.Grid)
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.menu.GridMenuHandler#setParam(java.lang.String, java.lang.String)
	 */
	public void setParam(String key, String value) {
		if (this.params == null) this.params = new HashMap<String,String>();
		this.params.put(key, value);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.menu.GridMenuHandler#getParam(java.lang.String)
	 */
	public String getParam(String key) {
		if ((this.params == null) || (this.params.containsKey(key) == false)) return null;
		return this.params.get(key);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.menu.GridMenuHandler#getParams()
	 */
	public HashMap<String,String> getParams() {
		return this.params;
	}


	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.GridMenuHandler#setParams(java.util.HashMap)
	 */
	public void setParams(HashMap<String,String> params) {
		this.params = params;
	}

}
