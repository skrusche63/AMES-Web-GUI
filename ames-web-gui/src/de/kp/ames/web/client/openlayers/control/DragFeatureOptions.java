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


import de.kp.ames.web.client.openlayers.control.DragFeature.CompleteListener;
import de.kp.ames.web.client.openlayers.control.DragFeature.DragListener;
import de.kp.ames.web.client.openlayers.control.DragFeature.StartDragListener;
import de.kp.ames.web.client.openlayers.util.JSObject;

public class DragFeatureOptions extends ControlOptions {

	public void onStart(StartDragListener listener){
		JSObject callback =DragFeatureImpl.createStartDragCallback(listener);
		getJSObject().setProperty("onStart", callback);
	}

	public void onDrag(DragListener listener){
		JSObject callback =DragFeatureImpl.createDragCallback(listener);
		getJSObject().setProperty("onDrag", callback);
	}

	public void onComplete(CompleteListener listener){
		JSObject callback =DragFeatureImpl.createCompleteCallback(listener);
		getJSObject().setProperty("onComplete", callback);
	}

}
