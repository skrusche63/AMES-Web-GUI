package de.kp.ames.web.client.test;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;

import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.upload.UploadFactory;

public class ScFactory {

	private static String PREFIX = "function:";
	
	private static String TABLE_ICON  = "silk/table.png";
	private static String WIDGET_ICON = "silk/widget.png";

	public static Tab getTab(String nid) {
		
		/*
		 * Upload-Layer
		 */
		if (nid.equals(PREFIX + "upload:data:UploadGridImpl:leaf")) {
			return createUploadGridImpl(nid);
			
		} else if (nid.equals(PREFIX + "upload:widget:UploadCreateDialog:leaf")) {
			return createUploadCreateDialog(nid);
			
		} else if (nid.equals(PREFIX + "upload:widget:UploadFormImpl:leaf")) {
			return createUploadFormImpl(nid);
			
		}

		return null;

	}

	private static Tab createUploadGridImpl(String nid) {
		
		Canvas content = new Canvas();
		
		Tab tab = createTab(nid, "UploadGridImpl", TABLE_ICON, content);	
		return tab;

	}
	
	private static Tab createUploadCreateDialog(String nid) {
		
        VLayout content = UploadFactory.createUploadCreateDialog();		
		
		Tab tab = createTab(nid, "UploadCreateDialog", WIDGET_ICON, content);	
		return tab;

	}
	
	private static Tab createUploadFormImpl(String nid) {

        VLayout content = UploadFactory.createUploadFormImpl();
		
		Tab tab = createTab(nid, "UploadFormImpl", WIDGET_ICON, content);	
		return tab;
	
	}
	
	private static Tab createTab(String id, String name, String icon, Canvas canvas) {
		
		Tab tab = new Tab();
		tab.setID(id + ":tab");
		
		tab.setCanClose(true);

        String imgHTML = Canvas.imgHTML(icon, 16, 16);
        tab.setTitle("<span>" + imgHTML + "&nbsp;" + name + "</span>");

		VLayout layout = createVLayout();
 		layout.setMembers(canvas);
		
		tab.setPane(layout);
		return tab;

	}
	
	private static VLayout createVLayout() {

		VLayout layout = new VLayout();
        /*
         * Style
         */
        layout.setStyleName(GuiStyles.X_BD_STYLE_0);
		return layout;
		
	}
	
}
