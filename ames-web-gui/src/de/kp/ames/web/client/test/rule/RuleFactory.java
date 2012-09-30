package de.kp.ames.web.client.test.rule;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test.rule
 *  Module: RuleFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #factory #rule #test #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.fnc.rule.data.RuleGridImpl;
import de.kp.ames.web.client.fnc.rule.widget.EvaluationEditDialog;
import de.kp.ames.web.client.fnc.rule.widget.ReasonerApplyDialog;
import de.kp.ames.web.client.fnc.rule.widget.ReasonerCreateDialog;
import de.kp.ames.web.client.fnc.rule.widget.ReasonerEditDialog;
import de.kp.ames.web.client.fnc.rule.widget.ReasonerFormImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.client.test.data.ScData;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class RuleFactory extends FncFactory {

	/*
	 * Reference to RuleGrid layout
	 */
	private VLayout ruleGridLayout;
	
	private static RuleFactory instance = new RuleFactory();
	
	public static RuleFactory getInstance() {
		if (instance == null) instance = new RuleFactory();
		return instance;
	}

	public VLayout createRuleGridImpl() {

		ruleGridLayout = new VLayout();
		ruleGridLayout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("Select an information type to get rendered in the RuleGrid.", 40);
      
        /*
         * Data for SelectItem
         */
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();  
        
        valueMap.put(ClassificationConstants.FNC_ID_Evaluation,   "Evaluation");  
        valueMap.put(ClassificationConstants.FNC_ID_Reasoner,     "Reasoner");  

        SelectItem selectItem = createSelectItem(valueMap);
        selectItem.addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				
				String type = (String)event.getItem().getValue();
				replacePlaceHolder(type);
				
			}
        	
        });
        
        /*
         * Dynamic Form
         */
        DynamicForm scForm = createSelectForm(selectItem);
        
        /*
         * Place Holder
         */
        
        ruleGridLayout.setMembers(pane, scForm, createPlaceHolder());      
        return ruleGridLayout;
        
 	}
	
	private void replacePlaceHolder(String type) {
				
		RuleGridImpl grid = new RuleGridImpl(type);
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);
		
		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		ruleGridLayout.removeMember(ruleGridLayout.getMember(2));
		ruleGridLayout.addMember(grid);
		
	}

	public VLayout createReasonerFormImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of a Reasoner Form.", 40);

        /*
         * Reasoner Form
         */
        ReasonerFormImpl reasonerForm = new ReasonerFormImpl(FormAction.CREATE);
		reasonerForm.setMargin(24);
		
		/*
		 * Style
		 */
		reasonerForm.setBackgroundColor("#F2F2F4");
		reasonerForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,reasonerForm);
		return layout;
	
	}

	public VLayout createReasonerEditDialog() {
		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Reasoner);
		
		final JSONObject jValue = ScData.getJsonReasoner();

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Reasoner successfully updated.");
			}
		};

		String message = "Click the button to open the ReasonerEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				ReasonerEditDialog.create(attributes, jValue, afterSendActivity);
			}
			
		});
	
	}

	public VLayout createReasonerCreateDialog() {

		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Reasoner);

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Reasoner successfully created.");
			}
		};
		
		String message = "Click the button to open the ReasonerCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				ReasonerCreateDialog.create(attributes, afterSendActivity);
			}			
			
		});
	
	}

	public VLayout createReasonerApplyDialog() {

		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_SERVICE, ScData.TEST_REASONER);
		
		final String name = ScData.TEST_REASONER_NAME;
		final String desc = ScData.TEST_REASONER_DESC;

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Reasoner successfully applied.");
			}
		};
		
		String message = "Click the button to open the ReasonerApplyDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				ReasonerApplyDialog.create(attributes, name, desc, afterSendActivity);
			}
			
		});
	
	}

	public VLayout createEvaluationEditDialog() {

		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Evaluation);
		
		final JSONObject jValue = ScData.getJsonEvaluation();

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Evaluation successfully updated.");
			}
		};

		String message = "Click the button to open the EvaluationEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				EvaluationEditDialog.create(attributes, jValue, afterSendActivity);
			}
			
		});
	
	}

}
