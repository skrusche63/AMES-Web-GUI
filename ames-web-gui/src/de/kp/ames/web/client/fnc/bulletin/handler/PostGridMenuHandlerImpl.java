package de.kp.ames.web.client.fnc.bulletin.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.bulletin.handler
 *  Module: PostGridMenuHandlerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #bulletin #client #fnc #grid #handler #menu #post #web
 * </SemanticAssist>
 *
 */


import java.util.ArrayList;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;

import de.kp.ames.web.client.fnc.bulletin.action.CommentCreateImpl;
import de.kp.ames.web.client.fnc.bulletin.action.CommentGetAllImpl;
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
		
		if (record != null) {
		
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

		}
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);
		
	}

}
