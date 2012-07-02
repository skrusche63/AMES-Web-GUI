package de.kp.ames.web.client.function.group.action;

import java.util.HashMap;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.action.grid.GridDeleteImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.client.function.group.GroupService;
import de.kp.ames.web.shared.JaxrConstants;

public class AffiliationDeleteImpl extends GridDeleteImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public AffiliationDeleteImpl(Grid grid, ListGridRecord record) {	
		super(grid, record);
	}
	
	public void execute() {
		
		/*
		 * Prepare data for delete request
		 */
		String[] keys = {
			JaxrConstants.RIM_SOURCE,
			JaxrConstants.RIM_TARGET
		};
		
		JSONObject jRecord = JsonConverter.recordToJson(record, keys);
		String data = jRecord.toString();
		
		HashMap<String,String> attributes = this.getParams();
		
		/*
		 * Invoke delete request
		 */
		GroupService service = new GroupService();
		service.doDelete(attributes, data, new ActivityImpl() {

			public void execute(JSONValue jValue) {
				// TODO				
			}
			
		});
	}

}
