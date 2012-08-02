package de.kp.ames.web.client.fnc.group.widget;

import java.util.HashMap;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.client.core.widget.dialog.ApplyGridDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.group.data.CategoryGridImpl;
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

		this.draw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.GridDialog#doSend()
	 */
	public void doSend() {
		// TODO
	}

	/**
	 * @param attributes
	 * @param activity
	 */
	public static void create(HashMap<String,String> attributes, Activity activity) {
		
		String item = attributes.get(MethodConstants.ATTR_ITEM);
		CategoryGridImpl grid = new CategoryGridImpl(item);
	
		new GroupCategoryDialog(grid);
		
	}
	
}
