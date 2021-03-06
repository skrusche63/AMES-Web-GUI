package de.kp.ames.web.client.fnc.bulletin.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.bulletin.widget
 *  Module: MessageImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #bulletin #client #fnc #message #web #widget
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

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DrawEvent;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.bulletin.BulletinService;
import de.kp.ames.web.client.fnc.bulletin.event.BulletinEventManager;
import de.kp.ames.web.shared.constants.MethodConstants;

/**
 * This class provides a mail-like user interface to send
 * a certain comment or posting
 * 
 * @author Stefan Krusche (kruscheqdr-kruscheundpartner.de)
 * 
 */
public class MessageImpl extends CreateFormDialog {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 592;
	private static int HEIGHT = 556;
	
	/*
	 * Reference to message type
	 */
	private String type;
	
	public MessageImpl(String title, String slogan, String type, JSONValue jValue) {
		super(title, slogan);
		
		/*
		 * Register message type
		 */
		this.type = type;
		
		/* 
		 * Register posting (for comment) or recipient
		 * for posting
		 */
		this.jValue = jValue;
		
		this.setShowCloseButton(true);
		this.setShowMinimizeButton(true);
		
		/*
		 * Set dimensions
		 */
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		
		/*
		 * The Posting Editor is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

		/*
		 * Set form data from externally provided JSON data
		 */
		this.form.addFormData(this.jValue);	
		
		this.redraw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new MessageFormImpl();
		this.form.addFormHandler(this);

		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSend()
	 */
	public void doSend() {
		
		String data = this.form.getFormData();

		String target = ((MessageFormImpl)this.form).getTarget();
		String type = this.type;

		HashMap<String,String> attributes = new HashMap<String,String>();
		
		attributes.put(MethodConstants.ATTR_TYPE,   type);
		attributes.put(MethodConstants.ATTR_TARGET, target);
		
		BulletinService service = new BulletinService();
		service.doSubmit(attributes, data, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				/*
				 * The Bulletin Event Manager informs registered
				 * listeners about the submission of a posting
				 */
				BulletinEventManager.getInstance().onPostingSubmitted();
			}
			
		});

	}


	/**
	 * Provide form with data after window
	 * has been drawn
	 * 
	 * @param event
	 */
	@SuppressWarnings("unused")
	private void afterDraw(DrawEvent event) {
	}

}

