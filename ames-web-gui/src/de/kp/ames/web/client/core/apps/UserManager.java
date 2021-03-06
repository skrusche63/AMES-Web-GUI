package de.kp.ames.web.client.core.apps;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.apps
 *  Module: UserController
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #apps #client #controller #core #user #web
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

import com.google.gwt.json.client.JSONObject;

import de.kp.ames.web.client.core.globals.GuiConstants;

public class UserManager {

	private static UserManager instance = new UserManager();
	
	/*
	 * Default values for user id & name
	 */
	private String uid   = GuiConstants.GUEST_ID;
	private String uname = GuiConstants.GUEST_NAME;
	
	/*
	 * User credentials
	 */
	private String alias   = null;
	private String keypass = null;
	
	/*
	 * Default value for user role
	 */
	private String urole = GuiConstants.GUEST_ROLE;

	/**
	 * Constructor
	 */
	private UserManager() {}
	
	public static UserManager getInstance() {
		if (instance == null) instance = new UserManager();
		return instance;
	}
	
	public void setUser(JSONObject jUser) {
				
		/* 
		 * Retrieve information about current user
		 */
		String uid   = jUser.get("id").isString().stringValue();
		setUserId(uid);
		
		String name = jUser.get("name").isString().stringValue();
		setUserName(name);
		
		String role = jUser.get("role").isString().stringValue();
		setUserRole(role);
		
	}
	
	/**
	 * @param uid
	 */
	public void setUserId(String uid) {
		this.uid = uid;
	}

	/**
	 * @param name
	 */
	public void setUserName(String name) {
		this.uname = name;
	}
	
	/**
	 * @param role
	 */
	public void setUserRole(String role) {
		this.urole = role;
	}
	
	/**
	 * @return
	 */
	public String getUserId() {
		return this.uid;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return this.uname;
	}
	
	/**
	 * @return
	 */
	public String getUserRole() {	
		return this.urole;		
	}
		
	/**
	 * Reset user parameters
	 */
	public void clearUser() {
		/*
		 * Reset user parameters to default
		 * parameters
		 */
		uid   = GuiConstants.GUEST_ID;
		uname = GuiConstants.GUEST_NAME;
		
		urole = GuiConstants.GUEST_ROLE;
		
		/*
		 * Reset user credentials
		 */
		alias   = null;
		keypass = null;
		
	}
	
	/**
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	/**
	 * @return
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * @param keypass
	 */
	public void setKeypass(String keypass) {
		this.keypass = keypass;
	}
	
	/**
	 * @return
	 */
	public String getKeypass() {
		return this.keypass;
	}

}
