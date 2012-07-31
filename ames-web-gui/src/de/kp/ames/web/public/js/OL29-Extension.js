/* Copyright (c) 2011 Dr. Krusche & Partner PartG, published under the Clear BSD
 * license.  See http://svn.openlayers.org/trunk/openlayers/license.txt for the
 * full text of the license. */

/**
 * @requires OpenLayers/Popup/FramedCloud.js
 * @requires OpenLayers/Util.js
 */

/**
 * Class: OpenLayers.Popup.GoogleCloud
 * 
 * Inherits from: 
 *  - <OpenLayers.Popup.FramedCloud>
 */
OpenLayers.Popup.GoogleCloud = 
  OpenLayers.Class(OpenLayers.Popup.FramedCloud, {

      /**
     * APIProperty: maxSize
     * {<OpenLayers.Size>}
     */
    maxSize: new OpenLayers.Size(600, 400),

    /** 
     * APIProperty: fixedRelativePosition
     * {Boolean} The Google Cloud popup works in just one fixed position.
     */
    fixedRelativePosition: true,
 
	/** 
     * Parameter: relativePosition
     * {String} Relative position of the popup ("br", "tr", "tl" or "bl").
     */
    relativePosition: "tr",
 
    /** 
     * Constructor: OpenLayers.Popup.GoogleCloud
     * 
     * Parameters:
     * id - {String}
     * lonlat - {<OpenLayers.LonLat>}
     * contentSize - {<OpenLayers.Size>}
     * contentHTML - {String}
     * anchor - {Object} Object to which we'll anchor the popup. Must expose 
     *     a 'size' (<OpenLayers.Size>) and 'offset' (<OpenLayers.Pixel>) 
     *     (Note that this is generally an <OpenLayers.Icon>).
     * closeBox - {Boolean}
     * closeBoxCallback - {Function} Function to be called on closeBox click.
     */
    initialize:function(id, lonlat, contentSize, contentHTML, anchor, closeBox, 
                        closeBoxCallback) {

        OpenLayers.Popup.FramedCloud.prototype.initialize.apply(this, arguments);
    },

    /** 
     * APIMethod: destroy
     */
    destroy: function() {
        OpenLayers.Popup.FramedCloud.prototype.destroy.apply(this, arguments);
    },

    CLASS_NAME: "OpenLayers.Popup.GoogleCloud"
});
