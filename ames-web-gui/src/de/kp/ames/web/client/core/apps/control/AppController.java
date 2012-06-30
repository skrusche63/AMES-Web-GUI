package de.kp.ames.web.client.core.apps.control;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONString;
import de.kp.ames.web.client.core.globals.CoreAttrs;
import de.kp.ames.web.client.function.globals.FncGlobals;
import de.kp.ames.web.client.function.portal.PortletConfig;

public class AppController {

	private static String ID   = CoreAttrs.RIM_ID;
	private static String NAME = CoreAttrs.RIM_NAME;
	
	private static AppController instance = new AppController();
	private AppController() {}
	
	public static AppController getInstance() {
		if (instance == null) instance = new AppController();
		return instance;
	}

	/**
	 * This method invokes an OASIS ebXML registry to retrieve
	 * the set of registered help apps that has been assigned
	 * to the current user
	 * 
	 * @return
	 */
	public ArrayList<PortletConfig> getPersonalizedHelp() {
		
		ArrayList<PortletConfig> portlets  = new ArrayList<PortletConfig>();		
		PortletConfig portlet = null;

		/*
		 * Online help
		 */
		
		portlet = new PortletConfig();
		
		portlet.put(ID,   new JSONString(FncGlobals.FNC_APP_ID_Help));
		portlet.put(NAME, new JSONString(FncGlobals.HELP_TITLE));

		portlets.add(portlet);
		
		return portlets;

	}

	/**
	 * This method invokes an OASIS ebXML registry to retrieve
	 * the set of registered applications that has been assigned
	 * to the current user
	 * 
	 * @return
	 */
	public ArrayList<PortletConfig> getPersonalizedApps() {
		
		ArrayList<PortletConfig> portlets  = new ArrayList<PortletConfig>();		
		PortletConfig portlet = null;

		/*
		 * Bulletin Board
		 */
		
		portlet = new PortletConfig();
		
		portlet.put(ID,   new JSONString(FncGlobals.FNC_APP_ID_Bulletin));
		portlet.put(NAME, new JSONString(FncGlobals.BULLETIN_TITLE));

		portlets.add(portlet);

		/*
		 * ScmSys
		 */
		
		portlet = new PortletConfig();
		
		portlet.put(ID,   new JSONString(FncGlobals.FNC_APP_ID_ScmSys));
		portlet.put(NAME, new JSONString(FncGlobals.SCM_TITLE));

		portlets.add(portlet);
		
		return portlets;

	}
}
