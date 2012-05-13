package de.kp.ames.web.client.core.gui.control;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONString;
import de.kp.ames.web.client.core.globals.CoreAttributes;
import de.kp.ames.web.client.core.gui.portal.PortletConfig;
import de.kp.ames.web.client.function.gui.globals.FncGlobals;

public class AppController {

	private static String ID = CoreAttributes.RIM_ID;
	
	private static AppController instance = new AppController();
	private AppController() {}
	
	public static AppController getInstance() {
		if (instance == null) instance = new AppController();
		return instance;
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
		 * ScmSys
		 */
		
		portlet = new PortletConfig();
		
		portlet.put(ID, new JSONString(FncGlobals.FNC_APP_ID_ScmSys));
		portlet.put(CoreAttributes.RIM_NAME, new JSONString(FncGlobals.SCM_TITLE));

		portlets.add(portlet);
		
		return portlets;

	}
}
