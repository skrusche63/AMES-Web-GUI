package de.kp.ames.web.client.fnc.rule;

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.controller.ControllerImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.rule.widget.EvaluationEditDialog;
import de.kp.ames.web.client.fnc.rule.widget.ReasonerApplyDialog;
import de.kp.ames.web.client.fnc.rule.widget.ReasonerCreateDialog;
import de.kp.ames.web.client.fnc.rule.widget.ReasonerEditDialog;
import de.kp.ames.web.client.fnc.rule.widget.ReasonerGetViewer;
import de.kp.ames.web.client.fnc.rule.widget.RuleSpecDialog;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class RuleController extends ControllerImpl {

	public void ResonerController() {	
	}
	
	/**
	 * Apply reasoner
	 * 
	 * @param attributes
	 * @param record
	 * @param afterSendActivity
	 */
	public void doApply(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {
		
		/*
		 * Prepare data
		 */
		attributes.put(MethodConstants.ATTR_SERVICE, record.getAttributeAsString(JaxrConstants.RIM_ID));
		
		String name = record.getAttributeAsString(JaxrConstants.RIM_NAME);
		String desc = record.getAttributeAsString(JaxrConstants.RIM_DESC);
		
		ReasonerApplyDialog.create(attributes, name, desc, afterSendActivity);

	}

	/**
	 * Create (local) specification or (remote) reasoner
	 * 
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.ControllerImpl#doCreate(java.util.HashMap, de.kp.ames.web.client.core.grid.Grid, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doCreate(HashMap<String,String> attributes, Grid grid, Activity activity) {
		
		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Specification)) {
			RuleSpecDialog.create(attributes, grid, activity);
			
		}

		if (type.equals(ClassificationConstants.FNC_ID_Reasoner)) {
			ReasonerCreateDialog.create(attributes, activity);
			
		}
	}

	/**
	 * Delete evaluation or reasoner
	 * 
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.ControllerImpl#doDelete(java.util.HashMap, de.kp.ames.web.client.core.grid.Grid, com.smartgwt.client.data.Record, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doDelete(final HashMap<String,String> attributes, final Grid grid, final Record record, final Activity activity) {

		SC.confirm(FncGlobals.CONFIRM_RULE_DELETE, new BooleanCallback() {  
 
			public void execute(Boolean value) {  
                if (value != null && value) {  
                	/*
                	 * Delete confirmed
                	 */
                	doDeleteConfirmed(attributes, record, activity);
 
                }  
            }  
        
		});

	}

	/**
	 * Delete evaluation or reasoner
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDeleteConfirmed(HashMap<String,String> attributes, Record record, Activity activity) {

		/*
		 * Prepare data for delete request
		 */
		attributes.put(MethodConstants.ATTR_ITEM, record.getAttributeAsString(JaxrConstants.RIM_ID));
			
		/*
		 * Invoke delete request
		 */
		RuleService service = new RuleService();
		service.doDelete(attributes, activity);
		
	}

	/**
	 * Edit evaluation or reasoner
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {

		final RuleController self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildEditDialog(attributes, jValue, afterSendActivity);
			}			
		};

		/*
		 * Retrieve actual version of evaluation or reasoner
		 */
		doGet(attributes, record, afterGetActivity);
		
	}

	/**
	 * Get evaluation or reasoner (metadata)
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(final HashMap<String,String> attributes, final Record record) {

		final RuleController self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildGetViewer(attributes, jValue);
			}			
		};

		/*
		 * Retrieve actual version of reasoner
		 */
		doGet(attributes, record, afterGetActivity);
	}

	/**
	 * @param attributes
	 * @param record
	 * @param afterGetActivity
	 */
	private void doGet(HashMap<String,String> attributes, Record record, ActivityImpl afterGetActivity) {

		/*
		 * Prepare get request
		 */
		String format = FormatConstants.FNC_FORMAT_ID_Object;
		String item = record.getAttributeAsString(JaxrConstants.RIM_ID);

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		
		/*
		 * Invoke get request
		 */
		RuleService service = new RuleService();
		service.doGet(format, type, item, afterGetActivity);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.ControllerImpl#doView(java.util.HashMap, com.smartgwt.client.data.Record)
	 */
	public void doView(final HashMap<String,String> attributes, final Record record) {

		final RuleController self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildGetViewer(attributes, jValue);
			}			
		};

		/*
		 * Retrieve actual version of reasoner
		 */
		doGet(attributes, record, afterGetActivity);

	}

	/**
	 * Build evaluation or reaosner edit dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(HashMap<String,String> attributes, JSONValue jValue, Activity afterSendActivity) {

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Evaluation)) {
			EvaluationEditDialog.create(attributes, jValue, afterSendActivity);
			
		} else {
			ReasonerEditDialog.create(attributes, jValue, afterSendActivity);
			
		}
		
	}

	/**
	 * Build Reasoner Get Viewer
	 * 
	 * @param attributes
	 * @param jValue
	 */
	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {
		ReasonerGetViewer.create(attributes, jValue);
	}

}
