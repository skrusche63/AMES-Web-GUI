package de.kp.ames.web.client.function.user.widget;
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

import com.smartgwt.client.widgets.Canvas;

import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;
import de.kp.ames.web.client.function.globals.FncGlobals;

public class UserGetViewer extends ViewerImpl {

	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public UserGetViewer(Canvas body) {
		super(FncGlobals.USER_G_TITLE, FncGlobals.USER_G_SLOGAN, body);
	}
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 * @param body
	 */
	public UserGetViewer(String title, String slogan, Canvas body) {
		super(title, slogan, body);
	}

}
