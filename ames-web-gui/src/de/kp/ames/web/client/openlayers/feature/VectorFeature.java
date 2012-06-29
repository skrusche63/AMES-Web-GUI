/**
 *
 */
package de.kp.ames.web.client.openlayers.feature;

import de.kp.ames.web.client.openlayers.Style;
import de.kp.ames.web.client.openlayers.geometry.Geometry;
import de.kp.ames.web.client.openlayers.layer.Vector;
import de.kp.ames.web.client.openlayers.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 * Class name deviates intentionally from OpenLayers class name.
 * Both vector layers and vector features are called Vector in OpenLayers.
 *
 *
 */
public class VectorFeature extends Feature {

    protected VectorFeature (JSObject vectorFeature){
        super(vectorFeature);
    }

    public VectorFeature (Geometry g){
        super(VectorFeatureImpl.create(g.getJSObject()));
    }

    public VectorFeature (Geometry g, Style s){
        super(VectorFeatureImpl.create(g.getJSObject(), s.getJSObject()));
    }

    public static VectorFeature narrowToVectorFeature(JSObject vectorFeature){
        return (vectorFeature == null)?null:new VectorFeature(vectorFeature);
    }

    /**
     * Provided together with getGeometry method, so geometry subclass can be
     * instantiated from geometry, for example:
     *   Point p = Point.narrowToPoint(vf.getGeometry)
     * Where vf is a VectorFeature of which the geometry is determined by user input,
     * for example by drawing a feature.
     */
    public String getGeometryClassName(){
        return VectorFeatureImpl.getGeometryClassName(getJSObject());
    }


    public JSObject getGeometry(){
        return VectorFeatureImpl.getGeometry(getJSObject());
    }

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public void setGeometry(Geometry geometry){
        VectorFeatureImpl.setGeometry(getJSObject(), geometry.getJSObject());
    }

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public Vector getVector() {
		return Vector.narrowToVector(VectorFeatureImpl.getVector(this.getJSObject()));    	
    }
    
    // __EXTENSION__ Dr. Krusche & Partner PartG
    public String getFid() {
    	return VectorFeatureImpl.getFid(getJSObject());
    }

    public void setFid(String fid) {
    	VectorFeatureImpl.setFid(getJSObject(), fid);
    }
 
    // __EXTENSION__ Dr. Krusche & Partner PartG
    public String getExternalGraphic() {
    	return VectorFeatureImpl.getExternalGraphic(getJSObject());
    }

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public void setExternalGraphic(String url, boolean forced) {
 
		String externalGraphic = VectorFeatureImpl.getExternalGraphic(getJSObject());
    	if ((externalGraphic == null) || (forced == true)) VectorFeatureImpl.setExternalGraphic(getJSObject(), url);
     
    }

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public void setLabel(String label) {
    	VectorFeatureImpl.setLabel(getJSObject(), label);
    }
    
    // __EXTENSION__ Dr. Krusche & Partner PartG
    public void setFontColor(String color) {
    	VectorFeatureImpl.setFontColor(getJSObject(), color);
    }

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public void setNodeStyle() {
    	VectorFeatureImpl.setNodeStyle(getJSObject());
    }
  
    // __EXTENSION__ Dr. Krusche & Partner PartG
    public void setEdgeStyle() {
    	VectorFeatureImpl.setEdgeStyle(getJSObject());
    }

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public void setPluginStyle() {
    	VectorFeatureImpl.setPluginStyle(getJSObject());
    }
 
    // __EXTENSION__ Dr. Krusche & Partner PartG
    public JSObject getAttributes() {
    	return VectorFeatureImpl.getAttributes(getJSObject());
    }
 
    // __EXTENSION__ Dr. Krusche & Partner PartG
    public String getAttributeAsString(String name) {
    	JSObject attributes = VectorFeatureImpl.getAttributes(getJSObject());
    	return attributes.getPropertyAsString(name);
    }

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public JSObject getAttributeAsObject(String name) {
    	JSObject attributes = VectorFeatureImpl.getAttributes(getJSObject());
    	return attributes.getProperty(name);
    }

    // __EXTENSION__ Dr. Krusche & Partner PartG
    public void setAttributeAsString(String name, String value) {
    	JSObject attributes = VectorFeatureImpl.getAttributes(getJSObject());
    	attributes.setProperty(name, value);
    }

}
