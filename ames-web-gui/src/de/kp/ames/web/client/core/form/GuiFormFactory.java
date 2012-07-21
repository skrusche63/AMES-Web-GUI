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

import com.google.gwt.user.client.ui.HTML;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.UploadItem;

public class GuiFormFactory {

	/**
	 * A GUI helper to create a label
	 * 
	 * @param seqno
	 * @param label
	 * @param style
	 * @return
	 */
	public static CanvasItem createScLabelItem(int seqno, String label, String style) {

		String title = "" + seqno + ". " + label;

		HTMLPane pane = new HTMLPane();
		pane.setHeight(2);
		
		CanvasItem canvasField = new CanvasItem();
		
		canvasField.setTitle(title);
		canvasField.setTitleStyle(style);
		
		canvasField.setCanvas(pane);		
		return canvasField;
		
	}

	/**
	 * A GUI helper to create a password item
	 * 
	 * @param label
	 * @param name
	 * @param style
	 * @param width
	 * @return
	 */
	public static PasswordItem createScPasswordItem(String label, String name, String style, int width) {
		
		PasswordItem textField = new PasswordItem(name, label);
		
		if (label == null) textField.setShowTitle(false);
		textField.setTitleStyle(style);

		textField.setWidth(width);
		return textField;
		
	}

	/**
	 * A GUI helper to create a text area
	 * 
	 * @param label
	 * @param name
	 * @param style
	 * @param width
	 * @return
	 */
	public static TextAreaItem createScTextAreaItem(String label, String name, String style, int width) {
		
		TextAreaItem textAreaField = new TextAreaItem(name, label);
		
		if (label == null) textAreaField.setShowTitle(false);
		textAreaField.setTitleStyle(style);

		textAreaField.setWidth(width);
		textAreaField.setHeight(100);
		
		return textAreaField;
		
	}

	/**
	 * A GUI helper to create a text area
	 * 
	 * @param label
	 * @param name
	 * @param style
	 * @param width
	 * @return
	 */
	public static TextAreaItem createScTextAreaItem(String label, String name, String style, String width) {
		
		TextAreaItem textAreaField = new TextAreaItem(name, label);
		
		if (label == null) textAreaField.setShowTitle(false);
		textAreaField.setTitleStyle(style);

		textAreaField.setWidth(width);
		textAreaField.setHeight(100);
		
		return textAreaField;
		
	}

	/**
	 * A GUI helper to create a text item
	 * 
	 * @param label
	 * @param name
	 * @param style
	 * @param width
	 * @return
	 */
	public static TextItem createScTextItem(String label, String name, String style, int width) {
		
		TextItem textField = new TextItem(name, label);
		
		if (label == null) textField.setShowTitle(false);
		textField.setTitleStyle(style);

		textField.setWidth(width);
		return textField;
		
	}

	/**
	 * A GUI helper to create a text item
	 * 
	 * @param label
	 * @param name
	 * @param style
	 * @param width
	 * @return
	 */
	public static TextItem createScTextItem(String label, String name, String style, String width) {
		
		TextItem textField = new TextItem(name, label);
		
		if (label == null) textField.setShowTitle(false);
		textField.setTitleStyle(style);

		textField.setWidth(width);
		return textField;
		
	}

	/**
	 * A GUI helper to create an upload item
	 * 
	 * @param label
	 * @param name
	 * @param style
	 * @param width
	 * @return
	 */
	public static UploadItem createScUploadItem(String label, String name, String style, int width) {
		
		UploadItem uploadField = new UploadItem(name, label);
		
		if (label == null) uploadField.setShowTitle(false);
		uploadField.setTitleStyle(style);

		uploadField.setWidth(width);
		return uploadField;
		
	}

	public static HTML createScUploadHtml(String label, String name, int width) {
		
		int internalWidth = width+28;
		int fileOffset = internalWidth - 215;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<div style=\"margin:16px;margin-top:24px;position:relative;width:" + internalWidth + "px;\">"); // container

		/*
		 * Fake item
		 */
		sb.append("<div style=\"position:absolute;top:0px;left:0px;\">");
		
		sb.append("<div style=\"top:0;left:0;\">"); // div wrapper for <input> element
		sb.append("<input type=\"text\" id=\"fake_upload\" style=\"width:" + width + "px;height:28px;\" />");
		sb.append("</div>");

		sb.append("<img src=\"images/upload24.png\" style=\"position:relative;top:-28px;left:" + width + "px;\"/>"); // browse image
		
		sb.append("</div>");
		
		/*
		 * File item
		 */		
		sb.append("<span style=\"position:relative;top:0px;left:" + fileOffset + "px;-moz-opacity:0;filter:alpha(opacity=0);opacity:0.0;text-align:right;cursor:pointer;\">");

		sb.append("<input type=\"file\" name=\"" + name + "\" onchange=\"document.getElementById('fake_upload').value=this.value;\" style=\"cursor:pointer;\" />");
		sb.append("</span>");

		sb.append("</div>"); // end container
		
		HTML html = new HTML();
		html.setHTML(sb.toString());
	     
		return html;
		
	}
	
	/**
	 * A helper method to create a rich text editor
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	public static RichTextEditor createScRichTextEditor(int width, int height) {
		
		RichTextEditor richTextEditor = new RichTextEditor();
		
		/*
		 * Dimensions
		 */
		richTextEditor.setWidth(width);
		richTextEditor.setHeight(height);
		
		/*
		 * Rendering
		 */
	    richTextEditor.setShowEdges(false);  

	    richTextEditor.setOverflow(Overflow.HIDDEN);  
	    richTextEditor.setCanDragResize(false);  
		
		return richTextEditor;
		
	}

}
