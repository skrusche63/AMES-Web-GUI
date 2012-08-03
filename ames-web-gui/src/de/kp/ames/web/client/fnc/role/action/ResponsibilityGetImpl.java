package de.kp.ames.web.client.fnc.role.action;

import java.util.HashMap;

import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.action.grid.GridGetImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.user.UserController;

public class ResponsibilityGetImpl extends GridGetImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public ResponsibilityGetImpl(Grid grid, Record record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();
		
		UserController controller = new UserController();
		controller.doGet(attributes, record);
		
	}


}
