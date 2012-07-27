package de.kp.ames.web.client.fnc.upload.event;

public interface UploadListener {

	/**
	 * This method is invoked after an upload is complete
	 */
	public void onSuccess();
	
	public void onFailure();
	
}
