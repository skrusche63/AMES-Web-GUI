package de.kp.ames.web.client.core.clas.event;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.clas.event
 *  Module: ClasEventManager
 *  @author spex66@gmx.net
 *   
 *  Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #event #core #manager #clas #web
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

import java.util.ArrayList;

import com.smartgwt.client.data.Record;

public class ClasEventManager implements ClasListener {

	private static ClasEventManager instance = new ClasEventManager();
	
	/*
	 * List of registered transform listeners
	 */
	private ArrayList<ClasListener> clasListeners;

	/**
	 * Constructor
	 */
	private ClasEventManager() {
		
		clasListeners = new ArrayList<ClasListener>();
		
	}
	
	/**
	 * Retrieve singleton instance of RuleEventManager
	 * 
	 * @return
	 */
	public static ClasEventManager getInstance() {
		if (instance == null) instance = new ClasEventManager();
		return instance;
	}
	
	/**
	 * Register rule listener
	 * 
	 * @param listener
	 */
	public void addClasListener(ClasListener listener) {
		clasListeners.add(listener);
	}
	
	/**
	 * Unregister rule listener
	 * 
	 * @param listener
	 */
	public void removeClasListener(ClasListener listener) {
		clasListeners.remove(listener);
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.clas.event.ClasListener#onClasSelected(com.smartgwt.client.data.Record)
	 */
	public void onClasSelected(Record record) {

		for (ClasListener listener:clasListeners) {
			listener.onClasSelected(record);
		}
	
	}

}