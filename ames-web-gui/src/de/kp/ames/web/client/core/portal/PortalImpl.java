package de.kp.ames.web.client.core.portal;

import com.google.gwt.json.client.JSONArray;

import de.kp.ames.web.client.core.apps.BaseApp;

public class PortalImpl extends BaseApp {

	/**
	 * @param portalColumns
	 * @param jArray
	 */
	public PortalImpl(int portalColumns, JSONArray jArray) {
	
		this.setWidth100();
		this.setHeight100();
		
		this.setContent(new Portal(portalColumns, jArray));
		
	}

}
