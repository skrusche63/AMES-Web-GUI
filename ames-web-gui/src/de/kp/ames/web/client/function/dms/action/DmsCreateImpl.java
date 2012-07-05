package de.kp.ames.web.client.function.dms.action;
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
import de.kp.ames.web.client.function.dms.DmsWidget;

/*
 * This action registers an already existing and transient document (cache) 
 * in an OASIS ebXML RegRep
 */
public class DmsCreateImpl extends GridCreateImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public DmsCreateImpl(Grid grid) {	
		super(grid);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {
		/*
		 * Prepare data for create request
		 */
		HashMap<String,String> attributes = this.getParams();

		/*
		 * Invoke create request
		 */
		final DmsCreateImpl self = this;
		
		DmsWidget widget = new DmsWidget();
		widget.doCreate(attributes, new ActivityImpl() {

			public void execute(JSONValue jValue) {
				self.doAfterCreate(jValue);
			}
			
		});

	}

}