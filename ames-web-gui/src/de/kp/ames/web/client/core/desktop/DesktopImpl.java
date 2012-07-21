package de.kp.ames.web.client.core.desktop;
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

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Orientation;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.events.RecordClickEvent;
import com.smartgwt.client.widgets.tile.events.RecordClickHandler;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

import de.kp.ames.web.client.core.apps.MainController;
import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.shared.constants.JsonConstants;

public class DesktopImpl extends BaseApp {

	private TileGrid deskview;
	
	private static int TILE_DIM = 128;
	
	private static String TILE_ICON  = JsonConstants.J_ICON;
	private static String TILE_ID    = JsonConstants.J_ID;
	private static String TILE_TITLE = JsonConstants.J_NAME;
	
	/*
	 * Reference to callers apps
	 */
	private JSONArray jApps;
	
	/**
	 * Contructor
	 * 
	 * @param jArray
	 */
	public DesktopImpl(JSONArray jArray) {

		/*
		 * Register Callers Apps
		 */
		this.jApps = jArray;
		
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		deskview = createDeskView();
		this.setMembers(deskview);
		
	}
	
	/**
	 * @return
	 */
	private TileGrid createDeskView() {
		
		TileGrid deskview = new TileGrid();

		/*
		 * Tile Rendering
		 */
		deskview.setShowEdges(false);
		
		deskview.setCanReorderTiles(true);  
		deskview.setShowAllRecords(true);  

		deskview.setAutoFetchData(true);  
		deskview.setAnimateTileChange(true);  

		/*
		 * Dimensions
		 */
		deskview.setWidth100();
		deskview.setHeight100();
		
		/*
		 * Tile dimensions
		 */
		deskview.setTileHeight(TILE_DIM);
		deskview.setTileWidth(TILE_DIM);

		deskview.setOrientation(Orientation.HORIZONTAL);
		
		/*
		 * Define fields
		 */
		DetailViewerField title = new DetailViewerField(TILE_TITLE);
		//title.setCellStyle(GUIStyles.X_TILE_CELL);
		
	    DetailViewerField icon  = new DetailViewerField(TILE_ICON);
		//icon.setCellStyle(GUIStyles.X_TILE_CELL);

	    icon.setType("image");
	    icon.setImageSize(96);
	    
	    deskview.setFields(icon, title);
	    deskview.setData(getTileRecords());

		deskview.addRecordClickHandler(new RecordClickHandler() {

			public void onRecordClick(RecordClickEvent event) {
	            final Record record = event.getRecord();
	            if (record == null) return;
	            
	            String profile = record.getAttributeAsString("id");
	            MainController.getInstance().createApp(profile);
	            
	        }
	    });

		return deskview;

	}
	
	/**
	 * @return
	 */
	private RecordList getTileRecords() {
		
	    RecordList records = new RecordList();
		if (jApps == null) return records;
	    
	    
	    for (int i=0; i < jApps.size(); i++) {
	    	
	    	JSONObject jApp = jApps.get(i).isObject();
	    	
	    	String aid  = jApp.get(JsonConstants.J_ID).isString().stringValue();
	    	String name = jApp.get(JsonConstants.J_NAME).isString().stringValue();
	    	
	    	String icon = jApp.get(JsonConstants.J_ICON).isString().stringValue();
		    records.add(new TileRecord(aid, name,  icon));
	    	
	    }
	  
	    return records;
	    
	}
	
	private class TileRecord extends Record {
		
		TileRecord(String id, String title, String icon) {
			
			setAttribute(TILE_ID,    id);
			setAttribute(TILE_TITLE, title);
			setAttribute(TILE_ICON,  icon);
		
		}

	}

}
