package de.kp.ames.web.client.core.portal;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.portal
 *  Module: PortalColumn
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #column #core #portal #web
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

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VStack;

/**
 * A VStack layout to represent the column of a portal
 * 
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */

public class PortalColumn extends VStack {  

	public PortalColumn() {  
		
		// leave some space between portlets  
		setMembersMargin(PortalConstants.MEMBERS_MARGIN);  

		// enable predefined component animation  
		setAnimateMembers(true);  
		setAnimateMemberTime(PortalConstants.MEMBER_TIME);  

		// enable drop handling  
		setCanAcceptDrop(true);  

		// change appearance of drag placeholder and drop indicator  
		setDropLineThickness(PortalConstants.DROPLINE_THICKNESS);  
 
		Canvas dropLineProperties = new Canvas();
		
		dropLineProperties.setBackgroundColor(PortalConstants.DROPLINE_BACKGROUND);  
		setDropLineProperties(dropLineProperties);  

		setShowDragPlaceHolder(true);  

		Canvas placeHolderProperties = new Canvas();  
		
		placeHolderProperties.setBorder(PortalConstants.PLACEHOLDER_BORDER);  
		setPlaceHolderProperties(placeHolderProperties);  

	}  

}
