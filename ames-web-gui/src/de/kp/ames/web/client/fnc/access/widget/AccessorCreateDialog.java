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

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.access.AccessService;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class AccessorCreateDialog extends CreateFormDialog {
	
	/**
	 * Constructor
	 */
	public AccessorCreateDialog(Grid grid) {
		super(FncGlobals.ACCESSOR_C_TITLE, FncGlobals.ACCESSOR_C_SLOGAN);		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new AccessorFormImpl();
		this.form.addFormHandler(this);

		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {

		String data = this.form.getFormData();
		
		AccessService service = new AccessService();
		service.doSubmit(data, this.sendActivity);

		/*
		 * REMARK: This is a remote grid; the after submit
		 * activity is used to reload the content of the grid
		 */
		
	}	
	
}
