package de.kp.ames.web.client.fnc.scm.control;
/**
 * Copyright 2012. All rights reserved by Dr. Krusche & Partner PartG
 * Please contact: team@dr-kruscheundpartner.de
 */

import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.scm.ScmSysImpl;
import de.kp.ames.web.client.fnc.scm.event.SearchEventManager;
import de.kp.ames.web.client.fnc.scm.event.SuggestListener;
import de.kp.ames.web.client.fnc.scm.widget.ResultFeedbackImpl;
import de.kp.ames.web.client.fnc.scm.widget.SearchWidget;
import de.kp.ames.web.shared.constants.JsonConstants;

public class ScmController implements SuggestListener {

	private static ScmController instance = new ScmController();


	/*
	 * Reference to the SearchWidget
	 */
	private SearchWidget searchWidget;

	private boolean isResultLayoutCreated;

	private ScmSysImpl scm;

	/**
	 * Constructor
	 */
	private ScmController() {
		/*
		 * register listener
		 */
		SearchEventManager.getInstance().addSuggestListener(this);
		
	}

	public static ScmController getInstance() {
		if (instance == null)
			instance = new ScmController();
		return instance;
	}

	public void doInit(ScmSysImpl scm) {
		this.scm = scm;
		openSearch();
	}

	private void updateResult(Record suggestRecord) {
		SC.logWarn("======> ScmController.updateResult");

		// send message to all listeners for update
		SearchEventManager.getInstance().doAfterSearchUpdate(suggestRecord);
	}
	
	private void createFirstTimeResult(Record suggestRecord) {

		SC.logWarn("======> ScmController.createFirstTimeResult");

		/* 
		 * Remove placeholder
		 */
		scm.removeMember(scm.getMember(1));
		
		VLayout newWrapper = new VLayout();
		newWrapper.setOverflow(Overflow.AUTO);

		newWrapper.addMember(new ResultFeedbackImpl(suggestRecord));
		scm.addMember(newWrapper);

		scm.redraw();

		SC.logWarn("======> ScmController.createFirstTimeResult END");
	}

	
	/**
	 * This method controls all actions that have to be taken after the main
	 * application as changed its size
	 * 
	 * @param event
	 */
	public void afterResized(ResizedEvent event) {
		if (getSearchWidget() != null)
			getSearchWidget().afterResized(event);
	}

	/**
	 * Close search widget and remove from root panel
	 */
	public void closeSearch() {

		RootPanel.get().remove(getSearchWidget());

		getSearchWidget().destroy();
		searchWidget = null;

	}

	/**
	 * Method to open (and show) the search widget
	 */
	public void openSearch() {

		if (getSearchWidget() != null)
			closeSearch();

		/*
		 * Setup search widget
		 */
		searchWidget = new SearchWidget();

	}

	/**
	 * Toggle visibility of search widget
	 */
	public void toggleSearch() {

		if (getSearchWidget() == null)
			openSearch();

		else
			closeSearch();

	}

	/**
	 * SuggestListener 
	 * Main method to establish after suggest handling
	 * 
	 * @param record
	 */
	@Override
	public void doAfterSuggest(Record record) {

		SC.logWarn("======> ScmController.doAfterSuggest");

		SuggestController.getInstance().removeSuggestor();
		getSearchWidget().moveToTop();
		getSearchWidget().setQuery(record.getAttributeAsString(JsonConstants.J_QUERYRAWSTRING));
		
		if (!isResultLayoutCreated) {
			isResultLayoutCreated = true;
			createFirstTimeResult(record);
		} else {
			updateResult(record);
		}
	}

	/**
	 * @return the searchWidget
	 */
	public SearchWidget getSearchWidget() {
		return searchWidget;
	}



}
