package de.kp.ames.web.client.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.handler
 *  Module: GridMenuHandler
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
import com.smartgwt.client.widgets.menu.MenuItem;

import de.kp.ames.web.client.core.controller.Controller;
import de.kp.ames.web.client.core.grid.Grid;

public interface GridMenuHandler {

	/**
	 * @param record
	 */
	public void doOpen(Record record);

	/**
	 * @return
	 */
	public MenuItem[] createMenuItems(Record record);

	/**
	 * @param key
	 * @return
	 */
	public String getParam(String key);

	/**
	 * @return
	 */
	public HashMap<String,String> getParams();
	
	/**
	 * @param key
	 * @param value
	 */
	public void setParam(String key, String value);

	/**
	 * @param params
	 */
	public void setParams(HashMap<String,String> params);


	/**
	 * @param controller
	 */
	public void setController(Controller controller);
	
	/**
	 * @param grid
	 */
	public void setGrid(Grid grid);

}
