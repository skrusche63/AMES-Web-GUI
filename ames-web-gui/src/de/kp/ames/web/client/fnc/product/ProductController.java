package de.kp.ames.web.client.fnc.product;
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

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;

import de.kp.ames.web.client.core.activity.Activity;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.product.widget.ProductorCreateDialog;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class ProductController {

	/**
	 * Constructor
	 */
	public ProductController() {
	}
	
	/**
	 * Create productor
	 * 
	 * @param attributes
	 * @param activity
	 */
	public void doCreate(HashMap<String,String> attributes, Activity activity) {

		/*
		 * Create dialog
		 */
		ProductorCreateDialog createDialog = new ProductorCreateDialog();
		
		/*
		 * Provide request specific information
		 */
		createDialog.setParams(attributes);
		createDialog.addSendActivity(activity);
		
	}

	/**
	 * Delete product or productor
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDelete(final HashMap<String,String> attributes, final Record record, final Activity activity) {

		SC.confirm(FncGlobals.CONFIRM_ACCESSOR_DELETE, new BooleanCallback() {  
 
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
	 * Delete product or productor
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
		ProductService service = new ProductService();
		service.doDelete(attributes, activity);
		
	}

	/**
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doDownload(HashMap<String,String> attributes, Record record, Activity activity) {
		/*
		 * Prepare data for download request
		 */
		attributes.put(MethodConstants.ATTR_ITEM, record.getAttributeAsString(JaxrConstants.RIM_ID));

		/*
		 * Invoke download request
		 */
		ProductService service = new ProductService();
		service.doDownload(attributes, activity);
		
	}
	
	/**
	 * Edit product or productor
	 * 
	 * @param attributes
	 * @param record
	 * @param activity
	 */
	public void doEdit(final HashMap<String,String> attributes, final Record record, final Activity afterSendActivity) {

		final ProductController self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildEditDialog(attributes, jValue, afterSendActivity);
			}			
		};

		/*
		 * Retrieve actual version of product or productor
		 */
		doGet(attributes, record, afterGetActivity);
		
	}

	/**
	 * Get product or productor (metadata)
	 * 
	 * @param attributes
	 * @param record
	 */
	public void doGet(final HashMap<String,String> attributes, final Record record) {

		final ProductController self = this;
		
		/*
		 * Specify get activity
		 */
		ActivityImpl afterGetActivity = new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.buildGetViewer(attributes, jValue);
			}			
		};

		/*
		 * Retrieve actual version of product or productor
		 */
		doGet(attributes, record, afterGetActivity);
		
	}

	public void doView(HashMap<String,String> attributes, Record record) {
		// TODO
	}

	private void doGet(HashMap<String,String> attributes, Record record, ActivityImpl afterGetActivity) {
		// TODO
	}

	/**
	 * Build Accessor Edit Dialog
	 * 
	 * @param jValue
	 */
	private void buildEditDialog(HashMap<String,String> attributes, JSONValue jValue, Activity afterSubmitActivity) {
		// TODO
	}

	private void buildGetViewer(HashMap<String,String> attributes, JSONValue jValue) {
		// TODO
	}

}
