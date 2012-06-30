package de.kp.ames.web.client.function.portal;

import java.util.ArrayList;

import de.kp.ames.web.client.core.apps.BaseApp;

public class PortalImpl extends BaseApp {

	public PortalImpl(int portalColumns, ArrayList<PortletConfig> jPortlets) {
		super("Bulletin Board","");
	
		this.setWidth100();
		this.setHeight100();
		
		this.setContent(new Portal(portalColumns, jPortlets));
		
	}

}
