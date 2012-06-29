package de.kp.ames.web.client.openlayers;

import de.kp.ames.web.client.openlayers.util.JSObject;
import de.kp.ames.web.client.openlayers.util.JSObjectWrapper;

/**
 * From the OpenLayers API docs:
 * Class for coordinate transforms between coordinate systems.
 *
 * @author Evgeny Gazdovsky
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Projection extends JSObjectWrapper {

	protected Projection(JSObject element) {
		super(element);
	}

	/**
	 *
	 * @param projectionCode - projection code that identifies the projection or an SRS in a
	 *   repository that contains projection and SRS definitions, such as the EPSG registry.
	 *   An example of an EPSG SRS code is EPSG:4326, which is typically projected in equidistant
	 *   cylindrical projection.
	 */
	public Projection(String projectionCode){
		this (ProjectionImpl.create(projectionCode));
	}

	/**
	 *
	 * @return String - projection code, see {@link #Projection(String)}.
	 */
	public String getProjectionCode(String projectionCode){
		return ProjectionImpl.getProjectionCode(getJSObject());
	}

}
