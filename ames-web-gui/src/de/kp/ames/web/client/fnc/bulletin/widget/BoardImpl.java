package de.kp.ames.web.client.fnc.bulletin.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.bulletin.widget
 *  Module: BoardImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #board #bulletin #client #fnc #web #widget
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
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.bulletin.data.PostGridImpl;
import de.kp.ames.web.client.fnc.bulletin.event.BulletinEventManager;
import de.kp.ames.web.client.fnc.bulletin.event.ContactListener;
import de.kp.ames.web.client.fnc.bulletin.handler.PostGridMenuHandlerImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.handler.RemoveHandler;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class BoardImpl extends VLayout implements ContactListener, RemoveHandler {

	/*
	 * Reference to registered postings
	 */
	private PostGridImpl grid;

	/**
	 * Constructor
	 */
	public BoardImpl() {
		
		/*
		 * Dimensions
		 */
		setWidth100();
		setHeight100();

		/*
		 * Build label
		 */
		Label label = new Label(FncGlobals.POSTINGS_LABEL);
		
		label.setWidth100();
		label.setHeight(22);
		
		label.setAlign(Alignment.CENTER);

		/*
		 * Build grid
		 */
		String recipient = null;
		grid = new PostGridImpl(recipient);

		/*
		 * Assign context specific menu handler
		 */
		HashMap<String,String> attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, ClassificationConstants.FNC_ID_Comment);
		
		PostGridMenuHandlerImpl menuHandler = new PostGridMenuHandlerImpl();
		menuHandler.setParams(attributes);
		
		grid.addMenuHandler(menuHandler);

		this.setMembers(label, grid);
		
		/*
		 * Context specific event handling
		 */
		BulletinEventManager.getInstance().addContactListener(this);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.RemoveHandler#beforeRemove()
	 */
	public void beforeRemove() {
		BulletinEventManager.getInstance().removeContactListener(this);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.bulletin.event.ContactListener#onContactSelected(com.smartgwt.client.widgets.grid.Record)
	 */
	public void onContactSelected(Record record) {
		
		String recipient = record.getAttributeAsString(JaxrConstants.RIM_ID);
		
		HashMap<String,String> attributes = new HashMap<String,String>();		
		attributes.put(MethodConstants.ATTR_TARGET, recipient);
		
		if (grid != null) grid.reload(attributes);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.fnc.bulletin.event.ContactListener#onPostingSubmitted()
	 */
	public void onPostingSubmitted() {
		/*
		 * Reload posting grid to show the newly
		 * submitted posting to the user
		 */
		if (grid != null) grid.reload();
		
	}

}
