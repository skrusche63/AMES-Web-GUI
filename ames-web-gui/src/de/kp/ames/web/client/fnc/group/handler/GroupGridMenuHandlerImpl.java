package de.kp.ames.web.client.fnc.group.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.group.handler
 *  Module: GroupGridMenuHandlerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #grid #group #handler #menu #web
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
import de.kp.ames.web.client.fnc.group.action.GroupCategoryImpl;
import de.kp.ames.web.client.fnc.group.action.GroupCreateImpl;
import de.kp.ames.web.client.fnc.group.action.GroupDeleteImpl;
import de.kp.ames.web.client.fnc.group.action.GroupEditImpl;
import de.kp.ames.web.client.fnc.group.action.GroupGetImpl;
import de.kp.ames.web.client.fnc.role.action.ResponsibilityGetImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.CategoryMenuItem;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;
import de.kp.ames.web.client.menu.EditMenuItem;
import de.kp.ames.web.client.menu.GetMenuItem;
import de.kp.ames.web.client.menu.ResponsibilityMenuItem;

public class GroupGridMenuHandlerImpl extends GridMenuHandlerImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public GroupGridMenuHandlerImpl(Grid grid) {
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
		 * Create Community
		 */
		GroupCreateImpl createAction = new GroupCreateImpl(grid);
		createAction.setParams(this.getParams());
		
		CreateMenuItem create = new CreateMenuItem();
		create.addAction(createAction);
		
		items.add(create);
		
		if (record != null) {
			
			/*
			 * Separate create from edit & delete
			 */
			items.add(separator);
			
			/*
			 * Edit Community
			 */
			GroupEditImpl editAction = new GroupEditImpl(grid, record);
			editAction.setParams(this.getParams());
			
			EditMenuItem edit = new EditMenuItem();
			edit.addAction(editAction);
			
			items.add(edit);
			
			/*
			 * Delete Community
			 */
			GroupDeleteImpl deleteAction = new GroupDeleteImpl(grid, record);
			deleteAction.setParams(this.getParams());
			
			DeleteMenuItem delete = new DeleteMenuItem();
			delete.addAction(deleteAction);
			
			items.add(delete);
					
			/*
			 * Separate delete from get
			 */
			items.add(separator);
			
			/*
			 * Get community
			 */
			GroupGetImpl getAction = new GroupGetImpl(grid, record);
			getAction.setParams(this.getParams());
			
			GetMenuItem get = new GetMenuItem();
			get.addAction(getAction);
			
			items.add(get);
			
			/*
			 * Separate category from get
			 */
			items.add(separator);
			
			/*
			 * Category
			 */
			GroupCategoryImpl categoryAction = new GroupCategoryImpl(grid, record);
			categoryAction.setParams(this.getParams());
			
			CategoryMenuItem category = new CategoryMenuItem();
			category.addAction(categoryAction);
			
			items.add(category);

			/*
			 * Separate responsibility from category
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
