package de.kp.ames.web.client.fnc.user.widget;

import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.form.FormImpl;

public class UserFormImpl extends FormImpl {
	
	/**
	 * Constructor
	 */
	public UserFormImpl() {
		
		/*
		 * Note, that width and height used below are the result
		 * of a boring rendering process to achieve the best user
		 * experience, so be careful when changing these numbers
		 */
		VLayout wrapper = new VLayout();
		
		wrapper.setWidth100();
		wrapper.setHeight100();
		
		scForm = new DynamicForm();
		scForm.setTitleSuffix(""); // default ":"
		
		scForm.setColWidths(60, 480);
		scForm.setFixedColWidths(true);
		
		scForm.setPadding(8);
		scForm.setTitleOrientation(TitleOrientation.LEFT);
		
		scForm.setWidth100();

		this.setMembers(wrapper);
		
	}

	// TODO
	
}
