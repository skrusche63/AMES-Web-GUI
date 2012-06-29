package de.kp.ames.web.client.openlayers;

public class MapUtils {

	private static MapUtils instance = new MapUtils();

	private double MERC = 20037508.34;
	private double PI   = Math.PI;

	private MapUtils() {
	}

	public static MapUtils getInstance() {
		return instance;
	}

	public double lon2Merc(double lon) {
		return MERC * lon / 180;
	}

	public double lat2Merc(double lat) {
	  lat = Math.log(Math.tan( (90 + lat) * PI / 360)) / (PI / 180);
	  return MERC * lat / 180;
	}

}
