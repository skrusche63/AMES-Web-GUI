package de.kp.ames.web.client.core.widget.dialog;

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.grid.GridImpl;

public class CreateGridDialog extends GridDialog {

	/*
	 * Buttons labels
	 */
	private static String LABEL1 = GUIGlobals.BTN_CREATE_LABEL;
	private static String LABEL2 = GUIGlobals.BTN_CAN_LABEL;

	public CreateGridDialog(String title, String slogan, GridImpl grid) {
		super(title, slogan, grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.base.BaseDialog#createButtons()
	 */
	public VLayout createButtons() {
		return createButtons(LABEL1, LABEL2);
	}
	
}
