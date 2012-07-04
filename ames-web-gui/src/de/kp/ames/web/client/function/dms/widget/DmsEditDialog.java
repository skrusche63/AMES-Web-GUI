package de.kp.ames.web.client.function.dms.widget;

import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.dialog.EditFormDialog;

public class DmsEditDialog extends EditFormDialog {

	private static String TITLE  = GUIGlobals.APP_TITLE + ": Dms Editor";
	private static String SLOGAN = "Use this widget to edit a specific Dms entry.";
	
	public DmsEditDialog() {
		super(TITLE, SLOGAN);
	}
	
}
