package de.kp.ames.web.client.fnc.scm.control;

import java.util.HashMap;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.client.fnc.scm.event.SearchEventManager;
import de.kp.ames.web.client.fnc.scm.widget.CheckoutViewerImpl;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class CheckoutController {


	/**
	 * @param attributes
	 * @param record
	 */
	public void doView(HashMap<String,String> attributes, JSONArray jCheckoutData) {

		/*
		 * Build viewer
		 */
		String title  = "Checkout Cart Viewer";
		String slogan = "This is the cart with your researched items and their suggested contexts";
		// this widget is a listener for checkout html
		new CheckoutViewerImpl(title, slogan);

		/*
		 * Configure service call to provide data for Checkout Viewer
		 */
		attributes.put(MethodConstants.ATTR_TYPE, "checkout");
			

		/*
		 * Send post request
		 */
		ServiceImpl service = new ServiceImpl(GuiConstants.REG_URL, ServiceConstants.SCM_SERVICE_ID);
		service.doApply(attributes, jCheckoutData.toString(), new ActivityImpl() {
			
			@Override
			public void execute(JSONValue jValue) {
				
				doAfterDataArrived((JSONObject)jValue);		
			}
		});
		
	}
	
	/*
	 * this callback is replaced by form download
	 */
	private void doAfterDataArrived(JSONObject jObject) {
		SearchEventManager.getInstance().doAfterUpdate(jObject);
		
	}

}
