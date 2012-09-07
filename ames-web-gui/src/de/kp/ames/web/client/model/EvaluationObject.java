package de.kp.ames.web.client.model;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model
 *  Module: EvaluationObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #evaluation #model #object #web
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;

import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.core.grid.GridFieldFactory;
import de.kp.ames.web.client.model.core.RegistryPackage;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

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
		TextItem nameItem = GuiFormFactory.createScTextItem(LabelConstants.FORM_NAME_LABEL, JaxrConstants.RIM_NAME, LABEL_STYLE, 360);
		items.add(nameItem);
		
		items.add(spacer);
		items.add(spacer);
		
		/*
		 * Build description
		 */
		TextAreaItem descItem = GuiFormFactory.createScTextAreaItem(LabelConstants.FORM_DESC_LABEL, JaxrConstants.RIM_DESC, LABEL_STYLE, 360);
		items.add(descItem);

		items.add(spacer);
		items.add(spacer);
		
		/*
		 * Build date
		 */
		TextItem dateItem = GuiFormFactory.createScTextItem(LabelConstants.FORM_DATE_LABEL, JaxrConstants.RIM_DATE, LABEL_STYLE, 360);
		items.add(dateItem);

		/*
		 * Build hidden id
		 */
		HiddenItem idItem = new HiddenItem(JaxrConstants.RIM_ID);
		items.add(idItem);


		return items;
		
	}
}
