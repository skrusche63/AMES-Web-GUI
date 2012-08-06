package de.kp.ames.web.client.fnc.rule.widget;

import java.util.HashMap;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.rule.RuleService;
import de.kp.ames.web.client.fnc.rule.event.RuleEventManager;
import de.kp.ames.web.client.fnc.rule.event.RuleListener;
import de.kp.ames.web.client.fnc.transform.TransformService;
import de.kp.ames.web.client.fnc.transform.event.TransformEventManager;
import de.kp.ames.web.client.fnc.transform.event.TransformListener;
import de.kp.ames.web.client.fnc.transform.widget.TransformCreateDialog;
import de.kp.ames.web.client.fnc.transform.widget.TransformFormImpl;

public class ReasonerCreateDialog extends CreateFormDialog {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 530;
	private static int HEIGHT = 630;

	public ReasonerCreateDialog() {
		super(FncGlobals.REASONER_C_TITLE, FncGlobals.REASONER_C_SLOGAN);
		
		/*
		 * Button handling
		 */
		this.setShowCloseButton(true);
		this.setShowMinimizeButton(true);
		
		/*
		 * Set dimensions
		 */
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		
		/*
		 * The dialog is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

		this.draw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new ReasonerFormImpl(FormAction.CREATE);
		this.form.addFormHandler(this);

		/*
		 * Register as rule listener
		 */
		RuleEventManager.getInstance().addRuleListener((RuleListener)this.form);
		
		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {

		/*
		 * Retrieve and validate form data
		 */
		String data = this.form.getFormData();
		if (data == null) {
			
			String message = FncGlobals.FORM_ERROR;
			SC.say(GUIGlobals.APP_TITLE + ": Form Error", message);		
			
			return;

		}

		new RuleService().doSubmit(data, this.sendActivity);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#beforeRemove()
	 */
	public void beforeRemove() {
		/*
		 * Unregister rule listener
		 */
		RuleEventManager.getInstance().removeRuleListener((RuleListener)this.form);
		
	}
	
	/**
	 * @param attributes
	 * @param activity
	 */
	public static void create(HashMap<String,String> attributes, Activity activity) {
		
		/*
		 * Create dialog
		 */
		ReasonerCreateDialog dialog = new ReasonerCreateDialog();
		
		/*
		 * Provide request specific information
		 */
		dialog.setParams(attributes);
		dialog.addSendActivity(activity);
	
	}

	

}


}
