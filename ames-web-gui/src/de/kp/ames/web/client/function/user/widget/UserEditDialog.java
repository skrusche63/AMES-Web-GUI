package de.kp.ames.web.client.function.user.widget;
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

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.dialog.EditFormDialog;
import de.kp.ames.web.client.function.user.UserService;

public class UserEditDialog extends EditFormDialog {

	private static String TITLE  = GUIGlobals.APP_TITLE + ": User Editor";;
	private static String SLOGAN = "Use this widget to edit a certain user.";
	
	/**
	 * Constructor
	 * 
	 * @param jValue
	 */
	public UserEditDialog(JSONValue jValue) {
		super(TITLE, SLOGAN, jValue);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new UserFormImpl();
		this.form.addFormHandler(this);

		this.form.addFormData(this.jValue);		
		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSubmit() {

		String data = this.form.getFormData();
		
		UserService service = new UserService();
		service.doSubmit(data, this.afterSubmitActivity);

	}

}
