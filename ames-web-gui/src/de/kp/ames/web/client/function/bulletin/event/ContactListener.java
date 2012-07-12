package de.kp.ames.web.client.function.bulletin.event;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public interface ContactListener {

	/**
	 * @param record
	 */
	public void onContactSelected(ListGridRecord record);
	
}
