package de.kp.ames.web.client.function.transform.handler;
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
import de.kp.ames.web.client.function.transform.action.TransformCreateImpl;
import de.kp.ames.web.client.function.transform.action.TransformDeleteImpl;
import de.kp.ames.web.client.function.transform.action.TransformViewImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;
import de.kp.ames.web.client.menu.ViewMenuItem;

public class TransformGridMenuHandlerImpl extends GridMenuHandlerImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public TransformGridMenuHandlerImpl(Grid grid) {
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
		 * Create transform
		 */
		TransformCreateImpl createAction = new TransformCreateImpl(grid);
		createAction.setParams(this.getParams());
		
		CreateMenuItem create = new CreateMenuItem();
		create.addAction(createAction);
		
		items.add(create);

		/*
		 * Separate create from delete
		 */
		items.add(separator);
		
		/*
		 * Delete transform
		 */
		TransformDeleteImpl deleteAction = new TransformDeleteImpl(grid, record);
		deleteAction.setParams(this.getParams());
		
		DeleteMenuItem delete = new DeleteMenuItem();
		delete.addAction(deleteAction);

		/*
		 * Separate delete from view
		 */
		items.add(separator);

		/*
		 * View upload
		 */
		TransformViewImpl viewAction = new TransformViewImpl(grid, record);
		viewAction.setParams(this.getParams());
		
		ViewMenuItem view = new ViewMenuItem();
		view.addAction(viewAction);
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}

}
