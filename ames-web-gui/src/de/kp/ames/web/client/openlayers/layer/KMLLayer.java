/*******************************************************************************
 * Copyright 2010 Dr. Krusche & Partner PartG
 *
 * All rights reserved.
 *   
 *******************************************************************************/

package de.kp.ames.web.client.openlayers.layer;

import de.kp.ames.web.client.openlayers.Style;
import de.kp.ames.web.client.openlayers.StyleMap;
import de.kp.ames.web.client.openlayers.feature.VectorFeature;
import de.kp.ames.web.client.openlayers.util.JSObject;


public class KMLLayer extends Layer {

	protected KMLLayer(JSObject element) {
		super(element);
	}

	public KMLLayer(String name, String url, String projection) {
		this(KMLLayerImpl.create(name, url, projection));
	}

	public int getFeatureCount(){
		return KMLLayerImpl.getFeatureCount(getJSObject());
	}

	public void drawFeature(VectorFeature feature) {
		KMLLayerImpl.drawFeature(this.getJSObject(), feature.getJSObject());
	}

	public void drawFeature(VectorFeature feature, Style style) {
		KMLLayerImpl.drawFeature(this.getJSObject(), feature.getJSObject(), style.getJSObject());
	}

	public VectorFeature[] getFeatures(){

		int cnt = getFeatureCount();
		if(cnt < 1) return null;

		VectorFeature[] features = new VectorFeature[cnt];
		for(int i = 0; i < cnt; i++){
			features[i] = VectorFeature.narrowToVectorFeature(KMLLayerImpl.getFeature(getJSObject(), i));
		}

		return features;

	};

	public void setStyle(Style style){
		getJSObject().setProperty("style", style.getJSObject());
	}

	public void setStyleMap(StyleMap styleMap){
		getJSObject().setProperty("styleMap", styleMap.getJSObject());
	}
	
	public void refresh() {
		KMLLayerImpl.refresh(this.getJSObject());
	}
	
}
