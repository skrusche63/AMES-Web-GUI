package de.kp.ames.web.client.function.help;

import de.kp.ames.web.client.core.apps.BaseApp;
import de.kp.ames.web.client.function.globals.FncGlobals;

public class HelpImpl extends BaseApp {

	public HelpImpl() {
		super(FncGlobals.HELP_TITLE, FncGlobals.HELP_SLOGAN);

		this.setWidth100();
		this.setHeight100();
		
	}
}
