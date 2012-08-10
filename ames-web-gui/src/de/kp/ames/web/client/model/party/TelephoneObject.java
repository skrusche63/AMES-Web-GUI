package de.kp.ames.web.client.model.party;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model.party
 *  Module: TelephoneObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #model #object #party #telephone #web
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

public class TelephoneObject extends ExtensibleObject {

	/**
	 * Constructor
	 */
	public TelephoneObject() {
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
		 * Build country code
		 */
		TextItem countryCodeItem = GuiFormFactory.createScTextItem("<b>Country Code</b>:", JaxrConstants.RIM_COUNTRY_CODE, LABEL_STYLE, 120);
		items.add(countryCodeItem);
		
		items.add(spacer);
		items.add(spacer);

		/*
		 * Build area code
		 */
		TextItem areaCodeItem = GuiFormFactory.createScTextItem("<b>Area Code</b>:", JaxrConstants.RIM_AREA_CODE, LABEL_STYLE, 120);
		items.add(areaCodeItem);
		
		items.add(spacer);
		items.add(spacer);

		/*
		 * Build phone number
		 */
		TextItem phoneNumberItem = GuiFormFactory.createScTextItem("<b>Phone Number</b>:", JaxrConstants.RIM_PHONE_NUMBER, LABEL_STYLE, 120);
		items.add(phoneNumberItem);
		
		items.add(spacer);
		items.add(spacer);

		/*
		 * Build phone extension
		 */
		TextItem extensionItem = GuiFormFactory.createScTextItem("<b>Extension</b>:", JaxrConstants.RIM_PHONE_EXTENSION, LABEL_STYLE, 120);
		items.add(extensionItem);

		return items;
		
	}
		
}
