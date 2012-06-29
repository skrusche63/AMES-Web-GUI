package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.LonLat;
import de.kp.ames.web.client.openlayers.Map;

/**
 * See {@link MousePosition}.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @since GWT-OL 0.4
 *
 */
public abstract class MousePositionOutput {

	/**
	 * A MousePositionOutput instance that implements this function can
	 * be used to set the output format on a {@link MousePosition} control.
	 *
	 * @param lonLat - a {@link de.kp.ames.web.client.openlayers.LonLat} with the longitude/latitude at the mouse position
	 * @param map - the {@link de.kp.ames.web.client.openlayers.Map} to which the control has been added.
	 * @return String - the output that is shown by the MousePosition control
	 */
	public abstract String format(LonLat lonLat, Map map);

}
