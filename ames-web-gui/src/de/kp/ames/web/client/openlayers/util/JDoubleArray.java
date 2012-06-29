package de.kp.ames.web.client.openlayers.util;


public class JDoubleArray extends JArrayBase {

	protected JDoubleArray(JSObject array) {
		super(array);
	}

	public static JDoubleArray narrowToJDoubleArray(JSObject array){
		return new JDoubleArray(array);
	}

	public double get(int index){
		return JDoubleArrayImpl.get(getJSObject(), index);
	}

}
