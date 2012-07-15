package de.kp.ames.web.client.function.bulletin;
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

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.function.globals.FncGlobals;
import de.kp.ames.web.shared.ClassificationConstants;
import de.kp.ames.web.shared.MethodConstants;

public class BulletinWidget {

	/**
	 * Constructor
	 */
	public BulletinWidget() {		
	}

	/**
	 * Create comment or posting
	 * 
	 * @param attributes
	 * @param data
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Record record, Activity activity) {

		String type = attributes.get(MethodConstants.ATTR_TYPE);
				
		if (type.equals(ClassificationConstants.FNC_ID_Comment)) {
		
			String title  = FncGlobals.COMMENT_TITLE;
			String slogan = FncGlobals.COMMENT_SLOGAN;
			
			// TODO record
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Posting)) {

			String title  = FncGlobals.POSTING_TITLE;
			String slogan = FncGlobals.POSTING_SLOGAN;

			// TODO record
		}
	}

}
