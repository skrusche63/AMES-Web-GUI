package de.kp.ames.web.client.fnc.rule.action;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.rule.action
 *  Module: ReasonerDeleteImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #delete #fnc #reasoner #rule #web
 * </SemanticAssist>
 *
 */


import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.action.grid.GridDeleteImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.rule.RuleController;

public class ReasonerDeleteImpl extends GridDeleteImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public ReasonerDeleteImpl(Grid grid, Record record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {
		
		final ReasonerDeleteImpl self = this;	
		RuleController controller = new RuleController();
		
		controller.doDelete(this.params, this.grid, this.record, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.doAfterDelete(jValue);				
			}
		});

	}

}

