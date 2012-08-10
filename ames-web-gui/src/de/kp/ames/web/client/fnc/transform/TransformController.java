package de.kp.ames.web.client.fnc.transform;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.transform
 *  Module: TransformController
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #controller #fnc #transform #web
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

import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.controller.ControllerImpl;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.service.FrameService;
import de.kp.ames.web.client.core.spec.data.SpecGridImpl;
import de.kp.ames.web.client.core.widget.viewer.ViewerFactory;
import de.kp.ames.web.client.fnc.transform.widget.TransformSpecDialog;
import de.kp.ames.web.client.fnc.transform.widget.TransformCreateDialog;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.FormatConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class TransformController extends ControllerImpl {

	/**
	 * Constructor
	 */
	public TransformController() {
	}

	/**
	 * Create (local) specification or (remote) transformator
	 * 
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.ControllerImpl#doCreate(java.util.HashMap, de.kp.ames.web.client.core.grid.Grid, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doCreate(HashMap<String,String> attributes, Grid grid, Activity activity) {
		
		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Specification)) {
			
			/*
			 * Create dialog: the referenced grid is the SpecGrid
			 */
			TransformSpecDialog createDialog = new TransformSpecDialog(grid);
			
			/*
			 * Provide request specific information
			 */
			createDialog.setParams(attributes);
			createDialog.addSendActivity(activity);
			
		}

		if (type.equals(ClassificationConstants.FNC_ID_Transformator)) {
			TransformCreateDialog.create(attributes, activity);
			
		}

	}

	/**
	 * Delete (local) specification or (remote) transformator
	 * 
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.ControllerImpl#doDelete(java.util.HashMap, de.kp.ames.web.client.core.grid.Grid, com.smartgwt.client.data.Record, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doDelete(HashMap<String,String> attributes, Grid grid, Record record, Activity activity) {

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Specification)) {
			/*
			 * Remove data from local grid
			 */
			((SpecGridImpl)grid).removeData(record);

		}

		if (type.equals(ClassificationConstants.FNC_ID_Transformator)) {

			/*
			 * Prepare data for delete request
			 */
			attributes.put(MethodConstants.ATTR_ITEM, record.getAttributeAsString(JaxrConstants.RIM_ID));
			
			/*
			 * Invoke delete request
			 */
			TransformService service = new TransformService();
			service.doDelete(attributes, activity);
		}
		
	}

	/**
	 * View specification or transformator (XSL file)
	 * 
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.ControllerImpl#doView(java.util.HashMap, com.smartgwt.client.data.Record)
	 */
	public void doView(HashMap<String,String> attributes, Record record) {

		/*
		 * View transformator either from cache or from the registry
		 */
		String format = FormatConstants.FNC_FORMAT_ID_File;
		attributes.put(MethodConstants.ATTR_FORMAT, format);
			
		String item = record.getAttributeAsString(JaxrConstants.RIM_ID);
		attributes.put(MethodConstants.ATTR_ITEM, item);
		
		/*
		 * Build request uri
		 */
		FrameService service = new FrameService();
		String uri = service.getUri(attributes);

		/*
		 * Build viewer
		 */
		String title  = GUIGlobals.APP_TITLE + ": Transform Viewer";
		String slogan = "Use this widget to view a certain transformator.";
		
		ViewerFactory.createFrameViewer(title, slogan, uri);
		
	}

}
