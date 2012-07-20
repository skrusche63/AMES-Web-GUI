package de.kp.ames.web.client.test;

import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;

import de.kp.ames.web.client.test.data.ScNode;
import de.kp.ames.web.client.test.data.ScData;

public class SideNavTree extends TreeGrid {

	private String idSuffix = "";
	private ScNode[] scData = ScData.getData(idSuffix);

    public SideNavTree() {
    	
    	/*
    	 * Dimensions
    	 */
        setWidth100();
        setHeight100();
        
        /*
         * Selection Style
         */
        setSelectionType(SelectionStyle.SINGLE);
        
        /*
        setCustomIconProperty("icon");
        setAnimateFolderTime(100);
        setAnimateFolders(true);
        setAnimateFolderSpeed(1000);
        setNodeIcon("silk/application_view_list.png");
        setShowSortArrow(SortArrow.CORNER);
        */

        /*
         * Data handling
         */
        setShowAllRecords(true);
        setLoadDataOnDemand(false);
        
        setCanSort(false);
        
        /*
         * TreeGrid field
         */
        TreeGridField field = new TreeGridField();
 
        field.setName("nodeTitle");
        field.setTitle("<b>Functional areas</b>");
        
        setFields(field);

        /*
         * Data handling
         */
        Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        
        tree.setNameProperty("nodeTitle");
        tree.setOpenProperty("isOpen");

        tree.setIdField("nodeID");
        tree.setParentIdField("parentNodeID");
        
        tree.setRootValue("root" + idSuffix);

        tree.setData(scData);
        setData(tree);
    
    }

}
