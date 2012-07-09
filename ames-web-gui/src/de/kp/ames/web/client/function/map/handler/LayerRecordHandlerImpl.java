package de.kp.ames.web.client.function.map.handler;

import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.handler.GridRecordHandlerImpl;

public class LayerRecordHandlerImpl extends GridRecordHandlerImpl {

	/*
	 * Reference to activity for after layer selection
	 */
	private Activity activity;

	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public LayerRecordHandlerImpl(Grid grid) {
		super(grid);
	}
	
	/**
	 * @param activity
	 */
	public void setAfterLayerActivity(Activity activity) {		
		/*
		 * Register activity
		 */
		this.activity = activity;
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.GridRecordHandlerImpl#doSelect(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	public void doSelect(ListGridRecord record) {
		/*
		 * Invoke after layer activity
		 */
		this.activity.execute(record);
		
	}
	
}
