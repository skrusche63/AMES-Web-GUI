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

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.desktop.DesktopImpl;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.portal.PortalImpl;
import de.kp.ames.web.client.core.search.SearchHandler;
import de.kp.ames.web.client.core.search.SearchWidget;
import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.core.widget.base.ControlLabel;
import de.kp.ames.web.client.core.widget.base.Viewport;
import de.kp.ames.web.client.function.bulletin.widget.BulletinImpl;
import de.kp.ames.web.client.function.globals.FncGlobals;
import de.kp.ames.web.client.function.help.HelpImpl;
import de.kp.ames.web.client.function.login.LoginDialog;
import de.kp.ames.web.client.function.scm.ScmSysImpl;
import de.kp.ames.web.client.test.ShowCaseImpl;
import de.kp.ames.web.shared.JsonConstants;

/**
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */
public class MainController {

	private static MainController instance = new MainController();
	
	/* 
	 * The viewport for the application
	 */
	private VLayout container;
	private Viewport viewport;
	
	/*
	 * 
	 * Reference to accessible apps for callers user
	 */
	private JSONArray jRegisteredApps;
	
	/*
	 * Reference to the selected application
	 */
	private BaseApp selectedApp;
	
	/*
	 * Reference to the SearchWidget
	 */
	private SearchWidget searchWidget;
		
	/*
	 * Reference to the search query
	 */
	private String searchQuery;
	
	/*
	 * Search (result) handler
	 */
	private SearchHandler searchHandler;
	
	/**
	 * Constructor
	 */
	private MainController() {}
	
	public static MainController getInstance() {		
		if (instance == null) instance = new MainController();
		return instance;
	}
	
	public void createShowCase() {
		
		/* 
		 * Remove the initial splash screen
		 */
		Element splash = DOM.getElementById(GUIGlobals.SPLASH_ID);
		DOM.removeChild(RootPanel.getBodyElement(), splash);

		/*
		 * Create viewport
		 */
		createViewport();

		/*
		 * Create ShowCase
		 */
		createApp(FncGlobals.FNC_APP_ID_ShowCase);

	}
	
	
	/**
	 * Create introduction viewport when
	 * starting the AMES Web application
	 */
	public void createOpsCase(JSONArray jApps) {
		
		/*
		 * Register callers apps
		 */
		this.jRegisteredApps = jApps;
		
		/* 
		 * Remove the initial splash screen
		 */
		Element splash = DOM.getElementById(GUIGlobals.SPLASH_ID);
		DOM.removeChild(RootPanel.getBodyElement(), splash);
		
		/*
		 * Create viewport
		 */
		createViewport();
		
		/*
		 * Show Login Dialog: this dialog is used to
		 * retrieve additional user credentials
		 */
		new LoginDialog(new ActivityImpl() {
			public void execute() {				
				/* 
				 * Add the user to main topline, and 
				 * second replace the main application
				 */
				viewport.setUser(UserController.getInstance().getUserName());	
				
				/*
				 * Create desktop application as initial
				 * viewport to enable the user to select
				 * specific apps
				 */
				createApp(FncGlobals.FNC_APP_ID_Desktop);
				
			}
		});
		
	}

	public MenuItem[] getRegisteredAppsAsItems(final ControlLabel control) {

		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		if (jRegisteredApps != null) {

			/*
			 * In case of the ShowCase application no registered apps are provided
			 */
			for (int i=0; i < jRegisteredApps.size(); i++) {
			
				JSONObject jRegisteredApp = jRegisteredApps.get(i).isObject();
				
				final String id    = jRegisteredApp.get(JsonConstants.J_ID).isString().stringValue();
				final String title = jRegisteredApp.get(JsonConstants.J_NAME).isString().stringValue();
				
				MenuItem item = new MenuItem(title);		
				
				item.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
					public void onClick(MenuItemClickEvent event) {
						 
						/*
						 * Deselect respective control
						 */
						control.setSelected(false);
						/*
						 * Invoke main controller to create the app
						 */ 
						MainController.getInstance().createApp(id);
						
					}				
				});
	
				items.add(item);
			}

		}
		
		return (MenuItem[])items.toArray(new MenuItem[items.size()]);
		
	}

	/**
	 * A helper method to append a selected application
	 * to the viewport, depending on the specific profile
	 * 
	 * @param profile
	 */
	public void createApp(String profile) {
		
		/*
		 * All apps are derived from an HLayout
		 */
		BaseApp app = null;		
		if (profile.equals(FncGlobals.FNC_APP_ID_Bulletin)) {
			/*
			 * Create Bulletin Board application
			 */
			app = new BulletinImpl();

		} else if (profile.equals(FncGlobals.FNC_APP_ID_Desktop)) {
			/*
			 * Create Web Desktop
			 */
			createDesktop();
			return;
		
		} else if (profile.equals(FncGlobals.FNC_APP_ID_Help)) {
			app = new HelpImpl();

		} else if (profile.equals(FncGlobals.FNC_APP_ID_Portal)) {
			/*
			 * Create Web Portal
			 */
			createPortal();
			return;

		} else if (profile.equals(FncGlobals.FNC_APP_ID_ScmSys)) {
			/*
			 * Create Source Code Discovery application
			 */
			app = new ScmSysImpl();

		} else if (profile.equals(FncGlobals.FNC_APP_ID_ShowCase)) {
			/*
			 * Create ShowCase application for testing
			 * and presentation purpose
			 */
			app = new ShowCaseImpl();

		}

		if (app == null) return;

		/*
		 * Append selected app
		 */
		replaceApp(app);
		
	}
	
	/**
	 * A helper method to create a web desktop
	 * from the registered apps of the callers 
	 * user
	 */
	private void createDesktop() {
		replaceApp(new DesktopImpl(jRegisteredApps));

	}
	
	/**
	 * A helper method to create a web portal
	 * from the registered apps of the callers 
	 * user
	 */
	private void createPortal() {
		replaceApp(new PortalImpl(4, jRegisteredApps));
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
