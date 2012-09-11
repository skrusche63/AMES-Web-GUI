package de.kp.ames.web.client.fnc.user.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.user.handler
 *  Module: UserGridMenuHandlerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #grid #handler #menu #user #web
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

import java.util.ArrayList;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.role.action.ResponsibilityGetImpl;
import de.kp.ames.web.client.fnc.user.action.UserEditImpl;
import de.kp.ames.web.client.fnc.user.action.UserGetImpl;
import de.kp.ames.web.client.fnc.user.action.UserRoleImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.EditMenuItem;
import de.kp.ames.web.client.menu.GetMenuItem;
import de.kp.ames.web.client.menu.ResponsibilityMenuItem;
import de.kp.ames.web.client.menu.RoleMenuItem;
import de.kp.ames.web.shared.constants.MethodConstants;

public class UserGridMenuHandlerImpl extends GridMenuHandlerImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public UserGridMenuHandlerImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.GridMenuHandlerImpl#createMenuItems(com.smartgwt.client.data.Record)
	 */
	public MenuItem[] createMenuItems(Record record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		if (record != null) {
			
			/* 
			 * Separator
			 */
			MenuItemSeparator separator = new MenuItemSeparator();
			
			/*
			 * Edit user
			 */
			UserEditImpl editAction = new UserEditImpl(grid, record);
			editAction.setParams(this.getParams());
			
			EditMenuItem edit = new EditMenuItem();
			edit.addAction(editAction);
			
			items.add(edit);
	
			/*
			 * Seperate edit from view
			 */
			items.add(separator);
			
			/*
			 * Get user
			 */
			UserGetImpl getAction = new UserGetImpl(grid, record);
			getAction.setParams(this.getParams());
			
			GetMenuItem get = new GetMenuItem();
			get.addAction(getAction);
			
			items.add(get);
			
			/*
			 * Determine whether this user is an affiliate of
			 * a certain community
			 */
			String item = this.getParam(MethodConstants.ATTR_ITEM);
			if (item != null) {
				
				/*
				 * Separate roles from get
				 */
				items.add(separator);

				UserRoleImpl roleAction = new UserRoleImpl(grid, record);
				roleAction.setParams(this.getParams());
				
				RoleMenuItem role = new RoleMenuItem();
				role.addAction(roleAction);
				
				items.add(role);

			}

			/*
			 * Separate responsibility from get or roles
			 */
			items.add(separator);
			
			/*
			 * Responsibilities
			 */
			ResponsibilityGetImpl responsibilityAction = new ResponsibilityGetImpl(grid, record);
			responsibilityAction.setParams(this.getParams());
			
			ResponsibilityMenuItem responsibility = new ResponsibilityMenuItem();
			responsibility.addAction(responsibilityAction);
			
			items.add(responsibility);

		}
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}

}
