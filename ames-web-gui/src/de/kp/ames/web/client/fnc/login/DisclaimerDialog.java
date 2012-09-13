package de.kp.ames.web.client.fnc.login;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.login
 *  Module: DisclaimerDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #dialog #disclaimer #fnc #login #web
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
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

import de.kp.ames.web.client.core.widget.dialog.BaseDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class DisclaimerDialog extends BaseDialog {

	private HTMLFlow flow;
	
	public DisclaimerDialog(String html) {
		super(FncGlobals.DISCLAIMER_TITLE, FncGlobals.DISCLAIMER_SLOGAN);
		
		this.flow.setContents(html);
		
		this.setTitle(FncGlobals.DISCLAIMER_TITLE);
		
		this.setShowCloseButton(false);
		this.setShowMinimizeButton(false);

		this.setWidth(480);
		this.setHeight(480);
		
		this.redraw();
		
	}

	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#createContent()
	 */
	@Override
	public Canvas createContent() {
		
		flow = new HTMLFlow();
		
		flow.setWidth100();
		flow.setHeight100();
		
		return flow;
		
	}

	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#createB1ClickHandler()
	 */
	@Override
	public ClickHandler createB1ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				destroy();			
			}			
		};
	}

	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#createB2ClickHandler()
	 */
	@Override
	public ClickHandler createB2ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				destroy();				
			}			
		};
	}

}
