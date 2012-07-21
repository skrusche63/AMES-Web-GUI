package de.kp.ames.web.client.core.portal;
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

import com.google.gwt.json.client.JSONObject;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.HeaderControl;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

import de.kp.ames.web.shared.constants.JsonConstants;

/**
 * A Portlet is a placeholder for a certain application;
 * it supports a portal representation of all the apps
 * registered for a specific user
 * 
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */
public class PortletImpl extends Window implements Portlet { 

	private JSONObject jConfiguration;
	
	public PortletImpl(JSONObject jConfig) {
		
		// register configuration data
		this.jConfiguration = jConfig;
		
		setShowShadow(false);  
		
		// enable predefined component animation  
		setAnimateMinimize(true);  
		
		// Window is draggable with "outline" appearance by default.  
		// "target" is the solid appearance.  
		setDragAppearance(DragAppearance.OUTLINE);  
		setCanDrop(true);  
		
		// customize the appearance and order of the controls in the window header  
		setHeaderControls(HeaderControls.MINIMIZE_BUTTON, HeaderControls.HEADER_LABEL, 
				new HeaderControl(HeaderControl.SETTINGS), 
				new HeaderControl(HeaderControl.HELP), 
				HeaderControls.CLOSE_BUTTON);  

		// show either a shadow, or translucency, when dragging a portlet  
		// (could do both at the same time, but these are not visually compatible effects)  
	    setShowDragShadow(true);  
		setDragOpacity(30);  
		
		// these settings enable the portlet to autosize its height only to fit its contents  
		// (since width is determined from the containing layout, not the portlet contents)  
		setVPolicy(LayoutPolicy.NONE);  
		setOverflow(Overflow.VISIBLE);  	
		
		this.build();
		
		// a click on the content of a portlet starts the
		// associated application into the actual viewport
		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// start associated application
				start();
			}			
		});
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.gui.portal.Portlet#build()
	 */
	public void build() {
		
		String title = this.jConfiguration.get(JsonConstants.J_NAME).isString().stringValue();
		this.setTitle(title);
		
		// this is a dummy content
		Label label = new Label();  
		label.setAlign(Alignment.CENTER); 
		
		//label.setLayoutAlign(VerticalAlignment.CENTER);  
		label.setContents("Portlet content");  
		
		label.setBackgroundColor(PortalConstants.PORTLET_BACKGROUND);
		this.addItem(label);  
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.gui.portal.Portlet#start()
	 */
	public void start() {
		// TODO
	}
}
