package de.kp.ames.web.client.fnc.symbol.widget;
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

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.symbol.data.SymbolTreeImpl;
import de.kp.ames.web.client.handler.RemoveHandler;

public class SymbolCodeImpl extends VLayout implements RemoveHandler {

	/*
	 * Reference to all registered symbols
	 */
	private SymbolTreeImpl tree;
	
	/**
	 * Constructor
	 */
	public SymbolCodeImpl(String type) {
		
		setWidth100();
		setHeight100();

		/*
		 * Build label
		 */
		Label label = new Label(FncGlobals.CODES_LABEL);
		
		label.setWidth100();
		label.setHeight(22);
		
		label.setAlign(Alignment.CENTER);
		
		/*
		 * Build tree
		 */
		tree = new SymbolTreeImpl(type);		
		this.setMembers(label, tree);
		
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

}
