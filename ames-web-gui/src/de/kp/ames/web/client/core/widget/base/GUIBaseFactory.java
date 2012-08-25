package de.kp.ames.web.client.core.widget.base;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.widget.base
 *  Module: GUIBaseFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #base #client #core #factory #gui #web #widget
 * </SemanticAssist>
 *
 */

/**
 *	Copyright 2012 Dr. Krusche & Partner PartG
 *
 *	AMES-Web-GUI is free software: you can redistribute it and/or 
 *	modify it under the terms of the GNU General Public License 
 *	as published by the Free Software Foundation, either version 3 of 
 *	the License, or (at your option) any later version.
 *
 *	AMES- Web-GUI is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 *  See the GNU General Public License for more details. 
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this software. If not, see <http://www.gnu.org/licenses/>.
 *
 */

import com.smartgwt.client.types.BkgndRepeat;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.style.GuiStyles;

public class GUIBaseFactory {
	
	/**
	 * Create application headline
	 * 
	 * @param title
	 * @param slogan
	 * @return
	 */
	public static VLayout createHeadline(String title, String slogan) {

		VLayout vLayout = new VLayout();
		vLayout.setStyleName(GuiStyles.X_BD_STYLE_1);
		
		/*
		 * Headline dimension
		 */
		vLayout.setWidth100();
		vLayout.setHeight(64);
		
		vLayout.setMargin(0);
		
		vLayout.setBackgroundImage(GuiStyles.APP_BG_IMAGE);
		vLayout.setBackgroundRepeat(BkgndRepeat.REPEAT);
	
		vLayout.addMember(new DialogHeadline(title, slogan));		
		return vLayout;
	
	}

}
