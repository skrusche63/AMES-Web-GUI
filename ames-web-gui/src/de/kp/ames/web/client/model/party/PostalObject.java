package de.kp.ames.web.client.model.party;

import java.util.ArrayList;

import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.model.core.ExtensibleObject;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class PostalObject extends ExtensibleObject {

	/**
	 * Constructor
	 */
	public PostalObject() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.ExtensibleObject#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		
		ArrayList<FormItem> items = new ArrayList<FormItem>();

		/*
		 * Space for rendering purpose only
		 */
		SpacerItem spacer = new SpacerItem();
		spacer.setHeight(2);

		/*
		 * Build country
		 */
		TextItem countryItem = GuiFormFactory.createScTextItem("<b>Country</b>:", JaxrConstants.RIM_COUNTRY, LABEL_STYLE, 280);
		items.add(countryItem);
		
		items.add(spacer);
		items.add(spacer);
      	
       	/*
       	 * Build state or province
       	 */
		TextItem stateItem = GuiFormFactory.createScTextItem("<b>State</b>:", JaxrConstants.RIM_STATE_OR_PROVINCE, LABEL_STYLE, 280);
		items.add(stateItem);
		
		items.add(spacer);
		items.add(spacer);

      	/*
       	 * Build postal code
       	 */
		TextItem postalCodeItem = GuiFormFactory.createScTextItem("<b>Postal Code</b>:", JaxrConstants.RIM_POSTAL_CODE, LABEL_STYLE, 120);
		items.add(postalCodeItem);
		
		items.add(spacer);
		items.add(spacer);

      	/*
       	 * Build city
       	 */
		TextItem cityItem = GuiFormFactory.createScTextItem("<b>City</b>:", JaxrConstants.RIM_CITY, LABEL_STYLE, 280);
		items.add(cityItem);
		
		items.add(spacer);
		items.add(spacer);

      	/*
       	 * Build street
       	 */
		TextItem streetItem = GuiFormFactory.createScTextItem("<b>Street</b>:", JaxrConstants.RIM_STREET, LABEL_STYLE, 280);
		items.add(streetItem);
		
		items.add(spacer);
		items.add(spacer);

      	/*
       	 * Build street number
       	 */
		TextItem streetNumberItem = GuiFormFactory.createScTextItem("<b>Street Number</b>:", JaxrConstants.RIM_STREET, LABEL_STYLE, 120);
		items.add(streetNumberItem);
		
		return items;
		
	}
	
}
