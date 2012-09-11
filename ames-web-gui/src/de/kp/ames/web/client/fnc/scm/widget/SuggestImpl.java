package de.kp.ames.web.client.fnc.scm.widget;
/**
 * Copyright 2012. All rights reserved by Dr. Krusche & Partner PartG
 * Please contact: team@dr-kruscheundpartner.de
 */

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.fnc.scm.control.SuggestController;
import de.kp.ames.web.client.fnc.scm.data.SuggestGridImpl;

public class SuggestImpl extends VLayout {
	
	private SuggestGridImpl grid;
	
	/**
	 * Constructor depends on search query 
	 * 
	 * @param query
	 */
	public SuggestImpl(String query) {

		this.setWidth(GuiConstants.SCM_SUGGEST_WIDTH);
		// height will be set dynamic in relation to rootpanel height
		this.setHeight(GuiConstants.SCM_SUGGEST_HEIGHT);

		/*
		 * This is an essential feature to ensure
		 * proper scrollbars, i.e vertical ones only
		 */
		this.setOverflow(Overflow.HIDDEN);

		/*
		 * Build ToolStrip
		 */
		ToolStrip toolStrip = createToolStrip();

		
		/*
		 * Build Grid
		 */
		grid = new SuggestGridImpl(query);
	
		this.setMembers(toolStrip, grid);
		
	};

	/**
	 * Create ToolStrip element
	 * 
	 * @param url
	 * @param params
	 * @param fields
	 * @return
	 */
	private ToolStrip createToolStrip() {

		ToolStrip ts = new ToolStrip();
//		ts.setStyleName("x-searchbox");

		ts.setWidth100();
		ts.setHeight(25);
		ts.addFill();

        ImgButton closeButton = new ImgButton();  
        closeButton.setSize(16);  
        closeButton.setShowRollOver(true);  
        closeButton.setSrc("[SKIN]/headerIcons/close.png");  
        closeButton.setActionType(SelectionType.BUTTON);
        closeButton.setTooltip("Close suggestions");
        closeButton.setAltText("Close suggestions");
        
        closeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.logWarn("====> SuggestImpl.closeButton.onClick");
				SuggestController.getInstance().removeSuggestor();

			}
		});
		
		
        ts.addMember(closeButton);  
		return ts;

	}

	
	/*
	 * focus moves from SearchBox to SuggestGrid
	 */
	public void focusToSuggestGrid() {

		SC.logWarn("====> SuggestImpl.focusToSuggestGrid");

		grid.focusToSuggestGrid();
	}


	private int getDrawnHeight() {
		Integer[] visibleRows = grid.getVisibleRows();
		
		SC.logWarn("====> grid visibleRows: " + visibleRows[0] + " : " + visibleRows[1]);
		
		int visibleHeight = 0; 
		for (int visibleRow = visibleRows[0]; visibleRow <= visibleRows[1]; visibleRow++) {
			visibleHeight += grid.getDrawnRowHeight(visibleRow);
		}
		return visibleHeight;
	}
	/*
	 * dynamic calculated new height
	 */
	public void setHeightTo(int h) {

//		grid.setMaxHeight(h);
		int drawnHeight = getDrawnHeight();
		SC.logWarn("====> grid drawnHeight: " + drawnHeight);
		if (drawnHeight < GuiConstants.SCM_SUGGEST_HEIGHT) {
			this.setHeight(drawnHeight);
		}
	}

}
