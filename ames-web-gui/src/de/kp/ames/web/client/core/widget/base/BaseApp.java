package de.kp.ames.web.client.core.widget.base;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.widget.base
 *  Module: BaseApp
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #app #base #client #core #web #widget
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

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.search.SearchHandler;
import de.kp.ames.web.client.handler.RemoveHandler;


/**
 * BaseApp is a vertical layout that holds
 * a common headline and a content area
 */
public class BaseApp extends VLayout implements RemoveHandler, SearchHandler {

	private AppHeadline headline;
	private BaseContent content;
	
	/**
	 * Constructor that does not provide headline
	 */
	public BaseApp() {

		content  = new BaseContent();
		
		this.setWidth100();
		this.setHeight100();
		
		this.setBackgroundColor("#F2F2F2");
		
		this.setMembers(content);
		
	}
	
	/**
	 * Constructor that provides a headline
	 * 
	 * @param title
	 * @param slogan
	 */
	public BaseApp(String title, String slogan) {		
		
		headline = new AppHeadline(title, slogan);
		content  = new BaseContent();
		
		this.setWidth100();
		this.setHeight100();
		
		this.setBackgroundColor("#F2F2F2");
		
		this.setMembers(headline, content);
		
	}
	
	/**
	 * @return
	 */
	public BaseContent getContent() {
		return this.content;
	}

	/**
	 * A wrapper method to add members to the content
	 * 
	 * @param members
	 */
	public void setContent(Canvas...members) {
		this.content.setMembers(members);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.RemoveHandler#beforeRemove()
	 */
	public void beforeRemove() {
		/*
		 * Must be overridden
		 */
	}

	@Override
	public void doSearch(String query) {
		SC.say(GuiConstants.APP_TITLE + ": Search Error", "The current application is not searchable.");		
	}
	
}
