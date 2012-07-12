package de.kp.ames.web.client.core.grid;
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
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.RowContextClickEvent;
import com.smartgwt.client.widgets.grid.events.RowContextClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.handler.GridMenuHandler;
import de.kp.ames.web.client.handler.GridRecordHandler;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.FormatConstants;
import de.kp.ames.web.shared.JsonConstants;
import de.kp.ames.web.shared.MethodConstants;

public class GridImpl extends ListGrid implements Grid {
	
	/*
	 * Reference to DataObject
	 */
	protected DataObject dataObject;

	/*
	 * Reference to DataSource
	 */
	protected RestDataSource dataSource;

	/*
	 * Reference to MenuHandler
	 */
	protected GridMenuHandler menuHandler;
	
	/*
	 * Reference to RecordHandler
	 */
	protected GridRecordHandler recordHandler;
	
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
	 * Page size
	 */
	protected int pageSize = 25;
	
	/*
	 * Reference to name of detail field
	 */
	protected String detailFieldName;
	
	/*
	 * Reference to attributes
	 */
	protected HashMap<String,String> attributes;
	
	/**
	 * Constructor
	 * 
	 * @param sid
	 */
	public GridImpl(String sid) {
		this(CoreGlobals.REG_URL, sid);
	}

	/**
	 * Constructor
	 * 
	 * @param base
	 * @param sid
	 */
	public GridImpl(String base, String sid) {

		/*
		 * Register basic connection parameters
		 */
		this.base = base;
		this.sid  = sid;
		
		/*
		 * No border style
		 */
		this.setBorder("0");
		
		/*
		 * Dimensions
		 */		
		this.setWidth100();
		this.setHeight100();

		/*
		 * Page size support
		 */
		this.setDataPageSize(pageSize);
		
		/*
		 * List entry may be expanded on click
		 */
		String detailFieldName = getDetailFieldName();

		if (detailFieldName != null) {

			this.setCanExpandRecords(true);
			this.setExpansionMode(ExpansionMode.DETAIL_FIELD);

			this.setDetailField(detailFieldName);
			
		}

		/*
		 * Data handling
		 */
		this.setAutoFetchData(false);		
		this.setShowAllRecords(false);

		/*
		 * Event handling
		 */
		final GridImpl self = this;
		
		this.addDataArrivedHandler(new DataArrivedHandler() {
			public void onDataArrived(DataArrivedEvent event) {								
		    	self.afterDataArrived(event);
			}			
		});
		
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
		
		this.addRowContextClickHandler(new RowContextClickHandler() {
			public void onRowContextClick(RowContextClickEvent event) {
				self.afterContextMenu(event);
			}			
		});

		this.addSelectionChangedHandler(new SelectionChangedHandler() {
			public void onSelectionChanged(SelectionEvent event) {
				self.afterSelectionChanged(event);				
			}
		});
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.BaseGrid#addMenuHandler(de.kp.ames.web.client.core.menu.GridMenuHandler)
	 */
	public void addMenuHandler(GridMenuHandler menuHandler) {
		/*
		 * Set Menu Handler and register grid
		 * for later processing
		 */
		this.menuHandler = menuHandler;
		this.menuHandler.setGrid(this);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#addRecordHandler(de.kp.ames.web.client.handler.GridRecordHandler)
	 */
	public void addRecordHandler(GridRecordHandler recordHandler) {
		/*
		 * Set Record Handler and register grid
		 * for later processing
		 */
		this.recordHandler = recordHandler;
		this.recordHandler.setGrid(this);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return JsonConstants.J_DESC;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#reload()
	 */
	public void reload() {
		
		/* 
		 * REMARK:
		 * 
		 * To invalidate the cache is essential to 
		 * retrieve data from the server again
		 */
		this.invalidateCache();
		this.redraw();

	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#reload(java.util.HashMap)
	 */
	public void reload(HashMap<String,String> attributes) {

		if (this.attributes != null) this.attributes.putAll(attributes);
		this.reload();
	
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.BaseGrid#getRequestUrl()
	 */
	public String getRequestUrl() {
		
		if ((this.sid == null) || (this.base == null)) return null;
		return this.base + "/" + this.sid;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#createDataFields()
	 */
	public DataSourceField[] createDataFields() {
		return this.dataObject.createDataFieldsAsArray();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#createGridFields()
	 */
	public ListGridField[] createGridFields() {
		return this.dataObject.createGridFieldsAsArray();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#createMethod()
	 */
	public RequestMethod createMethod() {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_GET);
		
		requestMethod.addAttribute(MethodConstants.ATTR_FORMAT, FormatConstants.FNC_FORMAT_ID_Grid);
		requestMethod.setAttributes(attributes);
		
		return requestMethod;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#getRequestParams()
	 */
	public Map<String,String> getRequestParams() {
		
		RequestMethod requestMethod = createMethod();
		return requestMethod.toParams();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#createScGridDS()
	 */
	public void createScGridDS() {

		/*
		 * Retrieve request url
		 */
		String requestUrl = getRequestUrl();

		/*
		 * Retrieve request fields from attributes
		 */
		DataSourceField[] requestFields = createDataFields();

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
		
		dataSource.setFetchDataURL(requestUrl);		
		dataSource.setFields(requestFields);

		/*
		 * finally set data source
		 */
		setDataSource(dataSource);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#afterRecordClick(com.smartgwt.client.widgets.grid.events.RecordClickEvent)
	 */
	public void afterRecordClick(RecordClickEvent event) {
		/*
		 * Stop event propagation
		 */
		event.cancel();
		
		/*
		 * Retrieve affected grid record
		 */
		ListGridRecord record = (ListGridRecord)event.getRecord();

		/*
		 * Invoke Grid RecordHandler
		 */
		if (this.menuHandler != null) this.menuHandler.doOpen(record);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#afterContextMenu(com.smartgwt.client.widgets.grid.events.RowContextClickEvent)
	 */
	public void afterContextMenu(RowContextClickEvent event) {
		/*
		 * Stop event propagation
		 */
		event.cancel();
		
		/*
		 * Retrieve affected grid record
		 */
		ListGridRecord record = event.getRecord();

		/*
		 * Invoke Grid MenuHandler
		 */
		if (this.menuHandler != null) this.menuHandler.doOpen(record);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#afterSelectionChanged(com.smartgwt.client.widgets.grid.events.SelectionEvent)
	 */
	public void afterSelectionChanged(SelectionEvent event) {
		/*
		 * Must be overridden: This event is usually used to
		 * support checkbox selection within grids
		 */
	}
	
	/**
	 * @param event
	 */
	public void afterDataArrived(DataArrivedEvent event) {
		/*
		 * Must be overridden
		 */
	}
	
	/**
	 * Fetch data after rendering
	 * 
	 * @param event
	 */
	public void afterDraw(DrawEvent event) {
		this.fetchData();
	}
	
}
