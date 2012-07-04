package de.kp.ames.web.client.function.ns.menu;

import java.util.ArrayList;

import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;
import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.core.tree.Tree;
import de.kp.ames.web.client.function.ns.action.NsCreateImpl;
import de.kp.ames.web.client.function.ns.action.NsDeleteImpl;
import de.kp.ames.web.client.function.ns.action.NsEditImpl;
import de.kp.ames.web.client.function.ns.action.NsGetImpl;
import de.kp.ames.web.client.handler.TreeMenuHandlerImpl;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;
import de.kp.ames.web.client.menu.EditMenuItem;
import de.kp.ames.web.client.menu.GetMenuItem;

public class NsTreeMenuHandlerImpl extends TreeMenuHandlerImpl {

	/**
	 * Constructor
	 * 
	 * @param tree
	 */
	public NsTreeMenuHandlerImpl(Tree tree) {
		super(tree);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.menu.TreeMenuHandlerImpl#createMenuItems(com.smartgwt.client.widgets.tree.TreeNode)
	 */
	public MenuItem[] createMenuItems(TreeNode node) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		/* 
		 * Separator
		 */
		MenuItemSeparator separator = new MenuItemSeparator();

		/*
		 * Create namespace (= folder)
		 */
		NsCreateImpl createAction = new NsCreateImpl(tree);
		createAction.setParams(this.getParams());
		
		CreateMenuItem create = new CreateMenuItem();
		create.addAction(createAction);
		
		items.add(create);
		
		/*
		 * Separate create from edit & delete
		 */
		items.add(separator);
		
		/*
		 * Edit namespace (= folder)
		 */
		NsEditImpl editAction = new NsEditImpl(tree, node);
		editAction.setParams(this.getParams());
		
		EditMenuItem edit = new EditMenuItem();
		edit.addAction(editAction);
		
		items.add(edit);
		
		/*
		 * Delete namespace (= folder)
		 */
		NsDeleteImpl deleteAction = new NsDeleteImpl(tree, node);
		deleteAction.setParams(this.getParams());
		
		DeleteMenuItem delete = new DeleteMenuItem();
		delete.addAction(deleteAction);
		
		items.add(delete);
				
		/*
		 * Separate delete from get
		 */
		items.add(separator);
		
		/*
		 * Get namespace (= folder)
		 */
		NsGetImpl getAction = new NsGetImpl(tree, node);
		getAction.setParams(this.getParams());
		
		GetMenuItem get = new GetMenuItem();
		get.addAction(getAction);
		
		items.add(get);
		
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);

	}

}
