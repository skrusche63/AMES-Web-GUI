package de.kp.ames.web.client.fnc.rule.event;
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

import com.smartgwt.client.data.Record;

public class RuleEventManager implements RuleListener {

	private static RuleEventManager instance = new RuleEventManager();
	
	/*
	 * List of registered transform listeners
	 */
	private ArrayList<RuleListener> ruleListeners;

	/**
	 * Constructor
	 */
	private RuleEventManager() {
		
		ruleListeners = new ArrayList<RuleListener>();
		
	}
	
	/**
	 * Retrieve singleton instance of RuleEventManager
	 * 
	 * @return
	 */
	public static RuleEventManager getInstance() {
		if (instance == null) instance = new RuleEventManager();
		return instance;
	}
	
	/**
	 * Register rule listener
	 * 
	 * @param listener
	 */
	public void addRuleListener(RuleListener listener) {
		ruleListeners.add(listener);
	}
	
	/**
	 * Unregister rule listener
	 * 
	 * @param listener
	 */
	public void removeRuleListener(RuleListener listener) {
		ruleListeners.remove(listener);
	}
	
	public void onRuleSelected(Record record) {

		for (RuleListener listener:ruleListeners) {
			listener.onRuleSelected(record);
		}
	
	}

}