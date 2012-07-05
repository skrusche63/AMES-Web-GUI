package de.kp.ames.web.client.function.access.widget;

import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.dialog.EditFormDialog;

public class AccessorEditDialog extends EditFormDialog {

	private static String TITLE  = GUIGlobals.APP_TITLE + ": Accessor Editor";;
	private static String SLOGAN = "Use this widget to edit a certain accessor.";

	/**
	 * Constructor
	 * 
	 * @param jValue
	 */
	public AccessorEditDialog(JSONValue jValue) {
		super(TITLE, SLOGAN, jValue);
	}

	// TODO
	
}
