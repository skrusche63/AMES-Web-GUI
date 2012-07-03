package de.kp.ames.web.client.function.user.menu;

import java.util.ArrayList;

import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.menu.MenuItem;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.function.group.action.GroupEditImpl;
import de.kp.ames.web.client.menu.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.item.EditMenuItem;

public class UserGridMenuHandlerImpl extends GridMenuHandlerImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public UserGridMenuHandlerImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.menu.GridMenuHandlerImpl#createMenuItems(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	public MenuItem[] createMenuItems(ListGridRecord record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		
		/*
		 * Edit Community
		 */
		EditMenuItem edit = new EditMenuItem();
		edit.addAction(new GroupEditImpl(grid, record));
		
		items.add(edit);
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}

}
