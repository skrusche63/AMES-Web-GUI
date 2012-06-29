package de.kp.ames.web.client.openlayers.control;


import de.kp.ames.web.client.openlayers.control.SelectFeature.SelectFeatureListener;
import de.kp.ames.web.client.openlayers.control.SelectFeature.UnselectFeatureListener;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * See {@link SelectFeature}.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
class SelectFeatureImpl {

	public static native JSObject create(JSObject layer)/*-{
		return new $wnd.OpenLayers.Control.SelectFeature(layer);
	}-*/;

	public static native JSObject create(JSObject layer, JSObject options)/*-{
		return new $wnd.OpenLayers.Control.SelectFeature(layer, options);

	}-*/;

    // __EXTENSION__ Dr. Krusche & Partner PartG

	// this method is introduced to enable multiple vector layers
	// to the respective SelectFeature
	public static native void addLayer(JSObject self, JSObject layer) /*-{

        self.deactivate();
	
		// determine whether there is more than a single layer
		// assigned to the select feature (control)
		if (self.layers == null) {
			
			// we move the current layer to the layers array
			self.layers = [self.layer];
			// this code snippet is from SelectFeature.js
            self.layer = new $wnd.OpenLayers.Layer.Vector.RootContainer(
                self.id + "_container", {
                    layers: self.layers
                }
            );
 
 			// update handlers as these now refer to the container
         	self.handlers = {
            	feature: new $wnd.OpenLayers.Handler.Feature(
                	self, self.layer, self.callbacks,
                	{geometryTypes: self.geometryTypes}
            	)
        	};
             
        }
        
        // add new layer to the layers array
        self.layers.push(layer);           
		self.activate();
		
	}-*/;
	
	
	public static native void setClickOut(JSObject self, boolean clickout)/*-{
		self.clickout = clickout;
	}-*/;

	public static native void setHover(JSObject self, boolean hover)/*-{
		self.hover = hover;
	}-*/;

	public static native void setMultiple(JSObject self, boolean multiple)/*-{
		self.multiple = multiple;
	}-*/;

	public static native void setToggle(JSObject self, boolean toggle)/*-{
		self.toggle = toggle;
	}-*/;

	public static native JSObject createSelectFeatureCallback(SelectFeatureListener listener)/*-{
		var callback = function(obj){
			var vectorFeatureObj = @de.kp.ames.web.client.openlayers.feature.VectorFeature::narrowToVectorFeature(Lde/kp/ames/web/client/openlayers/util/JSObject;)(obj);
			listener.@de.kp.ames.web.client.openlayers.control.SelectFeature.SelectFeatureListener::onFeatureSelected(Lde/kp/ames/web/client/openlayers/feature/VectorFeature;)(vectorFeatureObj);
		}
		return callback;
	}-*/;

	public static native JSObject createUnselectFeatureCallback(UnselectFeatureListener listener)/*-{
		var callback = function(obj){
			var vectorFeatureObj = @de.kp.ames.web.client.openlayers.feature.VectorFeature::narrowToVectorFeature(Lde/kp/ames/web/client/openlayers/util/JSObject;)(obj);
			listener.@de.kp.ames.web.client.openlayers.control.SelectFeature.UnselectFeatureListener::onFeatureUnselected(Lde/kp/ames/web/client/openlayers/feature/VectorFeature;)(vectorFeatureObj);
		}
		return callback;
	}-*/;

	public static native void unselect(JSObject selectFeature, JSObject feature)/*-{
    	selectFeature.unselect(feature);
	}-*/;

	public static native void setToggleKey(JSObject selectFeature, String keyName)/*-{
		selectFeature["toggleKey"] = keyName;
	}-*/;

	public static native void setMultipleKey(JSObject selectFeature, String keyName)/*-{
		selectFeature["multipleKey"] = keyName;
	}-*/;

	// __EXTENSION__ Dr. Krusche & Partner PartG
	public static native void setSelectStyle(JSObject selectFeature, JSObject style) /*-{
		selectFeature["selectStyle"] = style;
	}-*/;

	public static native void setHighlightOnly(JSObject selectFeature, boolean highlightOnly) /*-{
	selectFeature["highlightOnly"] = highlightOnly;
}-*/;
}
