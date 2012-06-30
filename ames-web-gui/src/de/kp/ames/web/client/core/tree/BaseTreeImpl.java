package de.kp.ames.web.client.core.tree;
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

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.events.DataArrivedEvent;

import de.kp.ames.web.client.core.method.RequestMethod;

public class BaseTreeImpl extends TreeGrid implements BaseTree {
	/*
	 * Reference to DataSource
	 */
	protected RestDataSource dataSource;

	/*
	 * Field
	 */
	protected String TITLE = "Name";
	
	/*
	 * Style
	 */
	protected String BASE_STYLE = "noBorderCell";

	public BaseTreeImpl() {

		/*
		 * Borders
		 */
		this.setBorder("0");
		
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Connectors
		 */
		this.setShowConnectors(true);

		/*
		 * Set base style
		 */
	    this.setBaseStyle(BASE_STYLE);  
	    /*
	     * By default no <open> or <drop>
	     * icons are supported
	     */
	    this.setShowOpenIcons(false);  
	    this.setShowDropIcons(false);  
	    
	    this.setClosedIconSuffix(""); 
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.BaseTree#createScTreeDS(java.lang.String, de.kp.ames.web.client.core.method.RequestMethod, com.smartgwt.client.data.DataSourceField[])
	 */
	public void createScTreeDS(final String url, final RequestMethod method, final DataSourceField[] fields) {
		
		dataSource = new RestDataSource() {
			  
			protected Object transformRequest(DSRequest dsRequest) {  
				dsRequest.setParams(method.toParams());				
				return super.transformRequest(dsRequest);  
			}  

			protected void transformResponse(DSResponse response, DSRequest request, Object data) {  
				super.transformResponse(response, request, data);  
			}  
			
		};
		
		dataSource.setDataFormat(DSDataFormat.JSON);
		dataSource.setDataProtocol(DSProtocol.GETPARAMS);  
		
		dataSource.setFetchDataURL(url);		
		dataSource.setFields(fields);
		
	}

	/**
	 * @param event
	 */
	protected void afterDataArrived(DataArrivedEvent event) {
		// Must be overridden
	}

}  