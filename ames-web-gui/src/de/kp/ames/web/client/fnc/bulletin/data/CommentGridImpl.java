package de.kp.ames.web.client.fnc.bulletin.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.bulletin.data
 *  Module: CommentGridImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #bulletin #client #comment #data #fnc #grid #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import de.kp.ames.web.client.core.grid.RemoteGridImpl;
import de.kp.ames.web.client.model.CommentObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class CommentGridImpl extends RemoteGridImpl {

	/**
	 * Constructor
	 * 
	 * @param posting
	 */
	public CommentGridImpl(String posting) {
		super(ServiceConstants.BULLETIN_SERVICE_ID);

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();	
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Comment);
		
		if (posting != null) attributes.put(MethodConstants.ATTR_TARGET, posting);

		/*
		 * Create data object
		 */
		this.dataObject = createDataObject();

		/*
		 * Create data source
		 */
		this.createScGridDS();

		/*
		 * Create grid fields
		 */
		this.setFields(createGridFields());

	}

	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new CommentObject();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return JaxrConstants.RIM_MESSAGE;
	}

}
