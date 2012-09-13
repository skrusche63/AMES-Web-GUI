package de.kp.ames.web.client.core.widget.base;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.widget.base
 *  Module: Viewport
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #base #client #core #viewport #web #widget
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

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.events.ResizedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

import de.kp.ames.web.client.core.apps.CustomAppsManager;
import de.kp.ames.web.client.core.apps.UserManager;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.shared.constants.ApplicationConstants;

public class Viewport extends VLayout {
	
	/*
	 * Actually three control labels are support
	 */
	private ControlLabel apps;
	private ControlLabel comm;
	private ControlLabel help;
	
	/* 
	 * A reference to the user label to enable change 
	 * and also provisioning of additional information
	 */
	
	private Label user;
	private ImgButton search;
	
	private static int TOP_HEIGHT = 24;

	private static String HEADER_ICON = "header_icon.png";
	
	public Viewport() {

		this.setShowEdges(false);
		this.setStyleName(GuiStyles.X_BD_STYLE_0);
		
		this.setWidth100();
		this.setHeight100();

		this.setBackgroundColor(GuiStyles.TOPLINE_BG_COLOR);
		this.setOverflow(Overflow.HIDDEN);

		this.addMember(createOpsToolStrip());
		/*
		 * Create place holder
		 */
		this.addMember(createPlaceHolder());
		
		/*
		 * Resized events
		 */
		this.addResizedHandler(new ResizedHandler() {
			public void onResized(ResizedEvent event) {
				CustomAppsManager.getInstance().afterResized(event);
			}
			
		});

	}
	
	public void enableSearch() {
		this.search.setVisible(true);
	}
	
	public void disableSearch() {
		this.search.setVisible(false);
	}
	
	/**
	 * Create Placeholder
	 * 
	 * @return
	 */
	private VLayout createPlaceHolder() {
		
		VLayout placeHolder = new VLayout();

		placeHolder.setShowEdges(false);
		return placeHolder;

	}

	/**
	 * Create Toolstrip
	 * 
	 * @return
	 */
	private ToolStrip createOpsToolStrip() {
		
		ToolStrip ts = new ToolStrip();
		ts.setStyleName(GuiStyles.X_HEADER);
		
		ts.setWidth100();
		ts.setHeight(TOP_HEIGHT);
		
		ts.addSpacer(5);
		
	    ImgButton logo = new ImgButton();
	    logo.setSrc(HEADER_ICON);
	    
	    logo.setWidth(16);
	    logo.setHeight(16);
	    
	    logo.setShowRollOver(false);
	    logo.setShowDownIcon(false);
	    
	    logo.setShowDisabledIcon(false);

	    logo.setShowDown(false);

	    logo.setShowFocused(false);
	    logo.setShowFocusedIcon(false);

	    logo.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	        	doLogo(event);
	        }
	    });

	    ts.addMember(logo);	    

		ts.addSpacer(5);
		

	    ts.addMember(createApplication());	    

	    ts.addMember(createCommunication());	    
	    ts.addMember(createHelp());
	    
	    ts.addFill();

	    /*
	     * User label
	     */

	    user = new Label(UserManager.getInstance().getUserName());
	    user.setStyleName(GuiStyles.X_USER);

	    user.setWidth(160);
	    user.setOverflow(Overflow.HIDDEN);
	    
	    ts.addMember(user);
	    ts.addSpacer(10);
	    
	    
	    /*
	     * Search image button
	     */

	    search = new ImgButton();
	    search.setSrc(GuiStyles.SEARCH_IMAGE);
	    
	    search.setWidth(16);
	    search.setHeight(16);
	    
	    search.setShowRollOver(false);
	    search.setShowDownIcon(false);
	    
	    search.setShowDisabledIcon(false);

	    search.setShowDown(false);

	    search.setShowFocused(false);
	    search.setShowFocusedIcon(false);

	    search.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	        	doSearch(event);
	        }
	    });

	    ts.addMember(search);
	    ts.addSpacer(15);

		return ts;
		
	}

	public void setUser(String text) {		
		user.setContents(text);
		user.redraw();
	}

	// FUNCTIONS ************************************************************

	private ControlLabel createApplication() {
		
		apps = new ControlLabel("Applications") ;
		apps.setWidth(80);
		
		apps.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				doApplication(event);
			}			
		});
		
		return apps;  
	}
	
	private ControlLabel createCommunication() {
		
		comm = new ControlLabel("Communication") ;
		comm.setWidth(80);
		
		comm.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				doCommunication(event);
			}			
		});
		
		return comm;  
	}

	private ControlLabel createHelp() {
		
		help = new ControlLabel("Help") ;
		help.setWidth(40);
		
		help.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				doHelp(event);
			}			
		});
		
		return help;  
	}

	// EVENTS ***************************************************************

	private void doApplication(ClickEvent e) {
		
		apps.setSelected(true);

		int x = apps.getAbsoluteLeft();
		int y = apps.getAbsoluteTop() + TOP_HEIGHT - 1;
		
		Menu menu = apps.getMenu();
		menu.setItems(CustomAppsManager.getInstance().getRegisteredAppsAsItems(apps));
		
		menu.moveTo(x, y);		
		menu.draw();
		
	}

	private void doCommunication(ClickEvent e) {

		comm.setSelected(true);

		int x = comm.getAbsoluteLeft();
		int y = comm.getAbsoluteTop() + TOP_HEIGHT - 1;
		
		Menu menu = comm.getMenu();
		menu.setItems(CustomAppsManager.getInstance().getRegisteredCommsAsItems(comm));
		
		menu.moveTo(x, y);		
		menu.draw();

	}
	
	/**
	 * A helper method to create the help menu items
	 * 
	 * @param e
	 */
	private void doHelp(ClickEvent e) {

		help.setSelected(true);

		int x = help.getAbsoluteLeft();
		int y = help.getAbsoluteTop() + TOP_HEIGHT - 1;
		
		Menu menu = help.getMenu();
		menu.setItems(CustomAppsManager.getInstance().getRegisteredAppsAsItems(help));
		
		menu.moveTo(x, y);		
		menu.draw();
		
	}
	
	/**
	 * Reload desktop 
	 * 
	 * @param e
	 */
	private void doLogo(ClickEvent e) {
		CustomAppsManager.getInstance().createApp(ApplicationConstants.FNC_APP_ID_Desktop);		
	}
	
	private void doSearch(ClickEvent e) {
		CustomAppsManager.getInstance().toggleSearch();
	}


}
