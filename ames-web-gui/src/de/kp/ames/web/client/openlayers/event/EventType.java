/**
 *
 */
package de.kp.ames.web.client.openlayers.event;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EventType {

	public static final String CONTROL_ACTIVATE = "activate";
	public static final String CONTROL_DEACTIVATE = "deactivate";

	public static final String LAYER_LOADSTART = "loadstart";
	public static final String LAYER_LOADEND = "loadend";
	public static final String LAYER_LOADCANCEL = "loadcancel";
	public static final String LAYER_VISIBILITYCHANGED = "visibilitychanged";

	public static final String MAP_BASE_LAYER_CHANGED = "changebaselayer";
	public static final String MAP_CLICK = "click";
	public static final String MAP_LAYER_ADDED = "addlayer";
	public static final String MAP_LAYER_CHANGED = "changelayer";
	public static final String MAP_LAYER_REMOVED = "removelayer";
	public static final String MAP_MOVE = "move";
	public static final String MAP_ZOOMEND = "zoomend";
	public static final String MAP_POPUP_OPEN = "popupopen";
	public static final String MAP_POPUP_CLOSE = "popupclose";
	public static final String MAP_MARKER_ADDED = "addmarker";
	public static final String MAP_MARKER_REMOVED = "removemarker";

	public static final String VECTOR_BEFORE_FEATURE_ADDED = "beforefeatureadded";
	public static final String VECTOR_FEATURE_ADDED = "featureadded";
	public static final String VECTOR_FEATURE_MODIFIED = "featuremodified";
	public static final String VECTOR_FEATURE_REMOVED = "featureremoved";
	public static final String VECTOR_FEATURE_SELECTED = "featureselected";
	public static final String VECTOR_FEATURE_UNSELECTED = "featureunselected";
}

