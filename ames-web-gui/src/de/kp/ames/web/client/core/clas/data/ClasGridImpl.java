package de.kp.ames.web.client.core.clas.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.concept.data
 *  Module: ConceptGridImpl
 *  @author spex66@gmx.net
 *  
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #data #grid #concept #classification #web
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
import java.util.Set;

import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.clas.handler.ClasGridMenuHandlerImpl;
import de.kp.ames.web.client.core.grid.LocalGridImpl;
import de.kp.ames.web.client.model.core.ConceptObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.JaxrConstants;

/*
 * A ClasGrid is a predefined key, value
 * list (or) grid that supports  handling
 */
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
	
		/*
		 * Add Menu Handler
		 */
		ClasGridMenuHandlerImpl menuHandler = new ClasGridMenuHandlerImpl(this);
		this.addMenuHandler(menuHandler);

		
	}
	
	
	/**
	 * A helper method to set the data of the concept grid
	 * 
	 * @param jClas
	 */
	public void setClas(JSONObject jClas) {

		Set<String> keys = jClas.keySet();
		for (String key:keys) {
			
			String val = jClas.get(key).isString().stringValue();
			
			final String id    = key;
			final String name  = val;
			
			ListGridRecord newClas = new ListGridRecord();
			
			newClas.setAttribute(JaxrConstants.RIM_ID, id);
			newClas.setAttribute(JaxrConstants.RIM_NAME, name);

			this.addData(newClas);
		}
		
	}
	
	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new ConceptObject();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return JaxrConstants.RIM_ID;
	}

	
}
