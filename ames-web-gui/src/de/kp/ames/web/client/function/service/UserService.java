package de.kp.ames.web.client.function.service;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.ServiceConstants;

public class UserService extends ServiceImpl {

	public UserService() {
		super(CoreGlobals.REG_URL, ServiceConstants.USER_SERVICE_ID);
	}

	public void doSubmitUser() {
		// TODO
	}

}