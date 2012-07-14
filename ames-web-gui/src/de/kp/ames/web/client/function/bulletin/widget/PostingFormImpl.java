package de.kp.ames.web.client.function.bulletin.widget;
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

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemKeyPressEvent;
import com.smartgwt.client.widgets.form.events.ItemKeyPressHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.apps.UserController;
import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.client.function.globals.FncAttrs;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.shared.JaxrConstants;

public class PostingFormImpl extends FormImpl {
	
	private static String RIM_ID   = JaxrConstants.RIM_ID;
	private static String RIM_NAME = JaxrConstants.RIM_NAME;

	private static String RIM_SUBJECT = JaxrConstants.RIM_SUBJECT;
	private static String RIM_MESSAGE = JaxrConstants.RIM_MESSAGE;
	
	/*
	 * Form fields
	 */
	private TextItem from;
	private TextItem to;
	
	private TextItem subject;
	
	private RichTextEditor body;

	/*
	 * Reference to recipient data
	 */
	JSONValue jRecipient;
	
	public PostingFormImpl() {

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
		
		/*
		 * From field (this is a GUI field only)
		 */
		
		from = GuiFormFactory.createScTextItem("<b>From</b>:", FncAttrs.FROM, LABEL_STYLE, 280);

		UserController uctrl = UserController.getInstance();		
		from.setValue(uctrl.getUserName());
		
		/*
		 * To field (this is a GUI field only)
		 */
		to = GuiFormFactory.createScTextItem("<b>To</b>:", FncAttrs.TO, LABEL_STYLE, 280);

		/*
		 * Subject field
		 */
		subject = GuiFormFactory.createScTextItem("<b>Subject</b>:", RIM_NAME, LABEL_STYLE, 470);
		
		/*
		 * Body field
		 */
		
		body = GuiFormFactory.createScRichTextEditor(546, 230);
		
		body.setBorder(GuiStyles.APP_BORDER);
		body.setMargin(8);

		/*
		 * Space for rendering purpose only
		 */
		SpacerItem spacer = new SpacerItem();
		spacer.setHeight(2);
		
		scForm.setFields(new FormItem[] {
			from, spacer, spacer, to, spacer, spacer, subject
		});
		
		scForm.setAutoFocus(true);
		scForm.setLayoutAlign(Alignment.CENTER);

		scForm.addItemKeyPressHandler(new ItemKeyPressHandler() {
			public void onItemKeyPress(ItemKeyPressEvent event) {
				if ("Enter".equals(event.getKeyName())) {
					// TODO
				}
			}
		});

		wrapper.setMembers(scForm, body);
		this.setMembers(wrapper);
		
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#addFormData(com.google.gwt.json.client.JSONValue)
	 */
	public void addFormData(JSONValue jValue) {

		this.jRecipient = jValue;
		
		/*
		 * Recipient name
		 */
		String name = jRecipient.isObject().get(RIM_NAME).isString().stringValue();
		to.setValue(name);

	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#getFormData()
	 */
	public String getFormData() {
		
		JSONObject jForm = new JSONObject();

		/*
		 * Subject field
		 */
		String subjectValue = subject.getValueAsString();
		jForm.put(RIM_SUBJECT, new JSONString(subjectValue));
		
		/*
		 * Body field
		 */
		String bodyValue = body.getValue();
		jForm.put(RIM_MESSAGE, new JSONString(bodyValue));

		return jForm.toString();
		
	}
	
	/**
	 * A helper method to retrieve the unique identifier
	 * of the recipient
	 * 
	 * @return
	 */
	public String getRecipient() {

		String recipient = jRecipient.isObject().get(RIM_ID).isString().stringValue();
		return recipient;
	
	}

}
