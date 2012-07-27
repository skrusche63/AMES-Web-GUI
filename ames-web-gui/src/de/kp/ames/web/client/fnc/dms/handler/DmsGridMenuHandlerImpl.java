package de.kp.ames.web.client.fnc.dms.handler;
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
import de.kp.ames.web.client.fnc.dms.action.DmsCreateImpl;
import de.kp.ames.web.client.fnc.dms.action.DmsDeleteImpl;
import de.kp.ames.web.client.fnc.dms.action.DmsDownloadImpl;
import de.kp.ames.web.client.fnc.dms.action.DmsEditImpl;
import de.kp.ames.web.client.fnc.dms.action.DmsGetImpl;
import de.kp.ames.web.client.fnc.dms.action.DmsViewImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;
import de.kp.ames.web.client.menu.DownloadMenuItem;
import de.kp.ames.web.client.menu.EditMenuItem;
import de.kp.ames.web.client.menu.GetMenuItem;
import de.kp.ames.web.client.menu.ViewMenuItem;

public class DmsGridMenuHandlerImpl extends GridMenuHandlerImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public DmsGridMenuHandlerImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.menu.GridMenuHandlerImpl#createMenuItems(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	public MenuItem[] createMenuItems(ListGridRecord record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		/* 
		 * Separator
		 */
		MenuItemSeparator separator = new MenuItemSeparator();

		/*
		 * Create Dms entry
		 */
		DmsCreateImpl createAction = new DmsCreateImpl(grid);
		createAction.setParams(this.getParams());

		CreateMenuItem create = new CreateMenuItem();
		create.addAction(createAction);
		
		items.add(create);
		
		/*
		 * Separate create from edit & delete
		 */
		items.add(separator);
		
		/*
		 * Edit Dms Entry
		 */
		DmsEditImpl editAction = new DmsEditImpl(grid, record);
		editAction.setParams(this.getParams());

		EditMenuItem edit = new EditMenuItem();
		edit.addAction(editAction);

		items.add(edit);
		
		/*
		 * Delete Dms Entry
		 */
		DmsDeleteImpl deleteAction = new DmsDeleteImpl(grid, record);
		deleteAction.setParams(this.getParams());

		DeleteMenuItem delete = new DeleteMenuItem();
		delete.addAction(deleteAction);
		
		items.add(delete);
		
		/*
		 * Separate get from edit & delete
		 */
		items.add(separator);
		
		/*
		 * Get Dms Entry
		 */
		DmsGetImpl getAction = new DmsGetImpl(grid, record);
		getAction.setParams(this.getParams());

		GetMenuItem get = new GetMenuItem();
		get.addAction(getAction);
		
		items.add(get);
		
		/*
		 * Separate get from view
		 */
		items.add(separator);
		
		/*
		 * View Dms Entry
		 */
		DmsViewImpl viewAction = new DmsViewImpl(grid, record);
		viewAction.setParams(this.getParams());

		ViewMenuItem view = new ViewMenuItem();
		view.addAction(viewAction);
		
		items.add(view);
		
		/*
		 * Separate download from view
		 */
		items.add(separator);

		DmsDownloadImpl downloadAction = new DmsDownloadImpl(grid, record);
		downloadAction.setParams(this.getParams());
		
		DownloadMenuItem download = new DownloadMenuItem();
		download.addAction(downloadAction);
		
		items.add(download);
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}

}
