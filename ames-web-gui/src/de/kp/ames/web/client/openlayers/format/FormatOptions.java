package de.kp.ames.web.client.openlayers.format;

import de.kp.ames.web.client.openlayers.Projection;
import de.kp.ames.web.client.openlayers.util.JSObject;
import de.kp.ames.web.client.openlayers.util.JSObjectWrapper;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class FormatOptions extends JSObjectWrapper {

	protected FormatOptions(JSObject jsObject) {
		super(jsObject);
	}

	public FormatOptions(){
		this(JSObject.createJSObject());
	}

	/**
	 *
	 * @param projection
	 */
	public void setInternalProjection(Projection projection){
		getJSObject().setProperty("internalProjection", projection.getJSObject());
	};

	/**
	 *
	 * @param projection
	 */
	public void setExternalProjection(Projection projection){
		getJSObject().setProperty("externalProjection", projection.getJSObject());
	};

	/**
	 * 
	 * @param extractStyles
	 */
	public void setExtractStyles(boolean extractStyles){
		getJSObject().setProperty("extractStyles", extractStyles);
	};

	/**
	 * 
	 * @param extractAttributes
	 */
	public void setExtractAttributes(boolean extractAttributes){
		getJSObject().setProperty("extractAttributes", extractAttributes);
	};

}
