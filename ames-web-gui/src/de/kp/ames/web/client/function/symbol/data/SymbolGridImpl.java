package de.kp.ames.web.client.function.symbol.data;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.events.RecordClickEvent;
import com.smartgwt.client.widgets.tile.events.RecordClickHandler;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.model.GraphicObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

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
	 * Reference to DataSource
	 */
	protected DataSource dataSource;
	
	/*
	 * Reference to attributes
	 */
	protected HashMap<String,String> attributes;
	
	/**
	 * Constructor
	 */
	public SymbolGridImpl() {
		
		/*
		 * Register connection parameter
		 */
		this.base = CoreGlobals.REG_URL;
		this.sid  = ServiceConstants.SYMBOL_SERVICE_ID;
		
		/*
		 * No border style
		 */
		this.setBorder("0");
		
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

	public void afterRecordClick(RecordClickEvent event) {
		// TODO
	}

	/**
	 * Fetch data after rendering
	 * 
	 * @param event
	 */
	public void afterDraw(DrawEvent event) {
		this.fetchData();
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
		this.redraw();

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
		requestMethod.setName(MethodConstants.METH_SYMBOLS);
		
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

		dataSource = new DataSource() {
			  
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
