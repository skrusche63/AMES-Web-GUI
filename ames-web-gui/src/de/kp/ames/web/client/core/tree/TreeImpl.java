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

import java.util.HashMap;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.widgets.grid.events.RowContextClickEvent;
import com.smartgwt.client.widgets.grid.events.RowContextClickHandler;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.DataArrivedEvent;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.handler.TreeMenuHandler;
import de.kp.ames.web.shared.FormatConstants;
import de.kp.ames.web.shared.MethodConstants;

public class TreeImpl extends TreeGrid implements Tree {
	/*
	 * Reference to DataSource
	 */
	protected RestDataSource dataSource;

	/*
	 * Reference to MenuHandler
	 */
	protected TreeMenuHandler menuHandler;

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
	 * Field
	 */
	protected String TITLE = "Name";
	
	/*
	 * Style
	 */
	protected String BASE_STYLE = "noBorderCell";

	/**
	 * Constructor
	 * 
	 * @param sid
	 */
	public TreeImpl(String sid) {
		this(CoreGlobals.REG_URL, sid);
	}
	
	/**
	 * Constructor
	 * 
	 * @param base
	 * @param sid
	 */
	public TreeImpl(String base, String sid) {

		/*
		 * Register basic connection parameters
		 */
		this.base = base;
		this.sid  = sid;

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

	    /*
	     * Event handling
	     */
	    final TreeImpl self = this;
	    
	    this.addRowContextClickHandler(new RowContextClickHandler() {
			public void onRowContextClick(RowContextClickEvent event) {
				self.afterContextMenu(event);
			}		
	    });

	}
	    
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#getRequestUrl()
	 */
	public String getRequestUrl() {
		
		if ((this.sid == null) || (this.base == null)) return null;
		return this.base + "/" + this.sid;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#addMenuHandler(de.kp.ames.web.client.menu.TreeMenuHandler)
	 */
	public void addMenuHandler(TreeMenuHandler menuHandler) {
		/*
		 * Set Menu Handler and register tree
		 * for later processing
		 */
		this.menuHandler = menuHandler;
		this.menuHandler.setTree(this);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#afterContextMenu(com.smartgwt.client.widgets.grid.events.RowContextClickEvent)
	 */
	public void afterContextMenu(RowContextClickEvent event) {
		/*
		 * Stop event propagation
		 */
		event.cancel();
		
		/*
		 * Retrieve affected tree node
		 */
		TreeNode node = (TreeNode)event.getRecord();
		
		/*
		 * Invoke Grid MenuHandler
		 */
		if (this.menuHandler != null) this.menuHandler.doOpen(node);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#createFields()
	 */
	public DataSourceField[] createFields() {
		/*
		 * Must be overridden
		 */
		return null;
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#createMethod(java.util.HashMap)
	 */
	public RequestMethod createMethod(HashMap<String,String> attributes) {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_GET);
		
		requestMethod.addAttribute(MethodConstants.ATTR_FORMAT, FormatConstants.FNC_FORMAT_ID_Tree);
		return requestMethod;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#createScTreeDS(java.util.HashMap, java.lang.String)
	 */
	public void createScTreeDS(HashMap<String,String> attributes, String title) {
		/*
		 * Retrieve request url
		 */
		String requestUrl = getRequestUrl();
		
		/*
		 * Retrieve request method
		 */
		RequestMethod requestMethod = createMethod(attributes);
		
		/*
		 * Retrieve request fields
		 */
		DataSourceField[] requestFields = createFields();
		
		/*
		 * Finally create data source
		 */
		createScTreeDS(requestUrl, requestMethod, title, requestFields);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#createScTreeDS(java.lang.String, de.kp.ames.web.client.core.method.RequestMethod, java.lang.String, com.smartgwt.client.data.DataSourceField[])
	 */
	public void createScTreeDS(final String url, final RequestMethod method, final String title, final DataSourceField[] fields) {
		
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
		dataSource.setTitleField(title);
		
	}

	/**
	 * @param event
	 */
	protected void afterDataArrived(DataArrivedEvent event) {
		// Must be overridden
	}

}  