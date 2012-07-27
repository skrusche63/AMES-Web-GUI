package de.kp.ames.web.client.test.group;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.group.data.GroupGridImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;

public class GroupFactory extends FncFactory {

	public static VLayout createCategoryGridImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

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
				// TODO
			}
			
		});
	
	}

	public static VLayout createGroupEditDialog() {

		String message = "Click the button to open the GroupEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createGroupFormImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public static VLayout createGroupGetViewer() {

		String message = "Click the button to open the GroupGetViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

}
