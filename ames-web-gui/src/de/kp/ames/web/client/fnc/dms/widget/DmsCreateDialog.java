package de.kp.ames.web.client.fnc.dms.widget;
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

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.dms.DmsService;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.shared.constants.MethodConstants;

public class DmsCreateDialog extends CreateFormDialog {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 530;
	private static int HEIGHT = 630;
	
	/**
	 * Constructor
	 */
	public DmsCreateDialog() {
		super(FncGlobals.DMS_C_TITLE, FncGlobals.DMS_C_SLOGAN);
		
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

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new DmsFormImpl(FormAction.CREATE);
		this.form.addFormHandler(this);

		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {

		String data = this.form.getFormData();

		/*
		 * Request specific parameters
		 */
		String type  = this.getParam(MethodConstants.ATTR_TYPE);
		new DmsService().doSubmit(type, data, this.sendActivity);

	}

	/**
	 * @param attributes
	 * @param afterSendActivity
	 */
	public static void create(HashMap<String,String> attributes, Activity afterSendActivity) {
		
		/*
		 * Create dialog
		 */
		DmsCreateDialog createDialog = new DmsCreateDialog();
		
		/*
		 * Provide request specific information
		 */
		createDialog.setParams(attributes);
		createDialog.addSendActivity(afterSendActivity);
		
	}

}