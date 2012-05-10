package de.kp.ames.web.client;
/**
 * This file is part of the AMES Web GUI.
 *
 * AMES Web GUI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AMES Web GUI is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the AMES Web GUI.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2012 Dr. Krusche & Partner PartG <team@dr-kruscheundpartner.de>
 *
 */

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;

import de.kp.ames.web.client.gui.search.SearchWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class main implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		String url = "http://localhost:8080";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("method", "suggest");
		
		DataSourceField[] fields = {
			new DataSourceTextField("id"),
			new DataSourceTextField("term")
		};
		
		SearchWidget searchImpl = new SearchWidget(url, params, fields);

	}

}
