package de.kp.ames.web.client.function.service;
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

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.globals.CoreAttrs;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.http.ConnectionCallback;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.client.core.widget.base.ActionIndicator;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class LoginService extends ServiceImpl {

	public LoginService() {
		super(CoreGlobals.REG_URL, ServiceConstants.SECURITY_SERVICE_ID);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.ServiceImpl#getHeaders()
	 */
	public HashMap<String,String> getHeaders() {
		
		HashMap<String,String> headers = new HashMap<String,String>();
		
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		return headers;

	}
	
	/**
	 * Register method
	 * 
	 * @param alias
	 * @param keypass
	 * @param activityCallback
	 */
	public void register(final String alias, final String keypass, final ActivityImpl activityCallback) {
		
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_REGISTER);
		
		requestMethod.addAttribute(CoreAttrs.ALIAS,   alias);
		requestMethod.addAttribute(CoreAttrs.KEYPASS, keypass);
		
		sendPostRequest(requestMethod, null, new ConnectionCallback() {

			public void onSuccess(String response) {

				try {

					JSONValue jValue = JSONParser.parseStrict(response);
					JSONObject jObject = jValue.isObject();
					
					boolean result = jObject.get("result").isBoolean().booleanValue();
					
					if (result == true) {
						activityCallback.execute(jObject);
						
					} else {
						String message = jObject.get("message").isString().stringValue();
						doRequestError(message);					
					}
					
				} catch (NullPointerException e) {
					doLoginFailed();
					
				}

			}

			public void onError(Throwable throwable) {				
				doLoginFailed();
			}

			public void onTimeout(String message) {
				doLoginFailed();
			}

			public void onFailure(String message) {
				doLoginFailed();					
			}
			
		});

	}
	
	/**
	 * Action due to login failure
	 */
	private void doLoginFailed() {
		/*
		 * Reset any action indicator
		 */
		ActionIndicator.getInstance().reset();	

		String message = "Login failed due to an illegal combination of user name and password.";
		doRequestError(message);		
	
	}

}
