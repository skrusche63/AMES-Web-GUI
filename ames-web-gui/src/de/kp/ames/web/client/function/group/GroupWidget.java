package de.kp.ames.web.client.function.group;

import java.util.HashMap;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.client.function.group.widget.GroupEditDialog;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.FormatConstants;
import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.MethodConstants;

public class GroupWidget {
	/**
	 * Constructor
	 */
	public GroupWidget() {
	}

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
		if (type.equals(ClassificationConstants.FNC_ID_Affiliation)) {

			/*
			 * Prepare data for delete request
			 */
			String[] keys = {
				JaxrConstants.RIM_SOURCE,
				JaxrConstants.RIM_TARGET
			};
			
			JSONObject jRecord = JsonConverter.recordToJson(record, keys);
			String data = jRecord.toString();
			
			/*
			 * Invoke delete request
			 */
			GroupService service = new GroupService();
			service.doDelete(attributes, data, activity);

		} else if (type.equals(ClassificationConstants.FNC_ID_Community)) {
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
			GroupService service = new GroupService();
			service.doDelete(attributes, data, activity);
			
		}

	}

	/**
	 * @param attributes
	 * @param record
	 * @param afterSendActivity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {

		final GroupWidget self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildEditDialog(attributes, jValue, afterSendActivity);
			}			
		};

		/*
		 * Retrieve actual version of group
		 */
		doGet(attributes, record, afterGetActivity);
		
	}

	/**
	 * Get group
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(final HashMap<String,String> attributes, final Record record) {

		final GroupWidget self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildGetViewer(attributes, jValue);
			}			
		};

		/*
		 * Retrieve actual version of group
		 */
		doGet(attributes, record, afterGetActivity);
		
	}

	/**
	 * Get Group (metadata)
	 * 
	 * @param attributes
	 * @param record
	 * @param afterGetActivity
	 */
	private void doGet(HashMap<String,String> attributes, Record record, ActivityImpl afterGetActivity) {
		/*
		 * Prepare get request
		 */
		String type = ClassificationConstants.FNC_ID_Community;
		
		String format = FormatConstants.FNC_FORMAT_ID_Object;
		String item = record.getAttributeAsString(JaxrConstants.RIM_ID);
		
		/*
		 * No affiliate provided
		 */
		String source = null;
		
		/*
		 * Invoke get request
		 */
		GroupService service = new GroupService();
		service.doGet(format, type, item, source, afterGetActivity);
	
	}

	/**
	 * Build Group Edit Dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(HashMap<String,String> attributes, JSONValue jValue, Activity afterSendActivity) {

		GroupEditDialog dialog = new GroupEditDialog(jValue);
		dialog.addSendActivity(afterSendActivity);
	
	}

	/**
	 * Build Group (Metadata) Viewer
	 * 
	 * @param jValue
	 */
	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {
		// TODO
	}

}
