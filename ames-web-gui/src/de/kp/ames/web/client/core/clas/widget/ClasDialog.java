package de.kp.ames.web.client.core.clas.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.clas.widget
 *  Module: ClasDialog
 *  @author spex66@gmx.net
 *  
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #dialog #core #clas #classification #web #widget
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

import de.kp.ames.web.client.core.clas.data.ClasGridImpl;
import de.kp.ames.web.client.core.clas.data.ClasRemoteGridImpl;
import de.kp.ames.web.client.core.clas.event.ClasEventManager;
import de.kp.ames.web.client.core.clas.event.ClasListener;
import de.kp.ames.web.client.core.clas.handler.ClasGridRecordHandlerImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.shared.constants.JaxrConstants;

/*
 * This dialog is used to populate the ClasGridImpl
 * from the registered classifications of an OASIS
 * ebXML RegRep
 */
public class ClasDialog extends CreateFormDialog implements ClasListener {

	/*
	 * Reference grid
	 */
	private Grid refGrid;
	
	/*
	 * Reference to the ClasGrid
	 */
	private ClasRemoteGridImpl clasGrid;

	/*
	 * Reference to classification selected from
	 * the respective ClasGrid
	 */
	private Record clasRecord;
	
	/**
	 * Constructor
	 * 
	 * @param refGrid
	 */
	public ClasDialog(Grid refGrid) {
		super(FncGlobals.CLAS_C_TITLE, FncGlobals.CLAS_C_SLOGAN);
		
		/*
		 * Register reference grid
		 */
		this.refGrid = refGrid;
		
		/*
		 * Register as clas listener
		 */
		ClasEventManager.getInstance().addClasListener(this);
		
		this.redraw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {
		
		clasGrid = new ClasRemoteGridImpl();
		
		/*
		 * Add record handler
		 */
		ClasGridRecordHandlerImpl recordHandler = new ClasGridRecordHandlerImpl();
		clasGrid.addRecordHandler(recordHandler);

		return clasGrid;
		
	}

	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSend()
	 */
	public void doSend() {
		/*
		 * Add new classification to the local classification grid;
		 * this action is performed on the client side only
		 */
		if (this.clasRecord == null) return;

		ListGridRecord record = new ListGridRecord();  

		/*
		 * Identifier
		 */
		String id = clasRecord.getAttributeAsString(JaxrConstants.RIM_ID);
		record.setAttribute(JaxrConstants.RIM_ID, id);

		/*
		 * Name
		 */
		String name = clasRecord.getAttributeAsString(JaxrConstants.RIM_NAME);
		record.setAttribute(JaxrConstants.RIM_NAME, name);

		/*
		 * Add new record to reference grid
		 */
		((ClasGridImpl)this.refGrid).addRecord(record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#beforeRemove()
	 */
	public void beforeRemove() {
		/*
		 * Unregister ClasListener listener
		 */
		ClasEventManager.getInstance().removeClasListener(this);
		
	}	

	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.core.clas.event.ClasListener#onClasSelected(com.smartgwt.client.data.Record)
	 */
	public void onClasSelected(Record record) {
		this.clasRecord = record;
		
	}

}
