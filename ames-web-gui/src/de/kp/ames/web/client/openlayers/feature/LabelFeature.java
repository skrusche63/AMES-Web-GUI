package de.kp.ames.web.client.openlayers.feature;

import de.kp.ames.web.client.openlayers.LonLat;
import de.kp.ames.web.client.openlayers.layer.Markers;
import de.kp.ames.web.client.openlayers.util.JSObject;


public class LabelFeature extends Feature {

    protected LabelFeature (JSObject labelFeature){
        super(labelFeature);
    }

    public LabelFeature (Markers layer, LonLat lonlat){
        super(LabelFeatureImpl.create(layer.getJSObject(), lonlat.getJSObject()));
    }

}
