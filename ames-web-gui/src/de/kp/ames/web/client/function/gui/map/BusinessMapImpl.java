package de.kp.ames.web.client.function.gui.map;

import java.util.ArrayList;

import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.function.gui.map.event.MapListener;
import de.kp.ames.web.client.openlayers.LonLat;
import de.kp.ames.web.client.openlayers.feature.VectorFeature;
import de.kp.ames.web.client.openlayers.geometry.Point;

public class BusinessMapImpl extends BaseMapImpl {

	private static String REGISTRY_ICON = "images/registry.34.png";

	public BusinessMapImpl(MapConfig jGeoInfo, MapListener listener) {
		super(jGeoInfo, listener);
	}
	
	public void addRegistry(Record record) {
		
		// retrieve lat & lon from the center coordinate
		LonLat center = map.getCenter();

		double lat = center.lat();
		double lon = center.lon();
		
		String key = record.getAttributeAsString("key");
		
		if (featureKeys == null) featureKeys = new ArrayList<String>();
		if (featureKeys.contains(key)) return;

		// register feature key
		featureKeys.add(key);

		double res = map.getResolution();

		double x = lon + res*18;
		double y = lat;

		VectorFeature feature = new VectorFeature(new Point(x,y));		
		feature.setPluginStyle();

		feature.setExternalGraphic(REGISTRY_ICON, true);

		// key (common to all objects, see drag&drop)
		feature.setAttributeAsString(FEA_ATTR_KEY, key);
	
		String title = record.getAttributeAsString("name");		
		feature.setAttributeAsString(FEA_ATTR_NAME, title);

		// build description
		StringBuffer description = new StringBuffer();
		description.append(record.getAttributeAsString("desc"));		
		
		feature.setAttributeAsString(FEA_ATTR_DESC, description.toString());

		feature.setLabel(title);

		featureLayer.addFeature(feature);		
		featureLayer.drawFeature(feature);
		
	}

	public void setRegistry(Record record) {

		String lon = record.getAttributeAsString("lon");
		String lat = record.getAttributeAsString("lat");

		if ((lat == null) || (lon == null)) return;
		if (lat.equals("null") || lon.equals("null")) return;
		
		String key = record.getAttributeAsString("key");
		
		if (featureKeys == null) featureKeys = new ArrayList<String>();
		if (featureKeys.contains(key)) return;

		// register feature key
		featureKeys.add(key);

		double res = map.getResolution();

		double x = Double.valueOf(lon) + res*18;
		double y = Double.valueOf(lat);

		VectorFeature feature = new VectorFeature(new Point(x,y));		
		feature.setPluginStyle();

		feature.setExternalGraphic(REGISTRY_ICON, true);

		// key (common to all objects, see drag&drop)
		feature.setAttributeAsString(FEA_ATTR_KEY, key);
	
		String title = record.getAttributeAsString("name");		
		feature.setAttributeAsString(FEA_ATTR_NAME, title);

		// build description
		StringBuffer description = new StringBuffer();
		description.append(record.getAttributeAsString("desc"));		

		feature.setAttributeAsString(FEA_ATTR_DESC, description.toString());

		feature.setLabel(title);

		featureLayer.addFeature(feature);		
		featureLayer.drawFeature(feature);
		
	}

}
