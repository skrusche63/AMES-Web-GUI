package de.kp.ames.web.client.fnc.dms.action;

import java.util.HashMap;

import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.action.grid.GridDownloadImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.dms.DmsWidget;

public class DmsDownloadImpl extends GridDownloadImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public DmsDownloadImpl(Grid grid, Record record) {
		super(grid, record);
	}

	public void execute() {

		HashMap<String,String> attributes = this.getParams();

		final DmsDownloadImpl self = this;
		
		DmsWidget widget = new DmsWidget();
		widget.doDownload(attributes, record, new ActivityImpl() {

			public void execute() {
				self.doAfterDownload();				
			}
			
		});

	}

	private void doAfterDownload() {
		// TODO
	}
	
}
