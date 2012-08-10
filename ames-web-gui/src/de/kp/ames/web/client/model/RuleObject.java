package de.kp.ames.web.client.model;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model
 *  Module: RuleObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #model #object #rule #web
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;

import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.core.grid.GridFieldFactory;
import de.kp.ames.web.client.model.core.RegistryPackage;

public class RuleObject extends RegistryPackage {

	public RuleObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();

		/*
		 * Product icon
		 */
		fields.add(GridFieldFactory.createRimIconField());
		
		/*
		 * Product name
		 */
		fields.add(GridFieldFactory.createRimNameField(160));

		/*
		 * Evaluation author
		 */
		fields.add(GridFieldFactory.createRimAuthorField("*"));
		
		return fields;
		
	}

}
