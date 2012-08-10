package de.kp.ames.web.client.menu;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.menu
 *  Module: BaseMenuItem
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #base #client #item #menu #web
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

import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

import de.kp.ames.web.client.action.Action;

public class BaseMenuItem extends MenuItem {

	/**
	 * Constructor
	 * 
	 * @param title
	 * @param icon
	 */
	public BaseMenuItem(String title, String icon) {
		
		this.setTitle(title);
		this.setIcon(icon);
		
	}

	/**
	 * Constructor
	 * 
	 * @param title
	 * @param icon
	 * @param action
	 */
	public BaseMenuItem(String title, String icon, final Action action) {
		
		this.setTitle(title);
		this.setIcon(icon);
		
		this.addClickHandler(new ClickHandler() {

			public void onClick(MenuItemClickEvent event) {
				action.execute();				
			}
			
		});
		
	}
	
	/**
	 * @param action
	 */
	public void addAction(final Action action) {

		this.addClickHandler(new ClickHandler() {

			public void onClick(MenuItemClickEvent event) {
				action.execute();				
			}
			
		});
		
	}
}
