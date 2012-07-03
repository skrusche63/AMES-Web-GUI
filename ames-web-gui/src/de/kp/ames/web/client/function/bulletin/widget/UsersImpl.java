package de.kp.ames.web.client.function.bulletin.widget;
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

import de.kp.ames.web.client.function.bulletin.menu.PostGridMenuHandler;
import de.kp.ames.web.client.function.user.grid.UserGridImpl;

public class UsersImpl extends VLayout {

	/*
	 * Reference to registered users
	 */
	private UserGridImpl grid;
	
	/**
	 * Constructor
	 */
	public UsersImpl() {
		
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Build member
		 */
		grid = new UserGridImpl();

		/*
		 * Assign context specific menu handler
		 */
		grid.addMenuHandler(new PostGridMenuHandler());
		
		this.addMember(grid);
		
	}
	
}
