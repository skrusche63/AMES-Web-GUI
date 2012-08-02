package de.kp.ames.web.client.fnc.group.action;

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.action.grid.GridCategoryImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.group.GroupController;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class GroupCategoryImpl extends GridCategoryImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public GroupCategoryImpl(Grid grid, Record record) {	
		super(grid, record);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();
		attributes.put(MethodConstants.ATTR_ITEM, record.getAttributeAsString(JaxrConstants.RIM_ID));

		GroupController controller = new GroupController();		
		final GroupCategoryImpl self = this;
		
		controller.doCategory(attributes, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.doAfterCategory(jValue);
			}
		});
		
	}

}
