package de.kp.ames.web.client.fnc.comm.widget;

/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.bulletin.widget
 *  Module: BulletinImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #comm #client #fnc #web #widget
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

import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Frame;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.widget.base.ActionIndicator;
import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.style.GuiStyles;

public class ChatImpl extends BaseApp {

	/*
	 * Reference to the IFrame that holds
	 * the chat client application
	 */
	private Frame frame;
	
	/**
	 * Constructor
	 */
	public ChatImpl() {
		super(FncGlobals.CHAT_TITLE, FncGlobals.CHAT_SLOGAN);
		
		/*
		 * Build endpoint
		 */
		String endpoint = CoreGlobals.COM_URL + "?service=chat&security=saml";
		
		/*
		 * VLayout
		 */
		VLayout layout = new VLayout();
		layout.setShowEdges(false);
		
		layout.setOverflow(Overflow.HIDDEN);
		
		layout.setWidth100();
		layout.setHeight100();
		
		frame = new Frame();
		frame.setStyleName(GuiStyles.X_FRAME);
		
		/*
		 * Event handling
		 */
		frame.addLoadHandler(new LoadHandler(){
			public void onLoad(LoadEvent event) {
				ActionIndicator.getInstance().reset();				
			}			
		});
		
		layout.addMember(frame);
		this.setContent(layout);
		
		/*
		 * finally set url
		 */
		frame.setUrl(endpoint);

		/*
		 * Open Action Indicator
		 */
		ActionIndicator.getInstance().open("Loading Chat Communicator...");
		
	}

}
