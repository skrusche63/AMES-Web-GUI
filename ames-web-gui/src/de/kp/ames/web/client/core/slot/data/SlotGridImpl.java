package de.kp.ames.web.client.core.slot.data;
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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.grid.LocalGridImpl;
import de.kp.ames.web.client.core.slot.handler.SlotGridMenuHandlerImpl;
import de.kp.ames.web.client.model.SlotObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.JaxrConstants;

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

		/*
		 * Add Menu Handler
		 */
		SlotGridMenuHandlerImpl menuHandler = new SlotGridMenuHandlerImpl(this);
		this.addMenuHandler(menuHandler);
		
	}
	
	/**
	 * Create new slot entry
	 */
	public void newSlot() {

		ListGridRecord newSlot = ((SlotObject)this.dataObject).createNewSlot();
		this.addData(newSlot);

	}
	
	/**
	 * Delete a certain slot entry
	 * @param record
	 */
	public void deleteSlot(Record record) {
		this.removeData(record);
	}
	
	/**
	 * A helper method to set the data of the slot grid
	 * 
	 * @param jSlots
	 */
	public void setSlots(JSONObject jSlots) {

		if (this.getRecords().length > 0) {
			/* 
			 * The initial record has been set
			 */
			this.removeData(this.getRecord(0));
		}
		
		Set<String> keys = jSlots.keySet();
		for (String key:keys) {
			
			String val = jSlots.get(key).isString().stringValue();
			
			ListGridRecord newSlot = new ListGridRecord();
			
			newSlot.setAttribute(JaxrConstants.RIM_KEY, key);
			newSlot.setAttribute(JaxrConstants.RIM_VAL, val);

			this.addData(newSlot);
			
		}
		
	}
	
	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new SlotObject();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return null;
	}

}
