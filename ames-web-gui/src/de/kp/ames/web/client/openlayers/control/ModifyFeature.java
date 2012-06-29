/**
 *
 */
package de.kp.ames.web.client.openlayers.control;


import de.kp.ames.web.client.openlayers.layer.Vector;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ModifyFeature extends Control {

    protected ModifyFeature(JSObject modifyFeature){
        super(modifyFeature);
    }

    public ModifyFeature(Vector vectorLayer){
        this(ModifyFeatureImpl.create(vectorLayer.getJSObject()));
    }

}
