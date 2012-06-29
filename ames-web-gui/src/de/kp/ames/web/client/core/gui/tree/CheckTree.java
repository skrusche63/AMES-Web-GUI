package de.kp.ames.web.client.core.gui.tree;
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

import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.events.DataArrivedEvent;
import com.smartgwt.client.widgets.tree.events.DataArrivedHandler;

public class CheckTree extends TreeGrid {

	/*
	 * Field
	 */
	protected String TITLE = "Name";
	
	/*
	 * Style
	 */
	protected String BASE_STYLE = "noBorderCell";
	
	public CheckTree() {
		/*
		 * Configure check tree
		 */
	    config();
	    
	    /*
	     * Event handling
	     */
	    final CheckTree self = this;
	    
	    this.addDataArrivedHandler(new DataArrivedHandler() {  
	        public void onDataArrived(DataArrivedEvent event) {  
	            self.afterDataArrived(event);  
	        }  
	    });  
	 	    
	}
	
	/**
	 * Set configuration for CheckTree
	 */
	protected void config() {
		/*
		 * Checkbox appearance
		 */
		this.setSelectionAppearance(SelectionAppearance.CHECKBOX); 
		
		/*
		 * Connectors
		 */
		this.setShowConnectors(true);

		/*
		 * Set base style
		 */
	    this.setBaseStyle(BASE_STYLE);  

	    /*
	     * Set title field
	     */
	    this.setFields(new TreeGridField(TITLE)); 
	    
	    /*
	     * By default no <open> or <drop>
	     * icons are supported
	     */
	    this.setShowOpenIcons(false);  
	    this.setShowDropIcons(false);  
	    
	    this.setClosedIconSuffix(""); 
	}

	/**
	 * @param event
	 */
	protected void afterDataArrived(DataArrivedEvent event) {
		// Must be overridden
	}

}
