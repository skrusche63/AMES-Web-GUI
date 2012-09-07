package de.kp.ames.web.client.model;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model
 *  Module: NsObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #model #ns #object #web
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

import java.util.ArrayList;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tree.TreeGridField;

import de.kp.ames.web.client.core.tree.TreeFieldFactory;
import de.kp.ames.web.client.model.core.RegistryPackage;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class NsObject extends RegistryPackage {

	/**
	 * Constructor
	 */
	public NsObject() {	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createDataFieldsAsList()
	 */
	@Override
	public ArrayList<DataSourceField> createDataFieldsAsList() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		SC.logWarn("====> NsObject.createDataFieldsAsList");
		/*
		 * Separated Identifier from RIM_ID    	
		 */
		DataSourceTextField id = new DataSourceTextField(JsonConstants.J_ID);
		id.setPrimaryKey(true);
		fields.add(id);
		
		/*
		 * Parent Identifier (without label) for hierarchical TreeGrids
		 */
		DataSourceTextField pid = new DataSourceTextField(JsonConstants.J_PID);
		pid.setForeignKey(JsonConstants.J_ID);
		fields.add(pid);

		
		/*
		 * Separated RIM Identifier    	
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_ID, LabelConstants.ID_LABEL));

		/* 
		 * Name
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_NAME, LabelConstants.NAME_LABEL));
		
		/*
		 * Description
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_DESC, LabelConstants.DESC_LABEL));

		/*
		 * Object type
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_TYPE, LabelConstants.TYPE_LABEL));
    	   	    	
		/*
		 * Home
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_HOME, LabelConstants.HOME_LABEL));
		
		/*
		 * Status
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_STATUS, LabelConstants.STATUS_LABEL));
		
		/* 
		 * Version					
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_VERSION, LabelConstants.VERSION_LABEL));

		/*
		 * Author
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_AUTHOR, LabelConstants.AUTHOR_LABEL));
		
		/*
		 * Owner
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_OWNER, LabelConstants.OWNER_LABEL));
		
		/*
		 * Timestamp & events
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_EVENT, LabelConstants.EVENT_LABEL));
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_TIMESTAMP, LabelConstants.TIMESTAMP_LABEL));
							
		/*
		 * Classifications (without label)
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_CLAS));

		/*
		 * Slots (without label)
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_SLOT));
		
		return fields;
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createTreeGridFieldsAsArray()
	 */
	public TreeGridField[] createTreeGridFieldsAsArray() {

		ArrayList<TreeGridField> fields = createTreeGridFieldsAsList();
		return (TreeGridField[])fields.toArray(new TreeGridField [fields.size()]);
				
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryObject#createTreeGridFieldsAsList()
	 */
	public ArrayList<TreeGridField> createTreeGridFieldsAsList() {

		ArrayList<TreeGridField> fields = new ArrayList<TreeGridField>();

	    /*
		 * Name
		 */
	    fields.add(TreeFieldFactory.createRimNameField());
		
		return fields;

	}
	
}
