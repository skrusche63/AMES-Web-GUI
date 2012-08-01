package de.kp.ames.web.client.fnc.symbol.event;

import java.util.HashMap;

import com.smartgwt.client.data.Record;

public interface SymbolListener {

	public void onSymbolSelected(HashMap<String,String> attributes);

	public void onSymbolSelected(Record record);

}
