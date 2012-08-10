package de.kp.ames.web.client.model.remote;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model.remote
 *  Module: RemoteFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #factory #model #remote #web
 * </SemanticAssist>
 *
 */


import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;

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
