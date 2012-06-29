package de.kp.ames.web.client.function.service;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.ServiceConstants;

public class NsService extends ServiceImpl {

	public NsService() {
		super(CoreGlobals.REG_URL, ServiceConstants.NAMESPACE_SERVICE_ID);
	}

	public void doSubmitNamespace() {
		// TODO
	}

}
