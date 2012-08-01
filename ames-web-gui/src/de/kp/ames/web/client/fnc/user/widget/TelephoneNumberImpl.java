package de.kp.ames.web.client.fnc.user.widget;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;

import de.kp.ames.web.client.model.party.TelephoneObject;

public class TelephoneNumberImpl extends DynamicForm {

	public TelephoneNumberImpl() {
		super();
				
		this.setTitleSuffix(""); // default ":"
		
		this.setColWidths(100, 320);
		this.setFixedColWidths(true);
		
		this.setPadding(16);
		this.setTitleOrientation(TitleOrientation.LEFT);
		
		this.setAutoFocus(true);
		this.setLayoutAlign(Alignment.CENTER);
		
		FormItem[] formItems = new TelephoneObject().createFormItemsAsArray();
		this.setFields(formItems);

	}
}
