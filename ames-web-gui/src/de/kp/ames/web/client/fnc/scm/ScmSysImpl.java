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


import java.util.ArrayList;

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.apps.CustomAppsManager;
import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.scm.control.ScmController;
import de.kp.ames.web.client.handler.RemoveHandler;

/**
 * ScmSysImpl is a web application that provides access
 * to the source code of the AMES project; this class
 * manages all the events that are necessary to communicate
 * between the different application components
 */
public class ScmSysImpl extends BaseApp {

	/*
	 * Reference to removable members
	 */
	public ArrayList<RemoveHandler> removables;

	public ScmSysImpl() {
		super(FncGlobals.SCM_TITLE, FncGlobals.SCM_SLOGAN);
				
		CustomAppsManager.getInstance().getViewport().disableSearch();

		this.removables = new ArrayList<RemoveHandler>();

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

	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.base.BaseApp#beforeRemove()
	 */
	@Override
	public void beforeRemove() {
		
		CustomAppsManager.getInstance().getViewport().enableSearch();

		ScmController.getInstance().doClear();
		
		for (RemoveHandler removable:removables) {
			removable.beforeRemove();
		}

	}

	
}
