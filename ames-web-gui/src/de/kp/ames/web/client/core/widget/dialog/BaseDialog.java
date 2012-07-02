package de.kp.ames.web.client.core.widget.dialog;
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

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.globals.GUIStyles;
import de.kp.ames.web.client.core.widget.base.ActionIndicator;
import de.kp.ames.web.client.core.widget.base.GUIBaseFactory;

/**
 * This class is the base window for a modal dialog;
 * it supports the default buttons (ok, cancel)
 */
public class BaseDialog extends Window {
	
	private IButton b1;
	private IButton b2;
	
	/*
	 * Button dimensions
	 */
	private static int BTN_WIDTH  = GUIGlobals.BTN_WIDTH;
	private static int BTN_HEIGHT = GUIGlobals.BTN_HEIGHT;

	/*
	 * Default labels of dialog window
	 */
	private static String LABEL1 = GUIGlobals.BTN_OK_LABEL;
	private static String LABEL2 = GUIGlobals.BTN_CAN_LABEL;
	
	/*
	 * Border styles
	 */
	private static String BORDER1 = GUIStyles.X_BD_STYLE_1;

	/*
	 * Default dimensions
	 */
	private static int DIM = GUIGlobals.DIALOG_DIM;
	
	/**
	 * Constructor requires title and slogan
	 * 
	 * @param title
	 * @param slogan
	 */
	public BaseDialog(String title, String slogan) {
		
		VLayout vLayout = new VLayout();
		vLayout.setShowEdges(false);
		
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		vLayout.setMembersMargin(0);
		vLayout.setLayoutMargin(0);
		
		/*
		 * Create headline, body and buttons
		 */
		vLayout.addMember(createHeadline(title, slogan));
		vLayout.addMember(createBody());
		vLayout.addMember(createButtons());
		
		this.addItem(vLayout);
		
		this.setWidth(DIM);
		this.setHeight(DIM);
		
		this.setShowShadow(true);
		this.setShadowOffset(3);

		this.setShadowSoftness(10);				
		this.setBodyColor(GUIStyles.DIA_BG_COLOR);

		final BaseDialog self = this;		

		this.addCloseClickHandler(new CloseClickHandler() {
			public void onCloseClick(CloseClickEvent event) {
				self.destroy();				
			}			
		});

		this.centerInPage();
		this.draw();
		
	}
	
	/**
	 * @return
	 */
	public VLayout createBody() {

		VLayout vLayout = new VLayout();
		vLayout.setStyleName(GUIStyles.X_BD_STYLE_2);

		vLayout.setWidth100();		
		vLayout.setHeight100();
		
		vLayout.addMember(createBodyContent());
		return vLayout;
		
	}
	
	/**
	 * Create body content (must be overridden)
	 * 
	 * @return
	 */
	public Canvas createBodyContent() {
		return null;
	}
	
	/**
	 * Method to create headline of dialog
	 * 
	 * @param title
	 * @param slogan
	 * @return
	 */
	private VLayout createHeadline(String title, String slogan) {
		return GUIBaseFactory.createHeadline(title, slogan);
	}
	
	/**
	 * Method to create default dialog buttons
	 * 
	 * @return
	 */
	public VLayout createButtons() {
		return createButtons(LABEL1, LABEL2);
	}
	
	/**
	 * Method to create customized dialog buttons
	 * 
	 * @param label1
	 * @param label2
	 * @return
	 */
	public VLayout createButtons(String label1, String label2) {

		/*
		 * First button
		 */
		b1 = new IButton(label1);
		b1.setWidth(BTN_WIDTH);
		b1.setLayoutAlign(Alignment.CENTER);

		b1.addClickHandler(createB1ClickHandler());

		/*
		 * Second button
		 */
		b2 = new IButton(label2);
		b2.setWidth(BTN_WIDTH);
		b2.setLayoutAlign(Alignment.CENTER);

		/*
		 * Button rendering
		 */
		b2.addClickHandler(createB2ClickHandler());
		
		VLayout b1Layout = new VLayout();
		b1Layout.setWidth("50%");
		
		b1Layout.setLayoutAlign(Alignment.RIGHT);
		b1Layout.addMember(b1);

		VLayout b2Layout = new VLayout();
		b2Layout.setWidth("50%");
		b2Layout.addMember(b2);
		
		HLayout buttonLayout = new HLayout();
		buttonLayout.setHeight(BTN_HEIGHT + 16);

		buttonLayout.setWidth(180);
		buttonLayout.setMembersMargin(8);

		buttonLayout.setLayoutMargin(8);
		buttonLayout.setLayoutAlign(Alignment.CENTER);

		buttonLayout.addMember(b1Layout);
		buttonLayout.addMember(b2Layout);

		VLayout vLayout = new VLayout();

		vLayout.setStyleName(BORDER1);
		vLayout.setWidth("100%");
		
		vLayout.setHeight(40);
		vLayout.setBackgroundColor(GUIStyles.BTN_BG_COLOR);
		
		vLayout.addMember(buttonLayout);
		return vLayout;
		
	}

	/**
	 * Click Handler for first button
	 * 
	 * @return
	 */
	public ClickHandler createB1ClickHandler() {
		return null;
	}
	
	/**
	 * Click Handler for second button
	 * 
	 * @return
	 */
	public ClickHandler createB2ClickHandler() {
		return null;
	}
	
	/**
	 * Set action indicator
	 * 
	 * @param mask
	 * @param text
	 */
	public void setIndicator(String text) {
		ActionIndicator.getInstance().open(text);
	}

	/**
	 * Reset action indicator
	 */
	public void resetIndicator() {
		ActionIndicator.getInstance().reset();		
	}
}
