package de.kp.ames.web.client.fnc.access.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.access.widget
 *  Module: AccessorGetViewer
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #access #accessor #client #fnc #get #viewer #web #widget
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
import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class AccessorGetViewer extends ViewerImpl {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 530;
	private static int HEIGHT = 630;

	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public AccessorGetViewer(Canvas body) {
		super(FncGlobals.ACCESS_G_TITLE, FncGlobals.ACCESS_G_SLOGAN, body);
		
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
		
		/*
		 * The Comm Viewer is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

		this.draw();

	}
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 * @param body
	 */
	public AccessorGetViewer(String title, String slogan, Canvas body) {
		super(title, slogan, body);
	}
	
	/**
	 * @param attributes
	 * @param jValue
	 */
	public static void create(HashMap<String,String> attributes, JSONValue jValue) {
		
		AccessorFormImpl form = new AccessorFormImpl(FormAction.GET);
		
		form.addFormData(jValue);	
		form.setParams(attributes);
		
		new AccessorGetViewer(form);

	}
	
}
