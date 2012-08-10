package de.kp.ames.web.client.fnc.help;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.help
 *  Module: HelpImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #help #web
 * </SemanticAssist>
 *
 */


import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class HelpImpl extends BaseApp {

	public HelpImpl() {
		super(FncGlobals.HELP_TITLE, FncGlobals.HELP_SLOGAN);

		this.setWidth100();
		this.setHeight100();
		
	}
}
