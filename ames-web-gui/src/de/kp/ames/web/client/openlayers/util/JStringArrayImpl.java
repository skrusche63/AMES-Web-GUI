package de.kp.ames.web.client.openlayers.util;

class JStringArrayImpl
{

	public static native void arraySet(JSObject array, int index, String value) /*-{
		array[index] = value;
	}-*/;

	public static native String getAsString(JSObject array, int pos)/*-{
		if (array) return array[pos];
		return "";
	}-*/;
}
