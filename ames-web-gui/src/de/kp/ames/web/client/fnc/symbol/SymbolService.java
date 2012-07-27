package de.kp.ames.web.client.fnc.symbol;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class SymbolService extends ServiceImpl {

	public SymbolService() {
		super(CoreGlobals.REG_URL, ServiceConstants.SYMBOL_SERVICE_ID);
	}


}
