package de.kp.ames.web.client.function.service;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.ServiceConstants;

public class MapService extends ServiceImpl {

	public MapService() {
		super(CoreGlobals.REG_URL, ServiceConstants.MAP_SERVICE_ID);
	}

}
