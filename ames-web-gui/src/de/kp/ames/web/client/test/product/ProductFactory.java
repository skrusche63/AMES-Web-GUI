package de.kp.ames.web.client.test.product;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.product.widget.ProductorFormImpl;
import de.kp.ames.web.client.style.GuiStyles;
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
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of a Productor Form.", 40);

        /*
         * Productor Form
         */
        ProductorFormImpl productorForm = new ProductorFormImpl();
		productorForm.setMargin(24);
		
		/*
		 * Style
		 */
		productorForm.setBackgroundColor("#F2F2F4");
		productorForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,productorForm);
		return layout;
	
	}

}
