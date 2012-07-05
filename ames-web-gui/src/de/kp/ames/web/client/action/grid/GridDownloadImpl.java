package de.kp.ames.web.client.action.grid;

import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.action.ActionImpl;
import de.kp.ames.web.client.core.grid.Grid;

public class GridDownloadImpl extends ActionImpl {

	/*
	 * Reference to Grid
	 */
	protected Grid grid;
	
	/*
	 * Reference to Record
	 */
	protected ListGridRecord record;
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public GridDownloadImpl(Grid grid, ListGridRecord record) {	
		this.grid = grid;
		this.record = record;
	}

}
