package de.kp.ames.web.client.test.symbol;

import java.util.LinkedHashMap;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.function.symbol.data.SymbolTreeImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.shared.constants.ClassificationConstants;

public class SymbolFactory extends FncFactory {

	/*
	 * Reference to SymbolTree layout
	 */
	private VLayout symbolTreeLayout;

	private static SymbolFactory instance = new SymbolFactory();
	
	public static SymbolFactory getInstance() {
		if (instance == null) instance = new SymbolFactory();
		return instance;
	}

	public VLayout createSymbolGridImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public VLayout createSymbolTreeImpl() {

        symbolTreeLayout = new VLayout();
        symbolTreeLayout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("Select an information type to get rendered in the SymbolTree.", 40);
       
        /*
         * Data for SelectItem
         */
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();  
        
        valueMap.put(ClassificationConstants.FNC_SYMBOL_ID_APP6B, "APP-6B Symbols");  
        valueMap.put(ClassificationConstants.FNC_SYMBOL_ID_Icon,  "Icon Symbols");  
 
        SelectItem selectItem = createSelectItem(valueMap);       
        selectItem.addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				
				String type = (String)event.getItem().getValue();
				replacePlaceHolderByTree(type);
				
			}
        	
        });
        
        /*
         * Dynamic Form
         */
        DynamicForm scForm = createSelectForm(selectItem);
        
        /*
         * Place Holder
         */
        
        symbolTreeLayout.setMembers(pane, scForm, createPlaceHolder());      
        return symbolTreeLayout;
	
	}

	public VLayout createSymbolViewer() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	private void replacePlaceHolderByTree(String type) {
		
		SymbolTreeImpl tree = new SymbolTreeImpl(type);
		tree.setMargin(24);

		tree.setStyleName(GuiStyles.X_BD_STYLE_4);

		symbolTreeLayout.removeMember(symbolTreeLayout.getMember(2));
		symbolTreeLayout.addMember(tree);
		
	}

}
