package de.kp.ames.web.client.fnc.product.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.product.widget
 *  Module: ProductorApplyDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #apply #client #dialog #fnc #product #productor #web #widget
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

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.widget.dialog.ApplyFormDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.product.ProductService;
import de.kp.ames.web.shared.constants.MethodConstants;

public class ProductorApplyDialog extends ApplyFormDialog {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 525;
	private static int HEIGHT = 675;

	/**
	 * Constructor
	 */
	public ProductorApplyDialog() {
		super(FncGlobals.PRODUCTOR_A_TITLE, FncGlobals.PRODUCTOR_C_SLOGAN);
		
		this.setTitle(FncGlobals.ADF_ENGINE);
		
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
		 * The Productor Engine is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

		this.redraw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new ProductorApplyFormImpl(FormAction.CREATE);
		this.form.addFormHandler(this);

		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {

		/*
		 * Prepare data
		 */
		String source = ((ProductorApplyFormImpl)this.form).getSource();
		if (source == null) {

			String message = FncGlobals.NAMESPACE_ERROR;
			SC.say(GuiConstants.APP_TITLE + ": Productor Error", message);		

			this.setAutoClose(false);
			return;
		
		}
		
		HashMap<String,String> attributes = this.getParams();
		attributes.put(MethodConstants.ATTR_SOURCE, source);
		
		String data = this.form.getFormData();
		
		this.setAutoClose(true);
		new ProductService().doApply(attributes, data, this.sendActivity);

	}	

	/**
	 * @param attributes
	 * @param name
	 * @param desc
	 * @param afterSendActivity
	 */
	public  static void create(HashMap<String,String> attributes, String name, String desc, Activity afterSendActivity) {
		
		/*
		 * Create dialog
		 */
		ProductorApplyDialog dialog = new ProductorApplyDialog();
		
		/*
		 * Provide request specific information
		 */
		dialog.setParams(attributes);
		dialog.addSendActivity(afterSendActivity);
	
	}

}
