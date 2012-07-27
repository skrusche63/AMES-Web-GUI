package de.kp.ames.web.client.fnc.bulletin.widget;

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class CommentsViewer extends ViewerImpl {

	/**
	 * Constructor
	 */
	public CommentsViewer(Canvas body) {
		super(FncGlobals.COMMENT_G_TITLE, FncGlobals.COMMENT_G_SLOGAN, body);
	}

}
