package de.kp.ames.web.client.core.form;

import de.kp.ames.web.client.core.activity.Activity;

public interface FormHandler {

	/**
	 * @param activity
	 */
	public void addAfterSubmitActivity(Activity activity);
	
	/**
	 * Submit form to server
	 */
	public void doSubmit();
	
}
