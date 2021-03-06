package de.kp.ames.web.client.fnc.transform;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.transform
 *  Module: TransformService
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #service #transform #web
 * </SemanticAssist>
 *
 */

/**
 *	Copyright 2012 Dr. Krusche & Partner PartG
 *
 *	AMES-Web-GUI is free software: you can redistribute it and/or 
 *	modify it under the terms of the GNU General Public License 
 *	as published by the Free Software Foundation, either version 3 of 
 *	the License, or (at your option) any later version.
 *
 *	AMES- Web-GUI is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 *  See the GNU General Public License for more details. 
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this software. If not, see <http://www.gnu.org/licenses/>.
 *
 */

import java.util.HashMap;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.service.ServiceImpl;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class TransformService extends ServiceImpl {

	/**
	 * Constructor
	 */
	public TransformService() {
		super(GuiConstants.REG_URL, ServiceConstants.TRANSFORM_SERVICE_ID);
	}

	/**
	 * A JSON based non-widget APPLY request; this request supports the
	 * application of a certain transformator (source) against a specific
	 * registry-object (source). The result of the transformation is
	 * registered as repository item in a target object.
	 * 
	 *                 source --> service --> target
	 * 
	 * This functionality actually has not UI representation.
	 * 
	 * @param source
	 * @param target
	 * @param service
	 * @param activity
	 */
	public void doApply(String source, String service, String target, Activity activity) {

		HashMap<String,String> attributes = new HashMap<String,String>();
		
		attributes.put(MethodConstants.ATTR_SOURCE, source);
		attributes.put(MethodConstants.ATTR_TARGET, target);
		
		attributes.put(MethodConstants.ATTR_SERVICE, service);
		
		doApply(attributes, activity);
	
	}
	
	/**
	 * A JSON based non-widget GET request
	 * 
	 * @param format
	 * @param type
	 * @param source
	 * @param activity
	 */
	public void doGet(String format, String type, String item, Activity activity) {

		HashMap<String,String> attributes = new HashMap<String,String>();

		attributes.put(MethodConstants.ATTR_FORMAT, format);
		attributes.put(MethodConstants.ATTR_TYPE,   type);
		
		if (item != null) attributes.put(MethodConstants.ATTR_ITEM, item);

		doGetJson(attributes, activity);
		
	}

}
