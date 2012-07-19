package de.kp.ames.web.client.function.transform.event;
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

public class TransformEventManager implements TransformListener {

	private static TransformEventManager instance = new TransformEventManager();
	
	/*
	 * List of registered transform listeners
	 */
	private ArrayList<TransformListener> transformListeners;

	/**
	 * Constructor
	 */
	private TransformEventManager() {
		
		transformListeners = new ArrayList<TransformListener>();
		
	}
	
	/**
	 * Retrieve singleton instance of TransformEventManager
	 * 
	 * @return
	 */
	public static TransformEventManager getInstance() {
		if (instance == null) instance = new TransformEventManager();
		return instance;
	}
	
	/**
	 * Register transform listener
	 * 
	 * @param listener
	 */
	public void addTransformListener(TransformListener listener) {
		transformListeners.add(listener);
	}
	
	/**
	 * Unregister transform listener
	 * 
	 * @param listener
	 */
	public void removeTransformListener(TransformListener listener) {
		transformListeners.remove(listener);
	}
	
	public void onTransformatorSelected(Record record) {

		for (TransformListener listener:transformListeners) {
			listener.onTransformatorSelected(record);
		}
	
	}

}