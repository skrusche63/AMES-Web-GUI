package de.kp.ames.web.client.fnc.scm;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.scm
 *  Module: ExplorerTree
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #explorer #fnc #scm #tree #web
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
import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.LeafClickEvent;
import com.smartgwt.client.widgets.tree.events.LeafClickHandler;

import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.fnc.scm.event.ScmEventManager;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class ExplorerTree extends TreeGrid {

	private RestDataSource ds;
	
	public ExplorerTree() {
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Rendering
		 */
		this.setStyleName(GuiStyles.X_BD_STYLE_0);
		
		this.setShowEdges(false);
        this.setShowConnectors(true);         

		//setCustomIconProperty("icon");
        //setAnimateFolderTime(100);
        //setAnimateFolders(true);
        //setAnimateFolderSpeed(1000);
        //setNodeIcon("silk/application_view_list.png");
        //setShowSortArrow(SortArrow.CORNER);
        this.setBaseStyle("noBorderCell");  

        /*
         * Field
         */
        TreeGridField field = new TreeGridField();
        field.setCanFilter(false);
        
        field.setName(JaxrConstants.RIM_NAME);
        field.setTitle("<b>" + FncGlobals.SCM_EXPLORER + "</b>");
        
        this.setFields(field);

		/*
		 * Data
		 */
		this.setSelectionType(SelectionStyle.SINGLE);

		this.setShowAllRecords(false);
        this.setLoadDataOnDemand(true);

        this.setCanSort(false);
		
		Map<String, String> params = new HashMap<String, String>();
		//params.put(FncGlobals.METHOD, FncGlobals.EXPLORE_METHOD);
		
		DataSourceField[] fields = {
			new DataSourceTextField(JaxrConstants.RIM_ID),
			new DataSourceTextField(JaxrConstants.RIM_NAME),
			new DataSourceTextField(JaxrConstants.RIM_URI)
		};

		ds = createDS(params, fields);
        
        this.setDataSource(ds);  
        this.setAutoFetchData(true);  

        /*
         * Event Handling
         */
        this.addLeafClickHandler(new LeafClickHandler() {
            public void onLeafClick(LeafClickEvent event) {            	
                TreeNode node = event.getLeaf();                
                ScmEventManager.getInstance().onModuleSelected(node);
            }
        });

	}
	
	/**
	 * Retrieve service url
	 * 
	 * @return
	 */
	private String getServiceUrl() {
		return null;
	}
	
	private RestDataSource createDS(final Map<String,String> params, final DataSourceField[] fields) {
		
		String url = getServiceUrl();
		RestDataSource ds = new RestDataSource() {
			
			protected Object transformRequest(DSRequest dsRequest) {
				dsRequest.setParams(params);
				return super.transformRequest(dsRequest);
			}
			
			protected void transformResponse(DSResponse response, DSRequest request, Object data) {
				super.transformResponse(response, request, data);
			}
			
		};
		
		ds.setDataFormat(DSDataFormat.JSON);
		ds.setDataProtocol(DSProtocol.GETPARAMS);
		
		ds.setFetchDataURL(url);
		ds.setFields(fields);
		
		return ds;
		
	}

}
