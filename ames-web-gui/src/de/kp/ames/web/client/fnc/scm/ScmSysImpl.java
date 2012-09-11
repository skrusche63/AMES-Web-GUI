package de.kp.ames.web.client.fnc.scm;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.scm
 *  Module: ScmSysImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #scm #sys #web
 * </SemanticAssist>
 *
 */


import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.scm.control.ScmController;
import de.kp.ames.web.client.fnc.scm.widget.SearchWidget;

/**
 * ScmSysImpl is a web application that provides access
 * to the source code of the AMES project; this class
 * manages all the events that are necessary to communicate
 * between the different application components
 */
public class ScmSysImpl extends BaseApp {

	public ScmSysImpl() {
		super(FncGlobals.SCM_TITLE, FncGlobals.SCM_SLOGAN);

		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Create viewport
		 */
		VLayout placeHolder = createInitialPlaceHolder();
		
		/*
		 * Create search widget
		 */
		ScmController.getInstance().doInit(this);

		
		/*
		 * Set members to SCMSys
		 */
		this.setContent(placeHolder);

	}
	
	
	/**
	 * Create Placeholder
	 * 
	 * @return
	 */
	private VLayout createInitialPlaceHolder() {
		
		VLayout placeHolder = new VLayout();

		placeHolder.setShowEdges(false);
		placeHolder.setWidth100();
		placeHolder.setHeight100();
		
		return placeHolder;

	}
	
}
