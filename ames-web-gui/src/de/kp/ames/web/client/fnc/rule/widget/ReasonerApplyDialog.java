package de.kp.ames.web.client.fnc.rule.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.rule.widget
 *  Module: ReasonerApplyDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #apply #client #dialog #fnc #reasoner #rule #web #widget
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.dialog.ApplyFormDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.rule.RuleService;
import de.kp.ames.web.shared.constants.MethodConstants;

public class ReasonerApplyDialog extends ApplyFormDialog {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 530;
	private static int HEIGHT = 630;

	/**
	 * Constructor
	 */
	public ReasonerApplyDialog() {
		super(FncGlobals.REASONER_A_TITLE, FncGlobals.REASONER_C_SLOGAN);
		
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
		this.form = new ReasonerApplyFormImpl(FormAction.CREATE);
		this.form.addFormHandler(this);

		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {

		/*
		 * Prepare data
		 */
		String source = ((ReasonerApplyFormImpl)this.form).getSource();
		if (source == null) {

			String message = FncGlobals.NAMESPACE_ERROR;
			SC.say(GUIGlobals.APP_TITLE + ": Reasoner Error", message);		

			this.setAutoClose(false);
			return;
		
		}
		
		HashMap<String,String> attributes = this.getParams();
		attributes.put(MethodConstants.ATTR_SOURCE, source);
		
		String data = this.form.getFormData();
		
		this.setAutoClose(true);
		new RuleService().doApply(attributes, data, this.sendActivity);

	}	

	/**
	 * @param attributes
	 * @param name
	 * @param desc
	 * @param afterSendActivity
	 */
	public  static void create(HashMap<String,String> attributes, String name, String desc, Activity afterSendActivity) {
		
		/*
		 * Create dialog
		 */
		ReasonerApplyDialog dialog = new ReasonerApplyDialog();
		dialog.setTitle(name);
		
		/*
		 * Provide request specific information
		 */
		dialog.setParams(attributes);
		dialog.addSendActivity(afterSendActivity);
	
	}

}
