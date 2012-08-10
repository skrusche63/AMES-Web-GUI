package de.kp.ames.web.client.fnc.map.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.map.handler
 *  Module: LayerGridRecordHandlerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #grid #handler #layer #map #record #web
 * </SemanticAssist>
 *
 */


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
