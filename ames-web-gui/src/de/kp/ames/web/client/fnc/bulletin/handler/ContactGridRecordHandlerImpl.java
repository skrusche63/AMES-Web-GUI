package de.kp.ames.web.client.fnc.bulletin.handler;
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

import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.fnc.bulletin.event.BulletinEventManager;
import de.kp.ames.web.client.handler.GridRecordHandlerImpl;

public class ContactGridRecordHandlerImpl extends GridRecordHandlerImpl {

	/**
	 * Constructor
	 */
	public ContactGridRecordHandlerImpl() {
		super();
	}
	
	public void doSelect(Record record) {
		/*
		 * Invoke Event Handling to inform other components
		 * about the selection of a certain contact
		 */
		BulletinEventManager.getInstance().onContactSelected(record);
		
	}
}
