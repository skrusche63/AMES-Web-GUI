package de.kp.ames.web.client.fnc.bulletin.widget;
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

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.handler.RemoveHandler;

public class BoardImpl extends VLayout implements RemoveHandler {

	/*
	 * Reference to overview
	 */
	private OverviewImpl overview;
	
	/*
	 * Reference to details
	 */
	private DetailImpl details;
	
	/*
	 * Reference to removable members
	 */
	private ArrayList<RemoveHandler> removables;

	/**
	 * Constructor
	 */
	public BoardImpl() {
		
		this.removables = new ArrayList<RemoveHandler>();
				
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Build members
		 */
		overview = new OverviewImpl();
		removables.add(overview);
		
		details  = new DetailImpl();
		removables.add(details);
		
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

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.RemoveHandler#beforeRemove()
	 */
	public void beforeRemove() {

		for (RemoveHandler removable:removables) {
			removable.beforeRemove();
		}
		
	}

}
