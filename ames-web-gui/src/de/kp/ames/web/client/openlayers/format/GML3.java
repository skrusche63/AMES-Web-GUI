package de.kp.ames.web.client.openlayers.format;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * Brief explanation of Geographic Markup Language (GML) vector format here.
 *
 * Reference to GML specification. GML is OGC standard.
 *
 * See http://www.ogc.org/
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class GML3 extends VectorFormat {

	protected GML3(JSObject gmlFormat){
		super(gmlFormat);
	}

	public GML3(){
		this(GML3Impl.create());
	}

}
