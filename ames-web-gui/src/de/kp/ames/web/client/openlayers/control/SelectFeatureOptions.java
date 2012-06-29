package de.kp.ames.web.client.openlayers.control;


import de.kp.ames.web.client.openlayers.control.SelectFeature.SelectFeatureListener;
import de.kp.ames.web.client.openlayers.control.SelectFeature.UnselectFeatureListener;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * See {@link SelectFeature}.
 *
 * Default mode of selection is clickout, see {@link SelectFeature}.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class SelectFeatureOptions extends ControlOptions {

	/**
	 *
	 */
	public void setHover(){
		getJSObject().setProperty("hover", true);
	}

	//__EXTENSION__
	/**
	 *
	 */
	public void setToggle(){
		getJSObject().setProperty("toggle", true);
	}

	/**
	 *
	 */
	public void setMultiple(){
		getJSObject().setProperty("multiple", true);
	}

	/**
	 * Triggers when a feature is selected
	 *
	 */
	public void onSelect(SelectFeatureListener listener){
		JSObject callback = SelectFeatureImpl.createSelectFeatureCallback(listener);
		getJSObject().setProperty("onSelect", callback);
	}

	/**
	 * Triggers when a feature is unselected
	 *
	 */
	public void onUnSelect(UnselectFeatureListener listener){
		JSObject callback = SelectFeatureImpl.createUnselectFeatureCallback(listener);
		getJSObject().setProperty("onUnselect", callback);
	}

}
