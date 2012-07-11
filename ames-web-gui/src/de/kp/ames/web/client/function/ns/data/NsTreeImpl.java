package de.kp.ames.web.client.function.ns.data;

import java.util.HashMap;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.widgets.tree.TreeGridField;

import de.kp.ames.web.client.core.tree.TreeImpl;
import de.kp.ames.web.client.function.ns.handler.NsTreeMenuHandlerImpl;
import de.kp.ames.web.client.model.NsObject;
import de.kp.ames.web.shared.JsonConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class NsTreeImpl extends TreeImpl {

	public NsTreeImpl() {
		super(ServiceConstants.NAMESPACE_SERVICE_ID);
		/*
	     * Set title field
	     */
	    this.setFields(new TreeGridField(TITLE)); 
	    
	    /*
	     * Set data source
	     */
	    this.createTreeDS();

	    /*
	     * Set menu handler
	     */
	    NsTreeMenuHandlerImpl menuHandler = new NsTreeMenuHandlerImpl(this);
	    this.addMenuHandler(menuHandler);
	    
	}
	
	/**
	 * Create data source
	 */
	private void createTreeDS() {

		HashMap<String,String> attributes = new HashMap<String,String>();
		String title = JsonConstants.J_NAME;
		
		this.createScTreeDS(attributes, title);
		this.setDataSource(dataSource);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.tree.TreeImpl#createFields(java.util.HashMap)
	 */
	public DataSourceField[] createDataFields(HashMap<String,String> attributes) {
		return new NsObject().createDataFieldsAsArray();
	}

}
