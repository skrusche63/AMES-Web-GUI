package de.kp.ames.web.client.function.transform.widget;
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

import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.widget.viewer.ViewerImpl;

public class TransformViewViewer extends ViewerImpl {

	private static String TITLE  = GUIGlobals.APP_TITLE + ": Transform Viewer";
	private static String SLOGAN = "Use this widget to view a certain transformator.";

	/**
	 * Constructor
	 * 
	 * @param body
	 */
	public TransformViewViewer(Canvas body) {
		super(TITLE, SLOGAN, body);
	}
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param slogan
	 * @param body
	 */
	public TransformViewViewer(String title, String slogan, Canvas body) {
		super(title, slogan, body);
	}

}