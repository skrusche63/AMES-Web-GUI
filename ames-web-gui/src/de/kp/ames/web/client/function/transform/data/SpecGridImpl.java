package de.kp.ames.web.client.function.transform.data;

import java.util.HashMap;

import de.kp.ames.web.client.core.grid.LocalGridImpl;
import de.kp.ames.web.client.function.transform.handler.SpecGridMenuHandlerImpl;
import de.kp.ames.web.client.model.SpecObject;
import de.kp.ames.web.client.model.core.DataObject;

public class SpecGridImpl extends LocalGridImpl {

	/**
	 * Constructor
	 */
	public SpecGridImpl() {
		super();
		
		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();

		/*
		 * Create data object
		 */
		this.dataObject = createDataObject();

		/*
		 * Create grid fields
		 */
		this.setFields(createGridFields());

		/*
		 * Create Grid Data
		 */
		this.setData(createGridRecords());
		
		/*
		 * Add menu handler
		 */
		SpecGridMenuHandlerImpl menuHandler = new SpecGridMenuHandlerImpl(this);
		menuHandler.setParams(attributes);
		
		this.addMenuHandler(menuHandler);
		
	}
	
	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new SpecObject();
	}

}
