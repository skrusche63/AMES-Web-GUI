package de.kp.ames.web.client.fnc.transform.widget;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.transform.widget
 *  Module: TransformFormImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #fnc #form #transform #web #widget
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

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

import de.kp.ames.web.client.core.form.FormImpl;
import de.kp.ames.web.client.fnc.transform.event.TransformListener;
import de.kp.ames.web.client.fnc.transform.handler.TransformGridRecordHandlerImpl;
import de.kp.ames.web.client.fnc.upload.data.UploadGridImpl;
import de.kp.ames.web.client.model.TransformatorObject;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.JsonConstants;

public class TransformFormImpl extends FormImpl implements TransformListener {
	
	private static String CACHE = "Cache";
	
	/*
	 * Form dimensions for proper rendering
	 */
	private static int FORM_WIDTH  = 512;
	private static int FORM_HEIGHT = 504;

	/*
	 * Reference to the UploadGrid as transformators
	 * are created from entries of a transient cache
	 */
	private UploadGridImpl uploadGrid;
	
	/*
	 * Reference to transformator selected from
	 * the respective UploadGrid
	 */
	private Record transformRecord;

	/**
	 * Constructor
	 */
	public TransformFormImpl() {

		/*
		 * Dimensions
		 */
		this.setWidth(FORM_WIDTH);
		this.setHeight(FORM_HEIGHT);

		/*
		 * Note, that width and height used below are the result
		 * of a boring rendering process to achieve the best user
		 * experience, so be careful when changing these numbers
		 */
		VLayout wrapper = new VLayout();
		
		wrapper.setWidth100();
		wrapper.setHeight100();
		
		scForm = new DynamicForm();
		scForm.setTitleSuffix(""); // default ":"
		
		scForm.setColWidths(60, 360);
		scForm.setFixedColWidths(true);
		
		scForm.setPadding(8);
		scForm.setTitleOrientation(TitleOrientation.LEFT);
		
		scForm.setWidth100();

		/*
		 * Build form fields
		 */
		scForm.setFields(createFormItemsAsArray());
		
		scForm.setAutoFocus(true);
		scForm.setLayoutAlign(Alignment.CENTER);

		/*
		 * Create Tabs
		 */
		VLayout layout = new VLayout();
		layout.setShowEdges(false);
		
		layout.setWidth(480);
		
		layout.setLayoutMargin(16);
		layout.setLayoutTopMargin(0);
		
		TabSet tabSet = createTabSet();
		
		tabSet.setWidth(480);
		tabSet.setHeight(320);

		/*
		 * Build UploadGrid
		 */
		tabSet.addTab(createUploadTab());
		layout.addMember(tabSet);
		
		/*
		 * Build ClassificiationGrid
		 * 
		 * This is prepared for future versions; actually
		 * classification of transformators is not supported
		 */
		
		wrapper.setMembers(scForm, layout);
		this.setMembers(wrapper);

	}

	private Tab createUploadTab() {

		/*
		 * Build UploadGrid
		 */
		String type = ClassificationConstants.FNC_ID_Transformator;
		uploadGrid = new UploadGridImpl(type);
				
		/*
		 * Add record handler
		 */
		TransformGridRecordHandlerImpl recordHandler = new TransformGridRecordHandlerImpl();
		uploadGrid.addRecordHandler(recordHandler);

        Tab tab = new Tab();   	
        tab.setWidth(80);

        tab.setTitle(CACHE);
 
        /*
         * Tab content
         */
        tab.setPane(uploadGrid);
		return tab;

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#createFormItemsAsList()
	 */
	public ArrayList<FormItem> createFormItemsAsList() {
		return new TransformatorObject().createFormItemsAsList();
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.core.form.FormImpl#getFormData()
	 */
	public String getFormData() {

		JSONObject jForm = new JSONObject();
		
		/*
		 * Key from cache entry
		 */
		if (transformRecord == null) return null;
		String key = transformRecord.getAttributeAsString(JsonConstants.J_KEY);
		
		jForm.put(JsonConstants.J_KEY, new JSONString(key));
		
		/*
		 * Name & description
		 */
		String name = "";
		String desc = "";
		
		FormItem[] items = scForm.getFields();
		for (FormItem item:items) {
			
			if (JaxrConstants.RIM_NAME.equals(item.getName())) {
				name = (String)item.getValue();
				
			} else if (JaxrConstants.RIM_DESC.equals(item.getName())) {
				desc = (String)item.getValue();
				
			}
			
		}
		
		jForm.put(JaxrConstants.RIM_NAME, new JSONString(name));
		jForm.put(JaxrConstants.RIM_DESC, new JSONString(desc));
		
		/*
		 * Classification
		 */
		JSONArray jClas = new JSONArray();
		jClas.set(0, new JSONString(ClassificationConstants.FNC_ID_Transformator));
		
		jForm.put(JaxrConstants.RIM_CLAS, new JSONString(jClas.toString()));
		return jForm.toString();
	
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.transform.event.TransformListener#onTransformatorSelected(com.smartgwt.client.data.Record)
	 */
	public void onTransformatorSelected(Record record) {
		this.transformRecord = record;
	}
	
}
