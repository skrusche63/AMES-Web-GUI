package de.kp.ames.web.client.core.apps;
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

import de.kp.ames.web.client.core.globals.CoreGlobals;

public class UserController {

	private static UserController instance = new UserController();
	
	/*
	 * Default values for user id & name
	 */
	private String uid   = CoreGlobals.GUEST_ID;
	private String uname = CoreGlobals.GUEST_NAME;
	
	/*
	 * User credentials
	 */
	private String alias   = null;
	private String keypass = null;
	
	/*
	 * Default value for user role
	 */
	private String urole = CoreGlobals.GUEST_ROLE;

	/**
	 * Constructor
	 */
	private UserController() {}
	
	public static UserController getInstance() {
		if (instance == null) instance = new UserController();
		return instance;
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
		uid   = CoreGlobals.GUEST_ID;
		uname = CoreGlobals.GUEST_NAME;
		
		urole = CoreGlobals.GUEST_ROLE;
		
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
