package de.kp.ames.web.client.function.symbol;

import java.util.ArrayList;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.tree.TreeGridField;

import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.core.tree.BaseTreeImpl;
import de.kp.ames.web.shared.JsonConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class SymbolTreeImpl extends BaseTreeImpl {

	/**
	 * Constructor for either APP-6B or Icon-based
	 * graphical symbols
	 * 
	 * @param type
	 */
	public SymbolTreeImpl(String type) {
		super(ServiceConstants.SYMBOL_SERVICE_ID);
		
	    /*
	     * Set title field
	     */
	    this.setFields(new TreeGridField(TITLE)); 
	    
	    /*
	     * Create request method & data source
	     */
	    String url = this.getRequestUrl();
	    RequestMethodImpl method = this.createMethod(type);
	    
	    DataSourceField[] fields = this.createFields();
	    
	    this.createScTreeDS(url, method, JsonConstants.J_NAME, fields);
	    this.setDataSource(dataSource);
	    
	    
	}
	
	/**
	 * @param type
	 * @return
	 */
	private RequestMethodImpl createMethod(String type) {
		
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_KEYS);
		
		requestMethod.addAttribute(MethodConstants.ATTR_TYPE, type);
		return requestMethod;
		
	}
	
	/**
	 * @return
	 */
	private DataSourceField[] createFields() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Identifier
		 */
	    fields.add(new DataSourceTextField("Id", JsonConstants.J_ID));

	    /*
		 * Name
		 */
	    fields.add(new DataSourceTextField("Name", JsonConstants.J_NAME));
		
		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);

	}
	
}
