package de.kp.ames.web.client.fnc.scm.data;
/**
 * Copyright 2012. All rights reserved by Dr. Krusche & Partner PartG
 * Please contact: team@dr-kruscheundpartner.de
 */

import java.util.HashMap;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;

import de.kp.ames.web.client.core.grid.RemoteGridImpl;
import de.kp.ames.web.client.fnc.scm.control.SimilarityController;
import de.kp.ames.web.client.fnc.scm.event.SearchEventManager;
import de.kp.ames.web.client.fnc.scm.handler.ResultRecordHandlerImpl;
import de.kp.ames.web.client.fnc.scm.model.ResultObject;
import de.kp.ames.web.client.fnc.scm.style.GuiStyles;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class ResultGridImpl extends RemoteGridImpl {

	public ResultGridImpl(Record record) {
		super(ServiceConstants.SCM_SERVICE_ID);
		initialize();
		setQueryAttributeParam(record);

	}

	public ResultGridImpl(String query) {
		super(ServiceConstants.SCM_SERVICE_ID);
		initialize();
		setQueryAttributeParam(query);

	}

	private void initialize() {
		
		/*
		 * No border style
		 */
		this.setStyleName(GuiStyles.X_BD_STYLE_0);

		this.setHeight100();
		this.setWidth100();

		this.setFixedRecordHeights(false);
		this.setWrapCells(true);
		this.setSelectionType(SelectionStyle.SINGLE);
		this.setShowHeader(true);

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, "search");

		/*
		 * Create data object
		 */
		this.dataObject = createDataObject();

		/*
		 * Create data source
		 */
		this.createScGridDS();

		/*
		 * Create grid fields
		 */
		this.setFields(createGridFields());

		
		/*
		 * Add Record Handler
		 */
		ResultRecordHandlerImpl recordHandler = new ResultRecordHandlerImpl(this);
		this.addRecordHandler(recordHandler);

	}

	/**
	 * Prepare search data from suggest result
	 * 
	 * @param record
	 */
	public void setQueryAttributeParam(Record record) {

		String queryString = record.getAttributeAsString(JsonConstants.J_QUERYSTRING);
		setQueryAttributeParam(queryString);
	
	}

	/**
	 * Prepare search data from suggest result
	 * 
	 * @param String
	 */
	public void setQueryAttributeParam(String query) {

		attributes.put(MethodConstants.ATTR_QUERY, query);
	
	}


	@Override
	public void afterCellClick(CellClickEvent event) {
		/*
		 * do nothing, instead of trigger another recordHandler.doSelect()
		 */
	}

	@Override
	public void afterRecordDoubleClick(RecordDoubleClickEvent event) {
		
		/*
		 * Retrieve affected grid record
		 */
		Record record = event.getRecord();
		SearchEventManager.getInstance().doAfterResultRecordConfirmed(record);
	}

	/**
	 * @param event
	 */
	@Override
	public void afterDataArrived(DataArrivedEvent event) {

		this.focus();
		
		if ((this.getRecords().length>0) && (this.getSelectedRecords().length == 0)) {
			/*
			 * nothing selected yet, select first in row if records are
			 * available there must be a group header first because of this we
			 * select second record, which contains first suggestion
			 */
			this.selectSingleRecord(0);
			// force similarity
			new SimilarityController().doGetSimilarity(this.getSelectedRecord());

			
		}
	}

	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new ResultObject();
	}

	
}
