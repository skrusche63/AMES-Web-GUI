package de.kp.ames.web.client.test.upload;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import de.kp.ames.web.client.function.upload.widget.UploadCreateDialog;
import de.kp.ames.web.client.function.upload.widget.UploadFormImpl;
import de.kp.ames.web.client.style.GuiStyles;

public class UploadFactory {

	public static VLayout createUploadGridImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;

	}

	public static VLayout createUploadCreateDialog() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = new HTMLPane();
        pane.setStyleName(GuiStyles.X_SC_TEASER);
        
        pane.setContents("Click the button to open the UploadCreateDialog.");
        pane.setHeight(40);

        /*
         * Canvas
         */
        Canvas canvas = new Canvas();
        canvas.setMargin(24);
        
		/*
		 * Button
		 */        
        IButton button = new IButton("Show Dialog");
         
        button.setWidth(120);
        button.setIcon("silk/widget.png");
	        
        button.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				new UploadCreateDialog();				
			}
        });

        canvas.addChild(button);
        
        layout.setMembers(pane, canvas);
        return layout;
	
	}

	
	public static VLayout createUploadFormImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = new HTMLPane();
        pane.setStyleName(GuiStyles.X_SC_TEASER);
        
        pane.setContents("This is an example of a <b>styled</b> Upload Form. Note, that this is a modification <br>of the HTML input file, that may not be rendered properly by all browsers. ");
        pane.setHeight(64);
        
        /*
         * Upload Form
         */
        UploadFormImpl uploadForm = new UploadFormImpl();
		uploadForm.setMargin(24);

		/*
		 * Dimensions
		 */
		uploadForm.setWidth(380);
		uploadForm.setHeight(1);
		
		/*
		 * Style
		 */
		uploadForm.setBackgroundColor("#F2F2F4");
		uploadForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,uploadForm);
		return layout;
	
	}

}
