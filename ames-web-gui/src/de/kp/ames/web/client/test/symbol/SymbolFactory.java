package de.kp.ames.web.client.test.symbol;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test.symbol
 *  Module: SymbolFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #factory #symbol #test #web
 * </SemanticAssist>
 *
 */

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

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.symbol.data.SymbolGridImpl;
import de.kp.ames.web.client.fnc.symbol.data.SymbolTreeImpl;
import de.kp.ames.web.client.fnc.symbol.widget.SymbolViewer;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class SymbolFactory extends FncFactory {

	/*
	 * Reference to SymbolGrid Layut
	 */
	private VLayout symbolGridLayout;
	
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

		symbolGridLayout = new VLayout();
		symbolGridLayout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("Select an information type to get rendered in the SymbolGrid.", 40);
      
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
				replacePlaceHolderByGrid(type);
				
			}
        	
        });
        
        /*
         * Dynamic Form
         */
        DynamicForm scForm = createSelectForm(selectItem);
        
        /*
         * Place Holder
         */
        
        symbolGridLayout.setMembers(pane, scForm, createPlaceHolder());      
        return symbolGridLayout;
	
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

		String message = "Click the button to open the UploadCreateDialog.";		
		return createDialog(message, new ScAction() {
			public void execute() {
				/*
				 * Symbols are restricted to APP-6 Icons
				 */
				String type = ClassificationConstants.FNC_SYMBOL_ID_APP6B;
				SymbolViewer.create(type);

			}
			
		});
		
	}

	protected void replacePlaceHolderByGrid(final String type) {

		final SymbolGridImpl grid = new SymbolGridImpl();
		grid.setMargin(24);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		symbolGridLayout.removeMember(symbolGridLayout.getMember(2));
		symbolGridLayout.addMember(grid);
		
		grid.addDrawHandler(new DrawHandler() {
			public void onDraw(DrawEvent event) {
				/*
				 * Provide parameters
				 */
				HashMap<String,String> attributes = new HashMap<String,String>();
				attributes.put(MethodConstants.ATTR_TYPE, type);
				
				grid.reload(attributes);
				
			}			
		});
		
	}

	private void replacePlaceHolderByTree(String type) {
		
		SymbolTreeImpl tree = new SymbolTreeImpl(type);
		tree.setMargin(24);

		tree.setStyleName(GuiStyles.X_BD_STYLE_4);

		symbolTreeLayout.removeMember(symbolTreeLayout.getMember(2));
		symbolTreeLayout.addMember(tree);
		
	}

}
