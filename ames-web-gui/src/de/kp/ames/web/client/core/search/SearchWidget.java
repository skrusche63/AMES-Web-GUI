package de.kp.ames.web.client.core.search;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.search
 *  Module: SearchWidget
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #search #web #widget
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
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class SearchWidget extends VLayout {

	private ComboBoxItem searchBox;
	
	/*
	 * Data Source for the search result
	 */
	private DataSource dataSource;
	
	/*
	 * Reference to Options Criteria
	 */
	private Criteria criteria;

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
	 * The query string sent to the search service
	 */
	private String query;
	private SearchHandler searchHandler;
	
	/*
	 * The offset position of the search widget
	 * from the top right corner of the viewport
	 */
	private static int X_OFF = 392;
	private static int Y_OFF = 24;
	
	private static int SEARCHBOX_WIDTH  = 320;
	
	private static int WIDGET_WIDTH  = 360;
	private static int WIDGET_HEIGHT = 28;
	
	public SearchWidget() {
		
		/*
		 * Connection parameters
		 */
		this.base = GuiConstants.REG_URL;
		this.sid  = ServiceConstants.SEARCH_SERVICE_ID;

		/*
		 * Appearance & Dimensions
		 */
		this.setWidth(WIDGET_WIDTH);
		this.setHeight(WIDGET_HEIGHT);
				
		this.setShowShadow(true);  
		this.setShadowSoftness(2);  
		
		this.setShadowOffset(1);  
		this.addMember(createToolStrip());
		
		/*
		 * The search widget is applied to the root
		 * panel, i.e. it is position on the viewport
		 * with respect to the offset position defined
		 */
		RootPanel root = RootPanel.get();		
		root.add(this);
		
		this.moveTo(root.getOffsetWidth() - X_OFF, Y_OFF);
		this.draw();

	}
	
	/**
	 * Set the search query
	 * 
	 * @param query
	 */
	public void setQuery(String query) {

		this.query = query;
		/*
		 * This invoke a change event 
		 */
		this.searchBox.setValue(this.query);
	
	}
	
	/**
	 * Register search handler for search widget
	 * 
	 * @param searchHandler
	 */
	public void addSearchHandler(SearchHandler searchHandler) {
		this.searchHandler = searchHandler;
	}
	
	/**
	 * @param event
	 */
	public void afterResized(ResizedEvent event) {
		this.moveTo(RootPanel.get().getOffsetWidth() - X_OFF, Y_OFF);	
		this.draw();
	}
	
	/**
	 * @param url
	 * @param params
	 * @param fields
	 * @return
	 */
	private ToolStrip createToolStrip() {
		
		ToolStrip ts = new ToolStrip();
		ts.setStyleName("x-searchbox");
		
		ts.setWidth100();
		ts.setHeight(WIDGET_HEIGHT);
		
		/*
		 * The combobox is used to display the name field of
		 * the respective data source
		 */
		searchBox = new ComboBoxItem(JsonConstants.J_TERM);
		searchBox.setTitle("<b>search</b>:");

		/*
		 * Display and Value field should not be set, if picklist formatter is used
		 * 
		 * searchBox.setDisplayField(JsonConstants.J_NAME);
		 * searchBox.setValueField(JsonConstants.J_TERM);
		 */

		searchBox.setWidth(SEARCHBOX_WIDTH);
		
		createScComboBoxDS();
		
		/*
		 * Criteria
		 */
		criteria = new Criteria();
		searchBox.setOptionCriteria(criteria);
		
		searchBox.setOptionDataSource(dataSource);
		
		
		searchBox.setShowPickerIcon(false);

		searchBox.addChangedHandler(new ChangedHandler() {
			
			/*
			 * (non-Javadoc)
			 * @see com.smartgwt.client.widgets.form.fields.events.ChangedHandler#onChanged(com.smartgwt.client.widgets.form.fields.events.ChangedEvent)
			 */
			public void onChanged(ChangedEvent event) {

				/*
				 * Live search feature
				 */
				ComboBoxItem item = (ComboBoxItem)event.getItem();
				

				String val = item.getValueAsString();
						
				/*
				 * Initiates the suggest request
				 */
				criteria.setAttribute(JsonConstants.J_QUERY, val);

				/*
				 * If item has a selected record, 
				 * this represents the user pick from the suggested terms
				 * and initiates the search request  
				 */
				Record record = item.getSelectedRecord();
				if (record != null) {
					doSearch(record);
				}

			}
			
		});
				
		/*
		 * Explicit formatter for picklist, to separate it from the ComboBox
		 */
        ListGrid pickListProperties = new ListGrid();  
        pickListProperties.setCellFormatter(new CellFormatter() {  
            @Override  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                return record.getAttribute(JsonConstants.J_NAME);  
            }  
        });  
  
        searchBox.setPickListProperties(pickListProperties);  

		
		
		/* 
		 * A dynamic form is used as a wrapper to get 
		 *  the search box centered in height
		 */
		
		DynamicForm form = new DynamicForm();
		
		form.setTitleSuffix(""); // default ":"
		form.setWidth100();
		
		form.setMargin(3);		
		form.setFields(searchBox);
		
		ts.addMember(form);		
		return ts;
		
	}
	
	/**
	 * @param record
	 */
	private void doSearch(Record record) {		

		/*
		 * Initiate search request
		 */
		String query = record.getAttributeAsString(JsonConstants.J_TERM);
		this.searchHandler.doSearch(query);

	}
	
	/**
	 * Data source
	 */
	private void createScComboBoxDS() {
		/*
		 * Retrieve request url
		 */
		String requestUrl = getRequestUrl();
	
		/*
		 * Retrieve request fields
		 */
		DataSourceField[] requestFields = createFields();
		
		/*
		 * Finally create data source
		 */
		createScComboBoxDS(requestUrl, requestFields);
		
	}
	
	/**
	 * @return
	 */
	private Map<String,String> getRequestParams() {
		
		/*
		 * Retrieve request method
		 */
		HashMap<String,String> attributes = new HashMap<String,String>();
		
		RequestMethod requestMethod = createMethod(attributes);
		return requestMethod.toParams();
		
	}
	
	/**
	 * @param url
	 * @param method
	 * @param fields
	 */
	private void createScComboBoxDS(final String url, final DataSourceField[] fields) {
		
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
		
	}

	/**
	 * Helper method to create the request url
	 * 
	 * @return
	 */
	private String getRequestUrl() {
		
		if ((this.sid == null) || (this.base == null)) return null;
		return this.base + "/" + this.sid;
		
	}

	/**
	 * @return
	 */
	private DataSourceField[] createFields() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Name
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_NAME, "Name"));

	    /*
		 * Term
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_TERM, "Term"));		
		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);
		
	}

	/**
	 * @param attributes
	 * @return
	 */
	public RequestMethod createMethod(HashMap<String,String> attributes) {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_SUGGEST);
		
		requestMethod.setAttributes(attributes);
		return requestMethod;
		
	}

}
