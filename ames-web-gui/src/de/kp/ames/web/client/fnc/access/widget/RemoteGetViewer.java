package de.kp.ames.web.client.fnc.access.widget;
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
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;

import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;
import de.kp.ames.web.client.fnc.access.AccessService;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.client.model.remote.DatabaseObject;
import de.kp.ames.web.client.model.remote.DavObject;
import de.kp.ames.web.client.model.remote.ImapObject;
import de.kp.ames.web.core.util.FileUtil;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class RemoteGetViewer extends ViewerImpl {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 640;
	private static int HEIGHT = 600;
	

	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public RemoteGetViewer(Canvas body) {
		super(FncGlobals.REMOTE_G_TITLE, FncGlobals.REMOTE_G_SLOGAN, body);
		
		/*
		 * Button handling
		 */
		this.setShowCloseButton(true);
		this.setShowMinimizeButton(true);
		
		/*
		 * Set dimensions
		 */
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);

		this.draw();

	}
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 * @param body
	 */
	public RemoteGetViewer(String title, String slogan, Canvas body) {
		super(title, slogan, body);
		
		/*
		 * Button handling
		 */
		this.setShowCloseButton(true);
		this.setShowMinimizeButton(true);
		
		/*
		 * Set dimensions
		 */
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);

		this.draw();

	}

	/**
	 * @param attributes
	 * @param jValue
	 */
	public static void create(HashMap<String,String> attributes, Record record) {
		
		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Database)) {
			/*
			 * View a single database entry
			 */
	 		// TODO
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Mail)) {
	
			boolean hasAttachment = record.getAttributeAsBoolean(JsonConstants.J_ATTACHMENT);
			if (hasAttachment) {
				/*
				 * Show attachment
				 */
				attributes.put(MethodConstants.ATTR_FORMAT, FormatConstants.FNC_FORMAT_ID_File);
				attributes.put(MethodConstants.ATTR_SOURCE, record.getAttributeAsString(JsonConstants.J_ID));
				
				String uri = new AccessService().getUri(attributes);
				
				/*
				 * Build html pane
				 */
				HTMLPane pane = new HTMLPane();
			    pane.setShowEdges(false);
			    
			    pane.setContentsURL(uri);
			    pane.setContentsType(ContentsType.PAGE);

			    new RemoteGetViewer(pane);
				
				
			} else {
				/*
				 * Show HTML Message
				 */
				attributes.put(MethodConstants.ATTR_FORMAT, FormatConstants.FNC_FORMAT_ID_Html);
				attributes.put(MethodConstants.ATTR_SOURCE, record.getAttributeAsString(JsonConstants.J_ID));
				
				String uri = new AccessService().getUri(attributes);
				
				/*
				 * Build html pane
				 */
				HTMLPane pane = new HTMLPane();
			    pane.setShowEdges(false);
			    
			    pane.setContentsURL(uri);
			    pane.setContentsType(ContentsType.PAGE);

			    new RemoteGetViewer(pane);

			}
			
		} else if (type.equals(ClassificationConstants.FNC_ID_WebDav)) {
			
			/*
			 * Distinguish between folder & file entry
			 */
			boolean isFolder = record.getAttributeAsBoolean(JsonConstants.J_IS_FOLDER);
			if (isFolder == true) {
				
				/*
				 * A WebDAV folder is actually not supported
				 */
				String html = "<div style=\"padding:16px;font-size:14px;\">A WebDAV folder is no supported by this wigdet.</div>";
				
				/*
				 * Build Html Pane
				 */
				HTMLPane pane = new HTMLPane();
			    pane.setShowEdges(false);

			    pane.setContents(html);			
				new RemoteGetViewer(pane);
				
			} else {				
				/*
				 * View a single webdav file
				 */
				String uri = record.getAttributeAsString(JsonConstants.J_URI);
				
				/*
				 * Build html pane
				 */
				HTMLPane pane = new HTMLPane();
			    pane.setShowEdges(false);
			    
			    pane.setContentsURL(uri);
			    pane.setContentsType(ContentsType.PAGE);

			    new RemoteGetViewer(pane);
				
			}
			
		}

	}

}
