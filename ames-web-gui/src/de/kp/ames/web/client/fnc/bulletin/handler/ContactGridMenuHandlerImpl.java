package de.kp.ames.web.client.fnc.bulletin.handler;
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

import de.kp.ames.web.client.fnc.bulletin.action.PostCreateImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.PostMenuItem;

public class ContactGridMenuHandlerImpl extends GridMenuHandlerImpl {

	/**
	 * Constructor
	 */
	public ContactGridMenuHandlerImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.GridMenuHandlerImpl#createMenuItems(com.smartgwt.client.data.Record)
	 */
	public MenuItem[] createMenuItems(Record record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		/*
		 * Build post
		 */
		PostCreateImpl createAction = new PostCreateImpl(grid, record);
		createAction.setParams(this.getParams());
		
		PostMenuItem post = new PostMenuItem();
		post.addAction(createAction);
		
		items.add(post);
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}

}
