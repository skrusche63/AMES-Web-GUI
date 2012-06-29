package de.kp.ames.web.client.function.service;

import java.util.HashMap;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.connection.ConnectionCallback;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class DesktopService extends ServiceImpl {

	public DesktopService() {
		super(CoreGlobals.REG_URL, ServiceConstants.SECURITY_SERVICE_ID);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.service.ServiceImpl#getHeaders()
	 */
	public HashMap<String,String> getHeaders() {
		
		HashMap<String,String> headers = new HashMap<String,String>();
		return headers;

	}

	/**
	 * @param activityCallback
	 */
	public void doGetCallersApps(final ActivityImpl activityCallback) {

		/*
		 * Build request method
		 */
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_GET);
		
		requestMethod.addAttribute(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_SECURITY_ID_App);

		/* 
		 * Send request
		 */
		sendGetRequest(requestMethod, new ConnectionCallback() {

			public void onSuccess(String response) {
				/*
				 * Invoke activity callback
				 */
				JSONValue jValue = JSONParser.parseStrict(response);
				activityCallback.execute(jValue);
			}

			public void onError(Throwable throwable) {				
				doGetFailed();
			}

			public void onTimeout(String message) {
				doGetFailed();
			}

			public void onFailure(String message) {
				doGetFailed();					
			}
			
		});

	}
	
	private void doGetFailed() {
		
	}
}
