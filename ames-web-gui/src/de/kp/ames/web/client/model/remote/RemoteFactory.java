package de.kp.ames.web.client.model.remote;

import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.ClassificationConstants;

public class RemoteFactory {

	/**
	 * Determine remote DataObject from classification (type)
	 * 
	 * @param type
	 * @return
	 */
	public static DataObject getRemoteObject(String type) {
		
		if (type.equals(ClassificationConstants.FNC_ID_Database)) {
			/*
			 * Database Object
			 */
			return new DatabaseObject();
		
		}  else if (type.equals(ClassificationConstants.FNC_ID_Mail)) {
			/*
			 * IMAP Object
			 */
			return new ImapObject();
		
		} else if (type.equals(ClassificationConstants.FNC_ID_WebDav)) {
			/*
			 * WebDAV Resource
			 */
			return new DavObject();
		}
		
		return null;
	}
	
}
