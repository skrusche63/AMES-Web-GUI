package de.kp.ames.web.client.core.service;

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

import java.util.HashMap;

import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.connection.ConnectionCallback;
import de.kp.ames.web.client.core.connection.ConnectionManager;
import de.kp.ames.web.client.core.connection.DeleteCallbackImpl;
import de.kp.ames.web.client.core.connection.GetJsonCallbackImpl;
import de.kp.ames.web.client.core.connection.SubmitCallbackImpl;
import de.kp.ames.web.client.core.gui.globals.GUIGlobals;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.shared.MethodConstants;

/**
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */

public class ServiceImpl implements Service {

	/*
	 * The base url necessary to invoke the
	 * web service that refers to this service
	 */
	
	protected String base;
	
	/*
	 * The unique service identifier
	 */
	protected String sid;
	
	/*
	 * Reference to Connection Manager
	 */
	
	protected static ConnectionManager cm = ConnectionManager.getInstance();
	
	/**
	 * Constructor
	 */
	public ServiceImpl() {		
	}

	/**
	 * @param base
	 * @param sid
	 */
	public ServiceImpl(String base, String sid) {
		this.base = base;
		this.sid  = sid;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.Service#setId(java.lang.String)
	 */
	public void setId(String sid) {
		this.sid = sid;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.Service#setBase(java.lang.String)
	 */
	public void setBase(String base) {
		this.base = base;
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.Service#doDelete(java.util.HashMap, java.lang.String, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doDelete(HashMap<String,String> attributes, String data, Activity activity) {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_DELETE);

		requestMethod.setAttributes(attributes);
		
		DeleteCallbackImpl callback = new DeleteCallbackImpl(activity, this);
		sendPostRequest(requestMethod, data, callback);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.Service#doGetJson(java.util.HashMap, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doGetJson(HashMap<String,String> attributes, Activity activity) {
	
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_GET);

		requestMethod.setAttributes(attributes);
		
		GetJsonCallbackImpl callback = new GetJsonCallbackImpl(activity, this);
		sendGetRequest(requestMethod, callback);
		
	}

	/**
	 * A JSON based non-widget SUBMIT request
	 * 
	 * @param data
	 * @param activity
	 */
	public void doSubmit(String data, Activity activity) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		doSubmit(attributes, data, activity);
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.Service#doSubmit(java.util.HashMap, java.lang.String, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doSubmit(HashMap<String,String> attributes, String data, Activity activity) {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_SUBMIT);

		requestMethod.setAttributes(attributes);
		
		SubmitCallbackImpl callback = new SubmitCallbackImpl(activity, this);
		sendPostRequest(requestMethod, data, callback);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.Service#sendGetRequest(de.kp.ames.web.client.core.method.RequestMethodImpl, de.kp.ames.web.client.core.callback.Callback)
	 */
	public void sendGetRequest(RequestMethodImpl method, ConnectionCallback callback) {
		
		String requestUrl = getRequestUrl();
		HashMap<String,String> requestHeaders = getHeaders();
		
		cm.sendGetRequest(requestUrl, method, requestHeaders, callback);
	
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.Service#sendPostRequest(de.kp.ames.web.client.core.method.RequestMethodImpl, java.lang.String, de.kp.ames.web.client.core.callback.Callback)
	 */
	public void sendPostRequest(RequestMethodImpl method, String data, ConnectionCallback callback) {

		String requestUrl = getRequestUrl();
		HashMap<String,String> requestHeaders = getHeaders();
	
		cm.sendPostRequest(requestUrl, method, requestHeaders, data, callback);		
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.Service#getHeaders()
	 */
	public HashMap<String,String> getHeaders() {
		
		HashMap<String,String> headers = new HashMap<String,String>();
		return headers;
	}
	
	/**
	 * @return
	 */
	private String getRequestUrl() {
		
		if ((this.sid == null) || (this.base == null)) return null;
		return this.base + "/" + this.sid;
		
	}

	/**
	 * Message box to show the request error failure
	 * 
	 * @param message
	 */
	public void doRequestError(String message) {
		SC.say(GUIGlobals.APP_TITLE + ": Request Error", message);		
	}

}
