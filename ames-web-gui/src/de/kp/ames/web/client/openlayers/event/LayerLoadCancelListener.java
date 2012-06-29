package de.kp.ames.web.client.openlayers.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadCancelListener extends EventListener {

	class LoadCancelEvent extends LayerEvent{

		public LoadCancelEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onLoadCancel(LoadCancelEvent eventObject);
}
