package de.kp.ames.web.client.model.party;

import java.util.ArrayList;

import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.model.core.ExtensibleObject;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class PersonNameObject extends ExtensibleObject {

	public PersonNameObject() {
		super();
	}
	
	public ArrayList<FormItem> createFormItemsAsList() {
		
		ArrayList<FormItem> items = new ArrayList<FormItem>();

		/*
		 * Space for rendering purpose only
		 */
		SpacerItem spacer = new SpacerItem();
		spacer.setHeight(2);

		/*
		 * Build first name
		 */
		TextItem firstNameItem = GuiFormFactory.createScTextItem("<b>First Name</b>:", JaxrConstants.RIM_FIRST_NAME, LABEL_STYLE, 240);
		items.add(firstNameItem);
		
		items.add(spacer);
		items.add(spacer);
		
		/*
		 * Build middle name
		 */
		TextItem middleNameItem = GuiFormFactory.createScTextItem("<b>Middle Name</b>:", JaxrConstants.RIM_MIDDLE_NAME, LABEL_STYLE, 240);
		items.add(middleNameItem);
		
		items.add(spacer);
		items.add(spacer);

		/*
		 * Build last name
		 */
		TextItem lastNameItem = GuiFormFactory.createScTextItem("<b>Last Name</b>:", JaxrConstants.RIM_LAST_NAME, LABEL_STYLE, 280);
		items.add(lastNameItem);
		
		items.add(spacer);
		items.add(spacer);

		/*
		 * Build email
		 */
		TextItem emailItem = GuiFormFactory.createScTextItem("<b>Email Address</b>:", JaxrConstants.RIM_EMAIL, LABEL_STYLE, 280);
		items.add(emailItem);

		return items;
		
	}

}
