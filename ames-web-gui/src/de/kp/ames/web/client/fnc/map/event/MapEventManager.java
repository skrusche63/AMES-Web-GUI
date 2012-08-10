package de.kp.ames.web.client.fnc.map.event;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.map.event
 *  Module: MapEventManager
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #event #fnc #manager #map #web
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
import com.smartgwt.client.widgets.Canvas;

public class MapEventManager implements LayerGridListener, MapListener {

	private static MapEventManager instance = new MapEventManager();
	
	/*
	 * List of registered upload listeners
	 */
	private ArrayList<LayerGridListener> layerGridListeners;

	/*
	 * List of registered map listeners
	 */
	private ArrayList<MapListener> mapListeners;

	/**
	 * Constructor
	 */
	private MapEventManager() {
		
		layerGridListeners = new ArrayList<LayerGridListener>();
		mapListeners       = new ArrayList<MapListener>();
		
	}
	
	/**
	 * Retrieve singleton instance of MapEventManager
	 * 
	 * @return
	 */
	public static MapEventManager getInstance() {
		if (instance == null) instance = new MapEventManager();
		return instance;
	}
	
	/**
	 * Register layer listener
	 * 
	 * @param listener
	 */
	public void addLayerGridListener(LayerGridListener listener) {
		layerGridListeners.add(listener);
	}
	
	/**
	 * Unregister layer listener
	 * 
	 * @param listener
	 */
	public void removeLayerGridListener(LayerGridListener listener) {
		layerGridListeners.remove(listener);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.bulletin.event.ContactListener#onContactSelected(com.smartgwt.client.widgets.grid.GridRecord)
	 */
	public void onLayerSelected(Record record) {

		for (LayerGridListener listener:layerGridListeners) {
			listener.onLayerSelected(record);
		}
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.fnc.map.event.LayerGridListener#onLayerSubmitted(com.smartgwt.client.data.Record)
	 */
	public void onLayerSubmitted(Record record) {

		for (LayerGridListener listener:layerGridListeners) {
			listener.onLayerSubmitted(record);
		}
	
	}

	/**
	 * Register map listener
	 * 
	 * @param listener
	 */
	public void addMapListener(MapListener listener) {
		mapListeners.add(listener);
	}
	
	/**
	 * Unregister map listener
	 * 
	 * @param listener
	 */
	public void removeMapListener(MapListener listener) {
		mapListeners.remove(listener);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.fnc.map.event.MapListener#onMap(com.smartgwt.client.widgets.Canvas)
	 */
	public void onMap(Canvas canvas) {

		for (MapListener listener:mapListeners) {
			listener.onMap(canvas);
		}
	
	}

	
}