package de.kp.ames.web.client.core.connection;
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

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.RequestTimeoutException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.core.callback.Callback;
import de.kp.ames.web.client.core.method.RequestMethodImpl;

/**
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */
public class ConnectionManager {

	private static final int STATUS_CODE_OK = 200;
	
	private static ConnectionManager instance = new ConnectionManager();
	
	public static ConnectionManager getInstance() {
		if(instance==null) instance = new ConnectionManager();
		return instance;
	}
	
	/**
	 * @param baseUrl
	 * @param method
	 * @param callback
	 */
	public void sendGetRequest(final String baseUrl, final RequestMethodImpl method, final Callback callback) {
		String url = baseUrl + method.toQuery();
		sendGetRequest(url, callback);
	}
	
	/**
	 * @param url
	 * @param callback
	 */
	public void sendGetRequest(final String url, final Callback callback) {
		
		String requestData = null;
	    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

	    try {
	      
	    	builder.sendRequest(requestData, new RequestCallback() {

				public void onResponseReceived(Request request, Response response) {

					if (STATUS_CODE_OK == response.getStatusCode()) {						
						handleSuccess(response, callback);
						
					} else {						
						handleFailure(response, callback);
					}
					
				}

				public void onError(Request request, Throwable exception) {
					
					if (exception instanceof RequestTimeoutException) {						
						handleTimeout(exception, callback);
					
					} else {						
						handleError(exception, callback);
				    }
					
				}
	    	});
	    
	    } catch (RequestException e) {
	      handleError(e, callback);
	    	
	    }
	    
	}
	
	/**
	 * @param baseUrl
	 * @param method
	 * @param requestData
	 * @param callback
	 */
	public void sendPostRequest(final String baseUrl, final RequestMethodImpl method, final String requestData, final Callback callback) {
		String url = baseUrl + method.toQuery();
		sendPostRequest(url, requestData, callback);
	}
	
	
	/**
	 * @param url
	 * @param requestData
	 * @param callback
	 */
	public void sendPostRequest(final String url, final String requestData, final Callback callback) {
	    
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);

	    try {
	    
	    	builder.sendRequest(requestData, new RequestCallback() {

		        public void onResponseReceived(Request request, Response response) {

					if (STATUS_CODE_OK == response.getStatusCode()) {						
						handleSuccess(response, callback);
					
					} else {						
						handleFailure(response, callback);
					}

		        }

		        public void onError(Request request, Throwable exception) {
					
					if (exception instanceof RequestTimeoutException) {						
						handleTimeout(exception, callback);
					
					} else {						
						handleError(exception, callback);
				    }

		        }
	    	
	    	});
	    
	    } catch (RequestException e) {
		      handleError(e, callback);

	    }
	  
	}
	
	/**
	 * @param response
	 * @param callback
	 */
	private void handleSuccess(Response response, Callback callback) {

		String responseText = response.getText();
		
		try {
			JSONValue jValue = JSONParser.parseStrict(responseText);
			if (callback != null) callback.onSuccess(jValue);
			
		} catch (NullPointerException e) {
			callback.onError(e);
			
		}
		
	}
	
	/**
	 * @param response
	 * @param callback
	 */
	private void handleFailure(Response response, Callback callback) {

		String responseText = response.getText();
		if (callback != null) callback.onFailure(responseText);

	}
	
	/**
	 * @param throwable
	 * @param callback
	 */
	private void handleError(Throwable throwable, Callback callback) {
		if (callback != null) callback.onError(throwable);
	}

	/**
	 * @param exception
	 * @param callback
	 */
	private void handleError(RequestException exception, Callback callback) {
		if (callback != null) callback.onError(exception);
	}

	/**
	 * @param throwable
	 * @param callback
	 */
	private void handleTimeout(Throwable throwable, Callback callback) {

		RequestTimeoutException exception = (RequestTimeoutException)throwable;
		if (callback != null) callback.onTimeout(exception.getMessage());
	
	}
  
}


