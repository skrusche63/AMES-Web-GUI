package de.kp.ames.web.client.core.service;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.shared.ServiceConstants;

public class FrameService extends ServiceImpl {

	/**
	 * Constructor
	 */
	public FrameService() {
		super(CoreGlobals.REG_URL, ServiceConstants.FRAME_SERVICE_ID);
	}
	
}
