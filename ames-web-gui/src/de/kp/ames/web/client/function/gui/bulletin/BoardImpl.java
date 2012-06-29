package de.kp.ames.web.client.function.gui.bulletin;
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

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.function.gui.bulletin.event.ContactListener;

public class BoardImpl extends VLayout implements ContactListener {

	private OverviewImpl overview;
	private DetailImpl details;

	public BoardImpl() {
				
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Set overview & details; note, that overview
		 * depends on a detail widget to show a selected
		 * posting
		 */
		details = new DetailImpl();
		overview = new OverviewImpl(details);
		
		/*
		 * Set Dimensions and splitter
		 */
		
		overview.setHeight("75%");
		details.setHeight("25%");
		
		/*
		 * Show splitter for overview
		 */
		overview.setShowResizeBar(true);
		
		/*
		 * Set members to board
		 */
		this.setMembers(overview, details);

	}

	/* This method loads all posting of a certain
	 * selected recipient
	 * 
	 * @see de.kp.ames.web.client.function.gui.bulletin.event.ContactListener#onContactSelected(java.lang.String)
	 */
	public void onContactSelected(String recipient) {		
		/*
		 * Reload positing of a certain recipient
		 */
		overview.reload(recipient);

	}
}
