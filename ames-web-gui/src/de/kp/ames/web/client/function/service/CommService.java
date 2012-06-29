package de.kp.ames.web.client.function.service;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.ServiceConstants;

public class CommService extends ServiceImpl {

	public CommService() {
		super(CoreGlobals.REG_URL, ServiceConstants.COMMUNICATION_SERVICE_ID);
	}

	public void doGetMail() {
		// TODO
	}

}