package de.kp.ames.web.client.core.widget.dialog;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.widget.dialog
 *  Module: ApplyGridDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #apply #client #core #dialog #grid #web #widget
 * </SemanticAssist>
 *
 */


import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class ApplyGridDialog extends GridDialog {

	/*
	 * Buttons labels
	 */
	private static String LABEL1 = GuiConstants.BTN_APPLY_LABEL;
	private static String LABEL2 = GuiConstants.BTN_CAN_LABEL;

	public ApplyGridDialog(String title, String slogan, GridImpl grid) {
		super(title, slogan, grid);
		
		/*
		 * Set Title
		 */
		this.setTitle(FncGlobals.ADF_EDITOR);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.base.BaseDialog#createButtons()
	 */
	public VLayout createButtons() {
		return createButtons(LABEL1, LABEL2);
	}

}
