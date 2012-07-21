package de.kp.ames.web.client.function.upload.widget;

import java.util.ArrayList;

import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.UploadItem;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.core.form.GuiFormFactory;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class UploadFormImpl extends FormImpl {
	/*
	 * Reference to label style for form items
	 */
	private static String LABEL_STYLE = "x-sc-label";

	/**
	 * Constructor
	 */
	public UploadFormImpl() {

		/*
		 * Note, that width and height used below are the result
		 * of a boring rendering process to achieve the best user
		 * experience, so be careful when changing these numbers
		 */
		VLayout wrapper = new VLayout();
		
		wrapper.setWidth100();
		wrapper.setHeight100();
		
		scForm = new DynamicForm();
		scForm.setEncoding(Encoding.MULTIPART);

		scForm.setWidth100();
		scForm.setHeight(64);

		/*
		 * Build form content from native Html; this way is used
		 * to beautify the original <input> file component
		 */
		scForm.addChild(GuiFormFactory.createScUploadHtml("", JaxrConstants.RIM_FILE, 280));

		/*
		 * Below is an alternate setup of 
		 * 
		 * scForm.setTitleSuffix(""); // default ":"
		 * 
		 * scForm.setColWidths(60, 480);
		 * scForm.setFixedColWidths(true);
		 * 
		 * scForm.setPadding(8);
		 * scForm.setTitleOrientation(TitleOrientation.LEFT);
		 * 
		 * scForm.setFields(createFormItemsAsArray());
		 * 
		 * scForm.setAutoFocus(true);
		 * scForm.setLayoutAlign(Alignment.CENTER);
		 */

		wrapper.setMembers(scForm);
		this.setMembers(wrapper);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		
		ArrayList<FormItem> items = new ArrayList<FormItem>();
		
		/*
		 * UplodItem
		 */
		UploadItem uploadItem = GuiFormFactory.createScUploadItem("<b>File</b>:", JaxrConstants.RIM_FILE, LABEL_STYLE, 320);
		items.add(uploadItem);
		
		return items;
		
	}

	public void doSubmit() {

		/*
		 * 
		 * final DynamicForm uploadForm = new DynamicForm();		
	uploadForm.setEncoding(Encoding.MULTIPART);
	UploadItem fileItem = new UploadItem("image");
	TextItem nameItem = new TextItem("imageName");
	TextItem descriptionItem = new TextItem("description");
	HiddenItem spaceImageIdItem = new HiddenItem("spaceImageId");
	HiddenItem propertyIdItem = new HiddenItem("propertyId");
	propertyIdItem.setValue(23);
	spaceImageIdItem.setValue(0);
	uploadForm.setTarget("hidden_frame");
	uploadForm.setAction("/company/imageUploadRest.do");
	IButton uploadButton = new IButton("Upload...");
	uploadButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler(){
		public void onClick(ClickEvent e){
			uploadForm.submitForm();
		}
	});
		
	uploadForm.setItems(fileItem, nameItem, descriptionItem, spaceImageIdItem, propertyIdItem);
	layout.setMembers(uploadForm, uploadButton);

	RootPanel.get("tree1").add(layout);
		 * 
		 */
		
	}
	/*
	 *  If it is acceptable that the application will do a full-page reload after the upload completes, you can simply:

    set DynamicForm.encoding to "multipart"
    include an UploadItem to get a basic HTML upload control
    set DynamicForm.action to a URL where you have deployed server-side code to handle the upload
    call DynamicForm.submitForm() to cause the form to be submitted 
	 */
}
