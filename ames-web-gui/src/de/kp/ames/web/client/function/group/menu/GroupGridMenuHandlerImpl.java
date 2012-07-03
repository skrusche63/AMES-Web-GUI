package de.kp.ames.web.client.function.group.menu;
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

import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.function.group.action.GroupCreateImpl;
import de.kp.ames.web.client.function.group.action.GroupDeleteImpl;
import de.kp.ames.web.client.function.group.action.GroupEditImpl;
import de.kp.ames.web.client.menu.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.item.CreateMenuItem;
import de.kp.ames.web.client.menu.item.DeleteMenuItem;
import de.kp.ames.web.client.menu.item.EditMenuItem;

public class GroupGridMenuHandlerImpl extends GridMenuHandlerImpl {
	
	public GroupGridMenuHandlerImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.menu.GridMenuHandlerImpl#createMenuItems(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	public MenuItem[] createMenuItems(ListGridRecord record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		/* 
		 * Separator
		 */
		MenuItemSeparator separator = new MenuItemSeparator();

		/*
		 * Create Community
		 */
		CreateMenuItem create = new CreateMenuItem();
		create.addAction(new GroupCreateImpl(grid));
		
		items.add(create);
		
		/*
		 * Separate create from block edit & delete
		 */
		items.add(separator);
		
		/*
		 * Edit Community
		 */
		EditMenuItem edit = new EditMenuItem();
		edit.addAction(new GroupEditImpl(grid, record));
		
		items.add(edit);
		
		/*
		 * Delete Community
		 */
		DeleteMenuItem delete = new DeleteMenuItem();
		delete.addAction(new GroupDeleteImpl(grid, record));
		
		items.add(delete);
				
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);

	}

}
