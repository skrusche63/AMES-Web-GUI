package de.kp.ames.web.client.function.portal;
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

import com.google.gwt.json.client.JSONObject;

/**
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */

public class PortletConfig extends JSONObject {
	
	/*
	 * A Portlet is described by a JSON object; this object has
	 * a set of predefined parameters that 
	 */
	public static String PORTLET_ID    = "id";
	public static String PORTLET_TITLE = "title";

	public PortletConfig() {	
	}
	
	/**
	 * @param key
	 * @return
	 */
	public String getStringValue(String key) {
		return this.get(key).isString().stringValue();
	}
	
}
