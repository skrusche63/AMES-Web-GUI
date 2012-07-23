package de.kp.ames.web.client.test.comm;

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;

public class CommFactory extends FncFactory {

	public static VLayout createCommGridImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public static VLayout createCommViewer() {

		String message = "Click the button to open the CommViewer.";
		return createDialog(message, "Show Viewer", new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

}
