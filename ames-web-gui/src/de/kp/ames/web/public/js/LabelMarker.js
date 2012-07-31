
/**
 * Extension to the OpenLayers-2.8 Library
 *
 * (c) 2009 Dr. Krusche & Partner PartG
 */

OpenLayers.Marker.LabelMarker = OpenLayers.Class(OpenLayers.Marker, {

  label:'',

  markerDiv:null,

  initialize: function(lonlat, icon, title) {
    OpenLayers.Marker.prototype.initialize.apply(this, [lonlat, icon]);

    this.label = title;

    this.markerDiv = OpenLayers.Util.createDiv();
    this.markerDiv.appendChild(this.icon.imageDiv);

    var txtDiv = OpenLayers.Util.createDiv();
    txtDiv.className = 'x-marker';

    var dx = (this.icon.size.w==1) ? 0 : 0;
    var dy = (this.icon.size.h==1) ? 5 : this.icon.size.h;

    OpenLayers.Util.modifyDOMElement(txtDiv, null, new OpenLayers.Pixel(dx,dy));
    txtDiv.innerHTML = this.label;
    this.markerDiv.appendChild(txtDiv);

  },

  /**
   * Method: destroy
   * Nullify references and remove event listeners to prevent circular
   * references and memory leaks
   */

  destroy: function() {
      OpenLayers.Marker.prototype.destroy.apply(this, arguments);
      this.markerDiv.innerHTML = "";
      this.markerDiv = null;
  },

  draw: function(px) {
    
    OpenLayers.Util.modifyAlphaImageDiv(this.icon.imageDiv,
                                        null,
                                        null,
                                        this.icon.size,
                                        this.icon.url);

    /** 
     * to a pixel correction due to the size of the
     * icon attached to the marker div
     */

    px=px.add( this.icon.offset.x, this.icon.offset.y );
    OpenLayers.Util.modifyDOMElement(this.markerDiv, null, px);

    return this.markerDiv;
  },

  redraw: function(px) {
    if ((px != null) && (this.markerDiv != null)) {
      /** 
       * to a pixel correction due to the size of the
       * icon attached to the marker div
       */
      
      px=px.add( this.icon.offset.x, this.icon.offset.y );
      OpenLayers.Util.modifyDOMElement(this.markerDiv, null, px);
    }
  },

  moveTo: function (px) {
    this.redraw(px);
    this.lonlat = this.map.getLonLatFromLayerPx(px);
  },

  setIconUrl: function(url) {
    this.icon.url = url;

    OpenLayers.Util.modifyAlphaImageDiv(this.icon.imageDiv,
                                        null,
                                        null,
                                        this.icon.size,
                                        this.icon.url);
  },

  isDrawn: function() {
    return false;
  },

  CLASS_NAME: "OpenLayers.Marker.LabelMarker"
}); 
