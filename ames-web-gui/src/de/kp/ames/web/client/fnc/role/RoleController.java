package de.kp.ames.web.client.fnc.role;
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

import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.role.widget.ResponsibilityCreateDialog;
import de.kp.ames.web.client.fnc.role.widget.RoleCreateDialog;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class RoleController {

	/**
	 * Constructor
	 */
	public RoleController() {
	}

	/**
	 * Create responsibility or role
	 * 
	 * @param attributes
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Activity activity) {

		String type = attributes.get(MethodConstants.ATTR_TYPE);
		if (type.equals(ClassificationConstants.FNC_ID_Responsibility)) {
			
			/*
			 * Create dialog
			 */
			ResponsibilityCreateDialog createDialog = new ResponsibilityCreateDialog();
			
			/*
			 * Provide request specific information
			 */
			createDialog.setParams(attributes);
			createDialog.addSendActivity(activity);
			
		} else if (type.equals(ClassificationConstants.FNC_ID_Role)) {
			
			/*
			 * Create dialog
			 */
			RoleCreateDialog createDialog = new RoleCreateDialog();
			
			/*
			 * Provide request specific information
			 */
			createDialog.setParams(attributes);
			createDialog.addSendActivity(activity);
			
		}
	
	}

	/**
	 * Delete responsibility or role
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(final HashMap<String,String> attributes, final Record record, final Activity activity) {

		SC.confirm(FncGlobals.CONFIRM_ROLE_DELETE, new BooleanCallback() {  
 
			public void execute(Boolean value) {  
                if (value != null && value) {  
                	/*
                	 * Delete confirmed
                	 */
                	doDeleteConfirmed(attributes, record, activity);
 
                }  
            }  
        
		});
		
	}

	/**
	 * Delete responsibility or role
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDeleteConfirmed(HashMap<String,String> attributes, Record record, Activity activity) {
		
		/*
		 * Prepare data for delete request
		 */
		attributes.put(MethodConstants.ATTR_ITEM, record.getAttributeAsString(JaxrConstants.RIM_ID));

		/*
		 * Invoke delete request
		 */
		RoleService service = new RoleService();
		service.doDelete(attributes, activity);

	}

}
