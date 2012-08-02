package de.kp.ames.web.client.fnc.transform.widget;
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

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.transform.TransformService;
import de.kp.ames.web.client.fnc.transform.event.TransformEventManager;
import de.kp.ames.web.client.fnc.transform.event.TransformListener;

/*
 * This dialog is used to register a new transformator that
 * already exists as a cache entry on the server side
 */
public class TransformCreateDialog extends CreateFormDialog {

	public TransformCreateDialog() {
		super(FncGlobals.TRANSFORM_C_TITLE, FncGlobals.TRANSFORM_C_SLOGAN);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new TransformFormImpl();
		this.form.addFormHandler(this);

		/*
		 * Register as transform listener
		 */
		TransformEventManager.getInstance().addTransformListener((TransformListener)this.form);
		
		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {

		/*
		 * Retrieve and validate form data
		 */
		String data = this.form.getFormData();
		if (data == null) {
			
			String message = FncGlobals.FORM_ERROR;
			SC.say(GUIGlobals.APP_TITLE + ": Form Error", message);		
			
			return;

		}

		new TransformService().doSubmit(data, this.sendActivity);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#beforeRemove()
	 */
	public void beforeRemove() {
		/*
		 * Unregister transform listener
		 */
		TransformEventManager.getInstance().removeTransformListener((TransformListener)this.form);
		
	}	

}