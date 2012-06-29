/**
 *
 */
package de.kp.ames.web.client.openlayers;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public class StyleImpl {

    public static native JSObject create()
    /*-{
        return $wnd.OpenLayers.Util.extend({}, $wnd.OpenLayers.Feature.Vector.style['default']);
        //return new Object(); //do it all yourself
    }-*/;

    public static native void setFillColor(JSObject self, String s)
    /*-{
        self.fillColor = s;
    }-*/;

    public static native String getFillColor(JSObject self)
    /*-{
        return self.fillColor;
    }-*/;

    public static native void setFillOpacity(JSObject self, double o)
    /*-{
        self.fillOpacity = o;
    }-*/;

    public static native double getFillOpacity(JSObject self)
    /*-{
        return self.fillOpacity;
    }-*/;

    public static native void setPointRadius(JSObject self, double o)
    /*-{
        self.pointRadius = o;
    }-*/;

    public static native double getPointRadius(JSObject self)
    /*-{
        return self.pointRadius;
    }-*/;

    public static native void setStrokeColor(JSObject self, String s)
    /*-{
        self.strokeColor = s;
    }-*/;

    public static native String getStrokeColor(JSObject self)
    /*-{
        return self.strokeColor;
    }-*/;

    public static native void setStrokeWidth(JSObject self, double w)
    /*-{
        self.strokeWidth = w;
    }-*/;

    public static native double getStrokeWidth(JSObject self)
    /*-{
        return self.strokeWidth;
    }-*/;

    public static native void setExternalGraphic(JSObject self, String graphicURL)
    /*-{
    	self.externalGraphic = graphicURL;
	}-*/;

    public static native String getExternalGraphic(JSObject self)
    /*-{
		return self.externalGraphic;
	}-*/;

    public static native void setGraphicSize(JSObject self, int width, int height)
    /*-{
		self.graphicWidth = width;
		self.graphicHeight = height;
	}-*/;

    public static native int getGraphicWidth(JSObject self)
    /*-{
		return self.graphicWidth;
	}-*/;

    public static native int getGraphicHeight(JSObject self)
    /*-{
		return self.graphicHeight;
	}-*/;

    public static native void setGraphicOffset(JSObject self, int xOffset, int yOffset)
    /*-{
		self.graphicXOffset = xOffset;
		self.graphicYOffset = yOffset;
	}-*/;

    // __Extension: Dr. Krusche & Partner PartG
    public static native void setGraphicOpacity(JSObject self, double o)
    /*-{
    	self.graphicOpacity =o;
    }-*/;

    // __Extension: Dr. Krusche & Partner PartG
    public static native void setGraphicXOffset(JSObject self, int xOffset)
    /*-{
 		self.graphicXOffset = xOffset;
    }-*/;

    // __Extension: Dr. Krusche & Partner PartG
    public static native void setCursor(JSObject self, String cursor)
    /*-{
    	self.cursor = cursor;
    }-*/;

    // __Extension: Dr. Krusche & Partner PartG
    public static native void setLabel(JSObject self, String label)
    /*-{
    	self.label = label;
    }-*/;

    // __Extension: Dr. Krusche & Partner PartG
    public static native void setLabelAlign(JSObject self, String align)
    /*-{
    	self.labelAlign = align;
    }-*/;

    // __Extension: Dr. Krusche & Partner PartG
    public static native void setFontColor(JSObject self, String color)
    /*-{
    	self.fontColor = color;
    }-*/;

    // __Extension: Dr. Krusche & Partner PartG
    public static native void setFontWeight(JSObject self, String weight)
    /*-{
    	self.fontWeight = weight;
    }-*/;

    
    public static native void setStrokeOpacity(JSObject self, double o)
    /*-{
    	self.strokeOpacity = o;
    }-*/;

}
