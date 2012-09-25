package de.kp.ames.web.client.core.clas.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.clas.data
 *  Module: SpecGridImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #data #grid #classification #clas #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;
import java.util.Set;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.grid.LocalGridImpl;
import de.kp.ames.web.client.model.core.ConceptObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class ClasGridImpl extends LocalGridImpl {
	
	/**
	 * Constructor
	 */
	public ClasGridImpl() {
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
	 * Add classifications to grid from JSON array
	 * 
	 * @param jClassifications
	 */
	public void setClassifications(JSONArray jClassifications) {
		
		for (int i=0; i < jClassifications.size(); i++) {
			
			JSONObject jClas = jClassifications.get(i).isObject();
			ListGridRecord record = new ListGridRecord();
			
			Set<String> keys = jClas.keySet();
			for (String key:keys) {
				
				String val = jClas.get(key).isString().stringValue();
				
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
		return new ConceptObject();
	}

}
