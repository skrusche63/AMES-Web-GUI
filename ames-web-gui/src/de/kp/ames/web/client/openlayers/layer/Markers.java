package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.Bounds;
import de.kp.ames.web.client.openlayers.LabelMarker;
import de.kp.ames.web.client.openlayers.Marker;
import de.kp.ames.web.client.openlayers.layer.MarkersImpl;
import de.kp.ames.web.client.openlayers.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Wayne Fang - Refractions Research
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class Markers extends Layer {

	protected Markers(JSObject element) {
		super(element);
	}

	public Markers(String name) {
		this (MarkersImpl.create(name));
	}

	public void addMarker(Marker marker) {
		MarkersImpl.addMarker(getJSObject(), marker.getJSObject());
	}

	// __EXTENSION: Dr. Krusche & Partner PartG
	public void addLabelMarker(LabelMarker marker) {
		MarkersImpl.addMarker(getJSObject(), marker.getJSObject());
	}

	public void removeMarker(Marker marker) {
		MarkersImpl.removeMarker(getJSObject(), marker.getJSObject());
	}

	// __EXTENSION: Dr. Krusche & Partner PartG
	public void removeLabelMarker(LabelMarker marker) {
		MarkersImpl.removeMarker(getJSObject(), marker.getJSObject());
	}

	public Bounds getDataExtent() {
	   return Bounds.narrowToBounds(MarkersImpl.getDataExtent(getJSObject()));
	}

	public void destroy() {
		MarkersImpl.destroy(getJSObject());
	}
	
	// __EXTENSION__ Dr. Krusche & Partner PartG
	public void clearMarkers() {
		MarkersImpl.clearMarkers(getJSObject());
	}

}
