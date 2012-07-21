package de.kp.ames.web.client.function.bulletin.widget;
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

import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.function.bulletin.data.PostGridImpl;
import de.kp.ames.web.client.function.bulletin.event.BulletinEventManager;
import de.kp.ames.web.client.function.bulletin.event.ContactListener;
import de.kp.ames.web.client.function.bulletin.handler.PostGridRecordHandlerImpl;
import de.kp.ames.web.client.handler.RemoveHandler;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class OverviewImpl extends VLayout implements ContactListener, RemoveHandler {

	/*
	 * Reference to registered postings
	 */
	private PostGridImpl grid;
	
	/**
	 * Contructor
	 */
	public OverviewImpl() {
		
		/*
		 * Dimensions
		 */
		setWidth100();
		setHeight100();
	
		/*
		 * Build member
		 */
		String recipient = null;
		grid = new PostGridImpl(recipient);
		
		/*
		 * Assign context specific record handler
		 */
		grid.addRecordHandler(new PostGridRecordHandlerImpl());		
		this.addMember(grid);
		
		/*
		 * Context specific event handling
		 */
		BulletinEventManager.getInstance().addContactListener(this);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.RemoveHandler#beforeRemove()
	 */
	public void beforeRemove() {
		BulletinEventManager.getInstance().removeContactListener(this);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.bulletin.event.ContactListener#onContactSelected(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	public void onContactSelected(ListGridRecord record) {
		
		String recipient = record.getAttributeAsString(JaxrConstants.RIM_ID);
		
		HashMap<String,String> attributes = new HashMap<String,String>();		
		attributes.put(MethodConstants.ATTR_TARGET, recipient);
		
		if (grid != null) grid.reload(attributes);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.bulletin.event.ContactListener#onPostingSubmitted(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	public void onPostingSubmitted(ListGridRecord record) {
		/*
		 * Reload posting grid to show the newly
		 * submitted posting to the user
		 */
		if (grid != null) grid.reload();
		
	}
	
}
