package de.kp.ames.web.client.core.gui.apps;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

import de.kp.ames.web.client.core.globals.CoreAttributes;
import de.kp.ames.web.client.core.gui.base.ControlLabel;
import de.kp.ames.web.client.core.gui.control.AppController;
import de.kp.ames.web.client.core.gui.control.MainController;
import de.kp.ames.web.client.core.gui.portal.PortletConfig;

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
		ArrayList<PortletConfig> portletConfigs = actrl.getPersonalizedApps();
		for (int i=0; i < portletConfigs.size(); i++) {
			
			final JSONObject jApp = portletConfigs.get(i).isObject();
			MenuItem item = new MenuItem(jApp.get(CoreAttributes.RIM_NAME).isString().stringValue());		
			
			item.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
				public void onClick(MenuItemClickEvent event) {
					/* 
					 * Deselect respective control
					 */
					control.setSelected(false);
					/* 
					 * Invoke main controller to create the app
					 */
					MainController.getInstance().createApp(jApp);
					
				}				
			});

			items.add(item);
		}
		
		if (items.size() > 0) items.add(new MenuItemSeparator());
		
		// application store
		MenuItem store = new MenuItem("Store...");
		store.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			public void onClick(MenuItemClickEvent event) {
				control.setSelected(false);
				// TODO
			}				
		});
		
		items.add(store);		
		return (MenuItem[])items.toArray(new MenuItem[items.size()]);
		
	}
}
