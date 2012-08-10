package de.kp.ames.web.client.test.user;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test.user
 *  Module: UserFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #factory #test #user #web
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

import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.user.data.UserGridImpl;
import de.kp.ames.web.client.fnc.user.widget.UserEditDialog;
import de.kp.ames.web.client.fnc.user.widget.UserFormImpl;
import de.kp.ames.web.client.fnc.user.widget.UserGetViewer;
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
				new UserEditDialog(jTestUser);
				
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

				JSONObject jTestUser = ScData.getJsonTestUser();

				UserFormImpl form = new UserFormImpl();
				form.addFormData(jTestUser);		
				
				new UserGetViewer(form);
				
			}
			
		});
	
	}

}
