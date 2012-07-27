package de.kp.ames.web.client.fnc.help;

import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.fnc.globals.FncGlobals;

public class HelpImpl extends BaseApp {

	public HelpImpl() {
		super(FncGlobals.HELP_TITLE, FncGlobals.HELP_SLOGAN);

		this.setWidth100();
		this.setHeight100();
		
	}
}
