package de.kp.ames.web.client.function.dms.menu;

import java.util.ArrayList;

import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.menu.MenuItem;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.menu.GridMenuHandlerImpl;

public class DmsGridMenuHandlerImpl extends GridMenuHandlerImpl {
	
	public DmsGridMenuHandlerImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.menu.GridMenuHandlerImpl#createMenuItems(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	public MenuItem[] createMenuItems(ListGridRecord record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		// TODO
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}

}
