package de.kp.ames.web.client.fnc.dms.action;
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

import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.action.grid.GridDownloadImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.widget.base.ActionIndicator;
import de.kp.ames.web.client.fnc.dms.DmsController;

public class DmsDownloadImpl extends GridDownloadImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public DmsDownloadImpl(Grid grid, Record record) {
		super(grid, record);
	}

	public void execute() {

		/*
		 * Open action indicator
		 */
		ActionIndicator.getInstance().open("Downloading...");

		HashMap<String,String> attributes = this.getParams();
		final DmsDownloadImpl self = this;
		
		DmsController controller = new DmsController();
		controller.doDownload(attributes, record, new ActivityImpl() {

			public void execute() {
				self.doAfterDownload();				
			}
			
		});

	}

	/**
	 * After download action
	 */
	private void doAfterDownload() {
		
		/*
		 * Reset action indicator
		 */
		ActionIndicator.getInstance().reset();
		
	}
	
}
