package de.kp.ames.web.client.core.service;

import java.util.HashMap;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class FrameService extends ServiceImpl {

	/**
	 * Constructor
	 */
	public FrameService() {
		super(CoreGlobals.REG_URL, ServiceConstants.FRAME_SERVICE_ID);
	}

	/**
	 * @param attributes
	 * @return
	 */
	public String getUri(HashMap<String,String> attributes) {

		/*
		 * Build method
		 */
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_GET);

		requestMethod.setAttributes(attributes);
		
		/*
		 * Build request uri
		 */
		return getRequestUrl() + requestMethod.toQuery();
		
	}
	
}
