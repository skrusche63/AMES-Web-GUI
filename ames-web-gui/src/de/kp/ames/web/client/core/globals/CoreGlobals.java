package de.kp.ames.web.client.core.globals;

import com.google.gwt.user.client.DOM;

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

public class CoreGlobals {

	/*
	 * Base Url for the AMES Web Service(s)
	 */
	public static String BASE_URL = "http://localhost";

	/*
	 * Connection Parameters
	 */
	public static int CONNECTION_TIMEOUT = 180000;

	/*
	 * Definition of Guest parameters
	 */
	public static String GUEST_ID   = "urn:de:kp:guest:user";
	public static String GUEST_NAME = "Anonymous";

	/* 
	 * Property (in index.html) that describes the URL to the
	 * AMES Web Service
	 */

	public static String REG_ID  = "urn:de:kp:reg:url";	
	public static String REG_URL = DOM.getElementById(REG_ID).getAttribute("content");

	/*
	 * Method
	 */
	public static String REGISTER_METHOD = "register";
	public static String SHOW_METHOD     = "show";
	
	/*
	 * Service identifier
	 */
	public static String DISCLAIMER_SERVICE_ID = "disclaimer";
	public static String LOGIN_SERVICE_ID      = "login";

}
