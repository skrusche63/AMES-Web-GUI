package de.kp.ames.web.client.core.widget.dialog;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.globals.GUIGlobals;

public class EditDialog extends BaseDialog {
	/*
	 * Buttons labels
	 */
	private static String LABEL1 = GUIGlobals.BTN_SAVE_LABEL;
	private static String LABEL2 = GUIGlobals.BTN_CAN_LABEL;

	protected static String STYLE = "x-sc-label";

	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 */
	public EditDialog(String title, String slogan) {
		super(title, slogan);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.base.BaseDialog#createButtons()
	 */
	public VLayout createButtons() {
		return createButtons(LABEL1, LABEL2);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.base.BaseDialog#createB1ClickHandler()
	 */
	public ClickHandler createB1ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				doSave();				
			}			
		};
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.base.BaseDialog#createB2ClickHandler()
	 */
	public ClickHandler createB2ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				destroy();				
			}			
		};
	}

	public void doSave() {
		/*
		 * Must be overridden
		 */
	}
	
}
