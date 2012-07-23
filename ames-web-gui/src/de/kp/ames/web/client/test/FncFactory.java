package de.kp.ames.web.client.test;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
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

}
