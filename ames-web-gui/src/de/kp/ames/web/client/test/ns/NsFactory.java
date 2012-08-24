package de.kp.ames.web.client.test.ns;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test.ns
 *  Module: NsFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #factory #ns #test #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.form.FormAction;
import de.kp.ames.web.client.fnc.ns.data.NsGridImpl;
import de.kp.ames.web.client.fnc.ns.data.NsTreeImpl;
import de.kp.ames.web.client.fnc.ns.widget.NsCreateDialog;
import de.kp.ames.web.client.fnc.ns.widget.NsEditDialog;
import de.kp.ames.web.client.fnc.ns.widget.NsFormImpl;
import de.kp.ames.web.client.fnc.ns.widget.NsGetViewer;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.client.test.data.ScData;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class NsFactory extends FncFactory {

	public static VLayout createNsGridImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

		/*
         * Label
         */
        HTMLPane pane = getTeaser("View all registered namespaces in the NsGrid.", 40);

        /*
         * Grid
         */       
		NsGridImpl grid = new NsGridImpl();
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane, grid);
		return layout;
	
	}

	public static VLayout createNsTreeImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of a Namespace Tree.", 40);

        /*
         * Namespace Tree
         */
        NsTreeImpl nsTree = new NsTreeImpl();
		nsTree.setMargin(24);
		
		/*
		 * Dimensions
		 */
		nsTree.setWidth(480);
		nsTree.setHeight(480);
		
		/*
		 * Style
		 */
		nsTree.setBackgroundColor("#F2F2F4");
		nsTree.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,nsTree);
		return layout;
	
	}

	public static VLayout createNsCreateDialog() {
		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Namespace);

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Namespace successfully created.");
			}
		};
		
		String message = "Click the button to open the NamespaceCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				NsCreateDialog.create(attributes, afterSendActivity);
			}			
			
		});
	
	}

	public static VLayout createNsEditDialog() {

		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Namespace);
		
		final JSONObject jValue = ScData.getJsonNamespace();

		final ActivityImpl afterSendActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				SC.say("Namespace successfully updated.");
			}
		};

		String message = "Click the button to open the NamespaceEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				NsEditDialog.create(attributes, jValue, afterSendActivity);
			}
			
		});
	
	}

	public static VLayout createNsFormImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of a Namespace Form.", 40);

        /*
         * Namespace Form
         */
        NsFormImpl nsForm = new NsFormImpl(FormAction.CREATE);
		nsForm.setMargin(24);
		
		/*
		 * Style
		 */
		nsForm.setBackgroundColor("#F2F2F4");
		nsForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,nsForm);
		return layout;
	
	}

	public static VLayout createNsViewer() {
		/*
		 * Prepare data
		 */
		final HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Namespace);
		
		final JSONObject jValue = ScData.getJsonNamespace();
		
		String message = "Click the button to open the NsGetViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				NsGetViewer.create(attributes, jValue);
			}
			
		});
	
	}

}
