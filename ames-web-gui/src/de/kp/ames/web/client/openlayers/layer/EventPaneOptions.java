package de.kp.ames.web.client.openlayers.layer;

/**
 *
 * @author Edwin Commandeur - Atlis Information Systems
 *
 */
public class EventPaneOptions extends LayerOptions {

	public void setSmoothDragPan(boolean smoothDragPan) {
		getJSObject().setProperty("smoothDragPan", smoothDragPan);
	}

	public void setIsFixed(boolean isFixed) {
		getJSObject().setProperty("isFixed", isFixed);
	}

}
