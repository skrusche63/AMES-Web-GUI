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

import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.handler.RemoveHandler;

public class BulletinImpl extends BaseApp {

	/*
	 * Reference to contacts
	 */
	private ContactsImpl contacts;
	
	/*
	 * Reference to board
	 */
	private BoardImpl board;
	
	/*
	 * Reference to removable members
	 */
	private ArrayList<RemoveHandler> removables;
	
	/**
	 * Constructor
	 */
	public BulletinImpl() {
		super(FncGlobals.BULLETIN_TITLE, FncGlobals.BULLETIN_SLOGAN);
		
		this.removables = new ArrayList<RemoveHandler>();
		
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Construct members of bulletin board
		 */
		contacts = new ContactsImpl();
		removables.add(contacts);
		
		board = new BoardImpl();
		removables.add(board);
		
		/*
		 * Set Dimensions and splitter
		 */		
		contacts.setWidth(240);
		board.setWidth("*");
		
		/*
		 * Show splitter for contacts
		 */
		contacts.setShowResizeBar(true);
		
		/*
		 * Set members to bulletin board
		 */
		this.setContent(contacts, board);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.base.BaseApp#beforeRemove()
	 */
	public void beforeRemove() {

		for (RemoveHandler removable:removables) {
			removable.beforeRemove();
		}
		
	}
	
}
