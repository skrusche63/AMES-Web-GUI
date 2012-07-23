package de.kp.ames.web.client.test.access;

import com.smartgwt.client.widgets.layout.VLayout;

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
        // TODO
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
