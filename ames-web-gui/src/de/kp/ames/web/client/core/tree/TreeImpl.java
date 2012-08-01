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
import java.util.Map;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.DataArrivedEvent;
import com.smartgwt.client.widgets.tree.events.NodeClickEvent;
import com.smartgwt.client.widgets.tree.events.NodeClickHandler;
import com.smartgwt.client.widgets.tree.events.NodeContextClickEvent;
import com.smartgwt.client.widgets.tree.events.NodeContextClickHandler;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.handler.TreeMenuHandler;
import de.kp.ames.web.client.handler.TreeNodeHandler;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class TreeImpl extends TreeGrid implements Tree {
	/*
	 * Reference to DataSource
	 */
	protected DataSource dataSource;
	
	/*
	 * Reference to DataObject
	 */
	protected DataObject dataObject;

	/*
	 * Reference to MenuHandler
	 */
	protected TreeMenuHandler menuHandler;

	/*
	 * Reference to NodeHandler
	 */
	protected TreeNodeHandler nodeHandler;
	
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
	 * Reference to attributes
	 */
	protected HashMap<String,String> attributes;
	
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
	    
	    this.addNodeContextClickHandler(new NodeContextClickHandler() {
			public void onNodeContextClick(NodeContextClickEvent event) {
				self.afterContextMenu(event);
			}		
	    });

	    this.addNodeClickHandler(new NodeClickHandler() {
			public void onNodeClick(NodeClickEvent event) {
				self.afterNodeClick(event);				
			}
	    	
	    });
	    
		this.addDrawHandler(new DrawHandler() {
			public void onDraw(DrawEvent event) {
				self.afterDraw(event);				
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
	 * @see de.kp.ames.web.client.core.tree.Tree#addNodeHandler(de.kp.ames.web.client.handler.TreeNodeHandler)
	 */
	public void addNodeHandler(TreeNodeHandler nodeHandler) {
		/*
		 * Set Node Handler and register tree
		 * for later processing
		 */
		this.nodeHandler = nodeHandler;
		this.nodeHandler.setTree(this);		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#afterContextMenu(com.smartgwt.client.widgets.tree.events.NodeContextClickEvent)
	 */
	public void afterContextMenu(NodeContextClickEvent event) {
		/*
		 * Stop event propagation
		 */
		event.cancel();
		
		/*
		 * Retrieve affected tree node
		 */
		TreeNode node = event.getNode();
		
		/*
		 * Invoke Tree MenuHandler
		 */
		if (this.menuHandler != null) this.menuHandler.doOpen(node);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#afterNodeClick(com.smartgwt.client.widgets.tree.events.NodeClickEvent)
	 */
	public void afterNodeClick(NodeClickEvent event) {

		/*
		 * Retrieve affected tree node
		 */
		TreeNode node = event.getNode();
		
		/*
		 * Invoke Tree NodeHandler
		 */
		if (this.nodeHandler != null) this.nodeHandler.doSelect(node);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#createFields()
	 */
	public DataSourceField[] createDataFields() {
		return this.dataObject.createDataFieldsAsArray();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#createTreeGridFields()
	 */
	public TreeGridField[] createTreeGridFields() {
		return this.dataObject.createTreeGridFieldsAsArray();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#createMethod(java.util.HashMap)
	 */
	public RequestMethod createMethod() {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_GET);
		
		requestMethod.addAttribute(MethodConstants.ATTR_FORMAT, FormatConstants.FNC_FORMAT_ID_Tree);

		requestMethod.setAttributes(attributes);				
		return requestMethod;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#createScTreeDS()
	 */
	public void createScTreeDS() {
		
		String requestUrl = getRequestUrl();

		DataSourceField[] requestFields = createDataFields();

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
		
		dataSource.setDataURL(requestUrl);		
		
		dataSource.setFields(requestFields);
		
		/*
		 * finally set data source
		 */
		setDataSource(dataSource);

	}

	/**
	 * A helper method to create request parameters
	 * 
	 * @return
	 */
	protected Map<String,String> getRequestParams() {
		
		RequestMethod requestMethod = createMethod();
		return requestMethod.toParams();
	
	}

	/**
	 * @param event
	 */
	protected void afterDataArrived(DataArrivedEvent event) {
		// Must be overridden
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