package de.kp.ames.web.client.function.role;

import java.util.HashMap;

import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;

public class RoleWidget {

	/**
	 * Constructor
	 */
	public RoleWidget() {
	}

	/**
	 * @param attributes
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Activity activity) {
		// TODO
	}
	
	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(HashMap<String,String> attributes, Record record, Activity activity) {
		
		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Responsibility)) {
			// TODO
		} else if (type.equals(ClassificationConstants.FNC_ID_Role)) {
			// TODO			
		}
	}

}
