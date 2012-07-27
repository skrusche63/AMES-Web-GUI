package de.kp.ames.web.client.fnc.scm;

import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.scm.event.ScmEventManager;

/**
 * ScmSysImpl is a web application that provides access
 * to the source code of the AMES project; this class
 * manages all the eventa that are ncessary to communicate
 * between the different application components
 */
public class ScmSysImpl extends BaseApp {

	private ExplorerImpl explorer;
	private ModuleImpl module;

	public ScmSysImpl() {
		super(FncGlobals.SCM_TITLE, FncGlobals.SCM_SLOGAN);

		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Construct members of SCMSys
		 */
		explorer = createExplorer();
		module = createModule();
		
		/*
		 * Set Dimensions and splitter
		 */
		
		explorer.setWidth("25%");
		module.setWidth("75%");
		
		/*
		 * Show splitter for explorer
		 */
		explorer.setShowResizeBar(true);
		
		/*
		 * Set members to SCMSys
		 */
		this.setContent(explorer, module);

		/*
		 * Register module as Explorer Listener
		 */
		ScmEventManager.getInstance().addExplorerListener(module);

	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.gui.apps.BaseApp#beforeRemove()
	 */
	public void beforeRemove() {
		
		/*
		 * The module part is an ExplorerListener and
		 * must be removed from the respective event
		 * manager
		 */
		ScmEventManager.getInstance().removeExplorerListener(module);
		
	}
	
	/**
	 * Create explorer part of SCMSys
	 * 
	 * @return
	 */
	private ExplorerImpl createExplorer() {
		return new ExplorerImpl();
	}
	
	/**
	 * Create module part of SCMSys
	 * 
	 * @return
	 */
	private ModuleImpl createModule() {
		return new ModuleImpl();
	}

	
}
