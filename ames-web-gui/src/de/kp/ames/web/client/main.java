package de.kp.ames.web.client;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client
 *  Module: main
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #main #web
 * </SemanticAssist>
 *
 */

/**
 * This file is part of the AMES Web GUI.
 *
 * AMES Web GUI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AMES Web GUI is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the AMES Web GUI.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2012 Dr. Krusche & Partner PartG <team@dr-kruscheundpartner.de>
 *
 */

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONValue;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.apps.CustomAppsManager;
import de.kp.ames.web.client.core.apps.AppsService;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.fnc.upload.event.UploadEventManager;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class main implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		/*
		 * Register external method to use with
		 * native JavaScript
		 */
		UploadEventManager.exportStaticMethods();

		/*
		 * Call main functionality either the showcase
		 * or the operational one
		 */
		if (GuiConstants.SHOWCASE_FLAG == true) {

			/*
			 * Showcase use of ADF
			 */
			CustomAppsManager.getInstance().createShowCase();
			
		} else {
			
			/*
			 * Operational use of ADF
			 */
			AppsService service = new AppsService();

			service.doGetCallersApps(new ActivityImpl() {
				public void execute(JSONValue jValue) {
					CustomAppsManager.getInstance().createOpsCase(jValue);
				}
			});
			
		}

	}

}
