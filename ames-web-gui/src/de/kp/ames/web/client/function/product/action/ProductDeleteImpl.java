package de.kp.ames.web.client.function.product.action;

import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.action.grid.GridDeleteImpl;
import de.kp.ames.web.client.core.grid.Grid;

public class ProductDeleteImpl extends GridDeleteImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public ProductDeleteImpl(Grid grid, ListGridRecord record) {
		super(grid, record);
	}

}
