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

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.connection.GetJsonCallbackImpl;
import de.kp.ames.web.client.core.connection.SubmitCallbackImpl;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class AccessService extends ServiceImpl {

	public AccessService() {
		super(CoreGlobals.REG_URL, ServiceConstants.ACCESS_SERVICE_ID);
	}

	/**
	 * A JSON based non-widget GET request
	 * 
	 * @param format
	 * @param type
	 * @param item
	 * @param activity
	 */
	public void doGet(String format, String type, String item, Activity activity) {
	
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_GET);

		/*
		 * Add method parameters and value
		 */
		requestMethod.addAttribute(MethodConstants.ATTR_FORMAT, format);
		requestMethod.addAttribute(MethodConstants.ATTR_TYPE,   type);
		
		if (item != null) requestMethod.addAttribute(MethodConstants.ATTR_ITEM, item);
		
		GetJsonCallbackImpl callback = new GetJsonCallbackImpl(activity, this);
		sendGetRequest(requestMethod, callback);
		
	}

	/**
	 * A JSON based non-widget SUBMIT request
	 * 
	 * @param data
	 * @param activity
	 */
	public void doSubmit(String data, final Activity activity) {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_SUBMIT);

		SubmitCallbackImpl callback = new SubmitCallbackImpl(activity, this);
		sendPostRequest(requestMethod, data, callback);
	
	}

}
