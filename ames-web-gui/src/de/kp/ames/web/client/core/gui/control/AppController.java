package de.kp.ames.web.client.core.gui.control;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONString;

import de.kp.ames.web.client.core.globals.CoreAttributes;
import de.kp.ames.web.client.core.gui.portal.PortletConfig;

public class AppController {

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
		
		ArrayList<PortletConfig> portletConfigs  = new ArrayList<PortletConfig>();		
		PortletConfig portletConfig = null;
		
		for (int i=0; i < 5; i++) {
			
			portletConfig = new PortletConfig();
			portletConfig.put(CoreAttributes.RIM_ID, new JSONString("urn:de:kp:app:" + i));
		
			portletConfig.put(CoreAttributes.RIM_NAME, new JSONString("Portlet " + i));
			portletConfig.put(CoreAttributes.RIM_URI,  new JSONString("http://www.smartclient.com/smartgwt/showcase/#main"));
			
			portletConfigs.set(i, portletConfig);

		}
		
		return portletConfigs;

	}
}
