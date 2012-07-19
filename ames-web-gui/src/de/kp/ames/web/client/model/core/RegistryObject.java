package de.kp.ames.web.client.model.core;
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
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

import de.kp.ames.web.shared.JaxrConstants;
import de.kp.ames.web.shared.LabelConstants;

public class RegistryObject implements DataObject {

	/*
	 * Reference to label style for form items
	 */
	protected static String LABEL_STYLE = "x-sc-label";

	/**
	 * Constructor
	 */
	public RegistryObject() {
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.DataObject#createFormItemsAsArray()
	 */
	public FormItem[] createFormItemsAsArray() {
		
		ArrayList<FormItem> items = createFormItemsAsList();
		return (FormItem[])items.toArray(new FormItem [items.size()]);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.DataObject#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		/*
		 * Must be overridden
		 */
		return null;		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.DataObject#createDataFieldsAsArray()
	 */
	public DataSourceField[] createDataFieldsAsArray() {
		
		ArrayList<DataSourceField> fields = createDataFieldsAsList();
		return (DataSourceField[])fields.toArray(new DataSourceField [fields.size()]);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.DataObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Identifier    	
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
	 * @see de.kp.ames.web.client.model.core.DataObject#createListGridRecordsAsArray()
	 */
	public ListGridRecord[] createListGridRecordsAsArray() {
		
		ArrayList<ListGridRecord> records = createListGridRecordsAsList();
		return (ListGridRecord[])records.toArray(new ListGridRecord [records.size()]);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.DataObject#createListGridRecordsAsList()
	 */
	public ArrayList<ListGridRecord> createListGridRecordsAsList() {
		/*
		 * Must be overridden
		 */
		return null;		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.DataObject#createGridFieldsAsArray()
	 */
	public ListGridField[] createListGridFieldsAsArray() {
		
		ArrayList<ListGridField> fields = createListGridFieldsAsList();
		return (ListGridField[])fields.toArray(new ListGridField [fields.size()]);
				
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.DataObject#createGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {
		/*
		 * Must be overridden
		 */
		return null;
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.DataObject#createTreeGridFieldsAsArray()
	 */
	public TreeGridField[] createTreeGridFieldsAsArray() {
		
		ArrayList<TreeGridField> fields = createTreeGridFieldsAsList();
		return (TreeGridField[])fields.toArray(new ListGridField [fields.size()]);
				
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.DataObject#createTreeGridFieldsAsList()
	 */
	public ArrayList<TreeGridField> createTreeGridFieldsAsList() {
		/*
		 * Must be overridden
		 */
		return null;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.DataObject#createViewerFieldsAsArray()
	 */
	public DetailViewerField[] createViewerFieldsAsArray() {
		
		ArrayList<DetailViewerField> fields = createViewerFieldsAsList();
		return (DetailViewerField[])fields.toArray(new DetailViewerField [fields.size()]);
				
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.DataObject#createViewerFieldsAsList()
	 */
	public ArrayList<DetailViewerField> createViewerFieldsAsList() {
		/*
		 * Must be overridden
		 */
		return null;
	}

}
