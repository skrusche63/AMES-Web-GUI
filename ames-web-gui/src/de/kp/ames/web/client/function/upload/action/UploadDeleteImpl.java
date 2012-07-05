package de.kp.ames.web.client.function.upload.action;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.action.grid.GridDeleteImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.function.upload.UploadWidget;

public class UploadDeleteImpl extends GridDeleteImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public UploadDeleteImpl(Grid grid, ListGridRecord record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {
		
		HashMap<String,String> attributes = this.getParams();

		final UploadDeleteImpl self = this;
		
		UploadWidget widget = new UploadWidget();
		widget.doDelete(attributes, record, new ActivityImpl() {

			public void execute(JSONValue jValue) {
				self.doAfterDelete(jValue);		
			}
			
		});
		
	}

}