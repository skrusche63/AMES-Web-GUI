package de.kp.ames.web.client.core.apps;
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

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

import de.kp.ames.web.client.core.desktop.DesktopImpl;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.portal.PortalImpl;
import de.kp.ames.web.client.core.search.SearchHandler;
import de.kp.ames.web.client.core.search.SearchWidget;
import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.core.widget.base.ControlLabel;
import de.kp.ames.web.client.core.widget.base.Viewport;
import de.kp.ames.web.client.fnc.bulletin.widget.BulletinImpl;
import de.kp.ames.web.client.fnc.comm.widget.ChatImpl;
import de.kp.ames.web.client.fnc.comm.widget.MailImpl;
import de.kp.ames.web.shared.constants.ApplicationConstants;
import de.kp.ames.web.shared.constants.JsonConstants;

public class AppsManager {

	/* 
	 * The viewport for the application
	 */
	protected VLayout container;
	protected Viewport viewport;
	
	/*
	 * 
	 * Reference to accessible apps for callers user
	 */
	protected JSONArray jRegisteredApps;
	
	/*
	 * Reference to the selected application
	 */
	protected BaseApp selectedApp;
	
	/*
	 * Reference to the SearchWidget
	 */
	protected SearchWidget searchWidget;
		
	/*
	 * Reference to the search query
	 */
	protected String searchQuery;
	
	/*
	 * Search (result) handler
	 */
	protected SearchHandler searchHandler;

	/**
	 * A helper method to remove the initial 
	 * splash screen
	 */
	public void removeSplash() {
		/* 
		 * Remove the initial splash screen
		 */
		Element splash = DOM.getElementById(GuiConstants.SPLASH_ID);
		DOM.removeChild(RootPanel.getBodyElement(), splash);
		
	}
	
	/**
	 * Create desktop application as initial
	 * viewport to enable the user to select
	 * specific apps
	 */
	public void createDesktop() {
		createApp(ApplicationConstants.FNC_APP_ID_Desktop);
	}

	/**
	 * Create portal application as initial
	 * viewport to enable the user to select
	 * specific apps
	 */
	public void createPortal() {
		createApp(ApplicationConstants.FNC_APP_ID_Portal);
	}
	
	/**
	 * A helper method to create the viewport
	 */
	public void createViewport() {
	
		/*
		 * Build view port of the application
		 */
		container = new VLayout();
		container.setShowEdges(false);
		
		container.setWidth100();
		container.setHeight100();
	
		container.setOverflow(Overflow.HIDDEN);
		
		viewport = new Viewport();
		container.addMember(viewport);
		
		container.draw();
	
	}

	/**
	 * Populate the main application menu
	 * with registered apps as items
	 * 
	 * @param control
	 * @return
	 */
	public MenuItem[] getRegisteredAppsAsItems(final ControlLabel control) {

		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
	
		if (jRegisteredApps != null) {

			for (int i=0; i < jRegisteredApps.size(); i++) {
			
				JSONObject jRegisteredApp = jRegisteredApps.get(i).isObject();
				
				final String id    = jRegisteredApp.get(JsonConstants.J_ID).isString().stringValue();
				final String title = jRegisteredApp.get(JsonConstants.J_NAME).isString().stringValue();
				
				MenuItem item = new MenuItem(title);		
				
				item.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
					public void onClick(MenuItemClickEvent event) {
						afterControlSelected(id, control);
					}				
				});
	
				items.add(item);
			}

		}
		
		return (MenuItem[])items.toArray(new MenuItem[items.size()]);
		
	}

	/**
	 * Populates the main communications menu
	 * with chat mail as items
	 * 
	 * @param control
	 * @return
	 */
	public MenuItem[] getRegisteredCommsAsItems(final ControlLabel control) {

		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		
		/*
		 * Chat
		 */		
		final String chatId    = ApplicationConstants.FNC_APP_ID_Chat;
		final String chatTitle = "Chat Communicator";
		
		MenuItem chatItem = new MenuItem(chatTitle);		
		
		chatItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			public void onClick(MenuItemClickEvent event) {
				afterControlSelected(chatId, control);
			}				
		});

		items.add(chatItem);

		/*
		 * Mail
		 */		
		final String mailId    = ApplicationConstants.FNC_APP_ID_Mail;
		final String mailTitle = "Mail Communicator";
		
		MenuItem mailItem = new MenuItem(mailTitle);		
		
		mailItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			public void onClick(MenuItemClickEvent event) {
				afterControlSelected(mailId, control);
			}				
		});

		items.add(mailItem);
		return (MenuItem[])items.toArray(new MenuItem[items.size()]);
		
	}

	/**
	 * A helper method to specify the action that is
	 * invoked after a control label has been clicked
	 * 
	 * @param id
	 * @param control
	 */
	public void afterControlSelected(final String id, final ControlLabel control) {
		/*
		 * Must be overridden
		 */
	}

	/**
	 * A helper method to append a selected application
	 * to the viewport, depending on the specific profile
	 * 
	 * @param profile
	 */
	public void createApp(String profile) {
		/*
		 * Must be overridden
		 */
	}
	
	/**
	 * A helper metod to create the bulletin board or
	 * chat and mai application from the respective profile
	 * 
	 * @param profile
	 * @return
	 */
	public BaseApp createCommApp(String profile) {

		if (profile.equals(ApplicationConstants.FNC_APP_ID_Bulletin)) {
			/*
			 * Create Bulletin Board application
			 */
			return new BulletinImpl();

		} else if (profile.equals(ApplicationConstants.FNC_APP_ID_Chat)) {
			/*
			 * Create Chat Communicator application
			 */
			return new ChatImpl();
			
		} else if (profile.equals(ApplicationConstants.FNC_APP_ID_Mail)) {
			/*
			 * Create Mail Communicator application
			 */
			return new MailImpl();

		}
		
		return null;
	
	}
	
	/**
	 * A helper metod to either create a web desktop
	 * or portal as the initial application
	 * 
	 * @param profile
	 * @return
	 */
	public BaseApp createInitialApp(String profile) {
		
		if (profile.equals(ApplicationConstants.FNC_APP_ID_Desktop)) {
			/*
			 * Create Web Desktop
			 */
			return new DesktopImpl(jRegisteredApps);

		} else if (profile.equals(ApplicationConstants.FNC_APP_ID_Portal)) {
			/*
			 * Create Web Portal
			 */
			return new PortalImpl(4, jRegisteredApps);

		}
		
		return null;
		
	}
	
	/**
	 * A helper method to replace the actual
	 * app with a new app
	 * 
	 * @param newApp
	 */
	public void replaceApp(BaseApp newApp) {

		/*
		 * Remove existing application from viewport;
		 * take into account that apps are always
		 * wrapped by vertical layouts
		 */
		
		/*
		 * Call application specific functionality
		 * before it is removed from the viewport
		 */
		if (selectedApp != null) selectedApp.beforeRemove();
		viewport.removeMember(viewport.getMember(1));
		
		/*
		 * Register new application as selected app
		 */
		selectedApp = newApp;
		
		/* 
		 * The wrapper is essential to get the vertical 
		 * scrollbar right in case of many portlets
		 */
		VLayout newWrapper = new VLayout();
		newWrapper.setOverflow(Overflow.AUTO);
		
		newWrapper.addMember(newApp);		
		viewport.addMember(newWrapper);

		container.draw();

	}

	/**
	 * This method controls all actions that have to be
	 * taken after the main application as changed its size
	 * 
	 * @param event
	 */
	public void afterResized(ResizedEvent event) {		
		if (searchWidget != null) searchWidget.afterResized(event);		
	}
	
	/**
	 * Set current application that acts as a
	 * response handler for search result
	 * 
	 * @param handler
	 */
	public void setSearchHandler(SearchHandler handler) {
		this.searchHandler = handler;
	}
	
	/**
	 * Search query term for 'suggest' search
	 * 
	 * @param query
	 */
	public void setSearchQuery(String query) {
		this.searchQuery = query;
	}
	
	/**
	 * Close search widget and remove from
	 * root panel
	 */
	public void closeSearch() {
		
		RootPanel.get().remove(searchWidget);
		
		searchWidget.destroy();
		searchWidget = null;
		
	}
	
	/**
	 * Method to open (and show) the search widget
	 */
	public void openSearch() {
		
		if (searchWidget != null) closeSearch();
		
		/*
		 * Setup search widget
		 */
		searchWidget = new SearchWidget();
		
		searchWidget.setQuery(this.searchQuery);
		searchWidget.addSearchHandler(this.searchHandler);

	}
	
	/**
	 * Toggle visibility of search widget
	 */
	public void toggleSearch() {

		if (searchWidget == null) 
			openSearch();
		
		else
			closeSearch();
		
	}

}
