package de.kp.ames.web.client.function.service;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.ServiceConstants;

public class SymbolService extends ServiceImpl {

	public SymbolService() {
		super(CoreGlobals.REG_URL, ServiceConstants.SYMBOL_SERVICE_ID);
	}


}
