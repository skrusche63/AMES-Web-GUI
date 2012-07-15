package de.kp.ames.web.client.function.bulletin.handler;

import java.util.ArrayList;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;

import de.kp.ames.web.client.function.bulletin.action.CommentCreateImpl;
import de.kp.ames.web.client.function.bulletin.action.CommentGetAllImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.CommentMenuItem;
import de.kp.ames.web.client.menu.CommentAllMenuItem;

public class PostGridMenuHandlerImpl extends GridMenuHandlerImpl {

	/**
	 * Constructor
	 */
	public PostGridMenuHandlerImpl() {
		super();
	}

	public MenuItem[] createMenuItems(Record record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		/*
		 * Build comment
		 */
		CommentCreateImpl createAction = new CommentCreateImpl(grid, record);
		createAction.setParams(this.getParams());
		
		CommentMenuItem comment = new CommentMenuItem();
		comment.addAction(createAction);
		
		items.add(comment);
		
		/*
		 * Separate create from get all
		 */
		items.add(new MenuItemSeparator());

		/*
		 * Build comment all
		 */
		CommentGetAllImpl getAllAction = new CommentGetAllImpl(grid, record);
		createAction.setParams(this.getParams());
		
		CommentAllMenuItem commentAll = new CommentAllMenuItem();
		comment.addAction(getAllAction);
		
		items.add(commentAll);

		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}

}
