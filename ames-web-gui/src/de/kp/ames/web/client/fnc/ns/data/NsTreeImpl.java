package de.kp.ames.web.client.fnc.ns.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.ns.data
 *  Module: NsTreeImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #data #fnc #ns #tree #web
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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.FolderClosedEvent;
import com.smartgwt.client.widgets.tree.events.FolderClosedHandler;
import com.smartgwt.client.widgets.tree.events.FolderOpenedEvent;
import com.smartgwt.client.widgets.tree.events.FolderOpenedHandler;

import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.core.tree.TreeImpl;
import de.kp.ames.web.client.fnc.ns.handler.NsTreeMenuHandlerImpl;
import de.kp.ames.web.client.model.NsObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class NsTreeImpl extends TreeImpl {

	private TreeNode openedFolder;

	/**
	 * Constructor
	 */
	public NsTreeImpl() {
		super(ServiceConstants.NAMESPACE_SERVICE_ID);
		
		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Namespace);

		/*
		 * Create data object
		 */
		this.dataObject = createDataObject();

		/*
	     * Set data source
	     */
	    this.createScTreeDS();

		/*
		 * Create tree grid fields
		 */
		this.setFields(createTreeGridFields());
		
		/*
		 * Assign a custom data field for the 
		 * respective icon description
		 */
		this.setCustomIconProperty(JaxrConstants.RIM_ICON);
	    
	    /*
	     * Event handling for folder 'Open' & 'Close' events;
	     * this information is used to access the respective
	     * node for later processing
	     */
	    this.addFolderOpenedHandler(new FolderOpenedHandler() {
			public void onFolderOpened(FolderOpenedEvent event) {
				openedFolder = event.getNode();
			}
		});
	    	    
	    this.addFolderClosedHandler(new FolderClosedHandler() {
			public void onFolderClosed(FolderClosedEvent event) {
				openedFolder = null;
			}
		});
		
	    /*
	     * Set menu handler
	     */
	    NsTreeMenuHandlerImpl menuHandler = new NsTreeMenuHandlerImpl(this);
	    menuHandler.setParams(attributes);
	    
	    this.addMenuHandler(menuHandler);

	}

	public void openFolder(TreeNode node) {
		com.smartgwt.client.widgets.tree.Tree tree = this.getData();
		if (!tree.isOpen(node))
			tree.openFolder(node);
	}
	
	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new NsObject();
	}

	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.TreeImpl#createScTreeDS()
	 */
	@Override
	public void createScTreeDS() {
		
		String requestUrl = getRequestUrl();
		DataSourceField[] requestFields = createDataFields();

		dataSource = new RestDataSource() {
			  
			protected Object transformRequest(DSRequest dsRequest) {  
				/*
				 * Distinguish between different data operations
				 * to ensure injection of appropriate request
				 * parameters		
				 */
				DSOperationType operationType = dsRequest.getOperationType();
				if (operationType == DSOperationType.ADD)
					dsRequest.setParams(getAddRequestParams());
				
				else if (operationType == DSOperationType.UPDATE)
					dsRequest.setParams(getUpdateRequestParams());
				
				else if (operationType == DSOperationType.REMOVE)
					dsRequest.setParams(getRemoveRequestParams());
				
				else if (operationType == DSOperationType.FETCH)
					dsRequest.setParams(getFetchRequestParams());
				
				return super.transformRequest(dsRequest);  
			
			}  

			protected void transformResponse(DSResponse response, DSRequest request, Object data) {  
				
				/*
				 * In case of an 'ADD' operation, the respective OASIS ebXML RegRep
				 * identifier is unknown for the client side; the subsequent mechanismen
				 * ensures injection of missing attributes
				 */
				DSOperationType operationType = request.getOperationType();
				if (operationType == DSOperationType.ADD) {

					/*
					 * Get id from server response: in case of a submit request,
					 * the server especially returns the (created) identifier
					 * for the processed data package
					 * 
					 * Object data: this is where the server response is held
					 */
					String rimId = JSOHelper.getAttribute((JavaScriptObject) data, JsonConstants.J_ID);

					/*
					 * Get request data in a JSON representation as these data are
					 * directly returned to the TreeGrid after the missing server
					 * 'id' has been injected
					 */
					String strData = JSOHelper.getAttribute(request.getJsObj(), "data");					
					JSONObject jNode = JSONParser.parseStrict(strData).isObject().get("data").isObject();
					
					Record record = new Record();
					for (String key: jNode.keySet()) {
						/*
						 * Data type handling: actually null parameters
						 * are not used
						 */
						if (jNode.get(key).isNull() != null) continue;
						
						if (jNode.get(key).isBoolean() != null) {
							record.setAttribute(key, jNode.get(key).isBoolean().booleanValue());

						} else {
							record.setAttribute(key, jNode.get(key).isString().stringValue());							

						}
					}
					
					/*
					 * Inject missing identifier
					 */
					record.setAttribute(JaxrConstants.RIM_ID, rimId);
					
					/*
					 * Manipulate response data to send enhanced request
					 * data back to the TreeGrid
					 */
					response.setData(new Record[] {record});

				}

				super.transformResponse(response, request, data);  
			
			}  
			
		};
		
		dataSource.setDataFormat(DSDataFormat.JSON);

		/*
		 * Fetch / get
		 */
		OperationBinding fetch = new OperationBinding();
        fetch.setOperationType(DSOperationType.FETCH);
        fetch.setDataProtocol(DSProtocol.GETPARAMS);
        
        
		/*
		 * Add / create
		 */
        OperationBinding add = new OperationBinding();
        add.setOperationType(DSOperationType.ADD);
        add.setDataProtocol(DSProtocol.POSTMESSAGE);
        
		/*
		 * Update / submit
		 */
        OperationBinding update = new OperationBinding();
        update.setOperationType(DSOperationType.UPDATE);
        update.setDataProtocol(DSProtocol.POSTMESSAGE);
        
		/*
		 * Remove / delete
		 */
        OperationBinding remove = new OperationBinding();        
        remove.setOperationType(DSOperationType.REMOVE);
        remove.setDataProtocol(DSProtocol.POSTMESSAGE);

        /*
         * add all operations to datasource
         */
        dataSource.setOperationBindings(fetch, add, update, remove);
		
		dataSource.setDataURL(requestUrl);		
		dataSource.setFields(requestFields);
		
		/*
		 * finally set data source
		 */
		setDataSource(dataSource);

	}

	/**
	 * A helper method to create add request parameters
	 * 
	 * @return
	 */
	private Map<String,String>  getAddRequestParams() {
		RequestMethod requestMethod = createAddMethod();
		return requestMethod.toParams();	
	}

	/**
	 * A helper method to create remove request parameters
	 * 
	 * @return
	 */
	private Map<String,String> getRemoveRequestParams() {
		RequestMethod requestMethod = createRemoveMethod();
		return requestMethod.toParams();	
	}

	/**
	 * A helper method to create fetch request parameters
	 * 
	 * @return
	 */
	private Map<String,String> getFetchRequestParams() {
		RequestMethod requestMethod = createFetchMethod();
		return requestMethod.toParams();	
	}

	/**
	 * A helper method to create update request parameters
	 * 
	 * @return
	 */
	private Map<String,String> getUpdateRequestParams() {
		RequestMethod requestMethod = createUpdateMethod();
		return requestMethod.toParams();
	
	}

	/**
	 * A helper method to create a RequestMethod for an
	 * ADD request: The required parameters are
	 * 
	 * MethodConstants.ATTR_TYPE
	 * MethodConstants.ATTR_PARENT
	 * 
	 * @return
	 */
	private RequestMethod createAddMethod() {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_SUBMIT);
		
		requestMethod.addAttribute(MethodConstants.ATTR_TYPE, attributes.get(MethodConstants.ATTR_TYPE));
		requestMethod.addAttribute(MethodConstants.ATTR_PARENT, attributes.get(MethodConstants.ATTR_PARENT));
						
		return requestMethod;

	}

	/**
	 * A helper method to create a RequestMethod for an
	 * FETCH request: The required parameters are
	 * 
	 * MethodConstants.ATTR_FORMAT
	 * MethodConstants.ATTR_PARENT
	 * 
	 * @return
	 */
	private RequestMethod createFetchMethod() {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_GET);
		
		requestMethod.addAttribute(MethodConstants.ATTR_FORMAT, FormatConstants.FNC_FORMAT_ID_Tree);
		if (openedFolder != null) requestMethod.addAttribute(MethodConstants.ATTR_PARENT, openedFolder.getAttribute(JaxrConstants.RIM_ID));

		return requestMethod;
		
	}
	
	/**
	 * A helper method to create a RequestMethod for an
	 * REMOVE request: The required parameters are
	 * 
	 * MethodConstants.ATTR_TYPE
	 * MethodConstants.ATTR_ITEM
	 * 
	 * @return
	 */
	private RequestMethod createRemoveMethod() {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_DELETE);

		requestMethod.addAttribute(MethodConstants.ATTR_TYPE, attributes.get(MethodConstants.ATTR_TYPE));
		requestMethod.addAttribute(MethodConstants.ATTR_ITEM, attributes.get(MethodConstants.ATTR_ITEM));
						
		return requestMethod;
	}

	/**
	 * A helper method to create a RequestMethod for an
	 * UPDATED request
	 * 
	 * @return
	 */

	private RequestMethod createUpdateMethod() {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_SUBMIT);
		
		return requestMethod;

	}
	

	/**
	 * A helper method to set additional request parameters
	 * 
	 * @param key
	 * @param value
	 */
	public void setAttribute(String key, String value) {
		attributes.put(key, value);		
	}
	
}
