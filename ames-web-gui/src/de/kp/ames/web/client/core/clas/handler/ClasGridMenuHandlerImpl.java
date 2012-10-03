package de.kp.ames.web.client.core.clas.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.clas.handler
 *  Module: ClasGridMenuHandlerImpl
 *  @author spex66@gmx.net
 *  
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #grid #handler #menu #clas #classification #web
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;

import de.kp.ames.web.client.core.clas.action.ClasCreateImpl;
import de.kp.ames.web.client.core.clas.action.ClasDeleteImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;

public class ClasGridMenuHandlerImpl  extends GridMenuHandlerImpl {
	
	/**
	 * Constructor
	 */
	public ClasGridMenuHandlerImpl() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public ClasGridMenuHandlerImpl(Grid grid) {
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
		 * Create Classification
		 */
		ClasCreateImpl createAction = new ClasCreateImpl(this.grid);
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
			 * Delete Classification
			 */
			ClasDeleteImpl deleteAction = new ClasDeleteImpl(grid, record);
			deleteAction.setParams(this.getParams());
				
			DeleteMenuItem delete = new DeleteMenuItem();
			delete.addAction(deleteAction);
			
			items.add(delete);

		}
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}


}
