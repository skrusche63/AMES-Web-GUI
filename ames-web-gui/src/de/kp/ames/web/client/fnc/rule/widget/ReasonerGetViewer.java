package de.kp.ames.web.client.fnc.rule.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.rule.widget
 *  Module: ReasonerGetViewer
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #get #reasoner #rule #viewer #web #widget
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class ReasonerGetViewer extends ViewerImpl {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 525;
	private static int HEIGHT = 640;

	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public ReasonerGetViewer(Canvas body) {
		super(FncGlobals.REASONER_G_TITLE, FncGlobals.REASONER_G_SLOGAN, body);
		
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
		 * The Reasoner Viewer is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

		this.draw();

	}
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 * @param body
	 */
	public ReasonerGetViewer(String title, String slogan, Canvas body) {
		super(title, slogan, body);
	}
	
	/**
	 * @param attributes
	 * @param jValue
	 */
	public static void create(HashMap<String,String> attributes, JSONValue jValue) {
		
		ReasonerFormImpl form = new ReasonerFormImpl(FormAction.GET);
		
		form.addFormData(jValue);	
		form.setParams(attributes);
		
		new ReasonerGetViewer(form);

	}

}
