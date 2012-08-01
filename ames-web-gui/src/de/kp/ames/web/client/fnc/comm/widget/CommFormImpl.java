package de.kp.ames.web.client.fnc.comm.widget;

import java.util.ArrayList;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;
import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.model.CommObject;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class CommFormImpl extends FormImpl {

	/*
	 * Form dimensions for proper rendering
	 */
	private static int FORM_WIDTH  = 512;
	private static int FORM_HEIGHT = 456;

	/*
	 * Reference to HTMLPane
	 */
	private HTMLPane htmlPane;
	
	public CommFormImpl() {

		/*
		 * Dimensions
		 */
		this.setWidth(FORM_WIDTH);
		this.setHeight(FORM_HEIGHT);
		
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
		
		scForm.setColWidths(60, 320);
		scForm.setFixedColWidths(true);
		
		scForm.setPadding(16);
		scForm.setTitleOrientation(TitleOrientation.LEFT);
		
		scForm.setWidth100();

		/*
		 * Build form fields
		 */
		scForm.setFields(createFormItemsAsArray());
		
		scForm.setAutoFocus(true);
		scForm.setLayoutAlign(Alignment.CENTER);

		/*
		 * Create Tabs
		 */
		VLayout layout = new VLayout();
		layout.setShowEdges(false);
		
		layout.setWidth(480);
		
		layout.setLayoutMargin(16);
		layout.setLayoutTopMargin(0);
		
		htmlPane = new HTMLPane();
		htmlPane.setStyleName(GuiStyles.X_BD_STYLE_4);
		
		htmlPane.setBackgroundColor("#ffffff");
		
		htmlPane.setWidth(480);
		htmlPane.setHeight(320);

		layout.addMember(htmlPane);
		
		wrapper.setMembers(scForm, layout);
		this.setMembers(wrapper);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		return new CommObject().createFormItemsAsList();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#addFormData(com.smartgwt.client.data.Record)
	 */
	public void addFormData(Record record) {
		
		/*
		 * Form data
		 */
		String[] keys = record.getAttributes();
		for (String key:keys) {
			FormItem field = scForm.getField(key);
			if (field != null) field.setValue(record.getAttributeAsString(key));

		}
		
		/*
		 * HTML data
		 */
		String html = record.getAttributeAsString(JaxrConstants.RIM_MESSAGE);
		htmlPane.setContents(html);
		
	}
}
