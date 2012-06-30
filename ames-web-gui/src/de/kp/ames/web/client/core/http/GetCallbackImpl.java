package de.kp.ames.web.client.core.http;
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

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.service.Service;
import de.kp.ames.web.client.core.widget.base.ActionIndicator;

public class GetCallbackImpl implements ConnectionCallback {

	/*
	 * Reference to After Request Activity
	 */
	protected Activity activity;
	
	/*
	 * Reference to Service
	 */
	protected Service service;
	
	/**
	 * Constructor
	 * 
	 * @param activity
	 * @param service
	 */
	public GetCallbackImpl(Activity activity, Service service) {
		this.activity = activity;
		this.service  = service;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.callback.ConnectionCallback#onSuccess(java.lang.String)
	 */
	public void onSuccess(String response) {
		/*
		 * Must be overridden
		 */
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.callback.ConnectionCallback#onError(java.lang.Throwable)
	 */
	public void onError(Throwable throwable) {
		doGetFailure();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.callback.ConnectionCallback#onTimeout(java.lang.String)
	 */
	public void onTimeout(String message) {
		doGetFailure();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.callback.ConnectionCallback#onFailure(java.lang.String)
	 */
	public void onFailure(String message) {
		doGetFailure();
	}
	
	/**
	 * Get request failure
	 */
	protected void doGetFailure() {
		/*
		 * Reset any action indicator
		 */
		ActionIndicator.getInstance().reset();	
	
		String message = "Get request failed due to server error.";
		service.doRequestError(message);		
	
	}


}
