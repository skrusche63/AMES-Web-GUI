package de.kp.ames.web.client.openlayers.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadStartListener extends EventListener {

	class LoadStartEvent extends LayerEvent{

		public LoadStartEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onLoadStart(LoadStartEvent eventObject);
}
