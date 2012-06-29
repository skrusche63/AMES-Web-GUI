package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class GMapTypeImpl
{
// Constants
// Constants Description

   /*
    * G_NORMAL_MAP  This is the normal street map type.
    */
   native static public JSObject G_NORMAL_MAP()/*-{
      return $wnd.G_NORMAL_MAP ? $wnd.G_NORMAL_MAP : null;
   }-*/;

   /*
    * G_SATELLITE_MAP  This map type shows Google Earth satellite images.
    */
   native static public JSObject G_SATELLITE_MAP()/*-{
      return $wnd.G_SATELLITE_MAP ? $wnd.G_SATELLITE_MAP : null;
   }-*/;

   /*
    * G_HYBRID_MAP  This map type shows transparent street maps over Google Earth satellite images.
    */
   native static public JSObject G_HYBRID_MAP()/*-{
      return $wnd.G_HYBRID_MAP ? $wnd.G_HYBRID_MAP : null;
   }-*/;
}
