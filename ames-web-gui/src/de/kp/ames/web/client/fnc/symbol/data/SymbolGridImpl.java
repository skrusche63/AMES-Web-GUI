package de.kp.ames.web.client.fnc.symbol.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.symbol.data
 *  Module: SymbolGridImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #data #fnc #grid #symbol #web
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
import java.util.Map;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.events.RecordClickEvent;
import com.smartgwt.client.widgets.tile.events.RecordClickHandler;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.fnc.symbol.event.SymbolEventManager;
import de.kp.ames.web.client.model.GraphicObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class SymbolGridImpl extends TileGrid {

	private static int TILE_WIDTH  = 128;
	private static int TILE_HEIGHT = 156;
	
	/*
	 * The base url necessary to invoke the
	 * web service that refers to this service
	 */	
	protected String base;
	
	/*
	 * The unique service identifier
	 */
	protected String sid;

	/*
	 * Reference to DataObject
	 */
	protected DataObject dataObject;

	/*
	 * Reference to RestDataSource
	 */
	protected RestDataSource dataSource;
	
	/*
	 * Reference to attributes
	 */
	protected HashMap<String,String> attributes;
	
	/**
	 * Constructor
	 */
	public SymbolGridImpl() {
		this(null);
	}

	/**
	 * @param type
	 */
	public SymbolGridImpl(String type) {
		
		/*
		 * Register connection parameter
		 */
		this.base = GuiConstants.REG_URL;
		this.sid  = ServiceConstants.SYMBOL_SERVICE_ID;
		
		/*
		 * No border style
		 */
		this.setBorder("0");
		this.setShowEdges(false);
		
		/*
		 * Dimensions
		 */		
		this.setWidth100();
		this.setHeight100();
				
		this.setTileWidth(TILE_WIDTH);
		this.setTileHeight(TILE_HEIGHT);
		
		this.setCanReorderTiles(true);
		this.setAnimateTileChange(true);
		/*
		 * Data handling
		 */
		this.setAutoFetchData(false);		
		this.setShowAllRecords(false);

		/*
		 * Event handling
		 */
		final SymbolGridImpl self = this;

		this.addDrawHandler(new DrawHandler() {
			public void onDraw(DrawEvent event) {
				self.afterDraw(event);
			}			
		});

		this.addRecordClickHandler(new RecordClickHandler() {
			public void onRecordClick(RecordClickEvent event) {
				self.afterRecordClick(event);				
			}
			
		});

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();
		if (type != null) attributes.put(MethodConstants.ATTR_TYPE, type);
		
		/*
		 * Create data object
		 */
		this.dataObject = createDataObject();

		/*
		 * Create data source
		 */
		this.createScGridDS();

		/*
		 * Create grid fields
		 */
		this.setFields(createViewerFields(attributes));

	}

	/**
	 * Initial data loading
	 * 
	 * @param event
	 */
	public void afterDraw(DrawEvent event) {

		if (this.attributes.isEmpty()) return;
		//this.fetchData();
	
	}

	/**
	 * Processing after a certain (image) symbol is clicked
	 * 
	 * @param event
	 */
	public void afterRecordClick(RecordClickEvent event) {
		
		Record record = event.getRecord();
		SymbolEventManager.getInstance().onSymbolSelected(record);
		
	}

	/**
	 * Reload Tile Grid from a set of parameters
	 * 
	 * @param attributes
	 */
	public void reload(HashMap<String,String>attributes) {

		this.attributes.putAll(attributes);
		this.reload();
	
	}
	
	/**
	 * A helper method to reload the content of the grid
	 */
	private void reload() {
		/* 
		 * REMARK:
		 * 
		 * To invalidate the cache is essential to 
		 * retrieve data from the server again
		 */
		this.invalidateCache();
		this.fetchData();
	}

	/**
	 * A helper method to build the request url
	 * 
	 * @return
	 */
	public String getRequestUrl() {
		
		if ((this.sid == null) || (this.base == null)) return null;
		return this.base + "/" + this.sid;
		
	}

	/**
	 * @param attributes
	 * @return
	 */
	public DataSourceField[] createDataFields(HashMap<String,String> attributes) {
		return this.dataObject.createDataFieldsAsArray();
	}

	/**
	 * @param attributes
	 * @return
	 */
	private DetailViewerField[] createViewerFields(HashMap<String,String> attributes) {
		return this.dataObject.createViewerFieldsAsArray();
	}

	/**
	 * @param attributes
	 * @return
	 */
	private RequestMethod createMethod() {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_GET);

		requestMethod.addAttribute(MethodConstants.ATTR_FORMAT, FormatConstants.FNC_FORMAT_ID_Grid);

		requestMethod.setAttributes(attributes);		
		return requestMethod;
		
	}

	/**
	 * A helper method to create request parameters
	 * 
	 * @return
	 */
	private Map<String,String> getRequestParams() {
		
		RequestMethod requestMethod = createMethod();
		return requestMethod.toParams();
	
	}

	/**
	 * Create Data Object
	 * 
	 * @param attributes
	 * @return
	 */
	private DataObject createDataObject() {
		return new GraphicObject();
	}

	/**
	 * Create DataSource for TileGrid
	 * 
	 * @param attributes
	 */
	private void createScGridDS() {
		
		/*
		 * Request url
		 */
		String url = getRequestUrl();

		/*
		 * Request fields
		 */
		DataSourceField[] fields = createDataFields(attributes);

		dataSource = new RestDataSource() {
			  
			protected Object transformRequest(DSRequest dsRequest) {  
				dsRequest.setParams(getRequestParams());				
				return super.transformRequest(dsRequest);  
			}  

			protected void transformResponse(DSResponse response, DSRequest request, Object data) {  
				super.transformResponse(response, request, data);  
			}  
			
		};
		
		dataSource.setDataFormat(DSDataFormat.JSON);
		dataSource.setDataProtocol(DSProtocol.GETPARAMS);  
		
		dataSource.setDataURL(url);		
		dataSource.setFields(fields);

		/*
		 * finally set data source
		 */
		setDataSource(dataSource);

	}

}
