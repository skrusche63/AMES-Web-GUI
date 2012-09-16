package de.kp.ames.web.client.core.util;

/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.util
 *  Module: DownloadFrame
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #core #download #frame #util #web
 * </SemanticAssist>
 *
 */

import com.google.gwt.event.dom.client.HasLoadHandlers;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.RootPanel;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.globals.GuiConstants;

public class DownloadFrame extends Frame implements LoadHandler, HasLoadHandlers {

	public static final String DOWNLOAD_FRAME = "__gwt_downloadFrame";
	public static final String CLIENT_PATH = GuiConstants.CLIENT_PATH;

	/*
	 * Reference to after download activity
	 */
	private Activity afterDownloadActivity;

	public DownloadFrame(String requestUrl, Activity afterDownloadActivity) {
		super();

		/*
		 * Register activity
		 */
		this.afterDownloadActivity = afterDownloadActivity;

		/*
		 * Dimensions
		 */
		this.setSize("1px", "1px");
		this.setVisible(true);

		RootPanel.get(DOWNLOAD_FRAME).add(this);
		startDownloadMonitor();
		
		requestUrl = requestUrl + "&clientpath=" + CLIENT_PATH; 
		this.setUrl(requestUrl);

	}
	
	private void startDownloadMonitor() {

		final DownloadFrame self = this;

		if (Cookies.getCookie("DOWNLOAD_READY") != null) Cookies.removeCookie("DOWNLOAD_READY");

		Cookies.setCookie("DOWNLOAD_READY", "START");
		
		Timer t = new Timer() {

			public void run() {
				
				if (Cookies.getCookie("DOWNLOAD_READY").equals("END")) {

					this.cancel();

					if (self.afterDownloadActivity != null) self.afterDownloadActivity.execute();

				}
			}
		};
		
		t.scheduleRepeating(1000);

	   
	  }

	@Override
	public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == Event.ONLOAD) {

        }
        super.onBrowserEvent(event);
      }


	/**
	 * @param url
	 */
	private native void openURLInNewWindow(String url) /*-{
		$wnd.open(url);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.user.client.ui.Frame#addLoadHandler(com.google.gwt.event
	 * .dom.client.LoadHandler)
	 */
	public HandlerRegistration addLoadHandler(LoadHandler handler) {
		return this.addHandler(handler, LoadEvent.getType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.event.dom.client.LoadHandler#onLoad(com.google.gwt.event
	 * .dom.client.LoadEvent)
	 */
	@Override
	public void onLoad(LoadEvent event) {

		if (this.afterDownloadActivity != null)
			this.afterDownloadActivity.execute();
	}

}
