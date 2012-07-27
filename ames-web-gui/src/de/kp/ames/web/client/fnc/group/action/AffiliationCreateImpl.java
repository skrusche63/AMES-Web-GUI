package de.kp.ames.web.client.fnc.group.action;

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.action.grid.GridCreateImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.group.GroupWidget;

public class AffiliationCreateImpl extends GridCreateImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public AffiliationCreateImpl(Grid grid) {	
		super(grid);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();

		final AffiliationCreateImpl self = this;
		GroupWidget widget = new GroupWidget();

		widget.doCreate(attributes, new ActivityImpl() {
			
			public void execute(JSONValue jValue) {
				self.doAfterCreate(jValue);
			}			
		
		});

	}

}
