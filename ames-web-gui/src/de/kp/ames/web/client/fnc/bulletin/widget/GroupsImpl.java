package de.kp.ames.web.client.fnc.bulletin.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.bulletin.widget
 *  Module: GroupsImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #bulletin #client #fnc #groups #web #widget
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

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.bulletin.handler.ContactGridMenuHandlerImpl;
import de.kp.ames.web.client.fnc.bulletin.handler.ContactGridRecordHandlerImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.group.data.GroupGridImpl;
import de.kp.ames.web.client.handler.RemoveHandler;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class GroupsImpl extends VLayout implements RemoveHandler {

	/*
	 * Reference to all registered groups
	 */
	private GroupGridImpl grid;
	
	/**
	 * Constructor
	 */
	public GroupsImpl() {
		
		setWidth100();
		setHeight100();

		/*
		 * Build label
		 */
		Label label = new Label(FncGlobals.GROUPS_LABEL);
		
		label.setWidth100();
		label.setHeight(22);
		
		label.setAlign(Alignment.CENTER);
		
		/*
		 * Build grid
		 */
		grid = new GroupGridImpl();

		/*
		 * Assign context specific menu handler
		 */
		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Posting);
		
		ContactGridMenuHandlerImpl menuHandler = new ContactGridMenuHandlerImpl();
		menuHandler.setParams(attributes);
		
		grid.addMenuHandler(menuHandler);

		/*
		 * Assign context specific record handler
		 */
		grid.addRecordHandler(new ContactGridRecordHandlerImpl());
		
		this.setMembers(label, grid);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.RemoveHandler#beforeRemove()
	 */
	public void beforeRemove() {
		/*
		 * Actually there is noting to do as there is
		 * no event handling invoked
		 */		
	}
	
}
