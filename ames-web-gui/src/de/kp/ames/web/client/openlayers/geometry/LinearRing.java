package de.kp.ames.web.client.openlayers.geometry;

import de.kp.ames.web.client.openlayers.util.JObjectArray;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LinearRing extends LineString {

    protected LinearRing(JSObject linearRing){
        super(linearRing);
    }

    public static LinearRing narrowToLinearRing(JSObject linearRing){
        return (linearRing == null)?null: new LinearRing(linearRing);
    }

    public LinearRing(Point[] pts){
        this(LinearRingImpl.create((new JObjectArray(pts).getJSObject())));
    }

    public static LinearRing fromCoordinateArray(double[][] coordinateArray){
        int max = coordinateArray.length;
        Point[] pts = new Point[max];
        for(int i = 0; i < max; i++){
            Point p = new Point(coordinateArray[i][0], coordinateArray[i][1]);
            pts[i] = p;
        }
        LinearRing ring = new LinearRing(pts);
        return ring;
    }
}
