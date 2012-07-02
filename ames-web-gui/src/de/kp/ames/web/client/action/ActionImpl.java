package de.kp.ames.web.client.action;

import java.util.HashMap;

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

public class ActionImpl implements Action {

	/*
	 * Request specific parameters
	 */
	protected HashMap<String,String> params;
	
	public ActionImpl() {
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.Action#execute()
	 */
	public void execute() {
		/*
		 * Must be overridden
		 */
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.Action#getParams()
	 */
	public HashMap<String,String> getParams() {
		if (this.params == null) this.params = new HashMap<String,String>();
		return this.params;
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.Action#setParams(java.util.HashMap)
	 */
	public void setParams(HashMap<String,String> params) {
		this.params = params;
	}

}
