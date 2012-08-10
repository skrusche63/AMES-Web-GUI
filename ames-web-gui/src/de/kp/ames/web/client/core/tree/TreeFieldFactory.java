package de.kp.ames.web.client.core.tree;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.tree
 *  Module: TreeFieldFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #factory #field #tree #web
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

import com.smartgwt.client.widgets.tree.TreeGridField;

import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class TreeFieldFactory {

	/**
	 * Create a predefined Name Field
	 *
	 * @return
	 */
	public static TreeGridField createRimNameField() {
		return createRimNameField(160);
	}

	/**
	 * Create a predefined Name Field
	 * 
	 * @return
	 */
	public static TreeGridField createRimNameField(int width) {
		
		TreeGridField nameField = new TreeGridField(JaxrConstants.RIM_NAME, LabelConstants.NAME_LABEL, width);
		return nameField;
		
	}

}
