package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class DragPanImpl
{

   public static native JSObject create()
   /*-{
      return new $wnd.OpenLayers.Control.DragPan();
   }-*/;

   public static native JSObject create(JSObject options) /*-{
      return new $wnd.OpenLayers.Control.DragPan(
          $wnd.gwt_openlayers_util.eventListenersToObject(options));
   }-*/;

}
