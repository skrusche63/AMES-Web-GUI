package de.kp.ames.web.client.core.portal;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.portal
 *  Module: PortalImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #portal #web
 * </SemanticAssist>
 *
 */


import com.google.gwt.json.client.JSONArray;

import de.kp.ames.web.client.core.widget.base.BaseApp;

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
