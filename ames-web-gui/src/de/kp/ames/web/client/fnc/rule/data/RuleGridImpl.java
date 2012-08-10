package de.kp.ames.web.client.fnc.rule.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.rule.data
 *  Module: RuleGridImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #data #fnc #grid #rule #web
 * </SemanticAssist>
 *
 */

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

import de.kp.ames.web.client.core.grid.RemoteGridImpl;
import de.kp.ames.web.client.model.EvaluationObject;
import de.kp.ames.web.client.model.ReasonerObject;
import de.kp.ames.web.client.model.RuleObject;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class RuleGridImpl extends RemoteGridImpl {

	/**
	 * Constructor
	 * 
	 * @param type
	 * @param item
	 */
	public RuleGridImpl(String type) {
		super(ServiceConstants.RULE_SERVICE_ID);

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, type);

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

		/*
		 * Distinguish between evaluations & reasoners
		 */
		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Evaluation)) {			
			/*
			 * Create data fields for evaluation grid
			 */
			return new EvaluationObject();
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Reasoner)) {
			/*
			 * Create data fields for reasoner grid
			 */
			return new ReasonerObject();

		} else if (type.equals(ClassificationConstants.FNC_ID_Rule)) {
			/*
			 * Create data fields for rule grid
			 */
			return new RuleObject();

		}

		return null;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.grid.GridImpl#getDetailFieldName()
	 */
	public String getDetailFieldName() {
		return JaxrConstants.RIM_DESC;
	}

}
