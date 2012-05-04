package de.kp.ames.web.client.core.service;

import de.kp.ames.web.client.core.method.RequestMethodImpl;

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

/**
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */

public interface Service {

	/**
	 * Unique Service Identifier
	 * @param sid
	 */
	public void setId(String sid);
	
	/**
	 * Base Url of associated web service
	 * @param base
	 */
	public void setBase(String base);

	/**
	 * Send GET request to web service
	 * @param method
	 */
	public void sendGetRequest(RequestMethodImpl method);

	/**
	 * Send POST request to web service
	 * @param method
	 * @param data
	 */
	public void sendPostRequest(RequestMethodImpl method, String data);
	
}
