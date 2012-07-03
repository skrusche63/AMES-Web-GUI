package de.kp.ames.web.client.function.dms.action;

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.action.grid.GridViewImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.function.dms.DmsWidget;

public class DmsViewImpl extends GridViewImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public DmsViewImpl(Grid grid, ListGridRecord record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();
		
		DmsWidget widget = new DmsWidget();
		widget.doView(attributes, record);
		
	}

}
