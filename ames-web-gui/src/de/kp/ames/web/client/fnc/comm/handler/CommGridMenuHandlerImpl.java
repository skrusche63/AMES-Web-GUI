package de.kp.ames.web.client.fnc.comm.handler;
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
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.comm.action.CommViewImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.ViewMenuItem;

public class CommGridMenuHandlerImpl extends GridMenuHandlerImpl {

	public CommGridMenuHandlerImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.menu.GridMenuHandlerImpl#createMenuItems(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	public MenuItem[] createMenuItems(ListGridRecord record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		/*
		 * View comm object
		 */
		CommViewImpl viewAction = new CommViewImpl(grid, record);
		viewAction.setParams(this.getParams());
		
		ViewMenuItem view = new ViewMenuItem();
		view.addAction(viewAction);
		
		items.add(view);
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);

	}

}
