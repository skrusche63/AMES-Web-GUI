package de.kp.ames.web.client.model.party;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model.party
 *  Module: PostalObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #model #object #party #postal #web
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;

import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.model.core.ExtensibleObject;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

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
		TextItem countryItem = GuiFormFactory.createScTextItem(LabelConstants.FORM_COUNTRY_LABEL, JaxrConstants.RIM_COUNTRY, LABEL_STYLE, 280);
		items.add(countryItem);
		
		items.add(spacer);
		items.add(spacer);
      	
       	/*
       	 * Build state or province
       	 */
		TextItem stateItem = GuiFormFactory.createScTextItem(LabelConstants.FORM_STATE_LABEL, JaxrConstants.RIM_STATE_OR_PROVINCE, LABEL_STYLE, 280);
		items.add(stateItem);
		
		items.add(spacer);
		items.add(spacer);

      	/*
       	 * Build postal code
       	 */
		TextItem postalCodeItem = GuiFormFactory.createScTextItem(LabelConstants.FORM_POSTAL_CODE, JaxrConstants.RIM_POSTAL_CODE, LABEL_STYLE, 120);
		items.add(postalCodeItem);
		
		items.add(spacer);
		items.add(spacer);

      	/*
       	 * Build city
       	 */
		TextItem cityItem = GuiFormFactory.createScTextItem(LabelConstants.FORM_CITY_LABEL, JaxrConstants.RIM_CITY, LABEL_STYLE, 280);
		items.add(cityItem);
		
		items.add(spacer);
		items.add(spacer);

      	/*
       	 * Build street
       	 */
		TextItem streetItem = GuiFormFactory.createScTextItem(LabelConstants.FORM_STREET_LABEL, JaxrConstants.RIM_STREET, LABEL_STYLE, 280);
		items.add(streetItem);
		
		items.add(spacer);
		items.add(spacer);

      	/*
       	 * Build street number
       	 */
		TextItem streetNumberItem = GuiFormFactory.createScTextItem(LabelConstants.FORM_STREET_NUMBER_LABEL, JaxrConstants.RIM_STREET_NUMBER, LABEL_STYLE, 120);
		items.add(streetNumberItem);
		
		return items;
		
	}
	
}
