package de.kp.ames.web.client.core.gui.base;
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

import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
import com.smartgwt.client.widgets.events.VisibilityChangedEvent;
import com.smartgwt.client.widgets.events.VisibilityChangedHandler;
import com.smartgwt.client.widgets.menu.Menu;

import de.kp.ames.web.client.core.gui.globals.GUIStyles;

public class ControlLabel extends Label {

	/* 
	 * Indicator to describe whether this label
	 * has been clicked (selected) or even not
	 */

	private boolean selected = false;

	private static String STYLE      = GUIStyles.X_CONTROL;
	private static String STYLE_OVER = GUIStyles.X_CONTROL_OVER;
	
	public ControlLabel(String text) {
		super(text);
	
		setStyleName(STYLE);
	
		final ControlLabel self = this;
		addMouseOverHandler(new MouseOverHandler() {
			public void onMouseOver(MouseOverEvent event) {
				self.setStyleName(STYLE_OVER);
				self.redraw();
			}			
		});
		
		addMouseOutHandler(new MouseOutHandler() {
			public void onMouseOut(MouseOutEvent event) {
				
				if (selected == true) return;
				
				self.setStyleName(STYLE);
				self.redraw();
				
			}			
		});

	}

	public Menu getMenu() {
		
		Menu menu = new Menu();
		
		final ControlLabel self = this;
		/* 
		 * This handler is invoked after ESC is pressed or the mouse
		 * is clicked outside the menu panel; in this case, the control
		 * must be informed to remove its selected status
		 */
		menu.addVisibilityChangedHandler(new VisibilityChangedHandler() {
			public void onVisibilityChanged(VisibilityChangedEvent event) {
				if (event.getIsVisible() == false) self.setSelected(false);				
			}			
		});
		
		return menu;
		
	}
	
	/**
	 * Toogle CSS style
	 * 
	 * @param selected
	 */
	public void setSelected(boolean selected) {

		this.selected = selected;
		
		if (this.selected == true)
			this.setStyleName(STYLE_OVER);
		
		else
			this.setStyleName(STYLE);
		
		this.redraw();
		
	}
}
