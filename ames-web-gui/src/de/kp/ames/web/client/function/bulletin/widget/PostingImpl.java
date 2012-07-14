package de.kp.ames.web.client.function.bulletin.widget;
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
import com.smartgwt.client.widgets.Canvas;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.widget.dialog.CreateFormDialog;
import de.kp.ames.web.client.function.bulletin.BulletinService;
import de.kp.ames.web.client.function.globals.FncGlobals;
import de.kp.ames.web.shared.ClassificationConstants;

/**
 * This class provides a mail-like user interface to send
 * a certain posting to a selected recipient
 * 
 * @author Stefan Krusche (kruscheqdr-kruscheundpartner.de)
 * 
 */
public class PostingImpl extends CreateFormDialog {
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 560;
	private static int HEIGHT = 480;
	
	public PostingImpl(JSONValue jValue) {
		super(FncGlobals.POSTING_TITLE, FncGlobals.POSTING_SLOGAN);
		
		/* 
		 * Register recipient
		 */
		this.jValue = jValue;
		
		this.setShowCloseButton(false);
		this.setShowMinimizeButton(false);
		
		/*
		 * Set dimensions
		 */
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);

		this.draw();

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#createContent()
	 */
	public Canvas createContent() {

		/*
		 * Register form and assign form handler
		 */
		this.form = new PostingFormImpl();
		this.form.addFormHandler(this);

		this.form.addFormData(this.jValue);		
		return this.form;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSend()
	 */
	public void doSend() {

		String recipient = ((PostingFormImpl)this.form).getRecipient();
		
		String data = this.form.getFormData();
		String type = ClassificationConstants.FNC_ID_Posting;

		final PostingImpl self = this;

		BulletinService service = new BulletinService();
		service.doSubmit(type, recipient, data, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.doAfterSend(jValue);
			}
			
		});

	}

	/**
	 * After send processing
	 * 
	 * @param jValue
	 */
	private void doAfterSend(JSONValue jValue) {

		// TODO
		
		/*
		 * BulletinEventManager.getInstance().onPostingSubmitted(record);
		 */
		this.destroy();

	}

}

