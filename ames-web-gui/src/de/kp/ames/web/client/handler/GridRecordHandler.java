package de.kp.ames.web.client.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.handler
 *  Module: GridRecordHandler
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #grid #handler #record #web
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
import de.kp.ames.web.client.core.grid.Grid;

public interface GridRecordHandler {

	/**
	 * @param record
	 */
	public void doSelect(Record record);

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
	 * @param grid
	 */
	public void setGrid(Grid grid);
	
	/**
	 * @param key
	 * @param value
	 */
	public void setParam(String key, String value);

}
