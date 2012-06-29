package de.kp.ames.web.client.function.gui.portal;

import java.util.ArrayList;

import de.kp.ames.web.client.core.gui.apps.BaseApp;

public class PortalImpl extends BaseApp {

	public PortalImpl(int portalColumns, ArrayList<PortletConfig> jPortlets) {
		super("Bulletin Board","");
	
		this.setWidth100();
		this.setHeight100();
		
		this.setContent(new Portal(portalColumns, jPortlets));
		
	}

}
