package de.kp.ames.web.client.fnc.access.action;
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

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;

import de.kp.ames.web.client.action.grid.GridCreateImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.access.AccessWidget;

public class AccessorCreateImpl extends GridCreateImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public AccessorCreateImpl(Grid grid) {	
		super(grid);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();

		final AccessorCreateImpl self = this;
		AccessWidget widget = new AccessWidget();

		widget.doCreate(attributes, grid, new ActivityImpl() {
			
			/* (non-Javadoc)
			 * @see de.kp.ames.web.client.core.activity.ActivityImpl#execute(com.google.gwt.json.client.JSONValue)
			 */
			public void execute(JSONValue jValue) {
				self.doAfterCreate(jValue);
			}
			
		});
	}

}
