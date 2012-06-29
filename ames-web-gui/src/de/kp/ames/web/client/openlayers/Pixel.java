package de.kp.ames.web.client.openlayers;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Curtis Jensen
 *
 */
public class Pixel extends OpenLayersObjectWrapper {

	protected Pixel(JSObject element) {
		super(element);
	}

	public static Pixel narrowToPixel(JSObject element)
	{
		return (element == null)? null: new Pixel(element);
	}

	public Pixel(int x, int y) {
		this(PixelImpl.create(x, y));
	}

	public int x() {
		return PixelImpl.getX(this.getJSObject());
	}

	public int y() {
		return PixelImpl.getY(this.getJSObject());
	}

	public String toString() {
		return PixelImpl.toString(getJSObject());
	}
}
