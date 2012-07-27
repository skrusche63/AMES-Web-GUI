package de.kp.ames.web.client.fnc.role.handler;
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
import de.kp.ames.web.client.fnc.role.action.ResponsibilityCreateImpl;
import de.kp.ames.web.client.fnc.role.action.ResponsibilityDeleteImpl;
import de.kp.ames.web.client.fnc.role.action.RoleCreateImpl;
import de.kp.ames.web.client.fnc.role.action.RoleDeleteImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class RoleGridMenuHandlerImpl extends GridMenuHandlerImpl {
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public RoleGridMenuHandlerImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.GridMenuHandlerImpl#createMenuItems(com.smartgwt.client.data.Record)
	 */
	public MenuItem[] createMenuItems(Record record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		/* 
		 * Separator
		 */
		MenuItemSeparator separator = new MenuItemSeparator();

		/*
		 * Distinguish between responsibilities & roles
		 */

		String type = this.getParam(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Responsibility)) {
			
			/*
			 * Create responsibility
			 */
			ResponsibilityCreateImpl createAction = new ResponsibilityCreateImpl(grid);
			createAction.setParams(this.getParams());
			
			CreateMenuItem create = new CreateMenuItem();
			create.addAction(createAction);
			
			items.add(create);
			
			if (record != null) {
				
				/*
				 * Separate create from delete
				 */
				items.add(separator);
				
				/*
				 * Delete responsibility
				 */
				ResponsibilityDeleteImpl deleteAction = new ResponsibilityDeleteImpl(grid, record);
				deleteAction.setParams(this.getParams());
				
				DeleteMenuItem delete = new DeleteMenuItem();
				delete.addAction(deleteAction);
				
				items.add(delete);

			}
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Role)) {

			/*
			 * Create role
			 */
			RoleCreateImpl createAction = new RoleCreateImpl(grid);
			createAction.setParams(this.getParams());
			
			CreateMenuItem create = new CreateMenuItem();
			create.addAction(createAction);
			
			items.add(create);
			
			if (record != null) {
				
				/*
				 * Separate create from delete
				 */
				items.add(separator);
				
				/*
				 * Delete role
				 */
				RoleDeleteImpl deleteAction = new RoleDeleteImpl(grid, record);
				deleteAction.setParams(this.getParams());
				
				DeleteMenuItem delete = new DeleteMenuItem();
				delete.addAction(deleteAction);
				
				items.add(delete);

			}
			
		}
		

		return (MenuItem[])items.toArray(new MenuItem [items.size()]);

	}

}
