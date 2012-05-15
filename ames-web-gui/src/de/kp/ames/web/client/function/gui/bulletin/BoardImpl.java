package de.kp.ames.web.client.function.gui.bulletin;

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.function.gui.bulletin.event.ContactListener;

public class BoardImpl extends VLayout implements ContactListener {

	private OverviewImpl overview;
	private DetailImpl details;

	public BoardImpl() {
				
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Set overview & details
		 */
		overview = new OverviewImpl();
		details = new DetailImpl();
		
		/*
		 * Set Dimensions and splitter
		 */
		
		overview.setHeight("75%");
		details.setHeight("25%");
		
		/*
		 * Show splitter for overview
		 */
		overview.setShowResizeBar(true);
		
		/*
		 * Set members to board
		 */
		this.setMembers(overview, details);

	}

	@Override
	public void onContactSelected() {
		// TODO Auto-generated method stub
		
	}
}
