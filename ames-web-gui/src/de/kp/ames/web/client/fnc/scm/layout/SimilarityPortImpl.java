package de.kp.ames.web.client.fnc.scm.layout;
/**
 * Copyright 2012. All rights reserved by Dr. Krusche & Partner PartG
 * Please contact: team@dr-kruscheundpartner.de
 */

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.fnc.scm.event.SearchEventManager;
import de.kp.ames.web.client.fnc.scm.event.SimilarityListener;
import de.kp.ames.web.client.fnc.scm.style.GuiStyles;
import de.kp.ames.web.client.fnc.scm.widget.SimilarityFeedbackImpl;


public class SimilarityPortImpl extends RightportImpl implements SimilarityListener {

	private SimilarityFeedbackImpl similarityFeedback;

	/**
	 * Constructor
	 */
	public SimilarityPortImpl() {

		SC.logWarn("======> ResultPortImpl.CTOR");

		/*
		 * Dimensions
		 */
		this.setWidth(GuiStyles.RIGHT_LINE_WIDTH);
		this.setHeight100();

		this.setShowEdges(false);

		/*
		 * Style
		 */
		this.setStyleName(GuiStyles.X_BD_STYLE_4);
		this.setBackgroundColor(GuiStyles.RIGHT_LINE_BG);
		
		similarityFeedback = new SimilarityFeedbackImpl();
		
		this.setMembers(similarityFeedback);

		/*
		 * register listener
		 */
		SearchEventManager.getInstance().addSimilarityListener(this);
		
	};
	

	@Override
	public void doShowSimilarity(JSONValue jValue) {
		SC.logWarn("======> SimilarityPortImpl.doShowSimilarity");
		/*
		 * update suggestion record
		 */
		similarityFeedback.update(jValue);
	}


	@Override
	public void beforeRemove() {
		/*
		 * unregister listener
		 */
		SearchEventManager.getInstance().removeSimilarityListener(this);
		
	}
}
