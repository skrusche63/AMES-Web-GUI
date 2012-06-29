/*******************************************************************************
 * Copyright 2010 Dr. Krusche & Partner PartG
 *
 * This file is part of the XSenseMaker project.
 *
 *   XSenseMaker is free software; you can redistribute it and/or modify it under 
 *   the terms of the GNU General Public License as published by the Free Software 
 *   Foundation; either version 2 of the License, or (at your option) any later version.
 *
 *   XSenseMaker is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 *   without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *   
 *   See the GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License along; if not, 
 *   write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 *   MA  02110-1301  USA
 *   
 *******************************************************************************/

package de.kp.ames.web.client.openlayers.control;

import de.kp.ames.web.client.openlayers.Pixel;
import de.kp.ames.web.client.openlayers.feature.VectorFeature;
import de.kp.ames.web.client.openlayers.layer.KMLLayer;
import de.kp.ames.web.client.openlayers.layer.Vector;
import de.kp.ames.web.client.openlayers.util.JSObject;


//(c) 2010 Dr. Krusche & Partner PartG
public class DragFeature extends Control {

	public interface StartDragListener {
		void onStart(VectorFeature vectorFeature, Pixel pixel);
	}

	public interface DragListener {
		void onDrag(VectorFeature vectorFeature, Pixel pixel);
	}

	public interface CompleteListener {
		void onComplete(VectorFeature vectorFeature, Pixel pixel);
	}
	
	protected DragFeature(JSObject element) {
		super(element);
	}

	public DragFeature(Vector layer) {
		this(DragFeatureImpl.create(layer.getJSObject()));
	}

	public DragFeature(Vector layer, DragFeatureOptions options) {
		this(DragFeatureImpl.create(layer.getJSObject(), options.getJSObject()));
	}

	public DragFeature(KMLLayer layer) {
		this(DragFeatureImpl.create(layer.getJSObject()));
	}

	public DragFeature(KMLLayer layer, DragFeatureOptions options) {
		this(DragFeatureImpl.create(layer.getJSObject(), options.getJSObject()));
	}

}
