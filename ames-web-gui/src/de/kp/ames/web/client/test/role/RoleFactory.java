package de.kp.ames.web.client.test.role;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test.role
 *  Module: RoleFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #factory #role #test #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.fnc.role.data.RoleGridImpl;
import de.kp.ames.web.client.fnc.role.widget.ResponsibilityCreateDialog;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.client.test.data.ScData;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class RoleFactory extends FncFactory {

	public static VLayout createRoleGridImpl() {

		/*
		 * Prepare data
		 */
		String type = ClassificationConstants.FNC_ID_Role;
		
		String source = ScData.TEST_ROLE_SOURCE;
		String target = ScData.TEST_ROLE_TARGET;
		
        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

		/*
         * Label
         */
        HTMLPane pane = getTeaser("View all registered roles in the RoleGrid for a pre-configured user and community.", 40);
        
        /*
         * Grid
         */       
		RoleGridImpl grid = new RoleGridImpl(type, source, target);
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane, grid);
		return layout;
	
	}

	public static VLayout createResponsibilityCreateDialog() {

		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Responsibility);

		/*
		 * SOURCE must be the logged in user to be able to confirm an association to a responsibilty
		 */
		attributes.put(MethodConstants.ATTR_SOURCE, ScData.TEST_USER);

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Responsibility successfully created.");
			}
		};

		String message = "Click the button to open the ResponsibilityCreateDialog for a pre-configured user.";
		return createDialog(message, new ScAction() {
			public void execute() {
				ResponsibilityCreateDialog.create(attributes, afterSendActivity);
			}
			
		});
	
	}

}
