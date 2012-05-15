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

import de.kp.ames.web.client.core.gui.apps.BaseApp;
import de.kp.ames.web.client.function.gui.bulletin.event.BulletinEventManager;
import de.kp.ames.web.client.function.gui.globals.FncGlobals;

public class BulletinImpl extends BaseApp {

	private ContactsImpl contacts;
	private BoardImpl board;
	
	public BulletinImpl() {
		super(FncGlobals.BULLETIN_TITLE, FncGlobals.BULLETIN_SLOGAN);
		
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Construct members of bulletin board
		 */
		contacts = createContacts();
		board = createBoard();
		
		/*
		 * Set Dimensions and splitter
		 */		
		contacts.setWidth("25%");
		board.setWidth("75%");
		
		/*
		 * Show splitter for contacts
		 */
		contacts.setShowResizeBar(true);
		
		/*
		 * Set members to bulletin board
		 */
		this.setContent(contacts, board);
		
		/*
		 * Register board as contact listener
		 */
		BulletinEventManager.getInstance().addContactListener(board);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.gui.apps.BaseApp#beforeRemove()
	 */
	public void beforeRemove() {
		
		/*
		 * The board part is a ContactListener and
		 * must be removed from the respective event
		 * manager
		 */
		BulletinEventManager.getInstance().removeContactListener(board);
		
	}

	/**
	 * Create contact part of bulletin board
	 * 
	 * @return
	 */
	private ContactsImpl createContacts() {
		return new ContactsImpl();
	}
	
	/**
	 * Create board part of bulletin board
	 * 
	 * @return
	 */
	private BoardImpl createBoard() {
		return new BoardImpl();
	}
	
}
