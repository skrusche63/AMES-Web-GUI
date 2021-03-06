package de.kp.ames.web.client.fnc.role.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.role.handler
 *  Module: ResponsibilityGridMenuHandlerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #grid #handler #menu #responsibility #role #web
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
import de.kp.ames.web.client.fnc.role.action.ResponsibilityCreateImpl;
import de.kp.ames.web.client.fnc.role.action.ResponsibilityDeleteImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;

public class ResponsibilityGridMenuHandlerImpl extends GridMenuHandlerImpl {
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public ResponsibilityGridMenuHandlerImpl(Grid grid) {
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

		return (MenuItem[])items.toArray(new MenuItem [items.size()]);

	}

}
