/*******************************************************************************
 * Copyright 2010 Dr. Krusche & Partner PartG
 *
 * All rights reserved.
 *   
 *******************************************************************************/

package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.util.JSObject;

// this is a pre-configured kml layer
public class KMLLayerImpl {

	public static native JSObject create(String name, String url, String projection)/*-{		
		var kml = new $wnd.OpenLayers.Layer.Vector(name, {
			projection: new $wnd.OpenLayers.Projection(projection),
			strategies: [new $wnd.OpenLayers.Strategy.Fixed()],
			protocol: new $wnd.OpenLayers.Protocol.HTTP({
				url: url,
			 	format: new $wnd.OpenLayers.Format.KML({
			 		extractStyles: true,
			 		extractAttributes: true
			 	})
			})
		});
		return kml;
	}-*/;

	public static native void drawFeature(JSObject layer, JSObject feature)/*-{
		layer.drawFeature(feature);
	}-*/;

	public static native void drawFeature(JSObject layer, JSObject feature, JSObject style)/*-{
		layer.drawFeature(feature, style);
	}-*/;

    public static native int getFeatureCount(JSObject self) /*-{
	    if(self.features){
	        return self.features.length;
	    } else {
	        return -1;
	    }
	}-*/;

    public static native JSObject getFeature(JSObject self, int index) /*-{
    	return self.features[index];
	}-*/;

    // __EXTENSION__ (c) 2010 Dr. Krusche & Partner PartG
    public static native void refresh(JSObject self) /*-{
    	
    	self.loaded = false;
    	self.setVisibility(true);
    	
    	self.refresh({
    		force:true, params:{'key': Math.random()}
    	});
    	
 	}-*/;
   
    
}
