package de.kp.ames.web.client.core.gui.apps;
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

import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

import de.kp.ames.web.client.core.globals.CoreAttrs;
import de.kp.ames.web.client.core.gui.base.ControlLabel;
import de.kp.ames.web.client.core.gui.control.AppController;
import de.kp.ames.web.client.core.gui.control.MainController;
import de.kp.ames.web.client.function.gui.portal.PortletConfig;

public class RegisteredPortlets {

	public static ArrayList<PortletConfig> getAsPortlets() {
		return AppController.getInstance().getPersonalizedApps();
	}
	
	public static MenuItem[] getAsItems(final ControlLabel control) {

		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		AppController actrl = AppController.getInstance();
		
		/* 
		 * Personalized applications
		 */
		ArrayList<PortletConfig> portlets = actrl.getPersonalizedApps();
		for (int i=0; i < portlets.size(); i++) {
			
			final PortletConfig portlet = portlets.get(i);
			MenuItem item = new MenuItem(portlet.getStringValue(CoreAttrs.RIM_NAME));		
			
			item.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
				public void onClick(MenuItemClickEvent event) {
					 
					/*
					 * Deselect respective control
					 */
					control.setSelected(false);
					/*
					 * Invoke main controller to create the app
					 */ 
					MainController.getInstance().createApp(portlet.getStringValue(CoreAttrs.RIM_ID));
					
				}				
			});

			items.add(item);
		}

		return (MenuItem[])items.toArray(new MenuItem[items.size()]);
		
	}
}
