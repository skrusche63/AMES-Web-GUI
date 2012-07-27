package de.kp.ames.web.client.fnc.group.widget;

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;

public class GroupGetViewer extends ViewerImpl {

	private static String TITLE  = GUIGlobals.APP_TITLE + ": Group Viewer";
	private static String SLOGAN = "Use this widget to view group specific information.";

	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public GroupGetViewer(Canvas body) {
		super(TITLE, SLOGAN, body);
	}
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 * @param body
	 */
	public GroupGetViewer(String title, String slogan, Canvas body) {
		super(title, slogan, body);
	}

}
