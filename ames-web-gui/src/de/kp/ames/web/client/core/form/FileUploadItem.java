package de.kp.ames.web.client.core.form;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.smartgwt.client.widgets.form.fields.UploadItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;

/*
 * Customized upload item
 */
public class FileUploadItem extends UploadItem {
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param title
	 * @param width
	 */
	public FileUploadItem(String name, String title, int width) {
        super(name, title);
 
        this.setAttribute("displayWidth", width);
        
        /*
         * The change event is used to fill the
         * display textitem
         */
        this.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				doAfterChange(event);				
			}
		});

	}
	
    /**
     * @param event
     */
    protected void doAfterChange(ChangeEvent event) {

    	String source = this.getAttribute("fileItemId");
    	String value = (String)event.getValue();

    	String target = source + "_fake";   		

    	Element e = DOM.getElementById(target);
    	
    	e.focus();
    	e.setInnerText(value);
    	 
    }

	/**
	 * This method is used to modify the HTML representation
	 * of the FileUploadItem
	 */
	public native void wrapHtmlElement() /*-{
    	
    	// Retrieve JS object for the FileUploadItem
    	var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
 
    	// Override the HTML representation method
    	self.getElementHTML = function(value, dataValue) {

	        var result;

	        var name  = this.name;
	        var width = this.displayWidth;
	        
	        var internalWidth = width + 28;
	        var fileOffset = 0; // this is correct in firefox
	        
	        var fileItemId = this.getDataElementId();
	        var fakeItemId = fileItemId + "_fake";
	        
	        this.fileItemId = fileItemId;
	        
			result = "<div style=\"margin:16px;margin-top:24px;position:relative;width:" + internalWidth + "px;\">"; // container
	
			result += "<div style=\"position:absolute;top:0px;left:0px;\">";
			result += "<div style=\"top:0;left:0;height:24px;\">"; // div wrapper for <input> element

			result += "<div id=\"" + fakeItemId + "\" style=\"width:" + (width-8) + "px;height:22px;border:1px solid #a0a0a0;background:#ffffff;margin:0;overflow:hidden;padding-top:4px;padding-left:4px;font-size:11px;\"></div>";
			result += "</div>";
			
			result += "<img src=\"images/upload24.png\" width=\"28\" height=\"28\"; style=\"position:relative;top:-24px;left:" + width + "px;\"/>"; // browse image
			result += "</div>";
				
			result += "<div style=\"position:relative;top:0px;left:" + fileOffset + "px;-moz-opacity:0.0;filter:alpha(opacity=0.0);opacity:0.0;text-align:right;cursor:pointer;\">";	
			result += "<input type=\"FILE\" id=\"" + fileItemId + "\" name=\"" + name + "\" style=\"cursor:pointer;\" />";	
			result += "</div>";
			result += "</div>"; // end container
			
	        return result;
		};
		
    }-*/;

}
