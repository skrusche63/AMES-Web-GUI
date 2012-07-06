package de.kp.ames.web.client.core.form;
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

import de.kp.ames.web.client.handler.FormHandler;

public interface Form {

	/**
	 * Add form data in terms of a JSONValue
	 * 
	 * @param jValue
	 */
	public void addFormData(JSONValue jValue);

	/**
	 * @return
	 */
	public String getFormData();
	
	/**
	 * Assign form handler to process (submit)
	 * form data
	 */
	public void addFormHandler(FormHandler formHandler);
	
	/**
	 * Indicate form to be read only or not
	 * 
	 * @param readOnly
	 */
	public void setReadOnly(boolean readOnly);
	
}
