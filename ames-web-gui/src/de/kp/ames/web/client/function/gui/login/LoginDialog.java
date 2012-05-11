package de.kp.ames.web.client.function.gui.login;
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
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemKeyPressEvent;
import com.smartgwt.client.widgets.form.events.ItemKeyPressHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.callback.ActivityCallback;
import de.kp.ames.web.client.core.callback.ConnectionCallback;
import de.kp.ames.web.client.core.globals.CoreAttributes;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.gui.base.BaseDialog;
import de.kp.ames.web.client.core.gui.control.UserController;
import de.kp.ames.web.client.core.gui.form.GUIFormFactory;
import de.kp.ames.web.client.core.gui.globals.GUIGlobals;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.core.service.DisclaimerService;
import de.kp.ames.web.client.core.service.LoginService;

/**
 * The login dialog is used to retrieve user credentials
 * independent of the X.509 certificate provided by the
 * Https connection; these credentials are relevant for
 * accessing chat and email servers that are part of the
 * AMES backend
 * 
 * @author Stefan Krusche (krusche@dr-kruscheundpartner.de)
 *
 */
public class LoginDialog extends BaseDialog {

	/*
	 * Buttons labels
	 */
	private static String LABEL1 = GUIGlobals.BTN_LOGIN_LABEL;
	private static String LABEL2 = GUIGlobals.BTN_CAN_LABEL;

	private static String STYLE = "x-sc-label";
	
	/*
	 * Title and slogan for login dialog
	 */
	private static String SLOGAN = GUIGlobals.APP_SLOGAN;
	private static String TITLE  = GUIGlobals.APP_TITLE;

	private DynamicForm scForm;
	
	/*
	 * Form items to enter alias and keypass
	 */
	private TextItem aliasItem;
	private PasswordItem keypassItem;
	
	/*
	 * Form item values
	 */
	private String alias   = null;
	private String keypass = null;

	private ActivityCallback activityCallback;
	
	/**
	 * Constructor requires callback
	 * 
	 * @param callback
	 */
	public LoginDialog(ActivityCallback callback) {
		super(TITLE, SLOGAN);
		
		/*
		 * Register activity callback
		 */
		this.activityCallback = callback;
		
		this.setTitle(TITLE + ": Login Form");
		
		this.setShowCloseButton(false);
		this.setShowMinimizeButton(false);
		
		this.setWidth(360);
		this.setHeight(256);

		this.draw();
		
	}

	// Dialog::createBodyContent
	public Canvas createBodyContent() {

		scForm = new DynamicForm();
		scForm.setTitleSuffix(""); // default ":"
		
		scForm.setColWidths(60, 180);
		scForm.setFixedColWidths(true);
		
		scForm.setPadding(20);
		scForm.setTitleOrientation(TitleOrientation.LEFT);
		
		scForm.setWidth100();
		scForm.setHeight100();
		
		/*
		 * Create dynamic form items
		 */
		aliasItem   = GUIFormFactory.createScTextItem("Alias:", CoreAttributes.ALIAS, STYLE, 180);
		keypassItem = GUIFormFactory.createScPasswordItem("Keypass:", CoreAttributes.KEYPASS, STYLE, 180);
		
		/*
		 * Space for rendering purpose only
		 */
		SpacerItem spacer = new SpacerItem();
		spacer.setHeight(4);
		
		scForm.setFields(new FormItem[] {
			aliasItem, spacer, spacer, keypassItem
		});
		
		scForm.setAutoFocus(true);
		scForm.setLayoutAlign(Alignment.CENTER);

		scForm.addItemKeyPressHandler(new ItemKeyPressHandler() {

			public void onItemKeyPress(ItemKeyPressEvent event) {
				if ("Enter".equals(event.getKeyName())) {
					doLogin();
				}
			}
		});

		return scForm;
	}

	// Dialog::createButtons
	public VLayout createButtons() {
		return createButtons(LABEL1, LABEL2);
	}

	// Dialog::createB1ClickHandler
	public ClickHandler createB1ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				doLogin();				
			}			
		};
	}

	// Dialog::createB2ClickHandler
	public ClickHandler createB2ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				destroy();				
			}			
		};
	}

	private void doLogin() {
				
		setIndicator("Authenticating...");

		FormItem[] items = scForm.getFields();			
		for (FormItem item:items) {
			
			String key = item.getName();
			Object val = item.getValue();
			
			if (val == null) continue;
			
			String value = val.toString();
			
			if (CoreAttributes.ALIAS.equals(key))   alias = value;
			if (CoreAttributes.KEYPASS.equals(key)) keypass = value;

		}

		if ((alias == null) || (keypass == null)) {
		
			String message = "Please provide all required parameters.";				
			showMissingParameters(message);

			return;
			
		}
		
		/*
		 * Login service and register method 
		 */
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(CoreGlobals.REGISTER_METHOD);
		
		requestMethod.addAttribute(CoreAttributes.ALIAS,   alias);
		requestMethod.addAttribute(CoreAttributes.KEYPASS, keypass);
		
		LoginService requestService = new LoginService();
		requestService.sendPostRequest(requestMethod, null, new ConnectionCallback() {

			public void onSuccess(String response) {

				try {

					JSONValue jValue   = JSONParser.parseStrict(response);
					JSONObject jObject = jValue.isObject();
					
					boolean result = jObject.get("result").isBoolean().booleanValue();
					
					if (result == true) {
						doLoginSuccess(jObject);
						
					} else {
						String message = jObject.get("message").isString().stringValue();
						doLoginFailed(message);					
					}
					
				} catch (NullPointerException e) {
					doLoginFailed();
					
				}

			}

			public void onError(Throwable throwable) {				
				doLoginFailed();
			}

			public void onTimeout(String message) {
				doLoginFailed();
			}

			public void onFailure(String message) {
				doLoginFailed();					
			}
			
		});

	}
	
	/**
	 * Action due to login success
	 * 
	 * @param jObject
	 */
	private void doLoginSuccess(JSONObject jObject) {
		
		resetIndicator();
		
		/* 
		 * Retrieve information about current user
		 */
		String uid   = jObject.get("id").isString().stringValue();
		String uname = jObject.get("name").isString().stringValue();
		
		String urole = jObject.get("role").isString().stringValue();
		
		/*
		 * Register information about current user
		 */
		UserController uctrl = UserController.getInstance();

		uctrl.setUserId(uid);
		uctrl.setUserName(uname);
		
		uctrl.setUserRole(urole);
	
		/* 
		 * Register alias and keypass
		 */
		uctrl.setAlias(alias);
		uctrl.setKeypass(keypass);
		
		/* 
		 * Hide login window before disclaimer is opened
		 * and finally remove loging window
		 */

		this.hide();
		
		String message = jObject.get("message").isString().stringValue();
		SC.say(TITLE, message, new BooleanCallback() {
			public void execute(Boolean value) {								
				loadDisclaimer();
			}
		});
	}
	
	/**
	 * Action due to login failure
	 */
	private void doLoginFailed() {
		
		resetIndicator();

		String message = "Login failed due to an illegal combination of user name and password.";
		doLoginFailed(message);		
	
	}

	/**
	 * Message box to show the login failure
	 * 
	 * @param message
	 */
	private void doLoginFailed(String message) {
		SC.say(TITLE + ": Login failed", message);		
	}

	/**
	 * Message box to show missing parameters
	 * 
	 * @param message
	 */
	private void showMissingParameters(String message) {
		SC.say(TITLE + ": Missing Parameters", message);		
	}

	private void loadDisclaimer() {
		
		final LoginDialog self = this;

		/*
		 * Disclaimer service and show method 
		 */
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(CoreGlobals.SHOW_METHOD);

		DisclaimerService requestService = new DisclaimerService();
		requestService.sendGetRequest(requestMethod, new ConnectionCallback() {

			public void onSuccess(String response) {
				new DisclaimerDialog(response, new ActivityCallback() {
					public void execute() {
						
						/* 
						 * Close login window
						 */
						self.destroy();
						
						/* 
						 * Execute callback provided with this window
						 */
						self.activityCallback.execute();
						
					}
				});
			}

			public void onError(Throwable throwable) {
				doLoginFailed();
			}

			public void onTimeout(String message) {
				doLoginFailed();
			}

			public void onFailure(String message) {
				doLoginFailed();
			}
			
		});
		
	}

}
