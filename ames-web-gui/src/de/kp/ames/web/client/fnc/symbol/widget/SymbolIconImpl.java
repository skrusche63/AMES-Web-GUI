package de.kp.ames.web.client.fnc.symbol.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.symbol.widget
 *  Module: SymbolIconImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #icon #symbol #web #widget
 * </SemanticAssist>
 *
 */

/**
 *	Copyright 2012 Dr. Krusche & Partner PartG
 *
 *	AMES-Web-GUI is free software: you can redistribute it and/or 
 *	modify it under the terms of the GNU General Public License 
 *	as published by the Free Software Foundation, either version 3 of 
 *	the License, or (at your option) any later version.
 *
 *	AMES- Web-GUI is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 *  See the GNU General Public License for more details. 
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this software. If not, see <http://www.gnu.org/licenses/>.
 *
 */

import java.util.HashMap;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.symbol.data.SymbolGridImpl;
import de.kp.ames.web.client.handler.RemoveHandler;

public class SymbolIconImpl extends VLayout implements RemoveHandler {

	/*
	 * Reference to SymbolGrid
	 */
	private SymbolGridImpl grid;

	public SymbolIconImpl(String type) {
		
		this.setShowEdges(false);
		
		this.setWidth100();
		this.setHeight100();

		/*
		 * Build label
		 */
		Label label = new Label(FncGlobals.SYMBOLS_LABEL);
		
		label.setWidth100();
		label.setHeight(22);
		
		label.setAlign(Alignment.CENTER);
		
		/*
		 * Build grid
		 */
		grid = new SymbolGridImpl(type);		
		this.setMembers(label, grid);


	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.RemoveHandler#beforeRemove()
	 */
	public void beforeRemove() {
		/*
		 * Actually there is noting to do as there is
		 * no event handling invoked
		 */		
	}

	/**
	 * @param attributes
	 */
	public void reload(HashMap<String,String> attributes) {
		grid.reload(attributes);
		
	}
	
}
