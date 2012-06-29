/**
 *
 */
package de.kp.ames.web.client.openlayers.geometry;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LineStringImpl {

    public static native JSObject create(JSObject points)
    /*-{
        return new $wnd.gwt_openlayers_util.relay.createLineString(points);
    }-*/;
}
