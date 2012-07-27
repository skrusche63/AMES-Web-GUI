package de.kp.ames.web.client.fnc.product.widget;
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
import de.kp.ames.web.client.core.widget.dialog.ApplyFormDialog;
import de.kp.ames.web.client.fnc.product.ProductService;
import de.kp.ames.web.shared.constants.MethodConstants;

public class ProductorApplyDialog extends ApplyFormDialog {

	private static String TITLE  = GUIGlobals.APP_TITLE + ": Productor Engine";;
	private static String SLOGAN = "Use this widget to apply a certain productor.";

	/**
	 * Constructor
	 */
	public ProductorApplyDialog() {
		super(TITLE, SLOGAN);
	}
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new ProductorApplyFormImpl();
		this.form.addFormHandler(this);

		this.form.addFormData(this.jValue);		
		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {

		/*
		 * Form data
		 */
		String data = this.form.getFormData();
		
		/*
		 * Request specific parameters
		 */
		String source  = this.form.getParam(MethodConstants.ATTR_SOURCE);
		String service = this.form.getParam(MethodConstants.ATTR_SERVICE);

		new ProductService().doApply(source, service, data, this.sendActivity);

	}	

}
