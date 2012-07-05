package de.kp.ames.web.client.core.form;

import de.kp.ames.web.client.core.activity.Activity;

public interface FormHandler {

	/**
	 * @param activity
	 */
	public void addSendActivity(Activity activity);
	
	/**
	 * Send form to server
	 */
	public void doSend();
	
}
