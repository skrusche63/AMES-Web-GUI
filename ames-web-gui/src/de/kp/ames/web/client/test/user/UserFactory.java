package de.kp.ames.web.client.test.user;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.user.data.UserGridImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;

public class UserFactory extends FncFactory {
	
	private static UserFactory instance = new UserFactory();
	
	public static UserFactory getInstance() {
		if (instance == null) instance = new UserFactory();
		return instance;
	}

	public VLayout createUserGridImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

		/*
         * Label
         */
        HTMLPane pane = getTeaser("View all registered users in the UserGrid.", 40);
        
        /*
         * Grid
         */       
		UserGridImpl grid = new UserGridImpl();
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane, grid);
		return layout;
	
	}

	public VLayout createUserEditDialog() {

		String message = "Click the button to open the UserEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public VLayout createUserFormImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public VLayout createUserGetViewer() {

		String message = "Click the button to open the UserGetViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

}
