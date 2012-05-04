package de.kp.ames.web.client.core.callback;
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

import com.google.gwt.http.client.RequestException;
import com.google.gwt.json.client.JSONValue;

/**
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */
public class CallbackImpl implements Callback {

	@Override
	public void onSuccess(JSONValue jValue) {
		// put your code in here
	}

	@Override
	public void onError(Throwable throwable) {
		
		if (throwable instanceof NullPointerException) {
			
			// the HTTP request request returned a response text NULL
			
		} else if (throwable instanceof RequestException) {
			
		}
		
	}

	@Override
	public void onTimeout(String message) {
		// put your code in here
	}

	@Override
	public void onFailure(String message) {
		// put your code in here
	}
	
}
