package de.kp.ames.web.client.core.gui.portal;
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
import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.widgets.layout.HLayout;

public class Portal extends HLayout {
	
	// reference to the portlets organized by this portal
	private Map<String, PortletImpl> portlets = new HashMap<String, PortletImpl>();
	
	public Portal(int portalColumns, ArrayList<PortletConfig> jPortlets) {

		this.setMargin(5);
		this.setMembersMargin(5);  
		
		for (int i = 0; i < portalColumns; i++) {  
			this.addMember(new PortalColumn());  
		}  

		this.createPortlets(jPortlets);
		
	}
	
	/**
	 * @param jPortlets
	 */
	private void createPortlets(ArrayList<PortletConfig> jPortlets) {
		
		for (int i=0; i < jPortlets.size(); i++) {
			
			PortletConfig jPortlet = jPortlets.get(i);
			PortletImpl portlet = new PortletImpl(jPortlet);
			
			String uid = jPortlet.get(PortletConfig.PORTLET_ID).isString().stringValue();
			portlets.put(uid, portlet);
			
			this.addPortlet(portlet);
			
		}
		
	}

	/**
	 * @param portlet
	 */
	private void addPortlet(PortletImpl portlet) {  
		
		// find the column with the fewest portlets  
		int fewestPortlets = Integer.MAX_VALUE;  
		PortalColumn fewestPortletsColumn = null;
		
		for (int i = 0; i < getMembers().length; i++) {
			
			int numPortlets = ((PortalColumn) getMember(i)).getMembers().length;  
			if (numPortlets < fewestPortlets) {  
	
				fewestPortlets = numPortlets;  
				fewestPortletsColumn = (PortalColumn) getMember(i);  
			}  
		}  
		
		fewestPortletsColumn.addMember(portlet);  
		
	}  

}
