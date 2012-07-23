package de.kp.ames.web.client.test.transform;

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;

public class TransformFactory extends FncFactory {

	public static VLayout createSpecGridImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public static VLayout createTransformGridImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public static VLayout createSpecCreateDialog() {

		String message = "Click the button to open the SpecCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createTransformCreateDialog() {

		String message = "Click the button to open the TransformCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createTransformFormImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

}
