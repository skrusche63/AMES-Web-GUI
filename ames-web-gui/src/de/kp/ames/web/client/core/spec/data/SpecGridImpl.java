package de.kp.ames.web.client.core.spec.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.spec.data
 *  Module: SpecGridImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #data #grid #spec #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;
import java.util.Set;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.grid.LocalGridImpl;
import de.kp.ames.web.client.core.spec.handler.SpecGridMenuHandlerImpl;
import de.kp.ames.web.client.model.SpecObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class SpecGridImpl extends LocalGridImpl {
	
	/**
	 * Constructor
	 */
	public SpecGridImpl() {
		super();

		/*
		 * Set row numbering
		 */
		this.setShowRowNumbers(true);  
		
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
		
	}
	
	/**
	 * Add specifications to grid from JSON array
	 * 
	 * @param jSpecs
	 */
	public void setSpecifications(JSONArray jSpecs) {
		
		for (int i=0; i < jSpecs.size(); i++) {
			
			JSONObject jSpec = jSpecs.get(i).isObject();
			ListGridRecord record = new ListGridRecord();
			
			Set<String> keys = jSpec.keySet();
			for (String key:keys) {
				
				String val = jSpec.get(key).isString().stringValue();
				
				if (key.equals(JaxrConstants.RIM_ID)) 
					record.setAttribute(JaxrConstants.RIM_ID, val);
				
				else if (key.equals(JaxrConstants.RIM_NAME))
					record.setAttribute(JaxrConstants.RIM_NAME, val);
			
			}
			
			this.addData(record);
			
		}

	}
	
	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new SpecObject();
	}

}
