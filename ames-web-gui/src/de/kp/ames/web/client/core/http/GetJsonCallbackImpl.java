package de.kp.ames.web.client.core.http;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.http
 *  Module: GetJsonCallbackImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #callback #client #core #get #http #json #web
 * </SemanticAssist>
 *
 */

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

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.service.Service;

public class GetJsonCallbackImpl extends GetCallbackImpl {
	
	/**
	 * Constructor
	 * 
	 * @param activity
	 * @param service
	 */
	public GetJsonCallbackImpl(Activity activity, Service service) {
		super(activity, service);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.callback.ConnectionCallback#onSuccess(java.lang.String)
	 */
	public void onSuccess(String response) {

		try {
			/*
			 * JSON response
			 */
			JSONValue jValue = JSONParser.parseStrict(response);
			this.activity.execute(jValue);
			
		} catch (NullPointerException e) {
			doGetFailure();
			
		}

	}

}
