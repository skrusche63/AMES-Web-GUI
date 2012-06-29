package de.kp.ames.web.client.function.service;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.ServiceConstants;

public class DomainService extends ServiceImpl {

	public DomainService() {
		super(CoreGlobals.REG_URL, ServiceConstants.DOMAIN_SERVICE_ID);
	}

}
