package de.kp.ames.web.client.core.apps;

import java.util.ArrayList;

import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

import de.kp.ames.web.client.core.apps.control.AppController;
import de.kp.ames.web.client.core.apps.control.MainController;
import de.kp.ames.web.client.core.globals.CoreAttrs;
import de.kp.ames.web.client.core.widget.base.ControlLabel;
import de.kp.ames.web.client.function.portal.PortletConfig;

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
