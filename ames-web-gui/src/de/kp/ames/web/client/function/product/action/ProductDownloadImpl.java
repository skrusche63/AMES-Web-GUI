package de.kp.ames.web.client.function.product.action;

import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.action.grid.GridDownloadImpl;
import de.kp.ames.web.client.core.grid.Grid;

public class ProductDownloadImpl extends GridDownloadImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public ProductDownloadImpl(Grid grid, ListGridRecord record) {
		super(grid, record);
	}

}
