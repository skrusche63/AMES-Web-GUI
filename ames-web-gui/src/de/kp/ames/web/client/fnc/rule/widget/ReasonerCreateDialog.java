package de.kp.ames.web.client.fnc.rule.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.rule.widget
 *  Module: ReasonerCreateDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #create #dialog #fnc #reasoner #rule #web #widget
 * </SemanticAssist>
 *
 */

import java.util.HashMap;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.rule.RuleService;
import de.kp.ames.web.client.fnc.rule.event.RuleEventManager;
import de.kp.ames.web.client.fnc.rule.event.RuleListener;

public class ReasonerCreateDialog extends CreateFormDialog {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 525;
	private static int HEIGHT = 640;

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
		 * The Reasoner Editor is a form-based window
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
			SC.say(GuiConstants.APP_TITLE + ": Form Error", message);		
			
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
