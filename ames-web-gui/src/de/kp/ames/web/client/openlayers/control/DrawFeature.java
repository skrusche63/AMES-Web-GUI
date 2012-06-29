package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.feature.VectorFeature;
import de.kp.ames.web.client.openlayers.handler.Handler;
import de.kp.ames.web.client.openlayers.layer.Vector;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 *  Don't be suprised by the following:
 *  Upon activating the DrawFeature tool it creates an extra layer
 *  that is used by the handler (the name of this layer reflects this).
 *
 * (tested in OpenLayers 2.7)
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class DrawFeature extends Control {

	public interface FeatureAddedListener {
		void onFeatureAdded(VectorFeature vectorFeature);
	}

	protected DrawFeature(JSObject element) {
		super(element);
	}

	/**
	 *
	 * @param layer
	 * @param handler - a PointHandler, PathHandler or PolygonHandler
	 */
	public DrawFeature(Vector layer, Handler handler) {
		this(DrawFeatureImpl.create(layer.getJSObject(), handler.getJSObject()));
	}

	/**
	 *
	 * @param layer
	 * @param handler - a PointHandler, PathHandler or PolygonHandler
	 * @param options - see {@link DrawFeatureOptions}
	 */
	public DrawFeature(Vector layer, Handler handler, DrawFeatureOptions options){
		this(DrawFeatureImpl.create(layer.getJSObject(), handler.getJSObject(), options.getJSObject()));
	}

}
