package de.kp.ames.web.client.fnc.bulletin;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.bulletin
 *  Module: BulletinController
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #bulletin #client #controller #fnc #web
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

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.util.JsonConverter;
import de.kp.ames.web.client.fnc.bulletin.data.CommentGridImpl;
import de.kp.ames.web.client.fnc.bulletin.widget.CommentsViewer;
import de.kp.ames.web.client.fnc.bulletin.widget.MessageImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class BulletinController {

	/**
	 * Constructor
	 */
	public BulletinController() {		
	}

	/**
	 * Create comment or posting
	 * 
	 * @param attributes
	 * @param data
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Record record, Activity activity) {

		String title  = null;
		String slogan = null;
		
		String type = attributes.get(MethodConstants.ATTR_TYPE);
				
		JSONValue jValue = null;
		
		if (type.equals(ClassificationConstants.FNC_ID_Comment)) {
		
			title  = FncGlobals.COMMENT_TITLE;
			slogan = FncGlobals.COMMENT_SLOGAN;
			
			String[] keys = {
					JaxrConstants.RIM_ID,
					JaxrConstants.RIM_SUBJECT
				};
				
				jValue = JsonConverter.recordToJson(record, keys);
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Posting)) {

			title  = FncGlobals.POSTING_TITLE;
			slogan = FncGlobals.POSTING_SLOGAN;

			String[] keys = {
				JaxrConstants.RIM_ID,
				JaxrConstants.RIM_NAME
			};
			
			jValue = JsonConverter.recordToJson(record, keys);
			

		}

		MessageImpl messageDialog = new MessageImpl(title, slogan, type, jValue);

		/*
		 * Provide request specific information
		 */
		messageDialog.setParams(attributes);
		messageDialog.addSendActivity(activity);

	}

	/**
	 * Get comments
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(final HashMap<String,String> attributes, final Record record) {

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Comment)) {

			String posting = record.getAttributeAsString(JaxrConstants.RIM_ID);
			CommentGridImpl grid = new CommentGridImpl(posting);

			new CommentsViewer(grid);
			
		}

	}

}
