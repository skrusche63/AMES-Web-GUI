package de.kp.ames.web.client.core.slot.handler;

import java.util.ArrayList;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.slot.action.SlotCreateImpl;
import de.kp.ames.web.client.core.slot.action.SlotDeleteImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;

public class SlotGridMenuHandlerImpl  extends GridMenuHandlerImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public SlotGridMenuHandlerImpl(Grid grid) {
		super(grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.GridMenuHandlerImpl#createMenuItems(com.smartgwt.client.data.Record)
	 */
	public MenuItem[] createMenuItems(Record record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		/* 
		 * Separator
		 */
		MenuItemSeparator separator = new MenuItemSeparator();

		/*
		 * Create Slot
		 */
		SlotCreateImpl createAction = new SlotCreateImpl(grid);
		createAction.setParams(this.getParams());

		CreateMenuItem create = new CreateMenuItem();
		create.addAction(createAction);
		
		items.add(create);
		
		if (record != null) {

			/*
			 * Separate create from delete
			 */
			items.add(separator);
			
			/*
			 * Delete Slot
			 */
			SlotDeleteImpl deleteAction = new SlotDeleteImpl(grid, record);
			deleteAction.setParams(this.getParams());
	
			DeleteMenuItem delete = new DeleteMenuItem();
			delete.addAction(deleteAction);
			
			items.add(delete);

		}
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}


}
