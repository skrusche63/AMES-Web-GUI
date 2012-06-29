package de.kp.ames.web.client.openlayers.geometry;

import de.kp.ames.web.client.openlayers.util.JSObject;

public class CollectionImpl {

    public native static int getNumberOfComponents(JSObject self)/*-{
        return self.components.length;
    }-*/;

    public native static JSObject getComponent(JSObject self, int index)/*-{
        return self.components[index];
    }-*/;
}
