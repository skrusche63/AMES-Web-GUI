package de.kp.ames.web.client.core.grid;
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
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.RowContextClickEvent;
import com.smartgwt.client.widgets.grid.events.RowContextClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;

import de.kp.ames.web.client.handler.GridMenuHandler;
import de.kp.ames.web.client.handler.GridRecordHandler;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.shared.JsonConstants;

public class GridImpl extends ListGrid implements Grid {
	
	/*
	 * Reference to DataObject
	 */
	protected DataObject dataObject;

	/*
	 * Reference to MenuHandler
	 */
	protected GridMenuHandler menuHandler;
	
	/*
	 * Reference to RecordHandler
	 */
	protected GridRecordHandler recordHandler;
	
	/*
	 * Reference to name of detail field
	 */
	protected String detailFieldName;
	
	/*
	 * Reference to attributes
	 */
	protected HashMap<String,String> attributes;

	/**
	 * Constructor
	 */
	public GridImpl() {	

		/*
		 * No border style
		 */
		this.setStyleName(GuiStyles.X_BD_STYLE_0);
		
		/*
		 * Dimensions
		 */		
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * List entry may be expanded on click
		 */
		String detailFieldName = getDetailFieldName();

		if (detailFieldName != null) {

			this.setCanExpandRecords(true);
			this.setExpansionMode(ExpansionMode.DETAIL_FIELD);

			this.setDetailField(detailFieldName);
			
		}
		/*
		 * Event handling
		 */
        final GridImpl self = this;
 
		this.addRecordClickHandler(new RecordClickHandler() {
			public void onRecordClick(RecordClickEvent event) {
				self.afterRecordClick(event);				
			}
			
		});
		
		this.addRowContextClickHandler(new RowContextClickHandler() {
			public void onRowContextClick(RowContextClickEvent event) {
				self.afterContextMenu(event);
			}			
		});

		this.addSelectionChangedHandler(new SelectionChangedHandler() {
			public void onSelectionChanged(SelectionEvent event) {
				self.afterSelectionChanged(event);				
			}
		});

	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.BaseGrid#addMenuHandler(de.kp.ames.web.client.core.menu.GridMenuHandler)
	 */
	public void addMenuHandler(GridMenuHandler menuHandler) {
		/*
		 * Set Menu Handler and register grid
		 * for later processing
		 */
		this.menuHandler = menuHandler;
		this.menuHandler.setGrid(this);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#addRecordHandler(de.kp.ames.web.client.handler.GridRecordHandler)
	 */
	public void addRecordHandler(GridRecordHandler recordHandler) {
		/*
		 * Set Record Handler and register grid
		 * for later processing
		 */
		this.recordHandler = recordHandler;
		this.recordHandler.setGrid(this);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#afterContextMenu(com.smartgwt.client.widgets.grid.events.RowContextClickEvent)
	 */
	public void afterContextMenu(RowContextClickEvent event) {
		/*
		 * Stop event propagation
		 */
		event.cancel();
		
		/*
		 * Retrieve affected grid record
		 */
		Record record = event.getRecord();

		/*
		 * Invoke Grid MenuHandler
		 */
		if (this.menuHandler != null) this.menuHandler.doOpen(record);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#afterRecordClick(com.smartgwt.client.widgets.grid.events.RecordClickEvent)
	 */
	public void afterRecordClick(RecordClickEvent event) {
		/*
		 * Stop event propagation
		 */
		event.cancel();
		
		/*
		 * Retrieve affected grid record
		 */
		Record record = event.getRecord();

		/*
		 * Invoke Grid RecordHandler
		 */
		if (this.recordHandler != null) this.recordHandler.doSelect(record);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#afterSelectionChanged(com.smartgwt.client.widgets.grid.events.SelectionEvent)
	 */
	public void afterSelectionChanged(SelectionEvent event) {
		/*
		 * Must be overridden: This event is usually used to
		 * support checkbox selection within grids
		 */
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return JsonConstants.J_DESC;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#reload()
	 */
	public void reload() {
		
		/* 
		 * REMARK:
		 * 
		 * To invalidate the cache is essential to 
		 * retrieve data from the server again
		 */
		this.invalidateCache();
		this.redraw();

	}
	
	/* (non-Javadoc)
	* @see de.kp.ames.web.client.core.grid.Grid#reload(java.util.HashMap)
	*/
	public void reload(HashMap<String,String> attributes) {
	
		if (this.attributes != null) this.attributes.putAll(attributes);
		this.reload();
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#createDataFields()
	 */
	public DataSourceField[] createDataFields() {
		return this.dataObject.createDataFieldsAsArray();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#createGridFields()
	 */
	public ListGridField[] createGridFields() {
		return this.dataObject.createListGridFieldsAsArray();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.Grid#createGridRecords()
	 */
	public ListGridRecord[] createGridRecords() {
		return this.dataObject.createListGridRecordsAsArray();
	}
	
}
