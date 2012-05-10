package de.kp.ames.web.client.gui.control;
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
	private String userId   = CoreGlobals.GUEST_ID;
	private String userName = CoreGlobals.GUEST_NAME;
	
	/*
	 * User credentials
	 */
	private String alias   = null;
	private String keypass = null;
	
	/*
	 * Indicates whether caller's user
	 * is administrator
	 */
	private boolean isAdmin = false;

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
		this.userId = uid;
	}

	/**
	 * @param name
	 */
	public void setUserName(String name) {
		this.userName = name;
	}
	
	/**
	 * @return
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * @return
	 */
	public String getUserRole() {	
		if (userId.equals(CoreGlobals.GUEST_ID)) return "Registry Guest";
		return (isAdmin) ? "Registry Administrator" : "Registry User";		
	}
		
	/**
	 * Reset user parameters
	 */
	public void clearUser() {
		/*
		 * Reset user parameters to default
		 * parameters
		 */
		userId   = CoreGlobals.GUEST_ID;
		userName = CoreGlobals.GUEST_NAME;

		/*
		 * Reset user credentials
		 */
		alias   = null;
		keypass = null;
		
	}
	
	/**
	 * @param isAdmin
	 */
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	/**
	 * @return
	 */
	public boolean getIsAdmin() {
		return this.isAdmin;
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
