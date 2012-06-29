/**
 *
 */
package de.kp.ames.web.client.openlayers.geometry;

import de.kp.ames.web.client.openlayers.util.JObjectArray;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LineString extends Curve{

    protected LineString(JSObject element){
        super(element);
    }

    public static LineString narrowToLineString(JSObject lineString){
        return (lineString == null)?null: new LineString(lineString);
    }

    public LineString(Point[] pts){
        this(LineStringImpl.create((new JObjectArray(pts)).getJSObject()));
    }

}
