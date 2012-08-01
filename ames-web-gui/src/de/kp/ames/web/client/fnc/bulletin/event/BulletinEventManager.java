package de.kp.ames.web.client.fnc.bulletin.event;
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

import com.smartgwt.client.data.Record;

public class BulletinEventManager implements ContactListener {

	private static BulletinEventManager instance = new BulletinEventManager();
	
	/*
	 * List of registered contact listeners
	 */
	private ArrayList<ContactListener> contactListeners;

	/**
	 * Constructor
	 */
	private BulletinEventManager() {
		
		contactListeners = new ArrayList<ContactListener>();
		
	}
	
	/**
	 * Retrieve singleton instance of BulletinEventManager
	 * 
	 * @return
	 */
	public static BulletinEventManager getInstance() {
		if (instance == null) instance = new BulletinEventManager();
		return instance;
	}
	
	/**
	 * Register contact listener
	 * 
	 * @param listener
	 */
	public void addContactListener(ContactListener listener) {
		contactListeners.add(listener);
	}
	
	/**
	 * Unregister contact listener
	 * 
	 * @param listener
	 */
	public void removeContactListener(ContactListener listener) {
		contactListeners.remove(listener);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.bulletin.event.ContactListener#onContactSelected(com.smartgwt.client.widgets.grid.Record)
	 */
	public void onContactSelected(Record record) {

		for (ContactListener listener:contactListeners) {
			listener.onContactSelected(record);
		}
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.fnc.bulletin.event.ContactListener#onPostingSubmitted()
	 */
	public void onPostingSubmitted() {

		for (ContactListener listener:contactListeners) {
			listener.onPostingSubmitted();
		}
	
	}

}