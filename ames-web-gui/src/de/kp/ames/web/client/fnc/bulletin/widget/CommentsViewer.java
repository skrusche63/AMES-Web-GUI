package de.kp.ames.web.client.fnc.bulletin.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.bulletin.widget
 *  Module: CommentsViewer
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #bulletin #client #comments #fnc #viewer #web #widget
 * </SemanticAssist>
 *
 */


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
