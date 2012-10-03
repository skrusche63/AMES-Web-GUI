package de.kp.ames.web.client.core.clas;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.clas
 *  Module: ClasController
 *  @author spex66@gmx.net
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #controller #clas #classification #core #web
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
import de.kp.ames.web.client.core.clas.data.ClasGridImpl;
import de.kp.ames.web.client.core.clas.widget.ClasDialog;
import de.kp.ames.web.client.core.controller.ControllerImpl;
import de.kp.ames.web.client.core.grid.Grid;

public class ClasController extends ControllerImpl {
	
	/**
	 * Constructor
	 */
	public ClasController() {
	}

	/**
	 * @param attributes
	 * @param afterSendActivity
	 */
	public void doCreate(HashMap<String,String> attributes, Grid refGrid, Activity afterSendActivity) {
		
		/*
		 * Create dialog: the referenced grid is the classification grid
		 */
		ClasDialog createDialog = new ClasDialog(refGrid);
		
		/*
		 * Provide request specific information
		 */
		createDialog.setParams(attributes);
		createDialog.addSendActivity(afterSendActivity);
	}

	
	/**
	 * Delete (local) classification
	 * 
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.controller.ControllerImpl#doDelete(java.util.HashMap, de.kp.ames.web.client.core.grid.Grid, com.smartgwt.client.data.Record, de.kp.ames.web.client.core.activity.Activity)
	 */
	public void doDelete(HashMap<String,String> attributes, Grid refGrid, Record record, Activity activity) {

		/*
		 * Remove data from local classification grid
		 */
		((ClasGridImpl)refGrid).removeData(record);
	}

}
