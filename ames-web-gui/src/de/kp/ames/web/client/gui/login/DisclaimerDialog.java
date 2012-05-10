package de.kp.ames.web.client.gui.login;
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
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

import de.kp.ames.web.client.core.callback.ActivityCallback;
import de.kp.ames.web.client.gui.base.BaseDialog;
import de.kp.ames.web.client.gui.globals.GUIGlobals;

public class DisclaimerDialog extends BaseDialog {

	private ActivityCallback callback;
	private HTMLFlow flow;
	
	public DisclaimerDialog(String html, ActivityCallback callback) {
		super(GUIGlobals.DISCLAIMER_TITLE, GUIGlobals.DISCLAIMER_SLOGAN);
		
		// register callback
		this.callback = callback;
		
		this.flow.setContents(html);
		
		this.setTitle(GUIGlobals.APP_TITLE + ": Disclaimer");
		
		this.setShowCloseButton(false);
		this.setShowMinimizeButton(false);

		this.setWidth(480);
		this.setHeight(480);
		
		this.draw();
		
	}

	// KPDialog::createBodyContent
	public Canvas createBodyContent() {
		
		flow = new HTMLFlow();
		
		flow.setWidth100();
		flow.setHeight100();
		
		return flow;
		
	}

	// Dialog::createB1ClickHandler
	public ClickHandler createB1ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if (callback != null) callback.execute();
				destroy();
			
			}			
		};
	}

	// Dialog::createB2ClickHandler
	public ClickHandler createB2ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				destroy();				
			}			
		};
	}

}
