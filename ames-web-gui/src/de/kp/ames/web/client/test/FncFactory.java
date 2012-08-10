package de.kp.ames.web.client.test;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test
 *  Module: FncFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #factory #fnc #test #web
 * </SemanticAssist>
 *
 */


import java.util.LinkedHashMap;

import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.style.GuiStyles;

public class FncFactory {
	
	/**
	 * A common helper method to start a certain dialog
	 * 
	 * @param message
	 * @param scAction
	 * @return
	 */
	public static VLayout createDialog(final String message, final ScAction scAction) {
		return createDialog(message, "Show Dialog", scAction);
	}

	/**
	 * @param message
	 * @param title
	 * @param scAction
	 * @return
	 */
	public static VLayout createDialog(final String message, final String title, final ScAction scAction) {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = new HTMLPane();
        pane.setStyleName(GuiStyles.X_SC_TEASER);
        
        pane.setContents(message);
        pane.setHeight(40);

        /*
         * Canvas
         */
        Canvas canvas = new Canvas();
        canvas.setMargin(24);
        
		/*
		 * Button
		 */        
        IButton button = new IButton(title);
         
        button.setWidth(120);
        button.setIcon("silk/widget.png");
	        
        button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				scAction.execute();				
			}
        });

        canvas.addChild(button);
        
        layout.setMembers(pane, canvas);
        return layout;
	
	}
	
	public static VLayout createPlaceHolder() {
		
		VLayout placeHolder = new VLayout();
		placeHolder.setMargin(24);
		
		/*
		 * Dimensions
		 */
		placeHolder.setWidth(480);
		placeHolder.setHeight(480);
		
		placeHolder.setBackgroundColor("#F2F2F4");
		placeHolder.setStyleName(GuiStyles.X_BD_STYLE_4);
		
		placeHolder.setShowEdges(false);
		return placeHolder;

	}

	public static DynamicForm createSelectForm(SelectItem selectItem) {
	
        /*
         * Dynamic Form
         */
        DynamicForm scForm = new DynamicForm();
        scForm.setWidth(480);
 
		scForm.setTitleSuffix(""); // default ":"
		scForm.setStyleName(GuiStyles.X_BD_STYLE_4);
		 
		scForm.setColWidths(60, 280);
		scForm.setFixedColWidths(true);
		 
		scForm.setPadding(8);
		scForm.setTitleOrientation(TitleOrientation.LEFT);
		 
		scForm.setAutoFocus(true);

        scForm.setMargin(24);
        scForm.setFields(selectItem);

        return scForm;
	}
	

	public static SelectItem createSelectItem(LinkedHashMap<String,String> valueMap) {
		
        /*
         * Select Item
         */
        SelectItem selectItem = new SelectItem();  
        selectItem.setTitle("<b>Select</b>");
        
        selectItem.setWidth(280);
        
        /*
         * Data for SelectItem
         */
        selectItem.setValueMap(valueMap);

        return selectItem;
        
	}

	public static HTMLPane getTeaser(String message, int height) {

	    HTMLPane pane = new HTMLPane();
	    pane.setStyleName(GuiStyles.X_SC_TEASER);
	    
	    pane.setContents(message);
	    pane.setHeight(height);

	    return pane;
	    
	}

}
