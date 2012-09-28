package de.kp.ames.web.client.core.apps;
/**
 *	Copyright 2012 Dr. Krusche & Partner PartG
 *
 *	AMES-Disaster is free software: you can redistribute it and/or 
 *	modify it under the terms of the GNU General Public License 
 *	as published by the Free Software Foundation, either version 3 of 
 *	the License, or (at your option) any later version.
 *
 *	AMES-Disaster is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 *  See the GNU General Public License for more details. 
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this software. If not, see <http://www.gnu.org/licenses/>.
 *
 */

/**
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.core.widget.base.ControlLabel;
import de.kp.ames.web.client.fnc.bulletin.widget.BulletinImpl;
import de.kp.ames.web.client.fnc.help.HelpImpl;
import de.kp.ames.web.client.fnc.login.DisclaimerDialog;
import de.kp.ames.web.client.fnc.scm.ScmSysImpl;
import de.kp.ames.web.client.fnc.service.DisclaimerService;
import de.kp.ames.web.client.fnc.workshop.widget.WorkshopImpl;
import de.kp.ames.web.client.test.ShowCaseImpl;
import de.kp.ames.web.shared.constants.ApplicationConstants;

public class CustomAppsManager extends AppsManager {

	private static CustomAppsManager instance = new CustomAppsManager();
	private String oldProfile = null;
	
	/**
	 * Constructor
	 */
	private CustomAppsManager() {}
	
	public static CustomAppsManager getInstance() {		
		if (instance == null) instance = new CustomAppsManager();
		return instance;
	}
	
	/**
	 * Create showcase viewport
	 */
	public void createShowCase() {
		
		/* 
		 * Remove the initial splash screen
		 */
		removeSplash();

		/*
		 * Create viewport
		 */
		createViewport();

		/*
		 * Create ShowCase
		 */
		createApp(ApplicationConstants.FNC_APP_ID_ShowCase);

	}

	/**
	 * Create showcase viewport
	 */
	public void createShowCase(JSONValue jValue) {

		JSONObject jObject = jValue.isObject();
		
		/*
		 * Retrieve User
		 */
		JSONObject jUser = jObject.get("user").isObject();
		UserManager.getInstance().setUser(jUser);
		
		/*
		 * Register callers apps
		 */
		this.jRegisteredApps = jObject.get("apps").isArray();
		
		/* 
		 * Remove the initial splash screen
		 */
		removeSplash();

		/*
		 * Create viewport
		 */
		createViewport();

		/*
		 * Create ShowCase
		 */
		createApp(ApplicationConstants.FNC_APP_ID_ShowCase);

	}

	/**
	 * Create operational viewport
	 */
	public void createOpsCase(JSONValue jValue) {
		
		JSONObject jObject = jValue.isObject();
		
		/*
		 * Retrieve User
		 */
		JSONObject jUser = jObject.get("user").isObject();
		UserManager.getInstance().setUser(jUser);
		
		/*
		 * Register callers apps
		 */
		this.jRegisteredApps = jObject.get("apps").isArray();
		
		/* 
		 * Remove the initial splash screen
		 */
		removeSplash();
		
		/*
		 * Create viewport
		 */
		createViewport();

		/* 
		 * Add the user to main topline
		 */
		viewport.setUser(UserManager.getInstance().getUserName());	

		/*
		 * Create desktop application as initial
		 * viewport to enable the user to select
		 * specific apps
		 */
		createDesktop();

		/*
		 * Show disclaimer dialog
		 */
		createDisclaimer();
		
	}

	@Override
	public void afterControlSelected(final String id, final ControlLabel control) {

		/*
		 * Deselect respective control
		 */
		control.setSelected(false);
		/*
		 * Invoke main controller to create the app
		 */ 
		CustomAppsManager.getInstance().createApp(id);

	}
	
	@Override
	public void createApp(String profile) {

		/*
		 * If same app switch back to Desktop
		 */
		if (oldProfile.equals(profile)) {
			return;
		}

		// remember chosen app
		oldProfile = profile;

		
		/*
		 * All apps are derived from an HLayout
		 */
		BaseApp app = null;		
		
		/*
		 * Create initial application either
		 * as a Web Desktop or Web Portal
		 */
		app = createInitialApp(profile);
		
		/*
		 * Create additional applications that refer to
		 * the current project environment
		 */		
		if (profile.equals(ApplicationConstants.FNC_APP_ID_Help)) {
			/*
			 * Create Online Help
			 */
			app = new HelpImpl();

		} else if (profile.equals(ApplicationConstants.FNC_APP_ID_Bulletin)) {
			/*
			 * Create Bulletin Board application
			 */
			app = new BulletinImpl();

		} else if (profile.equals(ApplicationConstants.FNC_APP_ID_ScmSys)) {
			/*
			 * Create Source Code Discovery application
			 */
			app = new ScmSysImpl();

		} else if (profile.equals(ApplicationConstants.FNC_APP_ID_ShowCase)) {
			/*
			 * Create ShowCase application for testing
			 * and presentation purpose
			 */
			app = new ShowCaseImpl();

		} else if (profile.equals(ApplicationConstants.FNC_APP_ID_Workshop)) {
			/*
			 * Create Workshop application for testing
			 * and presentation purpose
			 */
			app = new WorkshopImpl();

		}
		
		if (app == null) return;

		/*
		 * Set app as SearchHandler
		 */
		this.setSearchHandler(app);
		
		/*
		 * Append selected app
		 */
		replaceApp(app);
		
	}

	/**
	 * Show disclaimer dialog
	 */
	private void createDisclaimer() {

		DisclaimerService service = new DisclaimerService();
		service.doGetRequest(new ActivityImpl() {
			public void execute(String response) {
				new DisclaimerDialog(response);				
			}
		});

	}
	
}
