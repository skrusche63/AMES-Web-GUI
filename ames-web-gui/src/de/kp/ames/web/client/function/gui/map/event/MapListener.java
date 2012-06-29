package de.kp.ames.web.client.function.gui.map.event;

public interface MapListener {

	public void onDrag(String key, double lat, double lon);

	public void onDragComplete(String key, double lat, double lon);

}