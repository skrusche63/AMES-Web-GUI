package de.kp.ames.web.client.fnc.access.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.access.handler
 *  Module: AccessGridMenuHandlerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #access #client #fnc #grid #handler #menu #web
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
import de.kp.ames.web.client.fnc.access.action.AccessorCreateImpl;
import de.kp.ames.web.client.fnc.access.action.AccessorDeleteImpl;
import de.kp.ames.web.client.fnc.access.action.AccessorEditImpl;
import de.kp.ames.web.client.fnc.access.action.AccessorGetImpl;
import de.kp.ames.web.client.fnc.access.action.RemoteGetImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;
import de.kp.ames.web.client.menu.EditMenuItem;
import de.kp.ames.web.client.menu.GetMenuItem;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class AccessGridMenuHandlerImpl extends GridMenuHandlerImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public AccessGridMenuHandlerImpl(Grid grid) {
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
		 * Distinguish between accessors and actually registered
		 * remote information objects
		 */

		String type = this.getParam(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Accessor)) {

			/****************************************************************
			 * 
			 * ACCESSOR      ACCESSOR      ACCESSOR      ACCESSOR
			 * 
			 ***************************************************************/

			/*
			 * Create Accessor
			 */
			AccessorCreateImpl createAction = new AccessorCreateImpl(grid);
			createAction.setParams(this.getParams());
			
			CreateMenuItem create = new CreateMenuItem();
			create.addAction(createAction);
			
			items.add(create);
			
			if (record != null) {
			
				/*
				 * Separate create from block edit & delete
				 */
				items.add(separator);
				
				/*
				 * Edit accessor
				 */
				AccessorEditImpl editAction = new AccessorEditImpl(grid, record);
				editAction.setParams(this.getParams());
				
				EditMenuItem edit = new EditMenuItem();
				edit.addAction(editAction);
				
				items.add(edit);
				
				/*
				 * Delete accessor
				 */
				AccessorDeleteImpl deleteAction = new AccessorDeleteImpl(grid, record);
				deleteAction.setParams(this.params);
				
				DeleteMenuItem delete = new DeleteMenuItem();
				delete.addAction(deleteAction);
				
				items.add(delete);
	
				/*
				 * Separate get from block edit & delete
				 */
				items.add(separator);
	
				/*
				 * Get accessor
				 */
				AccessorGetImpl getAction = new AccessorGetImpl(grid, record);
				getAction.setParams(this.getParams());
				
				GetMenuItem get = new GetMenuItem();
				get.addAction(getAction);
				
				items.add(get);

			}
			
		} else {

			/****************************************************************
			 * 
			 * REMOTE OBJECT     REMOTE OBJECT     REMOTE OBJECT     REMOTE
			 * 
			 ***************************************************************/
			
			if (record != null) {
			
				/*
				 * Get remote object
				 */
				RemoteGetImpl getAction = new RemoteGetImpl(grid, record);
				getAction.setParams(this.getParams());
				
				GetMenuItem get = new GetMenuItem();
				get.addAction(getAction);
				
				items.add(get);

			}
			
		}
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}

}
