package de.kp.ames.web.client.fnc.map.handler;

import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.map.event.MapEventManager;
import de.kp.ames.web.client.handler.GridRecordHandlerImpl;

public class LayerGridRecordHandlerImpl extends GridRecordHandlerImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public LayerGridRecordHandlerImpl(Grid grid) {
		super(grid);
	}

	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.GridRecordHandlerImpl#doSelect(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	@Override
	public void doSelect(Record record) {
				
		MapEventManager.getInstance().onLayerSelected(record);
		
	}
	
}
