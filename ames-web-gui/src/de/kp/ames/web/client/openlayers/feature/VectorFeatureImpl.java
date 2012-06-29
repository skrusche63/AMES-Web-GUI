/**
 *
 */
package de.kp.ames.web.client.openlayers.feature;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class VectorFeatureImpl {

    public native static JSObject create(JSObject geometry)/*-{
        return new $wnd.OpenLayers.Feature.Vector(geometry, null, null);
    }-*/;

    public native static JSObject create(JSObject geometry, JSObject style)/*-{
    return new $wnd.OpenLayers.Feature.Vector(geometry, null, style);
    }-*/;

    public native static String getGeometryClassName(JSObject self)/*-{
        return self.geometry.CLASS_NAME;
    }-*/;

    public native static JSObject getGeometry(JSObject self) /*-{
        return self.geometry;
    }-*/;

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public native static void setGeometry(JSObject self, JSObject geometry) /*-{
		return self.geometry = geometry;
	}-*/;
   
    // __EXTENSION__ Dr. Krusche & Partner PartG    
    public native static JSObject getVector(JSObject self) /*-{
    	return self.layer;
	}-*/;
    
    // __EXTENSION__ Dr. Krusche & Partner PartG
    public native static String getFid(JSObject self) /*-{
    	return self.fid;
	}-*/;

    public native static void setFid(JSObject self, String fid) /*-{
		return self.fid = fid;
	}-*/;

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public native static JSObject getAttributes(JSObject self) /*-{
    	return self.attributes;
	}-*/;

    // __EXTENSION__ Dr. Krusche & Partner PartG    
    public native static String getExternalGraphic(JSObject self) /*-{
    	var graphic = self.style.externalGraphic
		return (typeof graphic == 'undefined') ? null : graphic;
 	}-*/;

    // __EXTENSION__ Dr. Krusche & Partner PartG    
    public native static void setExternalGraphic(JSObject self, String url) /*-{
		self.style.externalGraphic=url;
 	}-*/;
    
    // __EXTENSION__ Dr. Krusche & Partner PartG
    public native static String setLabel(JSObject self, String label) /*-{
    	return self.style.label=label;
	}-*/;

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public native static String setFontColor(JSObject self, String color) /*-{
    	return self.style.fontColor=color;
	}-*/;

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public native static void setEdgeStyle(JSObject self) /*-{
   		var style = {
 
     		graphicOpacity:1.0,
     		
     		strokeColor:"#2b477f",
     		strokeOpacity:0.8,
     		
     		strokeWidth:3,
 			
    		// cursor
    		cursor:"pointer"
 
     	};
     	
    	self.style=style;
 
	}-*/;

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public native static void setNodeStyle(JSObject self) /*-{
    	
    	var style = {
    		
    		// graphic style
    		graphicWidth:40,
    		graphicHeight:40,
    		graphicOpacity:1.0,
    		
     		graphicXOffset:-42,
    		
    		// label style
    		fontColor:"#566d99",
    		fontSize:"11px",
    		fontWeight:"bold",
     		labelAlign:"left",
 
 			label:"node",
 			
    		// cursor
    		cursor:"pointer"
    		
    	};
     	
    	self.style=style;

	}-*/;
 
    // __EXTENSION__ Dr. Krusche & Partner PartG
    public native static void setPluginStyle(JSObject self) /*-{
    	
    	var style = {
    		
    		// graphic style
    		graphicWidth:34,
    		graphicHeight:34,
    		graphicOpacity:1.0,
    		
     		graphicXOffset:-36,
    		
    		// label style
    		fontFamily:"tahoma,arial,sans-serif",
    		fontColor:"#566d99",
    		fontSize:"11px",
    		fontWeight:"bold",
     		labelAlign:"left",
 
 			label:"node",
 			
    		// cursor
    		cursor:"pointer"
    		
    	};
     	
    	self.style=style;

	}-*/;

}
