package de.kp.ames.web.client.openlayers.popup;

import de.kp.ames.web.client.openlayers.LonLat;
import de.kp.ames.web.client.openlayers.OpenLayersObjectWrapper;
import de.kp.ames.web.client.openlayers.Size;
import de.kp.ames.web.client.openlayers.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *
 */
public class AnchoredBubble extends Popup {

	protected AnchoredBubble(JSObject element) {
		super(element);
	}

	/**
	 *
	 * Use addCloseListener to respond to popup close event.
	 *
	 * For explanation of parameters see {@link Popup}.
	 */
	public AnchoredBubble(String id, LonLat lonlat, Size size, String html, OpenLayersObjectWrapper anchor, boolean closeBox) {
		this(AnchoredBubbleImpl.create(id,
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				anchor.getJSObject(),
				closeBox));
	}

}
