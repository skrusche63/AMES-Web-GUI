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
import java.util.Map;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RowContextClickEvent;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;

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
	 * @param event
	 */
	public void afterSelectionChanged(SelectionEvent event);

	/**
	 * @return
	 */
	public String getDetailFieldName();
	
	/**
	 * Data Handling after grid content has changed
	 */
	public void reload();

	/**
	 * Data Handling after grid content has changed
     *
	 * @param attributes
	 */
	public void reload(HashMap<String,String> attributes);
	
	/**
	 * @param attributes
	 * @return
	 */
	public DataSourceField[] createDataFields();

	/**
	 * @param attributes
	 * @return
	 */
	public ListGridField[] createGridFields();

	/**
	 * Create request method from attributes
	 * 
	 * @param attributes
	 * @return
	 */
	public RequestMethod createMethod();

	/**
	 * Create Data source
	 * 
	 * @param attributes
	 */
	public void createScGridDS();
	
	/**
	 * @return
	 */
	public String getRequestUrl();

	/**
	 * @return
	 */
	public Map<String,String> getRequestParams();
	
	
}
