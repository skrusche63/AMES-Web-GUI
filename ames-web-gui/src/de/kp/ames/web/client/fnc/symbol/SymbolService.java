package de.kp.ames.web.client.fnc.symbol;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.symbol
 *  Module: SymbolService
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #service #symbol #web
 * </SemanticAssist>
 *
 */


import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class SymbolService extends ServiceImpl {

	public SymbolService() {
		super(GuiConstants.REG_URL, ServiceConstants.SYMBOL_SERVICE_ID);
	}


}
