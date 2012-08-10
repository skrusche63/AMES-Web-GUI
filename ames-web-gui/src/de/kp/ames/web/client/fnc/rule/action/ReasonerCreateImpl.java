package de.kp.ames.web.client.fnc.rule.action;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.rule.action
 *  Module: ReasonerCreateImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #create #fnc #reasoner #rule #web
 * </SemanticAssist>
 *
 */


import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.action.grid.GridCreateImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.rule.RuleController;

public class ReasonerCreateImpl extends GridCreateImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public ReasonerCreateImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		final ReasonerCreateImpl self = this;
		RuleController controller = new RuleController();
		
		controller.doCreate(this.params, this.grid, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.doAfterCreate(jValue);
			}			
		});

	}
	
}

