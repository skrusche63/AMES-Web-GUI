package de.kp.ames.web.client.test.access;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.access.widget.AccessorFormImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;

public class AccessFactory extends FncFactory {

	public static VLayout createAccessGridImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public static VLayout createAccessorCreateDialog() {

		String message = "Click the button to open the AccessorCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createAccessorEditDialog() {

		String message = "Click the button to open the AccessorEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createAccessorFormImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of an Accessor Form.", 40);

        /*
         * Accessor Form
         */
        AccessorFormImpl accessorForm = new AccessorFormImpl();
		accessorForm.setMargin(24);
		
		/*
		 * Style
		 */
		accessorForm.setBackgroundColor("#F2F2F4");
		accessorForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,accessorForm);
		return layout;
	
	}

	public static VLayout createAccessorGetViewer() {

		String message = "Click the button to open the AccessorGetViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createRemoteViewer() {

		String message = "Click the button to open the RemoteViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

}
