package de.kp.ames.web.client.fnc.scm.control;

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.client.fnc.scm.event.SearchEventManager;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class SimilarityController {

	public void doGetSimilarity(Record record) {
		
		SC.logWarn("======> SimilarityController.doGetSimilarity");

		/*
		 * Build request data
		 */
		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, "similar");
		attributes.put(MethodConstants.ATTR_QUERY, record.getAttribute(JsonConstants.J_ID));
		
		SC.logWarn("======> doGetSimilarity name attribute:" + record.getAttribute(JsonConstants.J_NAME));
		
		attributes.put("name", record.getAttribute(JsonConstants.J_NAME));
		
		/*
		 * Create Service
		 */
		ServiceImpl service = new ServiceImpl(GuiConstants.REG_URL, ServiceConstants.SCM_SERVICE_ID);
		service.doGetJson(attributes, new ActivityImpl() {

			public void execute(JSONValue jValue) {
				SC.logWarn("======> SimilarityController.execute on JSONCallback");

				doAfterDataArrived(jValue);				
			}
			
		});
		
	}

	private void doAfterDataArrived(JSONValue jValue) {
		SC.logWarn("======> SimilarityController.doAfterDataArrived");
		SearchEventManager.getInstance().doShowSimilarity(jValue);
		
	}

}
