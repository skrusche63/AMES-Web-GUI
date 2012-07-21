package de.kp.ames.web.client.function.product.handler;
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

import java.util.ArrayList;

import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.function.product.action.ProductDeleteImpl;
import de.kp.ames.web.client.function.product.action.ProductDownloadImpl;
import de.kp.ames.web.client.function.product.action.ProductEditImpl;
import de.kp.ames.web.client.function.product.action.ProductViewImpl;
import de.kp.ames.web.client.function.product.action.ProductorApplyImpl;
import de.kp.ames.web.client.function.product.action.ProductorCreateImpl;
import de.kp.ames.web.client.function.product.action.ProductorDeleteImpl;
import de.kp.ames.web.client.function.product.action.ProductorEditImpl;
import de.kp.ames.web.client.function.product.action.ProductorGetImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.ApplyMenuItem;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;
import de.kp.ames.web.client.menu.DownloadMenuItem;
import de.kp.ames.web.client.menu.EditMenuItem;
import de.kp.ames.web.client.menu.GetMenuItem;
import de.kp.ames.web.client.menu.ViewMenuItem;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class ProductGridMenuHandlerImpl extends GridMenuHandlerImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public ProductGridMenuHandlerImpl(Grid grid) {
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
		 * Distinguish between productors & products
		 */

		String type = this.getParam(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Product)) {

			/*
			 * Edit product
			 */
			ProductEditImpl editAction = new ProductEditImpl(grid, record);
			editAction.setParams(this.getParams());
			
			EditMenuItem edit = new EditMenuItem();
			edit.addAction(editAction);
			
			items.add(edit);

			/*
			 * Delete product
			 */
			ProductDeleteImpl deleteAction = new ProductDeleteImpl(grid, record);
			deleteAction.setParams(this.getParams());
			
			DeleteMenuItem delete = new DeleteMenuItem();
			delete.addAction(deleteAction);
			
			items.add(delete);

			/*
			 * Separate view from delete
			 */
			items.add(separator);
			
			/*
			 * View product
			 */
			ProductViewImpl viewAction = new ProductViewImpl(grid, record);
			viewAction.setParams(this.getParams());
			
			ViewMenuItem view = new ViewMenuItem();
			view.addAction(viewAction);
			
			items.add(view);

			/*
			 * Separate download from view
			 */
			items.add(separator);
			
			/*
			 * Download product
			 */
			ProductDownloadImpl downloadAction = new ProductDownloadImpl(grid, record);
			downloadAction.setParams(this.getParams());
			
			DownloadMenuItem download = new DownloadMenuItem();
			download.addAction(downloadAction);
			
			items.add(download);


		} else if (type.equals(ClassificationConstants.FNC_ID_Productor)) {
			
			/*
			 * Create productor
			 */
			ProductorCreateImpl createAction = new ProductorCreateImpl(grid);
			createAction.setParams(this.getParams());
			
			CreateMenuItem create = new CreateMenuItem();
			create.addAction(createAction);
			
			items.add(create);
			
			/*
			 * Separate create from edit & delete
			 */
			items.add(separator);

			/*
			 * Edit productor
			 */
			ProductorEditImpl editAction = new ProductorEditImpl(grid, record);
			editAction.setParams(this.getParams());
			
			EditMenuItem edit = new EditMenuItem();
			edit.addAction(editAction);
			
			items.add(edit);

			/*
			 * Delete productor
			 */
			ProductorDeleteImpl deleteAction = new ProductorDeleteImpl(grid, record);
			deleteAction.setParams(this.getParams());
			
			DeleteMenuItem delete = new DeleteMenuItem();
			delete.addAction(deleteAction);
			
			items.add(delete);

			/*
			 * Separate delete from get
			 */
			items.add(separator);

			/*
			 * Get productor
			 */
			ProductorGetImpl getAction = new ProductorGetImpl(grid, record);
			getAction.setParams(this.getParams());
			
			GetMenuItem get = new GetMenuItem();
			get.addAction(getAction);
			
			items.add(get);

			/*
			 * Separate get from apply
			 */
			items.add(separator);

			/*
			 * Apply productor
			 */
			ProductorApplyImpl applyAction = new ProductorApplyImpl(grid, record);
			applyAction.setParams(this.getParams());
			
			ApplyMenuItem apply = new ApplyMenuItem();
			apply.addAction(applyAction);
			
			items.add(apply);
			
		}
				
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);

	}

}
