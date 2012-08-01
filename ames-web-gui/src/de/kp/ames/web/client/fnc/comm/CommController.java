package de.kp.ames.web.client.fnc.comm;
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

import de.kp.ames.web.client.fnc.comm.widget.CommFormImpl;
import de.kp.ames.web.client.fnc.comm.widget.CommViewer;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class CommController {

	/**
	 * Constructor
	 */
	public CommController() {	
	}
	
	/**
	 * View communication object
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doView(HashMap<String,String> attributes, Record record) {

		/*
		 * The comm form is independent of
		 * the actualy comm object
		 */
		CommFormImpl form = new CommFormImpl();
		form.addFormData(record);

		CommViewer viewer = new CommViewer(form);

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Chat)) {
			viewer.setTitle(FncGlobals.COMM_V_CHAT);
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Mail)) {
			viewer.setTitle(FncGlobals.COMM_V_MAIL);

		}
		
	}

}
