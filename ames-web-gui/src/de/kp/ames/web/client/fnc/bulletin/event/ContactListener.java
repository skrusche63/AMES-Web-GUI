package de.kp.ames.web.client.fnc.bulletin.event;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.bulletin.event
 *  Module: ContactListener
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #bulletin #client #contact #event #fnc #listener #web
 * </SemanticAssist>
 *
 */


import com.smartgwt.client.data.Record;

public interface ContactListener {

	/**
	 * @param record
	 */
	public void onContactSelected(Record record);
	
	public void onPostingSubmitted();
	
}
