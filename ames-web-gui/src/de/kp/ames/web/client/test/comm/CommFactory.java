package de.kp.ames.web.client.test.comm;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test.comm
 *  Module: CommFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #comm #factory #test #web
 * </SemanticAssist>
 *
 */


import java.util.LinkedHashMap;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.comm.data.CommGridImpl;
import de.kp.ames.web.client.fnc.comm.widget.CommFormImpl;
import de.kp.ames.web.client.fnc.comm.widget.CommViewer;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.shared.constants.ClassificationConstants;

public class CommFactory extends FncFactory {

	/*
	 * Reference to CommGrid layout
	 */
	private VLayout commGridLayout;
	
	private static CommFactory instance = new CommFactory();
	
	public static CommFactory getInstance() {
		if (instance == null) instance = new CommFactory();
		return instance;
	}

	public VLayout createCommGridImpl() {

		commGridLayout = new VLayout();
		commGridLayout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("Select an information type to get rendered in the CommGrid.", 40);
      
        /*
         * Data for SelectItem
         */
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();  
        
        valueMap.put(ClassificationConstants.FNC_ID_Chat, "Chat");  
        valueMap.put(ClassificationConstants.FNC_ID_Mail, "Mail");  

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
        
        commGridLayout.setMembers(pane, scForm, createPlaceHolder());      
        return commGridLayout;
        
	}

	private void replacePlaceHolder(String type) {
		
		CommGridImpl grid = new CommGridImpl(type);
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		commGridLayout.removeMember(commGridLayout.getMember(2));
		commGridLayout.addMember(grid);
		
	}

	public VLayout createCommFormImpl() {
		
        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of a Comm Form.", 40);

        /*
         * Comm Form
         */
        CommFormImpl commForm = new CommFormImpl();
		commForm.setMargin(24);
		
		/*
		 * Style
		 */
		commForm.setBackgroundColor("#F2F2F4");
		commForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,commForm);
		return layout;
	
	}

	public VLayout createCommViewer() {

		String message = "Click the button to open the CommViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {

				CommFormImpl form = new CommFormImpl();				
				new CommViewer(form);
				
			}
			
		});
	
	}

}
