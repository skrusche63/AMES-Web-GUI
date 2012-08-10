package de.kp.ames.web.client.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.handler
 *  Module: DialogHandler
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #dialog #handler #web
 * </SemanticAssist>
 *
 */


import de.kp.ames.web.client.core.activity.Activity;

public interface DialogHandler {

	/**
	 * @param activity
	 */
	public void addSendActivity(Activity activity);
	
	/**
	 * Send form to server
	 */
	public void doSend();
	
}
