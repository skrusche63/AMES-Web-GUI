package de.kp.ames.web.client.openlayers.control;
/**
 * This file is part of the AMES Web GUI.
 *
 * AMES Web GUI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AMES Web GUI is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the AMES Web GUI.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2012 Dr. Krusche & Partner PartG <team@dr-kruscheundpartner.de>
 *
 */

import de.kp.ames.web.client.openlayers.control.DragFeature.CompleteListener;
import de.kp.ames.web.client.openlayers.control.DragFeature.DragListener;
import de.kp.ames.web.client.openlayers.control.DragFeature.StartDragListener;
import de.kp.ames.web.client.openlayers.util.JSObject;

public class DragFeatureImpl {

    public static native JSObject create(JSObject layer) /*-{
    	return new $wnd.OpenLayers.Control.DragFeature(layer);
	}-*/;

	public static native JSObject create(JSObject layer, JSObject options)/*-{
		return new $wnd.OpenLayers.Control.DragFeature(layer, options);
	}-*/;

	public static native JSObject createStartDragCallback(StartDragListener listener)/*-{
		var callback = function(o,p){
			var vectorFeatureObj = @de.kp.ames.web.client.openlayers.feature.VectorFeature::narrowToVectorFeature(Lde/kp/ames/web/client/openlayers/util/JSObject;)(o);
			var pixelObject = @de.kp.ames.web.client.openlayers.Pixel::narrowToPixel(Lde/kp/ames/web/client/openlayers/util/JSObject;)(p);
			listener.@de.kp.ames.web.client.openlayers.control.DragFeature.StartDragListener::onStart(Lde/kp/ames/web/client/openlayers/feature/VectorFeature;Lde/kp/ames/web/client/openlayers/Pixel;)(vectorFeatureObj,pixelObject);
		}
		return callback;
	}-*/;

	public static native JSObject createDragCallback(DragListener listener)/*-{
		var callback = function(o,p){
			var vectorFeatureObj = @de.kp.ames.web.client.openlayers.feature.VectorFeature::narrowToVectorFeature(Lde/kp/ames/web/client/openlayers/util/JSObject;)(o);
			var pixelObject = @de.kp.ames.web.client.openlayers.Pixel::narrowToPixel(Lde/kp/ames/web/client/openlayers/util/JSObject;)(p);
			listener.@de.kp.ames.web.client.openlayers.control.DragFeature.DragListener::onDrag(Lde/kp/ames/web/client/openlayers/feature/VectorFeature;Lde/kp/ames/web/client/openlayers/Pixel;)(vectorFeatureObj,pixelObject);
		}
		return callback;
	}-*/;

	public static native JSObject createCompleteCallback(CompleteListener listener)/*-{
		var callback = function(o,p){
			var vectorFeatureObj = @de.kp.ames.web.client.openlayers.feature.VectorFeature::narrowToVectorFeature(Lde/kp/ames/web/client/openlayers/util/JSObject;)(o);
			var pixelObject = @de.kp.ames.web.client.openlayers.Pixel::narrowToPixel(Lde/kp/ames/web/client/openlayers/util/JSObject;)(p);
			listener.@de.kp.ames.web.client.openlayers.control.DragFeature.CompleteListener::onComplete(Lde/kp/ames/web/client/openlayers/feature/VectorFeature;Lde/kp/ames/web/client/openlayers/Pixel;)(vectorFeatureObj,pixelObject);
		}
		return callback;
	}-*/;

}
