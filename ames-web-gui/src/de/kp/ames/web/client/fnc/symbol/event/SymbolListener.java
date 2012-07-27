package de.kp.ames.web.client.fnc.symbol.event;

import java.util.HashMap;

public interface SymbolListener {

	public void onSymbolSelected(HashMap<String,String> attributes);
	
}
