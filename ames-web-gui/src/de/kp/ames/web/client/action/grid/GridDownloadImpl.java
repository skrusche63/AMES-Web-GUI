package de.kp.ames.web.client.action.grid;

import com.smartgwt.client.data.Record;
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
	protected Record record;
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public GridDownloadImpl(Grid grid, Record record) {	
		this.grid = grid;
		this.record = record;
	}

}
