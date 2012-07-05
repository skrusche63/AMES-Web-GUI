package de.kp.ames.web.client.function.dms.widget;
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

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.function.dms.DmsService;
import de.kp.ames.web.shared.MethodConstants;

public class DmsCreateDialog extends CreateFormDialog {

	private static String TITLE  = GUIGlobals.APP_TITLE + ": Dms Editor";
	private static String SLOGAN = "Use this widget to create a Dms entry.";
	
	/**
	 * Constructor
	 */
	public DmsCreateDialog() {
		super(TITLE, SLOGAN);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new DmsFormImpl();
		this.form.addFormHandler(this);

		this.form.addFormData(this.jValue);		
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
		String type  = this.form.getParam(MethodConstants.ATTR_TYPE);
		new DmsService().doSubmit(type, data, this.sendActivity);

	}

}