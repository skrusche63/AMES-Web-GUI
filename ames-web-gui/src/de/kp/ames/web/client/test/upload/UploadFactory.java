package de.kp.ames.web.client.test.upload;

import java.util.LinkedHashMap;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.function.upload.data.UploadGridImpl;
import de.kp.ames.web.client.function.upload.widget.UploadCreateDialog;
import de.kp.ames.web.client.function.upload.widget.UploadFormImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.shared.constants.ClassificationConstants;

public class UploadFactory extends FncFactory {

	/*
	 * Reference to UploadGrid layout
	 */
	private VLayout uploadGridLayout;
	
	private static UploadFactory instance = new UploadFactory();
	
	public static UploadFactory getInstance() {
		if (instance == null) instance = new UploadFactory();
		return instance;
	}
	
	public VLayout createUploadGridImpl() {

		uploadGridLayout = new VLayout();
		uploadGridLayout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("Select an information type to get rendered in the UploadGrid.", 40);
       
        /*
         * Data for SelectItem
         */
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();  
        
        valueMap.put(ClassificationConstants.FNC_ID_Document, 		"[Dms] Document");  
        valueMap.put(ClassificationConstants.FNC_ID_Image,    		"[Dms] Image");  
        valueMap.put(ClassificationConstants.FNC_ID_Transformator, 	"[Xsl] Transformator");  

        SelectItem selectItem = createSelectItem(valueMap);       
        selectItem.addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				
				String type = (String)event.getItem().getValue();
				replacePlaceHolder(type);
				
			}
        	
        });
        
        /*
         * Dynamic Form
         */
        DynamicForm scForm = createSelectForm(selectItem);
        
        /*
         * Place Holder
         */
        
        uploadGridLayout.setMembers(pane, scForm, createPlaceHolder());      
        return uploadGridLayout;
        
	}

	private void replacePlaceHolder(String type) {
		
		UploadGridImpl grid = new UploadGridImpl(type);
		grid.setMargin(24);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		uploadGridLayout.removeMember(uploadGridLayout.getMember(2));
		uploadGridLayout.addMember(grid);
		
	}
	
	public VLayout createUploadCreateDialog() {

		String message = "Click the button to open the UploadCreateDialog.";		
		return createDialog(message, new ScAction() {
			public void execute() {
				new UploadCreateDialog();
			}
			
		});
	
	}
	
	public VLayout createUploadFormImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of a <b>styled</b> Upload Form. Note, that this is a modification <br>of the HTML input file, that may not be rendered properly by all browsers.", 64);
        
        /*
         * Upload Form
         */
        UploadFormImpl uploadForm = new UploadFormImpl();
		uploadForm.setMargin(24);

		/*
		 * Dimensions
		 */
		uploadForm.setWidth(380);
		uploadForm.setHeight(1);
		
		/*
		 * Style
		 */
		uploadForm.setBackgroundColor("#F2F2F4");
		uploadForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,uploadForm);
		return layout;
	
	}

}
