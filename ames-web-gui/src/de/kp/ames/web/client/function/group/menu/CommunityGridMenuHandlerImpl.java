package de.kp.ames.web.client.function.group.menu;

import java.util.ArrayList;

import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;

import de.kp.ames.web.client.action.Action;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.menu.GridMenuHandlerImpl;
import de.kp.ames.web.client.core.menu.item.CreateMenuItem;
import de.kp.ames.web.client.core.menu.item.DeleteMenuItem;
import de.kp.ames.web.client.core.menu.item.EditMenuItem;
import de.kp.ames.web.client.function.group.action.CommunityCreateImpl;
import de.kp.ames.web.client.function.group.action.CommunityEditImpl;

public class CommunityGridMenuHandlerImpl extends GridMenuHandlerImpl {
	
	public CommunityGridMenuHandlerImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.menu.GridMenuHandlerImpl#createMenuItems(com.smartgwt.client.widgets.grid.ListGridRecord)
	 */
	public MenuItem[] createMenuItems(ListGridRecord record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		/* 
		 * Separator
		 */
		MenuItemSeparator separator = new MenuItemSeparator();

		/*
		 * Create Community
		 */
		CreateMenuItem create = new CreateMenuItem();
		create.addAction(new CommunityCreateImpl(grid));
		
		items.add(create);
		
		/*
		 * Separate create from block edit & delete
		 */
		items.add(separator);
		
		/*
		 * Edit Community
		 */
		EditMenuItem edit = new EditMenuItem();
		edit.addAction(new CommunityEditImpl(grid, record));
		
		items.add(edit);
		
		/*
		 * Delete Community
		 */
		DeleteMenuItem delete = new DeleteMenuItem();
		delete.addAction(CommunityDeleteImpl(grid, record));
		
		items.add(delete);
				
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);

	}

	private Action CommunityDeleteImpl(Grid grid, ListGridRecord record) {
		// TODO Auto-generated method stub
		return null;
	}
}
