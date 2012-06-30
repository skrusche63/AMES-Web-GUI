package de.kp.ames.web.client.function.access;

import java.util.HashMap;

import de.kp.ames.web.client.core.grid.BaseGridImpl;
import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class AccessGridImpl extends BaseGridImpl {
	
	public AccessGridImpl() {
		super(ServiceConstants.ACCESS_SERVICE_ID);
	}

	private RequestMethod createMethod(String type, String item) {
		
		HashMap<String,String> attributes = new HashMap<String,String>();
		
		attributes.put(MethodConstants.ATTR_TYPE, type);
		if (item != null) attributes.put(MethodConstants.ATTR_ITEM, item);
		
		return createMethod(attributes);
		
	}

}
