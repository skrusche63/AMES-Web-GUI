package de.kp.ames.web.client.function.product.widget;

import java.util.HashMap;

import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.widget.dialog.EditDialog;

public class ProductEditDialog extends EditDialog {
/*
 * - edit productor
 */
	// TODO
	private static String TITLE  = "";
	private static String SLOGAN = "";
	
	public ProductEditDialog(HashMap<String,String> attributes, ListGridRecord record, Activity activity) {
		super(TITLE, SLOGAN);
	}

}
