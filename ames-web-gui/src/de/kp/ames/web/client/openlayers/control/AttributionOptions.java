/**
 *
 */
package de.kp.ames.web.client.openlayers.control;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class AttributionOptions extends ControlOptions {

	/**
	 * String used to separate layers (from OL docs).
	 *
	 * Default separator is ", ".
	 */
	public void setSeparator(String separator){
		getJSObject().setProperty("separator", separator);
	}
}
