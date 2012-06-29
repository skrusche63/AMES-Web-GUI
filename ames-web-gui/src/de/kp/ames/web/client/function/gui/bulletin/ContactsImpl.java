package de.kp.ames.web.client.function.gui.bulletin;
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

import com.smartgwt.client.widgets.layout.VLayout;

public class ContactsImpl extends VLayout {

	private GroupsImpl groups;
	private UsersImpl users;
	
	public ContactsImpl() {
		
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Set groups & users
		 */
		groups = new GroupsImpl();
		users  = new UsersImpl();
		
		/*
		 * Set Dimensions and splitter
		 */
		
		groups.setHeight("50%");
		users.setHeight("50%");
		
		/*
		 * Show splitter for groups
		 */
		groups.setShowResizeBar(true);
		
		/*
		 * Set members to contacts
		 */
		this.setMembers(groups, users);

	}
}
