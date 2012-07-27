package de.kp.ames.web.client.test.dms;

import java.util.LinkedHashMap;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.dms.data.DmsGridImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.shared.constants.ClassificationConstants;

public class DmsFactory extends FncFactory {

	/*
	 * Reference to DmsGrid layout
	 */
	private VLayout dmsGridLayout;
	
	private static DmsFactory instance = new DmsFactory();
	
	public static DmsFactory getInstance() {
		if (instance == null) instance = new DmsFactory();
		return instance;
	}

	public VLayout createDmsGridImpl() {

		dmsGridLayout = new VLayout();
		dmsGridLayout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("Select an information type to get rendered in the DmsGrid.", 40);
      
        /*
         * Data for SelectItem
         */
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();  
        
        valueMap.put(ClassificationConstants.FNC_ID_Document, "Document");  
        valueMap.put(ClassificationConstants.FNC_ID_Image,    "Image");  

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
        
        dmsGridLayout.setMembers(pane, scForm, createPlaceHolder());      
        return dmsGridLayout;
 	}

	public VLayout createDmsCreateDialog() {

		String message = "Click the button to open the DmsCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public VLayout createDmsEditDialog() {

		String message = "Click the button to open the AccessorEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public VLayout createDmsFormImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public VLayout createDmsGetViewer() {

		String message = "Click the button to open the DmsGetViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public VLayout createDmsViewer() {

		String message = "Click the button to open the DmsViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	private void replacePlaceHolder(String type) {
		
		DmsGridImpl grid = new DmsGridImpl(type);
		grid.setMargin(24);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		dmsGridLayout.removeMember(dmsGridLayout.getMember(2));
		dmsGridLayout.addMember(grid);
		
	}

}
