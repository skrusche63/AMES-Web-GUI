package de.kp.ames.web.client.openlayers.util;


public class JDoubleArrayImpl {

	public static native double get(JSObject array, int index)/*-{
		return array[index];
	}-*/;
}
