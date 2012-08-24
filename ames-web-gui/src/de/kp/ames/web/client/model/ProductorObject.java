package de.kp.ames.web.client.model;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.model
 *  Module: ProductorObject
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #model #object #productor #web
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
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;

import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.core.grid.GridFieldFactory;
import de.kp.ames.web.client.model.core.ServiceObject;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.LabelConstants;

public class ProductorObject extends ServiceObject {

	/**
	 * Constructor
	 */
	public ProductorObject() {
		super();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryObject#createDataFieldsAsList()
	 */
	public ArrayList<DataSourceField> createDataFieldsAsList() {

		ArrayList<DataSourceField> fields = super.createDataFieldsAsList();

		/*
		 * Specifications (without label)
		 */
	    fields.add(new DataSourceTextField(JaxrConstants.RIM_SPEC));

	    return fields;
	    
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.model.core.RegistryObject#createGridFieldsAsList()
	 */
	public ArrayList<ListGridField> createListGridFieldsAsList() {

		ArrayList<ListGridField> fields = new ArrayList<ListGridField>();

		/*
		 * Productor icon
		 */
		fields.add(GridFieldFactory.createRimIconField());

		/*
		 * Productor name
		 */
		fields.add(GridFieldFactory.createRimNameField(160));

		/*
		 * Productor author
		 */
		fields.add(GridFieldFactory.createRimAuthorField("*"));
		
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

		return items;
		
	}

}
