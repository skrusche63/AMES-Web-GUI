package de.kp.ames.web.client.function.product.widget;

import java.util.HashMap;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.widget.dialog.CreateDialog;

public class ProductCreateDialog extends CreateDialog {
/*
 * - create productor
 * 
 */
	// TODO
	private static String TITLE  = "";
	private static String SLOGAN = "";
	
	public ProductCreateDialog(HashMap<String,String> attributes, Activity activity) {
		super(TITLE, SLOGAN);
	}

}
