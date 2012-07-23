package de.kp.ames.web.client.function.comm.widget;

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;

public class CommViewer extends ViewerImpl {

	private static String TITLE  = GUIGlobals.APP_TITLE + ": Comm Viewer";
	private static String SLOGAN = "Use this widget to view a certain communication object.";

	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public CommViewer(Canvas body) {
		super(TITLE, SLOGAN, body);
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
	}

}
