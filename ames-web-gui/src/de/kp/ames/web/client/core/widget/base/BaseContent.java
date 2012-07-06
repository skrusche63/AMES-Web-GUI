package de.kp.ames.web.client.core.widget.base;

import com.smartgwt.client.widgets.layout.HLayout;

import de.kp.ames.web.client.style.GuiStyles;

public class BaseContent extends HLayout {

	public BaseContent() {
		
		this.setWidth100();
		this.setHeight100();
		
		this.setStyleName(GuiStyles.X_BD_STYLE_3);
	}
}
