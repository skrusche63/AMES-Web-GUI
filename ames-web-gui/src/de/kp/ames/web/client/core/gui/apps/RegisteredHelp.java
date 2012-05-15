package de.kp.ames.web.client.core.gui.apps;

import java.util.ArrayList;

import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

import de.kp.ames.web.client.core.globals.CoreAttributes;
import de.kp.ames.web.client.core.gui.base.ControlLabel;
import de.kp.ames.web.client.core.gui.control.AppController;
import de.kp.ames.web.client.core.gui.control.MainController;
import de.kp.ames.web.client.function.gui.portal.PortletConfig;

public class RegisteredHelp {

	public static MenuItem[] getAsItems(final ControlLabel control) {

		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		AppController actrl = AppController.getInstance();
		
		/* 
		 * Personalized applications
		 */
		ArrayList<PortletConfig> portlets = actrl.getPersonalizedHelp();
		for (int i=0; i < portlets.size(); i++) {
			
			final PortletConfig portlet = portlets.get(i);
			MenuItem item = new MenuItem(portlet.getStringValue(CoreAttributes.RIM_NAME));		
			
			item.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
				public void onClick(MenuItemClickEvent event) {
					 
					/*
					 * Deselect respective control
					 */
					control.setSelected(false);
					/*
					 * Invoke main controller to create the app
					 */ 
					MainController.getInstance().createApp(portlet.getStringValue(CoreAttributes.RIM_ID));
					
				}				
			});

			items.add(item);
		}

		return (MenuItem[])items.toArray(new MenuItem[items.size()]);
		
	}

}
