package de.kp.ames.web.client.function.gui.scm;

import de.kp.ames.web.client.core.gui.apps.BaseApp;
import de.kp.ames.web.client.function.gui.globals.FncGlobals;

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
