package de.kp.ames.web.client.core.gui.search;
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

import java.util.Map;

import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

import de.kp.ames.web.client.core.gui.handler.ISearch;

public class SearchWidget extends VLayout {

	private ComboBoxItem searchBox;
	
	/*
	 * Rest Data Source for the search result
	 */
	private RestDataSource ds;
	
	/*
	 * The query string sent to the search service
	 */
	private String query;
	private ISearch handler;
	
	/*
	 * The offset position of the search widget
	 * from the top right corner of the viewport
	 */
	private static int X_OFF = 392;
	private static int Y_OFF = 24;
	
	private static int SEARCHBOX_WIDTH  = 320;
	
	private static int WIDGET_WIDTH  = 360;
	private static int WIDGET_HEIGHT = 28;
	
	public SearchWidget(final String url, final Map<String,String> params, final DataSourceField[] fields) {
		
		this.setWidth(WIDGET_WIDTH);
		this.setHeight(WIDGET_HEIGHT);
				
		this.setShowShadow(true);  
		this.setShadowSoftness(2);  
		
		this.setShadowOffset(1);  
		this.addMember(createToolStrip(url, params, fields));
		
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
	
	public void setHandler(ISearch handler) {
		this.handler = handler;
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
	private ToolStrip createToolStrip(final String url, final Map<String,String> params, final DataSourceField[] fields) {
		
		ToolStrip ts = new ToolStrip();
		ts.setStyleName("x-searchbox");
		
		ts.setWidth100();
		ts.setHeight(WIDGET_HEIGHT);
		
		searchBox = new ComboBoxItem("search");
		searchBox.setTitle("<b>search</b>:");
		
		searchBox.setWidth(SEARCHBOX_WIDTH);
		searchBox.setOptionDataSource(createDS(url, params, fields));
		
		searchBox.setShowPickerIcon(false);
		searchBox.addChangedHandler(new ChangedHandler() {

			/* (non-Javadoc)
			 * @see com.smartgwt.client.widgets.form.fields.events.ChangedHandler#onChanged(com.smartgwt.client.widgets.form.fields.events.ChangedEvent)
			 */
			public void onChanged(ChangedEvent event) {

				ComboBoxItem item = (ComboBoxItem)event.getItem();
				ListGridRecord rec = item.getSelectedRecord();
				
				/*
				 * The content of the searchbox has changed, so
				 * initiate another search
				 */
				doSearch(rec);

			}
			
		});
		
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
	private void doSearch(ListGridRecord record) {		
		if (this.handler == null) return;		
		
		// TODO
		
	}
	
	/**
	 * Create Rest Data Source
	 * 
	 * @param url
	 * @param params
	 * @param fields
	 * @return
	 */
	private RestDataSource createDS(final String url, final Map<String,String> params, final DataSourceField[] fields) {
		
		ds = new RestDataSource() {
			
			protected Object transformRequest(DSRequest dsRequest) {
				dsRequest.setParams(params);
				return super.transformRequest(dsRequest);
			}
			
			protected void transformResponse(DSResponse response, DSRequest request, Object data) {
				super.transformResponse(response, request, data);
			}
			
		};
		
		ds.setDataFormat(DSDataFormat.JSON);
		ds.setDataProtocol(DSProtocol.GETPARAMS);
		
		ds.setFetchDataURL(url);
		ds.setFields(fields);
		
		return ds;
		
	}
	
}
