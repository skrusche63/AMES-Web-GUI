package de.kp.ames.web.client.function.gui.bulletin;

import com.smartgwt.client.widgets.layout.VLayout;

public class BoardImpl extends VLayout {

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
}
