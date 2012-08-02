package de.kp.ames.web.client.test.group;

import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.group.data.GroupGridImpl;
import de.kp.ames.web.client.fnc.group.widget.GroupCreateDialog;
import de.kp.ames.web.client.fnc.group.widget.GroupEditDialog;
import de.kp.ames.web.client.fnc.group.widget.GroupFormImpl;
import de.kp.ames.web.client.fnc.group.widget.GroupGetViewer;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.client.test.data.ScData;

public class GroupFactory extends FncFactory {

	public static VLayout createGroupGridImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("View all registered Communities of Interest.", 40);
        
        /*
         * Grid
         */
        
		GroupGridImpl grid = new GroupGridImpl();
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane, grid);
		return layout;
	
	}

	public static VLayout createGroupCreateDialog() {

		String message = "Click the button to open the GroupCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {				
				new GroupCreateDialog();
			}
			
		});
	
	}

	public static VLayout createGroupEditDialog() {

		String message = "Click the button to open the GroupEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				
				JSONObject jTestGroup = ScData.getJsonTestGroup();
				new GroupEditDialog(jTestGroup);
				
			}
			
		});
	
	}

	public static VLayout createGroupFormImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of a Group Form.", 40);
        
        /*
         * Group Form
         */
        GroupFormImpl groupForm = new GroupFormImpl();
		groupForm.setMargin(24);

		/*
		 * Style
		 */
		groupForm.setBackgroundColor("#F2F2F4");
		groupForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,groupForm);
		return layout;
	
	}

	public static VLayout createGroupGetViewer() {

		String message = "Click the button to open the GroupGetViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {

				JSONObject jTestGroup = ScData.getJsonTestGroup();

				GroupFormImpl form = new GroupFormImpl();
				form.addFormData(jTestGroup);		
				
				new GroupGetViewer(form);
				
			}
			
		});
	
	}

}
