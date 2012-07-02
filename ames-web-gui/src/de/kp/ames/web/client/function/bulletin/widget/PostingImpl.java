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

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemKeyPressEvent;
import com.smartgwt.client.widgets.form.events.ItemKeyPressHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.apps.control.UserController;
import de.kp.ames.web.client.core.form.GUIFormFactory;
import de.kp.ames.web.client.core.globals.CoreAttrs;
import de.kp.ames.web.client.core.globals.GUIStyles;
import de.kp.ames.web.client.core.widget.dialog.BaseDialog;
import de.kp.ames.web.client.function.bulletin.BulletinService;
import de.kp.ames.web.client.function.bulletin.event.PostingListener;
import de.kp.ames.web.client.function.globals.FncAttrs;
import de.kp.ames.web.client.function.globals.FncGlobals;
import de.kp.ames.web.shared.ClassificationConstants;

/**
 * This class provides a mail-like user interface to send
 * a certain posting to a selected recipient
 * 
 * @author Stefan Krusche (kruscheqdr-kruscheundpartner.de)
 * 
 */
public class PostingImpl extends BaseDialog {

	private static String STYLE = "x-sc-label";

	private DynamicForm scForm;
	
	/* 
	 * Reference to the recipient of the posting
	 */
	private String recId;
	private String recName;
	
	private PostingListener listener;
	
	private static String RIM_DESC = CoreAttrs.RIM_DESC;
	private static String RIM_NAME = CoreAttrs.RIM_NAME;

	/*
	 * Form fields
	 */
	private TextItem from;
	private TextItem to;
	
	private TextItem subject;
	private RichTextEditor body;
	
	/*
	 * Dimensions (width & height below are the result
	 * of an interactive rendering approach to achieve
	 * the best user experience
	 */
	private static int WIDTH  = 560;
	private static int HEIGHT = 480;
	
	public PostingImpl(String title, String recId, String recName) {
		this(title, recId, recName, null);
	}
	
	public PostingImpl(String title, String recId, String recName, PostingListener listener) {
		super(FncGlobals.POSTING_TITLE, FncGlobals.POSTING_SLOGAN);
		
		/* 
		 * Register recipient
		 */
		this.recId   = recId;
		this.recName = recName;
		
		/*
		 * Set recipient name in form
		 */
		setToField();
		
		/* 
		 * Register handler
		 */
		this.listener = listener;

		this.setTitle(title);
		
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
	 * @see de.kp.ames.web.client.core.gui.base.BaseDialog#createB1ClickHandler()
	 */
	public ClickHandler createB1ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				submit();				
			}			
		};
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.gui.base.BaseDialog#createB2ClickHandler()
	 */
	public ClickHandler createB2ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				destroy();				
			}			
		};
	}

	/**
	 * Submit posting
	 */
	private void submit() {

		JSONObject jForm = new JSONObject();

		/*
		 * Subject field
		 */
		String subjectValue = subject.getValueAsString();
		jForm.put(RIM_NAME, new JSONString(subjectValue));
		
		/*
		 * Body field
		 */
		String bodyValue = body.getValue();
		jForm.put(RIM_DESC, new JSONString(bodyValue));

		/*
		 * Send submit request
		 */
		final PostingImpl self = this;

		BulletinService service = new BulletinService();
		service.doSubmit(ClassificationConstants.FNC_ID_Posting, this.recId, jForm.toString(), new ActivityImpl() {

			public void execute(JSONValue jValue) {
				if (self.listener != null) listener.afterSubmitted(self.recId);
				self.destroy();
			}
			
		});
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.gui.base.BaseDialog#createBodyContent()
	 */
	public Canvas createBodyContent() {

		/*
		 * Note, that width and height used below are the result
		 * of a boring rendering process to achieve the best user
		 * experience, so be careful when changing these numbers
		 */
		VLayout wrapper = new VLayout();
		
		wrapper.setWidth100();
		wrapper.setHeight100();
		
		scForm = new DynamicForm();
		scForm.setTitleSuffix(""); // default ":"
		
		scForm.setColWidths(60, 480);
		scForm.setFixedColWidths(true);
		
		scForm.setPadding(8);
		scForm.setTitleOrientation(TitleOrientation.LEFT);
		
		scForm.setWidth100();
		
		/*
		 * From field (this is a GUI field only)
		 */
		
		from = GUIFormFactory.createScTextItem("<b>From</b>:", FncAttrs.FROM, STYLE, 280);

		UserController uctrl = UserController.getInstance();		
		from.setValue(uctrl.getUserName());
		
		/*
		 * To field (this is a GUI field only)
		 */
		to = GUIFormFactory.createScTextItem("<b>To</b>:", FncAttrs.TO, STYLE, 280);

		/*
		 * Subject field
		 */
		subject = GUIFormFactory.createScTextItem("<b>Subject</b>:", RIM_NAME, STYLE, 470);
		
		/*
		 * Body field
		 */
		
		body = GUIFormFactory.createScRichTextEditor(546, 230);
		
		body.setBorder(GUIStyles.APP_BORDER);
		body.setMargin(8);

		/*
		 * Space for rendering purpose only
		 */
		SpacerItem spacer = new SpacerItem();
		spacer.setHeight(2);
		
		scForm.setFields(new FormItem[] {
			from, spacer, spacer, to, spacer, spacer, subject
		});
		
		scForm.setAutoFocus(true);
		scForm.setLayoutAlign(Alignment.CENTER);

		scForm.addItemKeyPressHandler(new ItemKeyPressHandler() {

			public void onItemKeyPress(ItemKeyPressEvent event) {
				if ("Enter".equals(event.getKeyName())) {

				}
			}
		});

		wrapper.setMembers(scForm, body);
		return wrapper;

	}

	/**
	 * A helper method to give user feedback
	 */
	private void setToField() {
		to.setValue(recName);

	}

}

