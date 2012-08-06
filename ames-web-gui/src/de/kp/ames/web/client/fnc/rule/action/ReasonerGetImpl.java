package de.kp.ames.web.client.fnc.rule.action;

import java.util.HashMap;

import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.action.grid.GridGetImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.rule.RuleController;

public class ReasonerGetImpl extends GridGetImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public ReasonerGetImpl(Grid grid, Record record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();
		
		RuleController controller = new RuleController();
		controller.doGet(attributes, record);

	}

}
