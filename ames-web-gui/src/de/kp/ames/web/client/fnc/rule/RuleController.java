package de.kp.ames.web.client.fnc.rule;

import java.util.HashMap;

import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.controller.ControllerImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.rule.widget.RuleSpecDialog;
import de.kp.ames.web.shared.constants.ClassificationConstants;
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
		// TODO
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
			// TODO
		}
	}

	/**
	 * Delete evaluation or reasoner
	 * 
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.ControllerImpl#doDelete(java.util.HashMap, de.kp.ames.web.client.core.grid.Grid, com.smartgwt.client.data.Record, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doDelete(HashMap<String,String> attributes, Grid grid, Record record, Activity activity) {
		// TODO
	}

	/**
	 * Edit evaluation or reasoner
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {
		// TODO
	}

	/**
	 * Get evaluation or reasoner (metadata)
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(final HashMap<String,String> attributes, final Record record) {
		// TODO
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.ControllerImpl#doView(java.util.HashMap, com.smartgwt.client.data.Record)
	 */
	public void doView(HashMap<String,String> attributes, Record record) {
		// TODO
	}


}
