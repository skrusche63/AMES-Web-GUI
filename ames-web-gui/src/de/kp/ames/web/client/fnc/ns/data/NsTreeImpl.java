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
import com.smartgwt.client.util.SC;
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
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class NsTreeImpl extends TreeImpl {

	private TreeNode openedFolder;

	/**
	 * Constructor
	 */
	public NsTreeImpl() {
		super(ServiceConstants.NAMESPACE_SERVICE_ID);
		
		SC.logWarn("====> NsTreeImpl CTOR");
		
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
		
		this.setCustomIconProperty(JaxrConstants.RIM_ICON);
		
	    /*
	     * Set menu handler
	     */
	    NsTreeMenuHandlerImpl menuHandler = new NsTreeMenuHandlerImpl(this);
	    menuHandler.setParams(attributes);
	    
	    this.addMenuHandler(menuHandler);
	    
	    
	    this.addFolderOpenedHandler(new FolderOpenedHandler() {
			

			@Override
			public void onFolderOpened(FolderOpenedEvent event) {
				openedFolder = event.getNode();
			}
		});
	    
	    
	    this.addFolderClosedHandler(new FolderClosedHandler() {
			
			@Override
			public void onFolderClosed(FolderClosedEvent event) {
				openedFolder = null;
			}
		});
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
				
				DSOperationType operationType = request.getOperationType();
				if (operationType == DSOperationType.ADD) {

					SC.logWarn("====> NsTreeImpl.transformResponse");
					/*
					 * Get id from server response
					 */
					String rimId = JSOHelper.getAttribute((JavaScriptObject) data, "id");
					SC.logWarn("====> NsTreeImpl.transformResponse: rimId: " + rimId);

					JavaScriptObject jsRequest = request.getJsObj();
					String strData = JSOHelper.getAttribute(jsRequest, "data");
					
					JSONObject jRequestRecord = JSONParser.parseStrict(strData).isObject().get("data").isObject();
					
					
					Record record = new Record();
					for (String key: jRequestRecord.keySet()) {
						SC.logWarn("====> key: " + key);
						
						// skip parent if null
						if (jRequestRecord.get(key).isNull() != null) continue;
						
						// handle booleans
						if (jRequestRecord.get(key).isBoolean() != null) {
							record.setAttribute(key, jRequestRecord.get(key).isBoolean().booleanValue());
						} else {
							record.setAttribute(key, jRequestRecord.get(key).isString().stringValue());							
						}
					}
					
					record.setAttribute(JaxrConstants.RIM_ID, rimId);
					response.setData(new Record[] {record});
									
					SC.logWarn("====> NsTreeImpl.transformResponse callback: END");
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
		
		SC.logWarn("======> NsTreeImpl.Operation: ADD");

		RequestMethod requestMethod = createAddMethod();
		return requestMethod.toParams();	
	}

	/**
	 * A helper method to create remove request parameters
	 * 
	 * @return
	 */
	private Map<String,String> getRemoveRequestParams() {
		
		SC.logWarn("======> NsTreeImpl.Operation: REMOVE");
		
		RequestMethod requestMethod = createRemoveMethod();
		return requestMethod.toParams();	
	}

	/**
	 * A helper method to create fetch request parameters
	 * 
	 * @return
	 */
	private Map<String,String> getFetchRequestParams() {
		
		SC.logWarn("======> NsTreeImpl.Operation: FETCH");


		RequestMethod requestMethod = createFetchMethod();
		return requestMethod.toParams();
	
	}

	/**
	 * A helper method to create update request parameters
	 * 
	 * @return
	 */
	private Map<String,String> getUpdateRequestParams() {
		
		SC.logWarn("======> NsTreeImpl.Operation: UPDATE");
		
		RequestMethod requestMethod = createUpdateMethod();
		return requestMethod.toParams();
	
	}
	
	private RequestMethod createUpdateMethod() {
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_SUBMIT);
		
		/*
		 * no explicit filter of attributes
		 */

		return requestMethod;
	}
	

	private RequestMethod createFetchMethod() {

		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_GET);
		
		/*
		 * explicit filter of attributes
		 */
		requestMethod.addAttribute(MethodConstants.ATTR_FORMAT, FormatConstants.FNC_FORMAT_ID_Tree);

		if (openedFolder != null) {
			requestMethod.addAttribute(MethodConstants.ATTR_PARENT, openedFolder.getAttribute(JaxrConstants.RIM_ID));
		}

		return requestMethod;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#createRemoveMethod()
	 */
	private RequestMethod createRemoveMethod() {
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_DELETE);
		
		/*
		 * explicit filter of attributes
		 */
		requestMethod.addAttribute(MethodConstants.ATTR_TYPE, attributes.get(MethodConstants.ATTR_TYPE));
		requestMethod.addAttribute(MethodConstants.ATTR_ITEM, attributes.get(MethodConstants.ATTR_ITEM));
						
		return requestMethod;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.Tree#createAddMethod()
	 */
	private RequestMethod createAddMethod() {
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_SUBMIT);
		
		/*
		 * explicit filter of attributes
		 */
		requestMethod.addAttribute(MethodConstants.ATTR_TYPE, attributes.get(MethodConstants.ATTR_TYPE));
		requestMethod.addAttribute(MethodConstants.ATTR_PARENT, attributes.get(MethodConstants.ATTR_PARENT));
						
		return requestMethod;
	}

	public void setAttribute(String key, String value) {

		SC.logWarn("======> NsTreeImpl.setAttribute: key: " + key + " / value: " + value);

		attributes.put(key, value);
		
	}
	
}
