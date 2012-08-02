package de.kp.ames.web.client.fnc.product.widget;

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class ProductorGetViewer extends ViewerImpl {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 530;
	private static int HEIGHT = 630;

	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public ProductorGetViewer(Canvas body) {
		super(FncGlobals.PRODUCTOR_G_TITLE, FncGlobals.PRODUCTOR_G_SLOGAN, body);
		
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
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 * @param body
	 */
	public ProductorGetViewer(String title, String slogan, Canvas body) {
		super(title, slogan, body);
	}
	
	/**
	 * @param attributes
	 * @param jValue
	 */
	public static void create(HashMap<String,String> attributes, JSONValue jValue) {
		
		ProductorFormImpl form = new ProductorFormImpl(FormAction.GET);
		
		form.addFormData(jValue);	
		form.setParams(attributes);
		
		new ProductorGetViewer(form);

	}

}
