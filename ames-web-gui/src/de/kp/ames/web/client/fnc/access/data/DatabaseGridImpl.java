package de.kp.ames.web.client.fnc.access.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.access.data
 *  Module: DatabaseGridImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #access #client #data #database #fnc #grid #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;
import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.RowEndEditAction;
import de.kp.ames.web.client.core.grid.LocalGridImpl;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.client.model.remote.DatabaseObject;

public class DatabaseGridImpl extends LocalGridImpl {

	/*
	 * Reference to the database data
	 */
	private JSONObject jDatabase;
	
	/**
	 * Constructor
	 * 
	 * @param jDatabase
	 */
	public DatabaseGridImpl(JSONObject jDatabase) {
		super();

		/*
		 * Register database columns & rows
		 */
		this.jDatabase = jDatabase;
		
		/*
		 * Set row numbering
		 */
		this.setShowRowNumbers(true);  
		this.setLeaveScrollbarGap(true);
		
		/*
		 * Configure grid editing
		 */
        this.setCanEdit(true);  
        this.setAlwaysShowEditors(true);  

        this.setEditByCell(true);  
        this.setEditEvent(ListGridEditEvent.CLICK);  
 		
        this.setListEndEditAction(RowEndEditAction.NEXT);
        
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
	 * @return
	 */
	private DataObject createDataObject() {
		
		DatabaseObject dataObject = new DatabaseObject();
		dataObject.setDatabase(this.jDatabase);
		
		return dataObject;
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return null;
	}

}
