package de.kp.ames.web.client.core.gui.apps;

import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.globals.CoreAttrs;

public class KPApplication extends VLayout {
	
	public KPApplication(JSONObject jApp) {
				
		this.setShowEdges(false);
		
		this.setWidth100();
		this.setHeight100();

		this.setMembersMargin(2);
		
		// TITLE ************************************************************
		
		String name = jApp.get(CoreAttrs.RIM_NAME).isString().stringValue();
		String uri  = jApp.get(CoreAttrs.RIM_URI).isString().stringValue();
		
	    Label title = new Label(name);
	    title.setStyleName("x-app-title");

	    title.setWidth100();
	    title.setHeight(18);
	    
	    this.addMember(title);
	    
	    // CONTENT **********************************************************
	    
		// iframe to represent the content
	    final HTMLPane htmlPane = new HTMLPane();
	    htmlPane.setStyleName("x-bd-style-3");
	    htmlPane.setShowEdges(false);
	    
	    htmlPane.setWidth100();
	    htmlPane.setHeight100();

	    htmlPane.setContentsURL(uri);
	    htmlPane.setContentsType(ContentsType.PAGE);
	    
		this.addMember(htmlPane);
		
	}
}
