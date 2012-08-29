package de.kp.ames.web.client.fnc.map.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.map.widget
 *  Module: LayerGridSelectDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #dialog #fnc #grid #layer #map #select #web #widget
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

import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;

import de.kp.ames.map.client.MapConfig;
import de.kp.ames.map.client.listener.MapListener;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.widget.dialog.ApplyFormDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.map.data.LayerGridImpl;
import de.kp.ames.web.client.fnc.map.event.LayerGridListener;
import de.kp.ames.web.client.fnc.map.event.MapEventManager;
import de.kp.ames.web.client.fnc.map.util.MapUtil;

public class LayerGridSelectDialog extends ApplyFormDialog implements LayerGridListener {

	/*
	 * Reference to selected layer record
	 */
	private Record layerRecord;
	
	/**
	 * Constructor
	 */
	public LayerGridSelectDialog() {
		super(FncGlobals.MAP_C_TITLE, FncGlobals.MAP_C_SLOGAN);
		
		/*
		 * Dialog Title
		 */
		this.setTitle(FncGlobals.MAP_TITLE);
		
		/*
		 * Dialog Dimensions
		 */
		this.setWidth(380);
		this.setHeight(320);
		
		/*
		 * Context specific event handling
		 */
		MapEventManager.getInstance().addLayerGridListener(this);
		
		this.redraw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		LayerGridImpl grid = new LayerGridImpl(GuiConstants.WMS_URL, new ActivityImpl() {
			public void execute() {
				// No activity required as this is a synchronous action
			}
			
		});
		
		/*
		 * Use double click for user experience to select layer
		 * AND open respective map with a single mouse event
		 */
		grid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
			
			public void onRecordDoubleClick(RecordDoubleClickEvent event) {
				
				Record record = event.getRecord();
				MapEventManager.getInstance().onLayerSubmitted(record);

			}
		});

		return grid;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {
		
		if (this.layerRecord == null) {

			String message = FncGlobals.LAYER_ERROR;
			SC.say(GuiConstants.APP_TITLE + ": Layer Select Error", message);		

			this.setAutoClose(false);
			return;
		
		}
		
		this.setAutoClose(true);
		this.openMap();
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#beforeRemove()
	 */
	public void beforeRemove() {
		MapEventManager.getInstance().removeLayerGridListener(this);	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.fnc.map.event.LayerGridListener#onLayerSelected(com.smartgwt.client.data.Record)
	 */
	public void onLayerSelected(Record record) {		
		this.layerRecord = record;
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.fnc.map.event.LayerGridListener#onLayerSubmitted(com.smartgwt.client.data.Record)
	 */
	public void onLayerSubmitted(Record record) {

		this.layerRecord = record;
		this.doSend();
		
		/*
		 * Initiate before remove processing
		 */
		this.beforeRemove();
		
		/*
		 * Destroy window
		 */
		this.destroy();
		
	}	
	
	/**
	 * This is a helper method to open a map
	 * with the selected layer
	 */
	private void openMap() {
		
		MapConfig jGeoInfo = MapUtil.buildMapConfig(this.layerRecord);
		jGeoInfo.setWmsServer(GuiConstants.WMS_URL);

		/*
		 * A map listener (for dragging) is not supported for
		 * the business map
		 */
		MapListener listener = null;
		final BusinessMapImpl map = new BusinessMapImpl(jGeoInfo, listener);

		/*
		 * Dimensions
		 */
		map.setWidth100();
		map.setHeight100();

		MapEventManager.getInstance().onMap(map);

	}

}
