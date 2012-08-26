package de.kp.ames.web.client.core.widget.viewer;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.widget.viewer
 *  Module: ViewerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #viewer #web #widget
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
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.widget.base.GUIBaseFactory;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.style.GuiStyles;

public class ViewerImpl extends Window {

	/*
	 * Default dimensions
	 */
	private static int DIM = GuiConstants.VIEWER_DIM;

	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 */
	public ViewerImpl(String title, String slogan, Canvas body) {
		/*
		 * Set overall title for viewer
		 */
		this.setTitle(FncGlobals.ADF_VIEWER);
		
		VLayout vLayout = new VLayout();
		vLayout.setShowEdges(false);
		
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		vLayout.setMembersMargin(0);
		vLayout.setLayoutMargin(0);
		
		/*
		 * Create headline & body
		 */
		vLayout.addMember(createHeadline(title, slogan));
		vLayout.addMember(createBody(body));
		
		this.addItem(vLayout);
		
		this.setWidth(DIM);
		this.setHeight(DIM);

		this.setCanDragReposition(true);  
        this.setCanDragResize(true);  

		this.setShowShadow(true);
		this.setShadowOffset(3);

		this.setShadowSoftness(10);				
		this.setBodyColor(GuiStyles.VWR_BG_COLOR);

		final ViewerImpl self = this;		

		this.addCloseClickHandler(new CloseClickHandler() {
			public void onCloseClick(CloseClickEvent event) {
				self.destroy();				
			}			
		});

		this.centerInPage();
		this.draw();
		
	}

	/**
	 * Create body element
	 * 
	 * @param canvas
	 * @return
	 */
	protected VLayout createBody(Canvas canvas) {

		VLayout vLayout = new VLayout();
		vLayout.setStyleName(GuiStyles.X_BD_STYLE_2);

		vLayout.setWidth100();		
		vLayout.setHeight100();
		
		vLayout.addMember(canvas);
		return vLayout;
		
	}

	/**
	 * Create headline element
	 * 
	 * @param title
	 * @param slogan
	 * @return
	 */
	protected VLayout createHeadline(String title, String slogan) {
		return GUIBaseFactory.createHeadline(title, slogan);
	}

}
