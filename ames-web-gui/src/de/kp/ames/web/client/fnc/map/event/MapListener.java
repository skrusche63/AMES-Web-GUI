package de.kp.ames.web.client.fnc.map.event;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.map.event
 *  Module: MapListener
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #event #fnc #listener #map #web
 * </SemanticAssist>
 *
 */


import com.smartgwt.client.widgets.Canvas;

public interface MapListener {

	public void onMap(Canvas canvas);
	
}
