package de.kp.ames.web.client.openlayers.feature;

import de.kp.ames.web.client.openlayers.Bounds;
import de.kp.ames.web.client.openlayers.LonLat;
import de.kp.ames.web.client.openlayers.OpenLayersObjectWrapper;
import de.kp.ames.web.client.openlayers.Style;
import de.kp.ames.web.client.openlayers.popup.Popup;
import de.kp.ames.web.client.openlayers.util.JSObject;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public abstract class Feature extends OpenLayersObjectWrapper {

    protected Feature(JSObject element){
        super(element);
    }

    public void destroy(){
        FeatureImpl.destroy(getJSObject());
    }

    public String getFeatureId(){
        return FeatureImpl.getFeatureId(getJSObject());
    }

	public Popup createPopup(boolean closeBox) {
		JSObject popupObj = FeatureImpl.createPopup(this.getJSObject(), closeBox);

		return Popup.narrowToOpenLayersPopup(popupObj);
	}

	public LonLat getCenterLonLat() {
		return Bounds.narrowToBounds(FeatureImpl.getBounds(this.getJSObject())).getCenterLonLat();
	}

	public void setPopup(Popup popup) {
		FeatureImpl.setPopup(this.getJSObject(), popup.getJSObject());
	}

	public Popup getPopup() {
		return Popup.narrowToOpenLayersPopup(FeatureImpl.getPopup(this.getJSObject()));
	}

	public void resetPopup() {
		FeatureImpl.resetPopup(this.getJSObject());
	}

	public void setStyle(Style newStyle) {
		FeatureImpl.setStyle(this.getJSObject(), newStyle.getJSObject());
	}
}
