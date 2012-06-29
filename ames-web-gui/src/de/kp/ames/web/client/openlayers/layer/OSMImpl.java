package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.util.JSObject;

public class OSMImpl {

	   public static native JSObject Mapnik(String name)
	   /*-{
	      return new $wnd.OpenLayers.Layer.OSM.Mapnik(name);
	   }-*/;

	   public static native JSObject Mapnik(String name, JSObject params)
	   /*-{
	      return new $wnd.OpenLayers.Layer.OSM.Mapnik(name, params);
	   }-*/;

	   public static native JSObject Osmarender(String name)
	   /*-{
	      return new $wnd.OpenLayers.Layer.OSM.Osmarender(name);
	   }-*/;

	   public static native JSObject Osmarender(String name, JSObject params)
	   /*-{
	      return new $wnd.OpenLayers.Layer.OSM.Osmarender(name, params);
	   }-*/;

	   public static native JSObject CycleMap(String name)
	   /*-{
	      return new $wnd.OpenLayers.Layer.OSM.CycleMap(name);
	   }-*/;

	   public static native JSObject CycleMap(String name, JSObject params)
	   /*-{
	      return new $wnd.OpenLayers.Layer.OSM.CycleMap(name, params);
	   }-*/;

	   public static native JSObject Maplint(String name)
	   /*-{
	      return new $wnd.OpenLayers.Layer.OSM.Maplint(name);
	   }-*/;

	   public static native JSObject Maplint(String name, JSObject params)
	   /*-{
	      return new $wnd.OpenLayers.Layer.OSM.Maplint(name, params);
	   }-*/;

}
