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

import java.util.ArrayList;
import java.util.HashMap;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.layout.HLayout;

import de.kp.ames.web.client.fnc.symbol.event.SymbolEventManager;
import de.kp.ames.web.client.fnc.symbol.event.SymbolListener;
import de.kp.ames.web.client.handler.RemoveHandler;

public class SymbolBoard extends HLayout implements RemoveHandler, SymbolListener {
	
	/*
	 * Reference to SymbolCode
	 */
	private SymbolCodeImpl symbolCodes;
	
	/*
	 * Reference to SymbolIcon
	 */
	private SymbolIconImpl symbolIcons;
	
	/*
	 * Reference to removable members
	 */
	private ArrayList<RemoveHandler> removables;

	public SymbolBoard(String type) {
		this.removables = new ArrayList<RemoveHandler>();
		
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Construct members
		 */
		symbolCodes = new SymbolCodeImpl(type);
		removables.add(symbolCodes);
		
		symbolIcons = new SymbolIconImpl(type);
		removables.add(symbolIcons);
		
		/*
		 * Set Dimensions and splitter
		 */		
		symbolCodes.setWidth(240);
		symbolIcons.setWidth("*");
		
		/*
		 * Show splitter for symbol codes
		 */
		symbolCodes.setShowResizeBar(true);
		
		this.setMembers(symbolCodes, symbolIcons);
		
		/*
		 * Context specific event handling
		 */
		SymbolEventManager.getInstance().addSymbolListener(this);

	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.RemoveHandler#beforeRemove()
	 */
	public void beforeRemove() {

		for (RemoveHandler removable:removables) {
			removable.beforeRemove();
		}

		SymbolEventManager.getInstance().removeSymbolListener(this);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.symbol.event.SymbolListener#onSymbolSelected(com.smartgwt.client.widgets.tree.TreeNode)
	 */
	public void onSymbolSelected(HashMap<String,String> attributes) {		
		symbolIcons.reload(attributes);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.fnc.symbol.event.SymbolListener#onSymbolSelected(com.smartgwt.client.data.Record)
	 */
	public void onSymbolSelected(Record record) {
		/*
		 * This method must not be used here
		 */		
	}

}
