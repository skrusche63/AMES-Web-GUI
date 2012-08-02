package de.kp.ames.web.client.fnc.bulletin.event;

import com.smartgwt.client.data.Record;

public interface ContactListener {

	/**
	 * @param record
	 */
	public void onContactSelected(Record record);
	
	public void onPostingSubmitted();
	
}