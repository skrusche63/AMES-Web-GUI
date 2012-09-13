package de.kp.ames.web.client.fnc.scm.layout;
/**
 * Copyright 2012. All rights reserved by Dr. Krusche & Partner PartG
 * Please contact: team@dr-kruscheundpartner.de
 */

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.scm.style.GuiStyles;
import de.kp.ames.web.client.handler.RemoveHandler;


public class LeftportImpl extends VLayout implements RemoveHandler {

	/**
	 * Constructor
	 */
	public LeftportImpl() {
		
		/*
		 * Dimensions
		 */
		this.setWidth(GuiStyles.LEFT_LINE_WIDTH);
		this.setHeight100();
		
		this.setShowEdges(false);

		/*
		 * Style
		 */
		this.setStyleName(GuiStyles.X_BD_STYLE_3);
		this.setBackgroundColor(GuiStyles.LEFT_LINE_BG);
		
	}

	@Override
	public void beforeRemove() {
		// nop
	};
	
}
