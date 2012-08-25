package de.kp.ames.web.client.core.widget.base;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.HLayout;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.style.GuiStyles;

public class DialogHeadline extends HLayout {

	private String title;
	private String slogan;

	private HTMLPane pane;
	
	/**
	 * Constructor requires title and slogan
	 * 
	 * @param title
	 * @param slogan
	 */
	public DialogHeadline(String title, String slogan) {
		
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
		this.pane = new HTMLPane();
		
		/*
		 * Left Pane dimensions
		 */
		this.pane.setWidth("*");
		this.pane.setHeight100();

		/*
		 * Headline dimneions
		 */
		this.setWidth100();
		this.setHeight(64);

		this.setMembers(pane);		
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

		this.pane.setContents(getHtml());
		
	}

	/**
	 * Method to change the title and keeping the slogan
	 * 
	 * @param title
	 */
	public void setHeading(String title) {

		this.title = title;
		this.pane.setContents(getHtml());
		
	}

	/**
	 * A helper method to create the HTML content of the headline
	 * 
	 * @return
	 */
	private String getHtml() {

		String html = "";
		
		if (CoreGlobals.SHOWCASE_FLAG) {

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
