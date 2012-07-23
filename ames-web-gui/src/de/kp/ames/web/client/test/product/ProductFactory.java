package de.kp.ames.web.client.test.product;

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;

public class ProductFactory extends FncFactory {

	public static VLayout createProductGridImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

	public static VLayout createProductEditDialog() {

		String message = "Click the button to open the ProductEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createProductorApplyDialog() {

		String message = "Click the button to open the ProductorApplyDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createProductorCreateDialog() {

		String message = "Click the button to open the ProductorCreateDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createProductorEditDialog() {

		String message = "Click the button to open the ProductorEditDialog.";
		return createDialog(message, new ScAction() {
			public void execute() {
				// TODO
			}
			
		});
	
	}

	public static VLayout createProductorFormImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

}
