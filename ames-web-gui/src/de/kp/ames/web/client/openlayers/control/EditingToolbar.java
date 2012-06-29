package de.kp.ames.web.client.openlayers.control;


import de.kp.ames.web.client.openlayers.layer.Vector;
import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EditingToolbar extends Control{

	protected EditingToolbar(JSObject element){
		super(element);
	}

	public EditingToolbar(Vector vectorLayer){
		this(EditingToolbarImpl.create(vectorLayer.getJSObject()));
	}

	public EditingToolbar(Vector vectorLayer, EditingToolbarOptions options){
		this(EditingToolbarImpl.create(vectorLayer.getJSObject(), options.getJSObject()));
	}
}
