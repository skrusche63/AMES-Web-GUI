package de.kp.ames.web.client.function.dms.widget;

import java.util.HashMap;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.widget.dialog.CreateDialog;

public class DmsCreateDialog extends CreateDialog {

	// TODO
	private static String TITLE  = "";
	private static String SLOGAN = "";
	
	public DmsCreateDialog(HashMap<String,String> attributes, Activity activity) {
		super(TITLE, SLOGAN);
	}

}
