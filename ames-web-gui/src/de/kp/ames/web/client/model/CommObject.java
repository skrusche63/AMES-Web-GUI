package de.kp.ames.web.client.model;

import java.util.ArrayList;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.model.core.ExtrinsicObject;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class CommObject extends ExtrinsicObject {
	
	public CommObject() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtrinsicObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {
		
		ArrayList<DataSourceField> fields = new ArrayList<DataSourceField>();

		/*
		 * Identifier (without label)
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_ID));

		/*
		 * Timestamp
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_TIMESTAMP, LabelConstants.TIMESTAMP_LABEL));

		/*
		 * Subject
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_SUBJECT, LabelConstants.SUBJECT_LABEL));

		/*
		 * From
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_FROM, LabelConstants.FROM_LABEL));

		/*
		 * Message (without label)
		 */
		fields.add(new DataSourceTextField(JaxrConstants.RIM_MESSAGE));

	    return fields;

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryObject#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		
		ArrayList<FormItem> items = new ArrayList<FormItem>();

		/*
		 * Space for rendering purpose only
		 */
		SpacerItem spacer = new SpacerItem();
		spacer.setHeight(2);

		/*
		 * Build timestamp
		 */
		TextItem timeStampItem = GuiFormFactory.createScTextItem("<b>Timestap</b>:", JaxrConstants.RIM_TIMESTAMP, LABEL_STYLE, 280);
		items.add(timeStampItem);
		
		items.add(spacer);
		items.add(spacer);
		
		/*
		 * Build from
		 */
		TextItem fromItem = GuiFormFactory.createScTextItem("<b>From</b>:", JaxrConstants.RIM_FROM, LABEL_STYLE, 280);
		items.add(fromItem);
		
		items.add(spacer);
		items.add(spacer);

		/*
		 * Build subject
		 */
		TextItem subjectItem = GuiFormFactory.createScTextItem("<b>Subject</b>:", JaxrConstants.RIM_SUBJECT, LABEL_STYLE, 280);
		items.add(subjectItem);

		return items;
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryObject#createListGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();

		/*
		 * Timestamp
		 */
		ListGridField timestampField = new ListGridField(JaxrConstants.RIM_TIMESTAMP, LabelConstants.TIMESTAMP_LABEL, 120);
		timestampField.setType(ListGridFieldType.TEXT);
	
		fields.add(timestampField);
		
		/*
		 * Subject
		 */
		ListGridField subjectField = new ListGridField(JaxrConstants.RIM_SUBJECT, LabelConstants.SUBJECT_LABEL, 160);
		subjectField.setType(ListGridFieldType.TEXT);
	
		fields.add(subjectField);
		
		/*
		 * From
		 */	
		ListGridField fromField = new ListGridField(JaxrConstants.RIM_FROM, LabelConstants.FROM_LABEL);
		
		fromField.setType(ListGridFieldType.TEXT);
		fromField.setWidth("*");
	
		fields.add(fromField);
		
		return fields;
	
	}

}
