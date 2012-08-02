package de.kp.ames.web.client.core.widget.dialog;

import java.util.HashMap;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.client.handler.DialogHandler;

public class GridDialog extends BaseDialog implements DialogHandler {

	/*
	 * Reference to grid
	 */
	protected GridImpl grid;

	/*
	 * Request specific parameters
	 */
	protected HashMap<String,String> params;
	
	/*
	 * Reference to after send activity
	 */
	protected Activity sendActivity;
	
	/*
	 * Form based label style
	 */
	protected static String STYLE = "x-sc-label";
	
	/*
	 * An indicator to determine whether a dialog is
	 * automatically closed after any button is clicked 
	 */
	protected boolean autoClose = true;
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 */
	public GridDialog(String title, String slogan, GridImpl grid) {
		super(title, slogan, grid);				
	}
	
	/**
	 * Get request specific parameters
	 * 
	 * @return
	 */
	public HashMap<String,String> getParams() {
		if (this.params == null) this.params = new HashMap<String,String>();
		return this.params;
	}
	
	/**
	 * Set request specific parameters
	 * 
	 * @param params
	 */
	public void setParams(HashMap<String,String> params) {
		if (this.params == null) this.params = new HashMap<String,String>();
		this.params.putAll(params);
	}

	/**
	 * Set a certain request specific parameter
	 * 
	 * @param key
	 * @param value
	 */
	public void setParam(String key, String value) {
		if (this.params == null) this.params = new HashMap<String,String>();
		this.params.put(key, value);
	}
	
	/**
	 * Get a certain request specific parameter
	 * 
	 * @param key
	 * @return
	 */
	public String getParam(String key) {
		if ((this.params == null) || (this.params.containsKey(key) == false)) return null;
		return this.params.get(key);
	}

	/**
	 * @param autoClose
	 */
	public void setAutoClose(boolean autoClose) {
		this.autoClose = autoClose;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormHandler#doSend()
	 */
	public void doSend() {
		/*
		 * Must be overridden
		 */
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormHandler#addSendActivity(de.kp.ames.web.client.core.activity.Activity)
	 */
	public void addSendActivity(Activity activity) {
		this.sendActivity = activity;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#createB1ClickHandler()
	 */
	public ClickHandler createB1ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				doB1Click();				
			}			
		};
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.BaseDialog#createB2ClickHandler()
	 */
	public ClickHandler createB2ClickHandler() {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				doB2Click();				
			}			
		};
	}

	/**
	 * Dialog handling after second button (B1) clicked
	 */
	public void doB1Click() {		
		/*
		 * Send respective form content
		 */
		this.doSend();				

		if (this.autoClose == false) return;
		
		/*
		 * Initiate before remove processing
		 */
		this.beforeRemove();
		
		/*
		 * Destroy window
		 */
		this.destroy();
		
	}
	
	/**
	 * Dialog handling after second button (B2) clicked
	 */
	public void doB2Click() {
		/*
		 * Initiate before remove processing
		 */
		this.beforeRemove();
		
		/*
		 * Destroy window
		 */
		this.destroy();

	}

}
