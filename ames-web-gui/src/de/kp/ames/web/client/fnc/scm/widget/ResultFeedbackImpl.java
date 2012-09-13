package de.kp.ames.web.client.fnc.scm.widget;
/**
 * Copyright 2012. All rights reserved by Dr. Krusche & Partner PartG
 * Please contact: team@dr-kruscheundpartner.de
 */

import java.util.ArrayList;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.layout.HLayout;

import de.kp.ames.web.client.fnc.scm.layout.LeftportImpl;
import de.kp.ames.web.client.fnc.scm.layout.RightportImpl;
import de.kp.ames.web.client.fnc.scm.layout.SimilarityPortImpl;
import de.kp.ames.web.client.handler.RemoveHandler;

public class ResultFeedbackImpl extends HLayout implements RemoveHandler {
	
	private LeftportImpl leftPort;
	private ResultPortImpl centerPort;
	private RightportImpl rightPort;

	/*
	 * Reference to removable members
	 */
	private ArrayList<RemoveHandler> removables;

	/**
	 * Constructor
	 * 
	 * @param record
	 */
	public ResultFeedbackImpl(Record record) {
		
		/*
		 * instantiate removables list 
		 */
		removables = new ArrayList<RemoveHandler>();

		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Left viewport is empty
		 */
		leftPort   = new LeftportImpl();
		removables.add(leftPort);
		
		/*
		 * Center viewport holds search results
		 */
		centerPort = new ResultPortImpl(record);
		removables.add(centerPort);
		
		/*
		 * Right viewport is empty
		 */
		rightPort  = new SimilarityPortImpl();
		removables.add(rightPort);

		this.setMembers(leftPort, centerPort, rightPort);
		
	}

	@Override
	public void beforeRemove() {

		for (RemoveHandler removable:removables) {
			removable.beforeRemove();
		}
		
	};

}
