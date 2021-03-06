package de.kp.ames.web.client.core.globals;

import com.google.gwt.user.client.DOM;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.globals
 *  Module: GUIGlobals
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #globals #gui #web
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

public class GuiConstants {

	/*
	 * Name of the anonymous user
	 */
	public static String ANONYMOUS_USER = "Guest";

	/*
	 * Main title of the application
	 */
	public static String APP_SLOGAN = "Share and visualize knowledge through the web.";
	public static String APP_TITLE  = "AMES Web";
	
	public static int APP_TITLE_WIDTH = 80;

	/*
	 * Button labels
	 */	
	public static String BTN_APPLY_LABEL  = "Apply";
	public static String BTN_CAN_LABEL    = "Cancel";
	public static String BTN_CREATE_LABEL = "Create";
	public static String BTN_LOGIN_LABEL  = "Login";
	public static String BTN_OK_LABEL     = "Ok";
	public static String BTN_SAVE_LABEL   = "Save";

	/*
	 * DOM identifier
	 */
	public static String SPLASH_ID = "x-splash";
		
	/*
	 * Default dimensions of button
	 */
	public static int BTN_WIDTH  = 80;
	public static int BTN_HEIGHT = 24;

	/*
	 * Default dimensions of a dialog
	 */
	public static int DIALOG_DIM = 360;
	/*
	 * Default dimensions of a viewer
	 */
	public static int VIEWER_DIM = 640;
	
	/*
	 * Icon Directory & suffix
	 */
	public static String ICON_DIR    = "icons/16/";
	public static String ICON_SUFFIX = ".png";


	public static String HISTORY_TOKEN = "historyToken";
	
	/*
	 * Base Url for the AMES Web Service(s)
	 */
	public static String BASE_URL = "http://localhost:8080";

	/*
	 * Connection Parameters
	 */
	public static int CONNECTION_TIMEOUT = 180000;

	/*
	 * Definition of Guest parameters
	 */
	public static String GUEST_ID   = "urn:de:kp:guest:user";
	public static String GUEST_NAME = "Anonymous";

	public static String GUEST_ROLE = "Registry Guest";
	
	/* 
	 * Property (in index.html) that describes the URL to the
	 * AMES Web Service
	 */

	public static String REG_ID  = "urn:de:kp:reg:url";	
	public static String REG_URL = DOM.getElementById(REG_ID).getAttribute("content");

	/* 
	 * Property (in index.html) that describes the URL to the
	 * Communication Service
	 */

	public static String COM_ID  = "urn:de:kp:com:url";	
	public static String COM_URL = DOM.getElementById(COM_ID).getAttribute("content");

	/*
	 * Property (in index.html) that describes the URL to the WMS Service
	 */
	public static String WMS_ID  = "urn:de:kp:wms:url";
	public static String WMS_URL = DOM.getElementById(WMS_ID).getAttribute("content");

	/*
	 * Property (in index.html) that describes the PATH to the client
	 */
	public static String CLIENT_PATH_ID  = "urn:de:kp:path";
	public static String CLIENT_PATH = DOM.getElementById(CLIENT_PATH_ID).getAttribute("content");

	/*
	 * Property (in index.html) to distinguish between showcase or operational use
	 */
	public static String SHOWCASE_FLAG_ID  = "urn:de:kp:showcase";
	public static boolean SHOWCASE_FLAG = Boolean.valueOf(DOM.getElementById(SHOWCASE_FLAG_ID).getAttribute("content"));

	/*
	 * AMES SCM specific constants
	 */
	public static int SCM_SUGGEST_WIDTH  = 420;
	public static int SCM_SUGGEST_HEIGHT = 600;

	public static String SCM_BROADER_LABEL = "From context";

}
