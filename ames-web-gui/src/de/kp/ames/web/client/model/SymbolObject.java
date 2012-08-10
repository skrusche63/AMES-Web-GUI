package de.kp.ames.web.client.model;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model
 *  Module: SymbolObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #model #object #symbol #web
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.tree.TreeGridField;

import de.kp.ames.web.client.model.external.ExternalObject;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class SymbolObject extends ExternalObject {
	
	/**
	 * Constructor
	 */
	public SymbolObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createDataFields()
	 */
	public DataSourceField[] createDataFieldsAsArray() {

		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Identifier (without label)
		 */
		DataSourceTextField id = new DataSourceTextField(JsonConstants.J_ID);
		id.setPrimaryKey(true);
		
		fields.add(id);

		/*
		 * Parent Identifier (without label)
		 */
		DataSourceTextField pid = new DataSourceTextField(JsonConstants.J_PID);

		pid.setForeignKey(JsonConstants.J_ID);
		fields.add(pid);

		/*
		 * Name
		 */
	    fields.add(new DataSourceTextField(JsonConstants.J_NAME, LabelConstants.NAME_LABEL));
		
		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.ExternalObject#createTreeGridFieldsAsList()
	 */
	public ArrayList<TreeGridField> createTreeGridFieldsAsList() {

		ArrayList<TreeGridField> fields = new ArrayList<TreeGridField>();

	    /*
		 * Name
		 */
	    fields.add(new TreeGridField(JsonConstants.J_NAME, LabelConstants.NAME_LABEL));
		
		return fields;
		
	}
	
}
