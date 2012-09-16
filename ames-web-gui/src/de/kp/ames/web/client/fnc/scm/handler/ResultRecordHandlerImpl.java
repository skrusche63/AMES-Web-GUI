package de.kp.ames.web.client.fnc.scm.handler;

import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.scm.control.SimilarityController;
import de.kp.ames.web.client.handler.GridRecordHandlerImpl;


public class ResultRecordHandlerImpl extends GridRecordHandlerImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public ResultRecordHandlerImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.search.client.handler.GridRecordHandlerImpl#doSelect(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	public void doSelect(Record record) {
		
		new SimilarityController().doGetSimilarity(record);
		
	}
	
}
