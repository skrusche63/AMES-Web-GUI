package de.kp.ames.web.client.core.form;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.form
 *  Module: DefaultFormImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #default #form #web
 * </SemanticAssist>
 *
 */


import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;

import de.kp.ames.web.client.model.core.DataObject;

public class DefaultFormImpl extends DynamicForm {

	/**
	 * Constructor
	 */
	public DefaultFormImpl(DataObject dataObject) {
		super();
		
		this.setTitleSuffix(""); // default ":"
		
		this.setColWidths(100, 320);
		this.setFixedColWidths(true);
		
		this.setPadding(16);
		this.setTitleOrientation(TitleOrientation.LEFT);
		
		this.setAutoFocus(true);
		this.setLayoutAlign(Alignment.CENTER);
		
		FormItem[] formItems = dataObject.createFormItemsAsArray();
		this.setFields(formItems);
		
	}	

}
