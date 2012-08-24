package de.kp.ames.web.client.model.party;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model.party
 *  Module: GroupNameObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #group #model #name #object #party #web
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;

import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.model.core.ExtensibleObject;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class GroupNameObject extends ExtensibleObject {

	public GroupNameObject() {
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
		 * Build name
		 */
		TextItem nameItem = GuiFormFactory.createScTextItem(LabelConstants.FORM_NAME_LABEL, JaxrConstants.RIM_NAME, LABEL_STYLE, 280);
		items.add(nameItem);
		
		items.add(spacer);
		items.add(spacer);
		
		/*
		 * Build description
		 */
		TextAreaItem descItem = GuiFormFactory.createScTextAreaItem(LabelConstants.FORM_DESC_LABEL, JaxrConstants.RIM_DESC, LABEL_STYLE, 280);
		items.add(descItem);

		items.add(spacer);
		items.add(spacer);

		/*
		 * Build email
		 */
		TextItem emailItem = GuiFormFactory.createScTextItem(LabelConstants.FORM_EMAIL_LABEL, JaxrConstants.RIM_EMAIL, LABEL_STYLE, 280);
		items.add(emailItem);

		return items;
		
	}

}
