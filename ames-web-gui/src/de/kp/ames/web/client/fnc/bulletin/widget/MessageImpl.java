package de.kp.ames.web.client.fnc.bulletin.widget;
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

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.fnc.bulletin.BulletinService;
import de.kp.ames.web.client.fnc.bulletin.event.BulletinEventManager;

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
		
		this.setShowCloseButton(false);
		this.setShowMinimizeButton(false);
		
		/*
		 * Set dimensions
		 */
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		
		/*
		 * The Comm Viewer is a form-based window
		 * and therefore equipped with a fixed size
		 */
		this.setCanDragResize(false);

		/*
		 * Event handling
		 */
		final MessageImpl self = this;
		
		this.addDrawHandler(new DrawHandler() {
			public void onDraw(DrawEvent event) {
				self.afterDraw(event);				
			}			
		});

		this.draw();

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
		
		String target = ((MessageFormImpl)this.form).getTarget();
		
		String data = this.form.getFormData();
		String type = this.type;

		BulletinService service = new BulletinService();
		service.doSubmit(type, target, data, new ActivityImpl() {
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
	private void afterDraw(DrawEvent event) {
		this.form.addFormData(this.jValue);		
	}

}

