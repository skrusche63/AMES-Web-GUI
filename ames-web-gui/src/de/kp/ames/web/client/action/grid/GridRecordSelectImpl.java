package de.kp.ames.web.client.action.grid;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.action.grid
 *  Module: GridRecordSelectImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #grid #record #select #web
 * </SemanticAssist>
 *
 */


import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.action.ActionImpl;
import de.kp.ames.web.client.core.grid.Grid;

public class GridRecordSelectImpl extends ActionImpl {

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
	public GridRecordSelectImpl(Grid grid, Record record) {	
		this.grid = grid;
		this.record = record;
	}

}
