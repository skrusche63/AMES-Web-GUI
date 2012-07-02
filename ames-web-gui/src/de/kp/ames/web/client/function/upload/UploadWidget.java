package de.kp.ames.web.client.function.upload;

import java.util.HashMap;

import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.client.function.product.ProductService;
import de.kp.ames.web.shared.JaxrConstants;

public class UploadWidget {

	public UploadWidget() {
	}

	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(HashMap<String,String> attributes, ListGridRecord record, Activity activity) {
		
		/*
		 * Prepare data for delete request
		 */
		String[] keys = {
			JaxrConstants.RIM_ID
		};
		
		JSONObject jRecord = JsonConverter.recordToJson(record, keys);
		String data = jRecord.toString();

		/*
		 * Invoke delete request
		 */
		ProductService service = new ProductService();
		service.doDelete(attributes, data, activity);

	}
	
	public void doUpload(HashMap<String,String> attributes, Activity activity) {
		// TODO
	}
}
