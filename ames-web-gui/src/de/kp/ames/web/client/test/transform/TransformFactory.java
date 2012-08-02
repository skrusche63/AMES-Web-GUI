package de.kp.ames.web.client.test.transform;

import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.fnc.transform.data.TransformGridImpl;
import de.kp.ames.web.client.fnc.transform.widget.TransformCreateDialog;
import de.kp.ames.web.client.fnc.transform.widget.TransformFormImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class TransformFactory extends FncFactory {

	public static VLayout createTransformGridImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

		/*
         * Label
         */
        HTMLPane pane = getTeaser("View all registered users in the TransformGrid.", 40);
        
        /*
         * Grid
         */       
		TransformGridImpl grid = new TransformGridImpl();
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane, grid);
		return layout;
	
	}

	public static VLayout createTransformCreateDialog() {

		/*
		 * Prepate data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Transformator);

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Transformator successfully created.");
			}
		};
		
		String message = "Click the button to open the TransformCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				TransformCreateDialog.create(attributes, afterSendActivity);
			}
			
		});
	
	}

	public static VLayout createTransformFormImpl() {

		VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

		/*
		 * Label
		 */
		HTMLPane pane = getTeaser("This is an example of a Transformator Form.", 40);
		
		/*
		 * Transformator Form
		 */
		TransformFormImpl transformatorForm = new TransformFormImpl();
		transformatorForm.setMargin(24);
		
		/*
		 * Style
		 */
		transformatorForm.setBackgroundColor("#F2F2F4");
		transformatorForm.setStyleName(GuiStyles.X_BD_STYLE_4);
		
		layout.setMembers(pane,transformatorForm);
		return layout;
	
	}

}
