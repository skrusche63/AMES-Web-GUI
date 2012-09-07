package de.kp.ames.web.client.fnc.role.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.role.widget
 *  Module: ResponsibilityGetViewer
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #get #responsibility #role #viewer #web #widget
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.role.data.RoleGridImpl;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class ResponsibilityGetViewer extends ViewerImpl {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 530;
	private static int HEIGHT = 450;

	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public ResponsibilityGetViewer(Canvas body) {
		super(FncGlobals.RESPONSIBILITY_G_TITLE, FncGlobals.RESPONSIBILITY_G_SLOGAN, body);
		
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
		 * The Comm Viewer is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

		this.redraw();

	}
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 * @param body
	 */
	public ResponsibilityGetViewer(String title, String slogan, Canvas body) {
		super(title, slogan, body);
		
		/*
		 * Button handling
		 */
		this.setShowCloseButton(false);
		this.setShowMinimizeButton(false);
		
		/*
		 * Set dimensions
		 */
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		
		/*
		 * The Comm Viewer is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

		this.redraw();

	}

	/**
	 * @param attributes
	 * @param jValue
	 */
	public static void create(HashMap<String,String> attributes) {

		String type = ClassificationConstants.FNC_ID_Responsibility;
		
		String source = attributes.get(MethodConstants.ATTR_SOURCE); 
		String target = null;

		RoleGridImpl grid = new RoleGridImpl(type, source, target);
		new ResponsibilityGetViewer(grid);
		
	}


}
