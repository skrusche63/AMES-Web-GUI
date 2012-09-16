package de.kp.ames.web.client.fnc.scm.widget;
/**
 * Copyright 2012. All rights reserved by Dr. Krusche & Partner PartG
 * Please contact: team@dr-kruscheundpartner.de
 */

import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

import de.kp.ames.web.client.fnc.scm.control.SuggestController;

public class SearchWidget extends VLayout {

	private TextItem searchBox;

	/*
	 * The query string sent to the search service
	 */
	private String query;
	
	/*
	 * Absolute position of search widget
	 */
	private int x;
	private int y;

	/*
	 * Predefined dimensions
	 */
	private static int SEARCHBOX_WIDTH = 360;

	private static int WIDGET_WIDTH = 440;
	private static int WIDGET_HEIGHT = 28;

	/**
	 * Constructor
	 */
	public SearchWidget() {

		calculateCenterPosition();
		setupWidget();

	}

	private void setupWidget() {

		/*
		 * Appearance & Dimensions
		 */
		this.setWidth(WIDGET_WIDTH);
		this.setHeight(WIDGET_HEIGHT);


		this.addMember(createToolStrip());

		RootPanel root = RootPanel.get();
		root.add(this);
		/*
		 * initial draw
		 */
		this.draw();

		/*
		 * Locate widget and redraw
		 */
		setWidget();
		
	}

	/**
	 * Calculate center position
	 */
	private void calculateCenterPosition() {
		/*
		 * The search widget is applied to the root panel, i.e. it is position
		 * on the viewport with respect to the offset position defined
		 */
		RootPanel root = RootPanel.get();

		x = (int) (0.5 * (root.getOffsetWidth() - WIDGET_WIDTH));
		y = 34; 

	}

	/**
	 * Set the search query
	 * 
	 * @param query
	 */
	public void setQuery(String query) {

		this.query = query;
		/*
		 * This invoke a change event
		 */
		this.searchBox.setValue(this.query);

	}

	/**
	 * @param event
	 */
	public void afterResized(ResizedEvent event) {
		
		/*
		 * Locate widget
		 */
		setWidget();

		/*
		 * Locate suggestor
		 */
		int x = this.getAbsoluteLeft() + 39;
		int y = this.getAbsoluteTop()  - 14;

		SuggestController.getInstance().moveSuggestorTo(x, y);
		
	}

	
	public void moveToTop() {
		
		this.setWidget();
	}
	
	/**
	 * Locate widget, reposition and redraw
	 */
	private void setWidget() {

		calculateCenterPosition();
		
		this.moveTo(x, y);
		this.redraw();

	}
	
	/**
	 * @param url
	 * @param params
	 * @param fields
	 * @return
	 */
	private ToolStrip createToolStrip() {

		ToolStrip ts = new ToolStrip();
		ts.setStyleName("x-searchbox");

		ts.setWidth100();
		ts.setHeight(WIDGET_HEIGHT);

		searchBox = new TextItem();

		searchBox.setTitle("<b>search</b>:");
		searchBox.setWidth(SEARCHBOX_WIDTH);


		searchBox.addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				afterChanged(event);
			}
		});
		
		searchBox.addKeyPressHandler(new KeyPressHandler() {
			public void onKeyPress(KeyPressEvent event) {

				String keyName = event.getKeyName();
				if (keyName.equals("Arrow_Down")) {
					
					SuggestController.getInstance().focusToSuggestGrid();
				}				
			}
			
		});
		
		/*
		 * A dynamic form is used as a wrapper to get the search box centered in
		 * height
		 */

		DynamicForm form = new DynamicForm();
		form.setAutoFocus(true);

		form.setTitleSuffix(""); // default ":"
		form.setWidth100();

		form.setMargin(3);
		form.setFields(searchBox);

		ts.addMember(form);
		return ts;

	}

	/**
	 * A helper method to create suggestor from TextItem value
	 * 
	 * @param event
	 */
	private void afterChanged(ChangedEvent event) {
		
		/*
		 * Retrieve search query from text item
		 */
		TextItem item = (TextItem) event.getItem();
		String val = item.getValueAsString();

		/*
		 * Do no term suggest in case of empty value
		 */
		if (val == null || val.length() == 0 )
			return;

		/*
		 * build suggestor
		 */

		int x = this.getAbsoluteLeft() + 39;
		int y = this.getAbsoluteTop()  - 14;

		SuggestController.getInstance().createSuggestor(x,y, val);

	}

	
	/*
	 * Set focus back to TextWidget
	 */
	public void focusToSearchBox() {

		searchBox.focusInItem();
		
	}

}
