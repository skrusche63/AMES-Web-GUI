package de.kp.ames.web.client.test.user;

import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.user.data.UserGridImpl;
import de.kp.ames.web.client.fnc.user.widget.UserEditDialog;
import de.kp.ames.web.client.fnc.user.widget.UserFormImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.client.test.data.ScData;

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
				JSONObject jTestUser = ScData.getJsonTestUser();
				
				UserEditDialog dialog = new UserEditDialog(jTestUser);
				dialog.setTitle("Edit User");
			}
			
		});
	
	}

	public VLayout createUserFormImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of a User Form.", 40);
        
        /*
         * User Form
         */
        UserFormImpl userForm = new UserFormImpl();
		userForm.setMargin(24);

		/*
		 * Style
		 */
		userForm.setBackgroundColor("#F2F2F4");
		userForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,userForm);
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
