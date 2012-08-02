package de.kp.ames.web.client.test.access;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.access.data.AccessGridImpl;
import de.kp.ames.web.client.fnc.access.widget.AccessorCreateDialog;
import de.kp.ames.web.client.fnc.access.widget.AccessorEditDialog;
import de.kp.ames.web.client.fnc.access.widget.AccessorFormImpl;
import de.kp.ames.web.client.fnc.access.widget.AccessorGetViewer;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.client.test.data.ScData;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class AccessFactory extends FncFactory {
	/*
	 * Reference to AccessGrid layout
	 */
	private VLayout accessGridLayout;
	
	private static AccessFactory instance = new AccessFactory();
	
	public static AccessFactory getInstance() {
		if (instance == null) instance = new AccessFactory();
		return instance;
	}

	public VLayout createAccessGridImpl() {

		accessGridLayout = new VLayout();
		accessGridLayout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("Select an information type to get rendered in the AccessGrid.", 40);
      
        /*
         * Data for SelectItem
         */
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();  
        
        valueMap.put(ClassificationConstants.FNC_ID_Accessor, "Accessor");  
        valueMap.put(ClassificationConstants.FNC_ID_Remote,   "Remote Object");  

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
        
        accessGridLayout.setMembers(pane, scForm, createPlaceHolder());      
        return accessGridLayout;
 	}
	
	private void replacePlaceHolder(String type) {
		
		String item = null;
		if (type.equals(ClassificationConstants.FNC_ID_Remote))
			item = ScData.TEST_ACCESSOR;
		
		AccessGridImpl grid = new AccessGridImpl(type, item);
		grid.setMargin(24);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		accessGridLayout.removeMember(accessGridLayout.getMember(2));
		accessGridLayout.addMember(grid);
		
	}

	public VLayout createAccessorCreateDialog() {
		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Accessor);

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Accessor successfully created.");
			}
		};
		
		String message = "Click the button to open the AccessorCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				Grid grid = null;
				AccessorCreateDialog.create(attributes, grid, afterSendActivity);
			}			
			
		});
	
	}

	public VLayout createAccessorEditDialog() {
		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Accessor);
		
		final JSONObject jValue = ScData.getJsonAccessor();

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Accessor successfully updated.");
			}
		};

		String message = "Click the button to open the AccessorEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				AccessorEditDialog.create(attributes, jValue, afterSendActivity);
			}
			
		});
	
	}

	public VLayout createAccessorFormImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of an Accessor Form.", 40);

        /*
         * Accessor Form
         */
        AccessorFormImpl accessorForm = new AccessorFormImpl(FormAction.CREATE);
		accessorForm.setMargin(24);
		
		/*
		 * Style
		 */
		accessorForm.setBackgroundColor("#F2F2F4");
		accessorForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,accessorForm);
		return layout;
	
	}

	public VLayout createAccessorGetViewer() {

		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Accessor);
		
		final JSONObject jValue = ScData.getJsonAccessor();
		
		String message = "Click the button to open the AccessorGetViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				AccessorGetViewer.create(attributes, jValue);
			}
			
		});
	
	}

	public VLayout createRemoteViewer() {

		String message = "Click the button to open the RemoteViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

}
