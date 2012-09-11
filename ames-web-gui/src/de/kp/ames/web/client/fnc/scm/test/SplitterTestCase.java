package de.kp.ames.web.client.fnc.scm.test;

import com.smartgwt.client.widgets.layout.HLayout;

import de.kp.ames.web.client.fnc.scm.layout.LeftportImpl;
import de.kp.ames.web.client.fnc.scm.layout.RightportImpl;

public class SplitterTestCase extends HLayout {
	
	private LeftportImpl leftPort;
	private RightportImpl rightPort;

	private SplitterTestPortImpl centerPort;

	/**
	 * Constructor
	 * 
	 * @param record
	 */
	public SplitterTestCase() {
		
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Left viewport is empty
		 */
		leftPort = new LeftportImpl();
		
		/*
		 * Center viewport
		 */
		centerPort = new SplitterTestPortImpl();
		
		/*
		 * Right viewport is empty
		 */
		rightPort  = new RightportImpl();

		this.setMembers(leftPort, centerPort, rightPort);
		
	};

}
