package de.kp.ames.web.client.function.rule;
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
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class RuleService extends ServiceImpl {

	/**
	 * Constructor
	 */
	public RuleService() {
		super(CoreGlobals.REG_URL, ServiceConstants.RULE_SERVICE_ID);
	}

	/**
	 * A JSON based non-widget APPLY request
	 * 
	 * @param source
	 * @param service
	 * @param data
	 * @param activity
	 */
	public void doApply(String source, String service, String data, Activity activity) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		
		attributes.put(MethodConstants.ATTR_SOURCE, source);
		attributes.put(MethodConstants.ATTR_SERVICE, service);

		doApply(attributes, data, activity);

	}

	/**
	 * A JSON based non-widget GET request
	 * 
	 * @param format
	 * @param type
	 * @param item
	 * @param activity
	 */
	public void doGet(String format, String type, String item, Activity activity) {
	
		HashMap<String,String> attributes = new HashMap<String,String>();

		attributes.put(MethodConstants.ATTR_FORMAT, format);
		attributes.put(MethodConstants.ATTR_TYPE,   type);
		
		if (item != null) attributes.put(MethodConstants.ATTR_ITEM, item);
		
		doGetJson(attributes, activity);
		
	}
	
}

