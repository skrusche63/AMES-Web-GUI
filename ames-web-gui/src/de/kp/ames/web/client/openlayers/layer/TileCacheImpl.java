package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.util.JSObject;

public class TileCacheImpl {

   public static native JSObject create(String name,JSObject url, double maxResolution) /*-{
	  return new $wnd.OpenLayers.Layer.TileCache(name, url, 'Tile Cache', {
	  	type:'png', gutter:0, buffer:0, transitionEffect:'resize',
	  	maxResolution:maxResolution,
	  	getURL:function(bounds) {
			var res = this.map.getResolution();

  			var x = Math.round((bounds.left - this.maxExtent.left) / (res * this.tileSize.w));
  			var y = Math.round((this.maxExtent.top - bounds.top) / (res * this.tileSize.h));
  			var z = this.map.getZoom();

  			var limit = Math.pow(2, z);

  			if (y < 0 || y >= limit) {
    			return "";
  			} else {
    			x = ((x % limit) + limit) % limit;
    			var url = this.url;
    			var path = z + "/" + x + "/" + y + ".png";
    			if (url instanceof Array) {
      				url = this.selectUrl(path, url);
    			}
    			return url + path;
  			}
	  	}

	  });
   }-*/;
}
