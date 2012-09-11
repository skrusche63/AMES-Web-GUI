package de.kp.ames.web.client.fnc.scm.control;

import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.fnc.scm.widget.SearchWidget;
import de.kp.ames.web.client.fnc.scm.widget.SuggestImpl;

public class SuggestController {

	/*
	 * Reference to SuggestImpl
	 */
	private SuggestImpl suggestor;
	
	/*
	 * Coordinates
	 */
	private int x;
	private int y;
	
	private static SuggestController instance = new SuggestController();
	
	private SuggestController() {
	}
	
	public static SuggestController getInstance() {
		if (instance == null) instance = new SuggestController();
		return instance;
	}
	
	public void focusToSuggestGrid() {

		SC.logWarn("====> SuggestController.focusToSuggestGrid");

		if (suggestor != null) suggestor.focusToSuggestGrid();
		
	}
	
	public void focusToSearchBox() {
		
		SearchWidget searchWidget = ScmController.getInstance().getSearchWidget();
		if (searchWidget != null) searchWidget.focusToSearchBox();
		
	}
	
	public void createSuggestor(int x, int y, String query) {

		/*
		 * Register coordinates
		 */
		this.x = x;
		this.y = y;
		
		/*
		 * Remove suggestor from root panel
		 */
		RootPanel rp = RootPanel.get();
		
		if (suggestor != null) {
			rp.remove(suggestor);
			
			suggestor.destroy();
			suggestor = null;

		}
				
		/*
		 * Build requestor
		 */
		//buildSuggestorAsync(query);
		buildSuggestorSync(query);
		
		
	}
	
	public void moveSuggestorTo(int x, int y) {
		if (suggestor != null) {
			suggestor.moveTo(x, y);

			// dynamic adjust height
			resizeHeightSuggestor();
		}
	}

	private void resizeHeightSuggestor() {
		if (suggestor != null) {
			RootPanel rp = RootPanel.get();
			int h = rp.getOffsetHeight() - 200;
			suggestor.setHeightTo(h);
		}
	}
	
	public void removeSuggestor() {

		RootPanel rp = RootPanel.get();
		
		if (suggestor != null) {
			rp.remove(suggestor);
			
			suggestor.destroy();
			suggestor = null;

		}
	}

	private void buildSuggestorSync(String query) {

		suggestor = new SuggestImpl(query);

		RootPanel rp = RootPanel.get();
		rp.add(suggestor);

		moveSuggestorTo(x,y);
		
	}
	

}
