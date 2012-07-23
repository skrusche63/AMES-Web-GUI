package de.kp.ames.web.client.test.role;

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;

public class RoleFactory extends FncFactory {

	public static VLayout createRoleGridImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public static VLayout createResponsibilityCreateDialog() {

		String message = "Click the button to open the ResponsibilityCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createResponsibilityFormImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public static VLayout createRoleCreateDialog() {

		String message = "Click the button to open the RoleCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createRoleFormImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

}
