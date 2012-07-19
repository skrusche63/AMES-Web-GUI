package de.kp.ames.web.client.function.bulletin.action;
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
import de.kp.ames.web.client.action.grid.GridGetAllImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.function.bulletin.BulletinWidget;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;

public class CommentGetAllImpl extends GridGetAllImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public CommentGetAllImpl(Grid grid, Record record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Comment);
		
		BulletinWidget widget = new BulletinWidget();
		widget.doGet(attributes, record);
		
	}

}
