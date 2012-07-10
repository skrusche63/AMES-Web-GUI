package de.kp.ames.web.client.core.widget.base;
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
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * BaseApp is a vertical layout that holds
 * a common headline and a content area
 */
public class BaseApp extends VLayout {

	private BaseHeadline headline;
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
		
		headline = new BaseHeadline(title, slogan);
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

	/**
	 * This method must be overridden to provide
	 * specific functionality before removing an
	 * application instance
	 */
	public void beforeRemove() {
	}
	
}
