package de.kp.ames.web.client.fnc.rule.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.rule.widget
 *  Module: RuleSpecDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #dialog #fnc #rule #spec #web #widget
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
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.spec.data.SpecGridImpl;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.rule.data.RuleGridImpl;
import de.kp.ames.web.client.fnc.rule.event.RuleEventManager;
import de.kp.ames.web.client.fnc.rule.event.RuleListener;
import de.kp.ames.web.client.fnc.rule.handler.RuleGridRecordHandlerImpl;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;

/*
 * This dialog is used to populate the SpecGridImpl
 * from the registered rulesers of an OASISebXML RegRep
 */
public class RuleSpecDialog extends CreateFormDialog implements RuleListener {

	/*
	 * Reference grid
	 */
	private Grid refGrid;
	
	/*
	 * Reference to the RuleGrid as specifications
	 * are created from registered transformators
	 */
	private RuleGridImpl ruleGrid;

	/*
	 * Reference to rule selected
	 */
	private Record ruleRecord;
	
	/**
	 * Constructor
	 * 
	 * @param refGrid
	 */
	public RuleSpecDialog(Grid refGrid) {
		super(FncGlobals.SPEC_C_TITLE, FncGlobals.SPEC_C_SLOGAN);
		
		/*
		 * Register reference grid
		 */
		this.refGrid = refGrid;
		
		/*
		 * Register as rule listener
		 */
		RuleEventManager.getInstance().addRuleListener(this);
		
		this.redraw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {
		
		String type = ClassificationConstants.FNC_ID_Rule;
		ruleGrid = new RuleGridImpl(type);
		
		/*
		 * Add record handler
		 */
		RuleGridRecordHandlerImpl recordHandler = new RuleGridRecordHandlerImpl();
		ruleGrid.addRecordHandler(recordHandler);

		return ruleGrid;
		
	}

	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSend()
	 */
	public void doSend() {
		/*
		 * Add new specification to the local specification grid;
		 * this action is performed on the client side only
		 */
		if (this.ruleRecord == null) return;

		ListGridRecord record = new ListGridRecord();  

		/*
		 * Identifier
		 */
		String id = ruleRecord.getAttributeAsString(JaxrConstants.RIM_ID);
		record.setAttribute(JaxrConstants.RIM_ID, id);

		/*
		 * Name
		 */
		String name = ruleRecord.getAttributeAsString(JaxrConstants.RIM_NAME);
		record.setAttribute(JaxrConstants.RIM_NAME, name);

		/*
		 * Add new record to reference grid
		 */
		((SpecGridImpl)this.refGrid).addRecord(record);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#beforeRemove()
	 */
	public void beforeRemove() {
		/*
		 * Unregister rule listener
		 */
		RuleEventManager.getInstance().removeRuleListener(this);
		
	}	

	/**
	 * @param attributes
	 * @param grid
	 * @param activity
	 */
	public static void create(HashMap<String,String> attributes, Grid grid, Activity activity) {
			
		/*
		 * Create dialog: the referenced grid is the SpecGrid
		 */
		RuleSpecDialog dialog = new RuleSpecDialog(grid);
		
		/*
		 * Provide request specific information
		 */
		dialog.setParams(attributes);
		dialog.addSendActivity(activity);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.fnc.rule.event.RuleListener#onRuleSelected(com.smartgwt.client.data.Record)
	 */
	public void onRuleSelected(Record record) {
		this.ruleRecord = record;
		
	}
	
}
