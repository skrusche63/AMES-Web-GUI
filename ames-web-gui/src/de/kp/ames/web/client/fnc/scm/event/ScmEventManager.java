package de.kp.ames.web.client.fnc.scm.event;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.scm.event
 *  Module: ScmEventManager
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #event #fnc #manager #scm #web
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
import java.util.ArrayList;

import com.smartgwt.client.widgets.tree.TreeNode;

public class ScmEventManager {

	private static ScmEventManager instance = new ScmEventManager();
	
	/*
	 * List of registered explorer listeners
	 */
	private ArrayList<ExplorerListener> explorerListeners;
	
	/**
	 * Constructor
	 */
	private ScmEventManager() {
		explorerListeners = new ArrayList<ExplorerListener>();
	}
	
	/**
	 * Retrieve singleton instance of ScmEventManager
	 * 
	 * @return
	 */
	public static ScmEventManager getInstance() {
		if (instance == null) instance = new ScmEventManager();
		return instance;
	}
	
	/**
	 * Register explorer listener
	 * 
	 * @param listener
	 */
	public void addExplorerListener(ExplorerListener listener) {
		explorerListeners.add(listener);
	}
	
	/**
	 * Unregister explorer listener
	 * 
	 * @param listener
	 */
	public void removeExplorerListener(ExplorerListener listener) {
		explorerListeners.remove(listener);
	}
	
	public void onModuleSelected(TreeNode module) {
		for (ExplorerListener listener:explorerListeners) {
			listener.onModuleSelected(module);
		}
	}
	
}
