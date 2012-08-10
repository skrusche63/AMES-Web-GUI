package de.kp.ames.web.client.fnc.upload.event;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.upload.event
 *  Module: UploadListener
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #event #fnc #listener #upload #web
 * </SemanticAssist>
 *
 */


public interface UploadListener {

	/**
	 * This method is invoked after an upload is complete
	 */
	public void onSuccess();
	
	public void onFailure();
	
}
