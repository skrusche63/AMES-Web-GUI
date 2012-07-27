package de.kp.ames.web.client.fnc.symbol.event;
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

public class SymbolEventManager implements SymbolListener {

	private static SymbolEventManager instance = new SymbolEventManager();
	
	/*
	 * List of registered symbol listeners
	 */
	private ArrayList<SymbolListener> symbolListeners;

	/**
	 * Constructor
	 */
	private SymbolEventManager() {
		
		symbolListeners = new ArrayList<SymbolListener>();
		
	}
	
	/**
	 * Retrieve singleton instance of TransformEventManager
	 * 
	 * @return
	 */
	public static SymbolEventManager getInstance() {
		if (instance == null) instance = new SymbolEventManager();
		return instance;
	}
	
	/**
	 * Register symbol listener
	 * 
	 * @param listener
	 */
	public void addSymbolListener(SymbolListener listener) {
		symbolListeners.add(listener);
	}
	
	/**
	 * Unregister symbol listener
	 * 
	 * @param listener
	 */
	public void removeSymbolListener(SymbolListener listener) {
		symbolListeners.remove(listener);
	}
	
	public void onSymbolSelected(HashMap<String,String> attributes) {

		for (SymbolListener listener:symbolListeners) {
			listener.onSymbolSelected(attributes);
		}
	
	}

}