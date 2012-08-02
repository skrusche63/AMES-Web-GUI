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

import java.util.HashMap;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.client.core.widget.dialog.ApplyGridDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class ProductorApplyDialog extends ApplyGridDialog {

	/**
	 * Constructor
	 */
	public ProductorApplyDialog(GridImpl grid) {
		super(FncGlobals.PRODUCTOR_A_TITLE, FncGlobals.PRODUCTOR_C_SLOGAN, grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {

		// TODO
		
		/*
		 * Request specific parameters
		 */
//		String source  = this.form.getParam(MethodConstants.ATTR_SOURCE);
//		String service = this.form.getParam(MethodConstants.ATTR_SERVICE);
//
//		new ProductService().doApply(source, service, data, this.sendActivity);

	}	

	/**
	 * @param attributes
	 * @param name
	 * @param desc
	 * @param afterSendActivity
	 */
	public  static void create(HashMap<String,String> attributes, String name, String desc, Activity afterSendActivity) {
	
		GridImpl grid = null;
		
		/*
		 * Create dialog
		 */
		ProductorApplyDialog dialog = new ProductorApplyDialog(grid);
		
		/*
		 * Provide request specific information
		 */
		dialog.setParams(attributes);
		dialog.addSendActivity(afterSendActivity);
	
	}

}
