package de.kp.ames.web.client.core.grid;
/**
 *	Copyright 2012 Dr. Krusche & Partner PartG
 *
 *	AMES-Web-GUI is free software: you can redistribute it and/or 
 *	modify it under the terms of the GNU General Public License 
 *	as published by the Free Software Foundation, either version 3 of 
 *	the License, or (at your option) any later version.
 *
 *	AMES- Web-GUI is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 *  See the GNU General Public License for more details. 
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this software. If not, see <http://www.gnu.org/licenses/>.
 *
 */

import java.util.HashMap;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RowContextClickEvent;

import de.kp.ames.web.client.core.method.RequestMethod;
import de.kp.ames.web.client.handler.GridMenuHandler;
import de.kp.ames.web.client.handler.GridRecordHandler;

public interface Grid {
	
	/**
	 * Register Grid MenuHandler
	 * 
	 * @param menuHandler
	 */
	public void addMenuHandler(GridMenuHandler menuHandler);
	
	/**
	 * Register Grid RecordHandler
	 * 
	 * @param recordHandler
	 */
	public void addRecordHandler(GridRecordHandler recordHandler);
	
	/**
	 * Event handling after right mouse click
	 * on grid entry (row)
	 * 
	 * @param event
	 */
	public void afterContextMenu(RowContextClickEvent event);

	/**
	 * 
	 * @param event
	 */
	public void afterRecordClick(RecordClickEvent event);

	/**
	 * @return
	 */
	public String getDetailFieldName();
	
	/**
	 * Data Handling after grid content has changed
	 */
	public void reload();

	/**
	 * @param attributes
	 * @return
	 */
	public DataSourceField[] createDataFields(HashMap<String,String> attributes);

	/**
	 * @param attributes
	 * @return
	 */
	public ListGridField[] createGridFields(HashMap<String,String> attributes);

	/**
	 * Create request method from attributes
	 * 
	 * @param attributes
	 * @return
	 */
	public RequestMethod createMethod(HashMap<String,String> attributes);

	/**
	 * Create Data source
	 * 
	 * @param attributes
	 */
	public void createScGridDS(HashMap<String,String> attributes);

	/**
	 * Create Data Source
	 * 
	 * @param url
	 * @param method
	 * @param fields
	 */
	public void createScGridDS(final String url, final RequestMethod method, final DataSourceField[] fields);

	/**
	 * Name of the Detail Field
	 * 
	 * @return
	 */
	//public String getDetailField();
	
	/**
	 * @return
	 */
	public String getRequestUrl();
	
}
