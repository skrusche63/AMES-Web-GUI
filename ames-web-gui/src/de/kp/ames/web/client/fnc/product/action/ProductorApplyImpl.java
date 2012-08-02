package de.kp.ames.web.client.fnc.product.action;

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.action.grid.GridApplyImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.product.ProductController;

public class ProductorApplyImpl extends GridApplyImpl {

	/**
	 * @param grid
	 * @param record
	 */
	public ProductorApplyImpl(Grid grid, Record record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();

		final ProductorApplyImpl self = this;
		ProductController controller = new ProductController();
		
		controller.doApply(attributes, record, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.doAfterApply(jValue);
			}			
		});

	}
	
}
