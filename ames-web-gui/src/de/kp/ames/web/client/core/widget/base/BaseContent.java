package de.kp.ames.web.client.core.widget.base;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.widget.base
 *  Module: BaseContent
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #base #client #content #core #web #widget
 * </SemanticAssist>
 *
 */


import com.smartgwt.client.widgets.layout.HLayout;

import de.kp.ames.web.client.style.GuiStyles;

public class BaseContent extends HLayout {

	public BaseContent() {
		
		this.setWidth100();
		this.setHeight100();
		
		this.setStyleName(GuiStyles.X_BD_STYLE_3);
	}
}
