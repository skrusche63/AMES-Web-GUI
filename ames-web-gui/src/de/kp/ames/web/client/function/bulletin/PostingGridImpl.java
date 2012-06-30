package de.kp.ames.web.client.function.bulletin;

import java.util.HashMap;

import de.kp.ames.web.client.core.grid.BaseGridImpl;
import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class PostingGridImpl extends BaseGridImpl {

	public PostingGridImpl() {
			super(ServiceConstants.BULLETIN_SERVICE_ID);
	}

	private RequestMethod createMethod(String recipient) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TARGET, recipient);
		
		return createMethod(attributes);
		
	}

}
