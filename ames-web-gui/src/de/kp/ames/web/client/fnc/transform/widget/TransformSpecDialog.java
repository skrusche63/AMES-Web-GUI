package de.kp.ames.web.client.fnc.transform.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.transform.widget
 *  Module: TransformSpecDialog
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #dialog #fnc #spec #transform #web #widget
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

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.spec.data.SpecGridImpl;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.transform.data.TransformGridImpl;
import de.kp.ames.web.client.fnc.transform.event.TransformEventManager;
import de.kp.ames.web.client.fnc.transform.event.TransformListener;
import de.kp.ames.web.client.fnc.transform.handler.TransformGridRecordHandlerImpl;
import de.kp.ames.web.shared.constants.JaxrConstants;

/*
 * This dialog is used to populate the SpecGridImpl
 * from the registered transformators of an OASIS
 * ebXML RegRep
 */
public class TransformSpecDialog extends CreateFormDialog implements TransformListener {

	/*
	 * Reference grid
	 */
	private Grid refGrid;
	
	/*
	 * Reference to the TransformdGrid as specifications
	 * are created from registered transformators
	 */
	private TransformGridImpl transformGrid;

	/*
	 * Reference to transformator selected from
	 * the respective UploadGrid
	 */
	private Record transformRecord;
	
	/**
	 * Constructor
	 * 
	 * @param refGrid
	 */
	public TransformSpecDialog(Grid refGrid) {
		super(FncGlobals.SPEC_C_TITLE, FncGlobals.SPEC_C_SLOGAN);
		
		/*
		 * Register reference grid
		 */
		this.refGrid = refGrid;
		
		/*
		 * Register as transform listener
		 */
		TransformEventManager.getInstance().addTransformListener(this);
		
		this.redraw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {
		
		transformGrid = new TransformGridImpl();
		
		/*
		 * Add record handler
		 */
		TransformGridRecordHandlerImpl recordHandler = new TransformGridRecordHandlerImpl();
		transformGrid.addRecordHandler(recordHandler);

		return transformGrid;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.transform.event.TransformListener#onTransformatorSelected(com.smartgwt.client.data.Record)
	 */
	public void onTransformatorSelected(Record record) {
		this.transformRecord = record;
		
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
		if (this.transformRecord == null) return;

		ListGridRecord record = new ListGridRecord();  

		/*
		 * Identifier
		 */
		String id = transformRecord.getAttributeAsString(JaxrConstants.RIM_ID);
		record.setAttribute(JaxrConstants.RIM_ID, id);

		/*
		 * Name
		 */
		String name = transformRecord.getAttributeAsString(JaxrConstants.RIM_NAME);
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
		 * Unregister transform listener
		 */
		TransformEventManager.getInstance().removeTransformListener(this);
		
	}	

}
