package de.kp.ames.web.client.openlayers.control;

/**
 * Options specific to Panel Control.
 *
 * @author Curtis Jensen
 *
 */
public class PanelOptions extends ControlOptions {

	public void setDefaultControl(Control defaultControl){
		getJSObject().setProperty("defaultControl",  defaultControl.getJSObject());
	}
}
