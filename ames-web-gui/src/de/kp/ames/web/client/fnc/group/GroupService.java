package de.kp.ames.web.client.fnc.group;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.group
 *  Module: GroupService
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #group #service #web
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

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class GroupService extends ServiceImpl {

	/**
	 * Constructor
	 */
	public GroupService() {
		super(GuiConstants.REG_URL, ServiceConstants.COMMUNITY_SERVICE_ID);
	}

	/**
	 * @param type
	 * @param data
	 * @param activity
	 */
	public void doDelete(String type, String data, Activity activity) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, type);
		
		doDelete(attributes, data, activity);

	}
	
	/**
	 * A JSON based non-widget GET request
	 * 
	 * @param format
	 * @param type
	 * @param source
	 * @param activity
	 */
	public void doGet(String format, String type, String item, String source, Activity activity) {

		HashMap<String,String> attributes = new HashMap<String,String>();

		attributes.put(MethodConstants.ATTR_FORMAT, format);
		attributes.put(MethodConstants.ATTR_TYPE,   type);
		
		if (item != null) attributes.put(MethodConstants.ATTR_ITEM, item);
		if (source != null) attributes.put(MethodConstants.ATTR_SOURCE, source);

		doGetJson(attributes, activity);
		
	}
	

}
