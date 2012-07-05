package de.kp.ames.web.client.function.access.widget;

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;

public class RemoteViewViewer extends ViewerImpl {

	private static String TITLE  = GUIGlobals.APP_TITLE + ": Remote Viewer";
	private static String SLOGAN = "Use this widget to view a certain remote object.";

	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public RemoteViewViewer(Canvas body) {
		super(TITLE, SLOGAN, body);
	}
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 * @param body
	 */
	public RemoteViewViewer(String title, String slogan, Canvas body) {
		super(title, slogan, body);
	}

	// TODO

}
