package de.kp.ames.web.client.test.user;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;

public class UserFactory extends FncFactory {

	public static VLayout createUserGridImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

		/*
         * Label
         */
        HTMLPane pane = getTeaser("View all registered users in the UserGrid.", 40);

        // TODO
        
        layout.setMembers(pane);
		return layout;
	
	}

	public static VLayout createUserEditDialog() {

		String message = "Click the button to open the UserEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createUserFormImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public static VLayout createUserGetViewer() {

		String message = "Click the button to open the UserGetViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

}
