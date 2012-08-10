package de.kp.ames.web.client.core.service;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.service
 *  Module: FrameService
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #frame #service #web
 * </SemanticAssist>
 *
 */


import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class FrameService extends ServiceImpl {

	/**
	 * Constructor
	 */
	public FrameService() {
		super(CoreGlobals.REG_URL, ServiceConstants.FRAME_SERVICE_ID);
	}
	
}
