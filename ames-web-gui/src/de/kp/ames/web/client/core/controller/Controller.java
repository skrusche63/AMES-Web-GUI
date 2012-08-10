package de.kp.ames.web.client.core.controller;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.controller
 *  Module: Controller
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

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.grid.Grid;

public interface Controller {

	/**
	 * @param attributes
	 * @param grid
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Grid grid, Activity activity);

	/**
	 * @param attributes
	 * @param grid
	 * @param record
	 * @param activity
	 */
	public void doDelete(HashMap<String,String> attributes, Grid grid, Record record, Activity activity);

	/**
	 * @param attributes
	 * @param record
	 */
	public void doView(HashMap<String,String> attributes, Record record);

}
