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
import de.kp.ames.web.client.core.connection.SubmitCallbackImpl;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class BulletinService extends ServiceImpl {

	public BulletinService() {
		super(CoreGlobals.REG_URL, ServiceConstants.BULLETIN_SERVICE_ID);
	}

	public void doSubmitComment() {
		// TODO
	}
	
	/**
	 * Submit posting method
	 * 
	 * @param recipient
	 * @param data
	 * @param activity
	 */
	public void doSubmitPosting(String recipient, String data, Activity activity) {
		
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_SUBMIT);
		
		requestMethod.addAttribute(MethodConstants.ATTR_TYPE,   ClassificationConstants.FNC_ID_Posting);
		requestMethod.addAttribute(MethodConstants.ATTR_TARGET, recipient);

		SubmitCallbackImpl callback = new SubmitCallbackImpl(activity, this);
		sendPostRequest(requestMethod, data, callback);

	}

}
