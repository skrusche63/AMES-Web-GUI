package de.kp.ames.web.client.fnc.group.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.group.widget
 *  Module: GroupCategoryDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #category #client #dialog #fnc #group #web #widget
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.client.core.widget.dialog.ApplyGridDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.group.GroupService;
import de.kp.ames.web.client.fnc.group.data.CategoryGridImpl;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class GroupCategoryDialog extends ApplyGridDialog {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 480;
	private static int HEIGHT = 480;

	public GroupCategoryDialog(GridImpl grid) {
		super(FncGlobals.CATEGORY_E_TITLE, FncGlobals.CATEGORY_E_SLOGAN, grid);
		
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

		this.redraw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.GridDialog#doSend()
	 */
	public void doSend() {

		Record selected = this.grid.getSelectedRecord();
		if (selected == null) {

			String message = FncGlobals.CATEGORY_ERROR;
			SC.say(GuiConstants.APP_TITLE + ": Category Error", message);		

			this.setAutoClose(false);
			return;
		
		}
		
		this.setAutoClose(true);

		/*
		 * Retrieve category
		 */
		String cate = selected.getAttributeAsString(JaxrConstants.RIM_ID);
		
		JSONObject jData = new JSONObject();
		jData.put(JaxrConstants.RIM_CATE, new JSONString(cate));
		
		String data = jData.toString();

		/*
		 * Request specific parameters
		 */
		// String type = this.getParam(MethodConstants.ATTR_TYPE);
		
		String item = this.getParam(MethodConstants.ATTR_ITEM);;
		String type = ClassificationConstants.FNC_ID_Category;
		new GroupService().doSubmit(type, item, data, this.sendActivity);
		
	}

	/**
	 * @param attributes
	 * @param activity
	 */
	public static void create(HashMap<String,String> attributes, Activity activity) {
		
		String item = attributes.get(MethodConstants.ATTR_ITEM);
		CategoryGridImpl grid = new CategoryGridImpl(item);
	
		GroupCategoryDialog dialog = new GroupCategoryDialog(grid);
		
		/*
		 * Provide request specific information
		 */
		dialog.setParams(attributes);
		dialog.addSendActivity(activity);
		
	}
	
}
