package de.kp.ames.web.client.core.slot;

import java.util.HashMap;

import com.smartgwt.client.types.ListGridEditEvent;

import de.kp.ames.web.client.core.grid.LocalGridImpl;
import de.kp.ames.web.client.model.SlotObject;
import de.kp.ames.web.client.model.core.DataObject;

/*
 * A SlotGrid is a predefined key, value
 * list (or) grid that supports slot handling
 */
public class SlotGridImpl extends LocalGridImpl {

	/**
	 * Constructor
	 */
	public SlotGridImpl() {
		super();

		/*
		 * Set row numbering
		 */
		this.setShowRowNumbers(true);  
		
		/*
		 * Configure grid editing
		 */
        this.setCanEdit(true);  
        this.setAlwaysShowEditors(true);  

        this.setEditByCell(true);  
        this.setEditEvent(ListGridEditEvent.CLICK);  
 		
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
		return new SlotObject();
	}

}
