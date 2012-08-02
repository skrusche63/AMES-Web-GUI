package de.kp.ames.web.client.handler;

import de.kp.ames.web.client.core.activity.Activity;

public interface DialogHandler {

	/**
	 * @param activity
	 */
	public void addSendActivity(Activity activity);
	
	/**
	 * Send form to server
	 */
	public void doSend();
	
}
