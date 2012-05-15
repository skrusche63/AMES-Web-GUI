package de.kp.ames.web.client.core.gui.control;
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
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.callback.ActivityCallback;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.gui.apps.BaseApp;
import de.kp.ames.web.client.core.gui.apps.KPApplication;
import de.kp.ames.web.client.core.gui.apps.RegisteredPortlets;
import de.kp.ames.web.client.core.gui.base.Viewport;
import de.kp.ames.web.client.core.gui.globals.GUIGlobals;
import de.kp.ames.web.client.core.gui.handler.ISearch;
import de.kp.ames.web.client.core.gui.search.SearchWidget;
import de.kp.ames.web.client.function.gui.bulletin.BulletinImpl;
import de.kp.ames.web.client.function.gui.desktop.DesktopImpl;
import de.kp.ames.web.client.function.gui.globals.FncGlobals;
import de.kp.ames.web.client.function.gui.help.HelpImpl;
import de.kp.ames.web.client.function.gui.login.LoginDialog;
import de.kp.ames.web.client.function.gui.portal.PortalImpl;
import de.kp.ames.web.client.function.gui.portal.PortletConfig;
import de.kp.ames.web.client.function.gui.scm.ScmSysImpl;

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
	private ISearch searchHandler;
	
	/**
	 * Constructor
	 */
	private MainController() {}
	
	public static MainController getInstance() {		
		if (instance == null) instance = new MainController();
		return instance;
	}
	
	/**
	 * Create introduction viewport when
	 * starting the AMES Web application
	 */
	public void createWelcome() {
		
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
		new LoginDialog(new ActivityCallback() {
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
			app = new BulletinImpl();

		} else if (profile.equals(FncGlobals.FNC_APP_ID_Desktop)) {
			app = new DesktopImpl();
		
		} else if (profile.equals(FncGlobals.FNC_APP_ID_Help)) {
			app = new HelpImpl();

		} else if (profile.equals(FncGlobals.FNC_APP_ID_Portal)) {
			/* 
			 * Retrieve registered portlets for the caller's user
			 */
			ArrayList<PortletConfig> portletConfigs = RegisteredPortlets.getAsPortlets();
			app = new PortalImpl(4, portletConfigs);

		} else if (profile.equals(FncGlobals.FNC_APP_ID_ScmSys)) {
			app = new ScmSysImpl();
			
		}

		if (app == null) return;

		/*
		 * Append selected app
		 */
		replaceApp(app);
		
	}
	
	public void createApp(JSONObject jApp) {
		
		KPApplication app = new KPApplication(jApp);
		
		/* 
		 * Remove the existing application
		 */
		viewport.removeMember(viewport.getMember(1));
		
		/* 
		 * Create wrapper
		 */
		VLayout wrapper = new VLayout();
		wrapper.setOverflow(Overflow.HIDDEN);
		
		wrapper.addMember(app);		
		viewport.addMember(wrapper);

		container.draw();

		
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
	public void setSearchHandler(ISearch handler) {
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
		 * AMES Web Service base url
		 */
		String url = CoreGlobals.BASE_URL;
		
		/*
		 * Interface parameters for the search
		 * method 'suggest'
		 */
		Map<String, String> params = new HashMap<String, String>();
		params.put("method", "suggest");
		
		DataSourceField[] fields = {
			new DataSourceTextField("id"),
			new DataSourceTextField("term")
		};
		
		/*
		 * Setup search widget
		 */
		searchWidget = new SearchWidget(url, params, fields);
		
		searchWidget.setQuery(this.searchQuery);
		searchWidget.setHandler(this.searchHandler);

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
