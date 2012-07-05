package de.kp.ames.web.client.core.widget.viewer;

import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.widgets.HTMLPane;

public class ViewerFactory {

	/**
	 * Files are loaded view an <IFrame>, i.e. using
	 * the <HTMLPane> component
	 * 
	 * @param title
	 * @param slogan
	 * @param uri
	 */
	public static void createFrameViewer(String title, String slogan, String uri) {
		
		/*
		 * Build html pane
		 */
		HTMLPane htmlPane = new HTMLPane();
	    htmlPane.setShowEdges(false);
	    
	    htmlPane.setWidth100();
	    htmlPane.setHeight100();
	    
	    htmlPane.setContentsURL(uri);
	    htmlPane.setContentsType(ContentsType.PAGE);
		
	    /*
	     * Instantiate viewer
	     */
	    new ViewerImpl(title, slogan, htmlPane);
	    
	}
	
}