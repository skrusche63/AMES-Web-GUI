package de.kp.ames.web.client.test.transform;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.transform.widget.TransformFormImpl;
import de.kp.ames.web.client.style.GuiStyles;
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
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

		/*
		 * Label
		 */
		HTMLPane pane = getTeaser("This is an example of a Transformator Form.", 40);
		
		/*
		 * Transformator Form
		 */
		TransformFormImpl transformatorForm = new TransformFormImpl();
		transformatorForm.setMargin(24);
		
		/*
		 * Style
		 */
		transformatorForm.setBackgroundColor("#F2F2F4");
		transformatorForm.setStyleName(GuiStyles.X_BD_STYLE_4);
		
		layout.setMembers(pane,transformatorForm);
		return layout;
	
	}

}
