package de.kp.ames.web.client.core.gui.base;

import com.smartgwt.client.widgets.layout.HLayout;

import de.kp.ames.web.client.core.gui.globals.GUIStyles;

public class BaseContent extends HLayout {

	public BaseContent() {
		
		this.setWidth100();
		this.setHeight100();
		
		this.setStyleName(GUIStyles.X_BD_STYLE_3);
	}
}
