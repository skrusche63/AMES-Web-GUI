package de.kp.ames.web.client.function.group;

import java.util.HashMap;

import de.kp.ames.web.client.core.grid.BaseGridImpl;
import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class GroupGridImpl extends BaseGridImpl {

	public GroupGridImpl() {
		super(ServiceConstants.COMMUNITY_SERVICE_ID);
	}

	private RequestMethod createMethod(String affiliate) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Community);

		if (affiliate != null) attributes.put(MethodConstants.ATTR_SOURCE, affiliate);

		return createMethod(attributes);
		
	}

}
