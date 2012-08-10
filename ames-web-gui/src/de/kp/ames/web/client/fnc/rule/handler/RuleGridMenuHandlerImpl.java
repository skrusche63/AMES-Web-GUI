package de.kp.ames.web.client.fnc.rule.handler;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.rule.handler
 *  Module: RuleGridMenuHandlerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #grid #handler #menu #rule #web
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

import java.util.ArrayList;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.product.action.ProductorDeleteImpl;
import de.kp.ames.web.client.fnc.rule.action.EvaluationDeleteImpl;
import de.kp.ames.web.client.fnc.rule.action.EvaluationEditImpl;
import de.kp.ames.web.client.fnc.rule.action.ReasonerApplyImpl;
import de.kp.ames.web.client.fnc.rule.action.ReasonerCreateImpl;
import de.kp.ames.web.client.fnc.rule.action.ReasonerEditImpl;
import de.kp.ames.web.client.fnc.rule.action.ReasonerGetImpl;
import de.kp.ames.web.client.handler.GridMenuHandlerImpl;
import de.kp.ames.web.client.menu.ApplyMenuItem;
import de.kp.ames.web.client.menu.CreateMenuItem;
import de.kp.ames.web.client.menu.DeleteMenuItem;
import de.kp.ames.web.client.menu.EditMenuItem;
import de.kp.ames.web.client.menu.GetMenuItem;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

/**
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */
public class RuleGridMenuHandlerImpl extends GridMenuHandlerImpl {
	
	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public RuleGridMenuHandlerImpl(Grid grid) {
		super(grid);
	}

	public MenuItem[] createMenuItems(Record record) {
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		/* 
		 * Separator
		 */
		MenuItemSeparator separator = new MenuItemSeparator();

		/*
		 * Distinguish between evaluations & reasoners
		 */

		String type = this.getParam(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Evaluation)) {

			if (record != null) {
				
				/*
				 * Edit evaluation
				 */
				EvaluationEditImpl editAction = new EvaluationEditImpl(grid, record);
				editAction.setParams(this.getParams());
				
				EditMenuItem edit = new EditMenuItem();
				edit.addAction(editAction);
				
				items.add(edit);
	
				/*
				 * Delete evaluation
				 */
				EvaluationDeleteImpl deleteAction = new EvaluationDeleteImpl(grid, record);
				deleteAction.setParams(this.getParams());
				
				DeleteMenuItem delete = new DeleteMenuItem();
				delete.addAction(deleteAction);
				
				items.add(delete);

			}
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Reasoner)) {
			
			/*
			 * Create reasoner
			 */
			ReasonerCreateImpl createAction = new ReasonerCreateImpl(grid);
			createAction.setParams(this.getParams());
			
			CreateMenuItem create = new CreateMenuItem();
			create.addAction(createAction);
			
			items.add(create);

			if (record != null) {
				
				/*
				 * Separate create from edit & delete
				 */
				items.add(separator);
	
				/*
				 * Edit reasoner
				 */
				ReasonerEditImpl editAction = new ReasonerEditImpl(grid, record);
				editAction.setParams(this.getParams());
				
				EditMenuItem edit = new EditMenuItem();
				edit.addAction(editAction);
				
				items.add(edit);
	
				/*
				 * Delete reasoner
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
				ReasonerGetImpl getAction = new ReasonerGetImpl(grid, record);
				getAction.setParams(this.getParams());
				
				GetMenuItem get = new GetMenuItem();
				get.addAction(getAction);
				
				items.add(get);
	
				/*
				 * Separate get from apply
				 */
				items.add(separator);
	
				/*
				 * Apply reasoner
				 */
				ReasonerApplyImpl applyAction = new ReasonerApplyImpl(grid, record);
				applyAction.setParams(this.getParams());
				
				ApplyMenuItem apply = new ApplyMenuItem();
				apply.addAction(applyAction);
				
				items.add(apply);

			}
			
		}
				
		return (MenuItem[])items.toArray(new MenuItem [items.size()]);

	}

}
