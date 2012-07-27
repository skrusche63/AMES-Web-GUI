package de.kp.ames.web.client.fnc.upload.event;
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

import java.util.ArrayList;

public class UploadEventManager implements UploadListener {

	private static UploadEventManager instance = new UploadEventManager();
	
	/*
	 * List of registered upload listeners
	 */
	private ArrayList<UploadListener> UploadListeners;

	/**
	 * Constructor
	 */
	private UploadEventManager() {
		
		UploadListeners = new ArrayList<UploadListener>();
		
	}
	
	/**
	 * Retrieve singleton instance of UploadEventManager
	 * 
	 * @return
	 */
	public static UploadEventManager getInstance() {
		if (instance == null) instance = new UploadEventManager();
		return instance;
	}
	
	/**
	 * Register upload listener
	 * 
	 * @param listener
	 */
	public void addUploadListener(UploadListener listener) {
		UploadListeners.add(listener);
	}
	
	/**
	 * Unregister upload listener
	 * 
	 * @param listener
	 */
	public void removeUploadListener(UploadListener listener) {
		UploadListeners.remove(listener);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.upload.event.UploadListener#onSuccess()
	 */
	public void onSuccess() {
		for (UploadListener listener:UploadListeners) {
			listener.onSuccess();
		}
	}

	public void onFailure() {
		for (UploadListener listener:UploadListeners) {
			listener.onFailure();
		}
	}

	public static void onUploadSuccess() {
		UploadEventManager.getInstance().onSuccess();
	}
	
	public static void onUploadFailure() {
		UploadEventManager.getInstance().onFailure();
	}

    /**
     * Register static methods to invoke the
     * UploadEventManager from javascript
     */
    public static native void exportStaticMethods() /*-{
       
       $wnd.onUploadSuccess = $entry(@de.kp.ames.web.client.fnc.upload.event.UploadEventManager::onUploadSuccess());
       $wnd.onUploadFailure = $entry(@de.kp.ames.web.client.fnc.upload.event.UploadEventManager::onUploadFailure());
    
    }-*/;
	
}