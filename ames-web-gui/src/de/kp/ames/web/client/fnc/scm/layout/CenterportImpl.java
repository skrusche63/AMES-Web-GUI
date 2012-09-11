package de.kp.ames.web.client.fnc.scm.layout;

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.scm.style.GuiStyles;

public class CenterportImpl extends VLayout {

	public CenterportImpl() {

		/*
		 * Dimensions
		 */
		this.setWidth(GuiStyles.CENTER_LINE_WIDTH);
		this.setHeight100();

		this.setShowEdges(false);

		/*
		 * Style
		 */
		this.setStyleName(GuiStyles.X_BD_STYLE_4);

	}
	
}
