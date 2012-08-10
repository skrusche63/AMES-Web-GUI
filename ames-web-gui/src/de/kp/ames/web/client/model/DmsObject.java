package de.kp.ames.web.client.model;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model
 *  Module: DmsObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #dms #model #object #web
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

import java.util.ArrayList;

import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.core.grid.GridFieldFactory;
import de.kp.ames.web.client.model.core.ExtrinsicObject;

public class DmsObject extends ExtrinsicObject {

	public DmsObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryObject#createGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();

		/*
		 * Document icon
		 */
		fields.add(GridFieldFactory.createRimIconField());
		
		/*
		 * Document name
		 */
		fields.add(GridFieldFactory.createRimNameField(160));

		/*
		 * Document mimetype
		 */
		fields.add(GridFieldFactory.createRimMimeField(120));

		/*
		 * Document author
		 */
		fields.add(GridFieldFactory.createRimAuthorField("*"));
		
		return fields;
		
	}

}
