package de.kp.ames.web.client.test.product;

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
import de.kp.ames.web.client.fnc.product.data.ProductGridImpl;
import de.kp.ames.web.client.fnc.product.widget.ProductorCreateDialog;
import de.kp.ames.web.client.fnc.product.widget.ProductorEditDialog;
import de.kp.ames.web.client.fnc.product.widget.ProductorFormImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.client.test.data.ScData;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class ProductFactory extends FncFactory {
	/*
	 * Reference to ProductGrid layout
	 */
	private VLayout productGridLayout;
	
	private static ProductFactory instance = new ProductFactory();
	
	public static ProductFactory getInstance() {
		if (instance == null) instance = new ProductFactory();
		return instance;
	}

	public VLayout createProductGridImpl() {
		productGridLayout = new VLayout();
		productGridLayout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("Select an information type to get rendered in the ProductGrid.", 40);
      
        /*
         * Data for SelectItem
         */
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();  
        
        valueMap.put(ClassificationConstants.FNC_ID_Product,   "Product");  
        valueMap.put(ClassificationConstants.FNC_ID_Productor, "Productor");  

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
        
        productGridLayout.setMembers(pane, scForm, createPlaceHolder());      
        return productGridLayout;
 	}
	
	private void replacePlaceHolder(String type) {
				
		ProductGridImpl grid = new ProductGridImpl(type);
		grid.setMargin(24);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		productGridLayout.removeMember(productGridLayout.getMember(2));
		productGridLayout.addMember(grid);
		
	}

	public VLayout createProductEditDialog() {

		String message = "Click the button to open the ProductEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public VLayout createProductorApplyDialog() {

		String message = "Click the button to open the ProductorApplyDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public VLayout createProductorCreateDialog() {

		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Productor);

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Productor successfully created.");
			}
		};
		
		String message = "Click the button to open the ProductorCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				ProductorCreateDialog.create(attributes, afterSendActivity);
			}			
			
		});
	
	}

	public VLayout createProductorEditDialog() {
		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Productor);
		
		final JSONObject jValue = ScData.getJsonAccessor();

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Productor successfully updated.");
			}
		};

		String message = "Click the button to open the ProductorEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				ProductorEditDialog.create(attributes, jValue, afterSendActivity);
			}
			
		});
	
	}

	public VLayout createProductorFormImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of a Productor Form.", 40);

        /*
         * Productor Form
         */
        ProductorFormImpl productorForm = new ProductorFormImpl(FormAction.CREATE);
		productorForm.setMargin(24);
		
		/*
		 * Style
		 */
		productorForm.setBackgroundColor("#F2F2F4");
		productorForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,productorForm);
		return layout;
	
	}

}
