package de.kp.ames.web.client.openlayers.popup;

import de.kp.ames.web.client.openlayers.LonLat;
import de.kp.ames.web.client.openlayers.OpenLayersObjectWrapper;
import de.kp.ames.web.client.openlayers.Size;
import de.kp.ames.web.client.openlayers.util.JSObject;


/**
 *
 * @author Curtis Jensen
 *
 */
public class Framed extends Popup {

	protected Framed(JSObject element) {
		super(element);
	}

	/**
	 *
	 * Use addCloseListener to respond to popup close event.
	 *
	 * @param anchor - ...
	 *
	 * For explanation of other parameters see {@link Popup}.
	 */
	public Framed(String id, LonLat lonlat, Size size, String html, OpenLayersObjectWrapper anchor, boolean closeBox) {
		this(FramedImpl.create(id,
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				anchor.getJSObject(),
				closeBox));
	}

	public Framed(String id, LonLat lonlat, Size size, String html, boolean closeBox) {
		this(FramedImpl.create(id,
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				null,
				closeBox));
	}

	public Framed(String id, LonLat lonlat, String html, boolean closeBox) {
		this(FramedImpl.create(id,
				lonlat.getJSObject(),
				null,
				html,
				null,
				closeBox));
	}
}
