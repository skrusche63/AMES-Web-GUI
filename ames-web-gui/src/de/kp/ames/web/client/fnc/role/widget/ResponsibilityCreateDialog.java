package de.kp.ames.web.client.fnc.role.widget;
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

import java.util.HashMap;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.globals.GUIGlobals;
import de.kp.ames.web.client.core.grid.GridImpl;
import de.kp.ames.web.client.core.widget.dialog.CreateGridDialog;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.ns.data.NsGridImpl;
import de.kp.ames.web.client.fnc.role.RoleService;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class ResponsibilityCreateDialog extends CreateGridDialog {

	public ResponsibilityCreateDialog(GridImpl grid) {
		super(FncGlobals.RESPONSIBILITY_C_TITLE, FncGlobals.RESPONSIBILITY_C_SLOGAN, grid);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.widget.dialog.FormDialog#doSubmit()
	 */
	public void doSend() {

		JSONArray jNamespaces = new JSONArray();
		Record[] selected = this.grid.getSelectedRecords();
		
		if (selected.length == 0) {

			String message = FncGlobals.RESPONSIBILITY_ERROR;
			SC.say(GUIGlobals.APP_TITLE + ": Responsibility Error", message);		

			this.setAutoClose(false);
			return;
		
		}
		
		this.setAutoClose(true);

		/*
		 * Retrieve namespaces
		 */
		
		for (Record record:selected) {
			String namespace = record.getAttributeAsString(JaxrConstants.RIM_ID);
			jNamespaces.set(jNamespaces.size(), new JSONString(namespace));
			
		}
		
		JSONObject jData = new JSONObject();
		jData.put(JaxrConstants.RIM_NAMESPACE, new JSONString(jNamespaces.toString()));
		
		String data = jData.toString();
		
		RoleService service = new RoleService();
		service.doSubmit(this.getParams(), data, this.sendActivity);
		
	}	
	
	/**
	 * @param attributes
	 * @param activity
	 */
	public static void create(HashMap<String,String> attributes, Activity activity) {
		
		GridImpl grid = new NsGridImpl();
		
		/*
		 * Create dialog
		 */
		ResponsibilityCreateDialog dialog = new ResponsibilityCreateDialog(grid);
		
		/*
		 * Provide request specific information
		 */
		dialog.setParams(attributes);
		dialog.addSendActivity(activity);
	
	}

}
