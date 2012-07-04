package de.kp.ames.web.client.function.symbol;

import java.util.ArrayList;
import java.util.HashMap;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.tree.TreeGridField;

import de.kp.ames.web.client.core.tree.TreeImpl;
import de.kp.ames.web.shared.JsonConstants;
import de.kp.ames.web.shared.MethodConstants;
import de.kp.ames.web.shared.ServiceConstants;

public class SymbolTreeImpl extends TreeImpl {

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
	     * Create data source
	     */
	    this.createTreeDS(type);	    
	    
	}
	
	/**
	 * @return
	 */
	public DataSourceField[] createFields() {
		
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

	/**
	 * Create data source
	 */
	private void createTreeDS(String type) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, type);

		String title = JsonConstants.J_NAME;
		
		this.createScTreeDS(attributes, title);
		this.setDataSource(dataSource);
		
	}

}
