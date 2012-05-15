package de.kp.ames.web.client.function.gui.desktop;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Orientation;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.events.RecordClickEvent;
import com.smartgwt.client.widgets.tile.events.RecordClickHandler;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

import de.kp.ames.web.client.core.gui.apps.BaseApp;
import de.kp.ames.web.client.core.gui.control.MainController;
import de.kp.ames.web.client.core.gui.globals.GUIStyles;
import de.kp.ames.web.client.function.gui.globals.FncGlobals;

public class DesktopImpl extends BaseApp {

	private TileGrid deskview;
	
	private static int TILE_DIM = 128;
	
	private static String TILE_ICON  = "icon";
	private static String TILE_ID    = "id";
	private static String TILE_TITLE = "title";
	
	public DesktopImpl() {

		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		deskview = createDeskView();
		this.setMembers(deskview);
		
	}
	
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
		title.setCellStyle(GUIStyles.X_TILE_CELL);
		
	    DetailViewerField icon  = new DetailViewerField(TILE_ICON);
		icon.setCellStyle(GUIStyles.X_TILE_CELL);

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
	
	private RecordList getTileRecords() {

	    RecordList records = new RecordList();
	    
	    records.add(new TileRecord(FncGlobals.FNC_APP_ID_Bulletin, FncGlobals.BULLETIN_TITLE,  "x-bulletin96.png"));
	  
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
