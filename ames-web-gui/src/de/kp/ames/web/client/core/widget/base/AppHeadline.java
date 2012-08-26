package de.kp.ames.web.client.core.widget.base;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.widget.base
 *  Module: BaseHeadline
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #base #client #core #headline #web #widget
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

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.layout.HLayout;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.style.GuiStyles;

public class AppHeadline extends HLayout {

	private String title;
	private String slogan;

	private HTMLPane leftPane;
	private Canvas rightPane;
	
	/**
	 * Constructor requires title and slogan
	 * 
	 * @param title
	 * @param slogan
	 */
	public AppHeadline(String title, String slogan) {
		
		this.title  = title;
		this.slogan = slogan;
		
		this.setStyleName(GuiStyles.X_TOPLINE);
		
		this.setShowEdges(false);

		/*
		 * May be used as an alternative header style
		 * 
		 * this.setBackgroundImage(GuiStyles.APP_BG_IMAGE); 
		 * this.setBackgroundRepeat(BkgndRepeat.REPEAT);
		 */

		this.setBackgroundColor(GuiStyles.TOPLINE_BG_COLOR);		
		this.leftPane = new HTMLPane();
		
		/*
		 * Left Pane dimensions
		 */
		this.leftPane.setWidth("*");
		this.leftPane.setHeight100();
		
		this.rightPane = new Canvas();
		
		/*
		 * Right Pane dimensions
		 */
		this.rightPane.setWidth(221);
		this.rightPane.setHeight100();
		
		this.setWidth100();
		this.setHeight(64);

		this.setMembers(leftPane,rightPane);		
		this.setHeadline(title, slogan);
		
	}
	
	/**
	 * Method to initially set title and slogan
	 * 
	 * @param title
	 * @param slogan
	 */
	public void setHeadline(String title, String slogan) {

		this.title  = title;
		this.slogan = slogan;

		this.leftPane.setContents(getHtml());
		if (GuiConstants.SHOWCASE_FLAG) rightPane.addChild(createLogo());
		
	}

	/**
	 * Method to change the title and keeping the slogan
	 * 
	 * @param title
	 */
	public void setHeading(String title) {

		this.title = title;

		this.leftPane.setContents(getHtml());
		if (GuiConstants.SHOWCASE_FLAG) rightPane.addChild(createLogo());
		
	}

	/**
	 * @return
	 */
	private ImgButton createLogo() {

		ImgButton logo = new ImgButton();
		logo.setSrc(GuiStyles.LOGO_IMAGE);
		
		logo.setMargin(5);
		
		logo.setWidth(221);
		logo.setHeight(58);

	    logo.setHoverStyle(GuiStyles.X_IMAGEHOVER);
	    
	    logo.setShowRollOver(false);
	    logo.setShowDownIcon(false);

	    logo.setShowDown(false);

	    return logo;
	    
	}
	
	/**
	 * A helper method to create the HTML content of the headline
	 * 
	 * @return
	 */
	private String getHtml() {

		String html = "";
		
		if (GuiConstants.SHOWCASE_FLAG) {

			/*
			 * Showcase
			 */
			html = "<div class='x-topline'>";
			html += "<div style='padding:8px 0px 0px 8px;font-size:22px;vertical-align:top;'><b>" + this.title + "</b><br/>";
			html += "<span style='padding:8px 0px 0px 2px;font-size:11px;'>" + this.slogan + "</span></div>";
			html += "</div";
		
		} else {
			
			/*
			 * Operational use case
			 */
			html = "<div class='x-topline'>";
			html += "<img src='" + GuiStyles.APP_ICON + "' height='48' width='48' style='display:block;float:left;margin:8px 4px 4px 4px;'>";
			html += "<div style='padding:8px 0px 0px 8px;font-size:22px;vertical-align:top;'><b>" + this.title + "</b><br/>";
			html += "<span style='padding:8px 0px 0px 2px;font-size:11px;'>" + this.slogan + "</span></div>";
			html += "</div";
		
		}
		
		return html;

	}

}
