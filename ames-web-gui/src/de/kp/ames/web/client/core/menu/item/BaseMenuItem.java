package de.kp.ames.web.client.core.menu.item;

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
