package de.kp.ames.web.client.model;

import java.util.ArrayList;

import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.core.grid.GridFieldFactory;
import de.kp.ames.web.client.model.core.RegistryPackage;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class EvaluationObject extends RegistryPackage {

	public EvaluationObject() {
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

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryPackage#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		
		ArrayList<FormItem> items = new ArrayList<FormItem>();

		/*
		 * Space for rendering purpose only
		 */
		SpacerItem spacer = new SpacerItem();
		spacer.setHeight(2);

		/*
		 * Build name
		 */
		TextItem nameItem = GuiFormFactory.createScTextItem("<b>Name</b>:", JaxrConstants.RIM_NAME, LABEL_STYLE, 280);
		items.add(nameItem);
		
		items.add(spacer);
		items.add(spacer);
		
		/*
		 * Build description
		 */
		TextAreaItem descItem = GuiFormFactory.createScTextAreaItem("<b>Description</b>:", JaxrConstants.RIM_DESC, LABEL_STYLE, 280);
		items.add(descItem);

		items.add(spacer);
		items.add(spacer);
		
		/*
		 * Build date
		 */
		TextItem dateItem = GuiFormFactory.createScTextItem("<b>Date</b>:", JaxrConstants.RIM_DATE, LABEL_STYLE, 280);
		items.add(dateItem);

		return items;
		
	}
}
