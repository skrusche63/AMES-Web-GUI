package de.kp.ames.web.client.core.grid;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.grid
 *  Module: GridFieldFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #factory #field #grid #web
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

import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class GridFieldFactory {

	/**
	 * Create a predefined Author Field
	 *
	 * @return
	 */
	public static ListGridField createRimAuthorField() {
		return createRimNameField(160);
	}

	/**
	 * Create a predefined Author Field
	 * 
	 * @return
	 */
	public static ListGridField createRimAuthorField(int width) {
		
		ListGridField authorField = new ListGridField(JaxrConstants.RIM_AUTHOR, LabelConstants.AUTHOR_LABEL, width);
		authorField.setType(ListGridFieldType.TEXT);

		return authorField;
		
	}

	/**
	 * Create a predefined Author Field
	 * 
	 * @param width
	 * @return
	 */
	public static ListGridField createRimAuthorField(String width) {
		
		ListGridField authorField = new ListGridField(JaxrConstants.RIM_AUTHOR, LabelConstants.AUTHOR_LABEL);
		
		authorField.setType(ListGridFieldType.TEXT);
		authorField.setWidth(width);
		
		return authorField;
		
	}

	/**
	 * Create a predefined Icon Field
	 *
	 * @return
	 */
	public static ListGridField createRimIconField() {
		return createRimIconField(40);
	}

	/**
	 * Create a predefined Icon Field
	 * 
	 * @return
	 */
	public static ListGridField createRimIconField(int width) {
		
		ListGridField iconField = new ListGridField(JaxrConstants.RIM_ICON, " ", width);
		iconField.setType(ListGridFieldType.IMAGE);
		
		iconField.setImageSize(16);
		
		iconField.setImageURLPrefix(GUIGlobals.ICON_DIR);
		iconField.setImageURLSuffix(GUIGlobals.ICON_SUFFIX);

		return iconField;
		
	}

	/**
	 * Create a predefined Mimetype Field
	 *
	 * @return
	 */
	public static ListGridField createRimMimeField() {
		return createRimMimeField(160);
	}

	/**
	 * Create a predefined Mimetype Field
	 * 
	 * @return
	 */
	public static ListGridField createRimMimeField(int width) {
		
		ListGridField mimeField = new ListGridField(JaxrConstants.RIM_MIME, LabelConstants.MIME_LABEL, width);
		mimeField.setType(ListGridFieldType.TEXT);

		return mimeField;
		
	}

	/**
	 * Create a predefined Name Field
	 *
	 * @return
	 */
	public static ListGridField createRimNameField() {
		return createRimNameField(160);
	}

	/**
	 * Create a predefined Name Field
	 * 
	 * @return
	 */
	public static ListGridField createRimNameField(int width) {
		
		ListGridField nameField = new ListGridField(JaxrConstants.RIM_NAME, LabelConstants.NAME_LABEL, width);
		nameField.setType(ListGridFieldType.TEXT);

		return nameField;
		
	}

	/**
	 * Create a predefined Name Field
	 * 
	 * @return
	 */
	public static ListGridField createRimNameField(String width) {
		
		ListGridField nameField = new ListGridField(JaxrConstants.RIM_NAME, LabelConstants.NAME_LABEL);
		
		nameField.setType(ListGridFieldType.TEXT);
		nameField.setWidth("*");
		
		return nameField;
		
	}

}
