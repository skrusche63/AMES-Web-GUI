package de.kp.ames.web.client.fnc.symbol.event;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.symbol.event
 *  Module: SymbolListener
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #event #fnc #listener #symbol #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.smartgwt.client.data.Record;

public interface SymbolListener {

	public void onSymbolSelected(HashMap<String,String> attributes);

	public void onSymbolSelected(Record record);

}
