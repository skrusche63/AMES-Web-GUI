package de.kp.ames.web.client.fnc.comm.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.comm.widget
 *  Module: CommViewer
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #comm #fnc #viewer #web #widget
 * </SemanticAssist>
 *
 */


import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class CommViewer extends ViewerImpl {

	private static int VIEWER_WIDTH  = 524;
	private static int VIEWER_HEIGHT = 560;
	
	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public CommViewer(Canvas body) {
		super(FncGlobals.COMM_V_TITLE, FncGlobals.COMM_V_SLOGAN, body);
		
		/*
		 * Dimensions
		 */
		this.setWidth(VIEWER_WIDTH);
		this.setHeight(VIEWER_HEIGHT);
		
		/*
		 * The Comm Viewer is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 * @param body
	 */
	public CommViewer(String title, String slogan, Canvas body) {
		super(title, slogan, body);
		
		/*
		 * Dimensions
		 */
		this.setWidth(VIEWER_WIDTH);
		this.setHeight(VIEWER_HEIGHT);
		
		/*
		 * The Comm Viewer is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

	}

}
