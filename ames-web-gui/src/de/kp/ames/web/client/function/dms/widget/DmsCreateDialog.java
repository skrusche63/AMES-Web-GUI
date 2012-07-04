package de.kp.ames.web.client.function.dms.widget;

import java.util.HashMap;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.dialog.CreateDialog;

public class DmsCreateDialog extends CreateDialog {

	// TODO
	private static String TITLE  = GUIGlobals.APP_TITLE + ": Dms Viewer";
	private static String SLOGAN = "Use this widget to create a Dms entry.";
	
	public DmsCreateDialog(HashMap<String,String> attributes, Activity activity) {
		super(TITLE, SLOGAN);
	}

}
