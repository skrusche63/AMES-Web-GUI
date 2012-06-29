package de.kp.ames.web.client.openlayers.geometry;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PointImpl {

    public native static JSObject create(double x, double y)/*-{
        return new $wnd.OpenLayers.Geometry.Point(x, y);
    }-*/;

    public native static double getX(JSObject self)/*-{
        return self.x;
    }-*/;

    public native static double getY(JSObject self)/*-{
        return self.y;
    }-*/;

    public native static String getId(JSObject self)/*-{
        return self.id;
    }-*/;

    public native static void setX(JSObject self, double x)/*-{
        self.x = x;
    }-*/;

    public native static void setY(JSObject self, double y)/*-{
        self.x = y;
    }-*/;

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public native static void move(JSObject self, double dx, double dy)/*-{
    	self.move(dx,dy);
	}-*/;

}
