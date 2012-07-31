package de.kp.ames.web.client.fnc.transform.action;

import java.util.HashMap;

import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.action.grid.GridDeleteImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.transform.TransformController;

public class SpecDeleteImpl extends GridDeleteImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public SpecDeleteImpl(Grid grid, Record record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();
		
		TransformController controller = new TransformController();		
		controller.doDelete(attributes, grid, record, new ActivityImpl() {
			public void execute() {
				/*
				 * No action invoked for local delete			
				 */
			}
		});

	}

}
