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

import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.core.callback.Callback;
import de.kp.ames.web.client.core.connection.ConnectionManager;
import de.kp.ames.web.client.core.method.RequestMethodImpl;

/**
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */

public class ServiceImpl implements Callback, Service {

	/*
	 * The base url necessary to invoke the
	 * web service that refers to this service
	 */
	
	private String base;
	
	/*
	 * The unique service identifier
	 */
	private String sid;
	
	/*
	 * Reference to Connection Manager
	 */
	
	private static ConnectionManager cm = ConnectionManager.getInstance();
	
	public ServiceImpl() {		
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
	 * @see de.kp.ames.web.client.core.service.Service#sendGetRequest(de.kp.ames.web.client.core.method.RequestMethodImpl)
	 */
	public void sendGetRequest(RequestMethodImpl method) {
		String requestUrl = getRequestUrl();
		cm.sendGetRequest(requestUrl, method, this);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.Service#sendPostRequest(de.kp.ames.web.client.core.method.RequestMethodImpl, java.lang.String)
	 */
	public void sendPostRequest(RequestMethodImpl method, String data) {
		String requestUrl = getRequestUrl();
		cm.sendPostRequest(requestUrl, method, data, this);		
	}
	
	/**
	 * @return
	 */
	private String getRequestUrl() {
		
		if ((this.sid == null) || (this.base == null)) return null;
		return this.base + "/" + this.sid;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.callback.Callback#onSuccess(com.google.gwt.json.client.JSONValue)
	 */
	@Override
	public void onSuccess(JSONValue jValue) {
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.callback.Callback#onError(java.lang.Throwable)
	 */
	@Override
	public void onError(Throwable throwable) {
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.callback.Callback#onTimeout(java.lang.String)
	 */
	@Override
	public void onTimeout(String message) {
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.callback.Callback#onFailure(java.lang.String)
	 */
	@Override
	public void onFailure(String message) {
	}

	
}
