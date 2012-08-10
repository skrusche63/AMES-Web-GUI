package de.kp.ames.web.client.fnc.product.action;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.product.action
 *  Module: ProductDownloadImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #download #fnc #product #web
 * </SemanticAssist>
 *
 */

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

import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.action.grid.GridDownloadImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.widget.base.ActionIndicator;
import de.kp.ames.web.client.fnc.product.ProductController;

public class ProductDownloadImpl extends GridDownloadImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public ProductDownloadImpl(Grid grid, Record record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		/*
		 * Open action indicator
		 */
		ActionIndicator.getInstance().open("Downloading...");
		
		HashMap<String,String> attributes = this.getParams();
		final ProductDownloadImpl self = this;
		
		ProductController controller = new ProductController();
		controller.doDownload(attributes, record, new ActivityImpl() {
			/* (non-Javadoc)
			 * @see de.kp.ames.web.client.core.activity.ActivityImpl#execute()
			 */
			public void execute() {
				self.doAfterDownload();				
			}
			
		});

	}

	/**
	 * After download action
	 */
	private void doAfterDownload() {
		
		/*
		 * Reset action indicator
		 */
		ActionIndicator.getInstance().reset();
		
	}

}
