package de.kp.ames.web.client.fnc.access.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.access.widget
 *  Module: AccessorEditDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #access #accessor #client #dialog #edit #fnc #web #widget
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

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.widget.dialog.EditFormDialog;
import de.kp.ames.web.client.fnc.access.AccessService;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class AccessorEditDialog extends EditFormDialog {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 525;
	private static int HEIGHT = 640;

	/**
	 * Constructor
	 * 
	 * @param jValue
	 */
	public AccessorEditDialog(JSONValue jValue) {
		super(FncGlobals.ACCESS_E_TITLE, FncGlobals.ACCESS_E_SLOGAN, jValue);
		
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
		 * The Accessor Editor is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

		this.draw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new AccessorFormImpl(FormAction.EDIT);
		this.form.addFormHandler(this);

		this.form.addFormData(jValue);
		return this.form;
		
	}

	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSend()
	 */
	public void doSend() {

		String data = this.form.getFormData();
		HashMap<String,String> attributes = new HashMap<String,String>();

		AccessService service = new AccessService();
		service.doSubmit(attributes, data, this.sendActivity);

		/*
		 * REMARK: This is a remote grid; the after submit
		 * activity is used to reload the content of the grid
		 */

	}	
	
	/**
	 * @param attributes
	 * @param jValue
	 * @param afterSendActivity
	 */
	public  static void create(HashMap<String,String> attributes, JSONValue jValue, Activity afterSendActivity) {
	
		/*
		 * Create dialog
		 */
		AccessorEditDialog dialog = new AccessorEditDialog(jValue);
		
		/*
		 * Provide request specific information
		 */
		dialog.setParams(attributes);
		dialog.addSendActivity(afterSendActivity);
	
	}
	
}
