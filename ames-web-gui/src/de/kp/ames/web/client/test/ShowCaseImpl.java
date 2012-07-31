package de.kp.ames.web.client.test;
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

import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.LeafClickEvent;
import com.smartgwt.client.widgets.tree.events.LeafClickHandler;

import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.data.ScNode;

public class ShowCaseImpl extends BaseApp {
	
	/*
	 * Reference to MainTabs
	 */
	private TabSet mainTabs;
	
	/**
	 * Constructor
	 */
	public ShowCaseImpl() {
		super("ADF Showcase", "Discover the Application Development Framework");
		
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();

		/*
		 * Side navigation
		 */
		VLayout sideNav = createSideNavigation();
	   
		/*
		 * Main tabs
		 */
		Canvas mainTabs = createMainTabs();
		
		/*
		 * Set members to bulletin board
		 */
		this.setContent(sideNav, mainTabs);

	}
	
	private VLayout createSideNavigation() {

        VLayout sideNavLayout = new VLayout();
        
        /*
         * Dimensions
         */
        sideNavLayout.setWidth(240);
        sideNavLayout.setHeight100();

        /*
         * Style
         */
        sideNavLayout.setStyleName(GuiStyles.X_BD_STYLE_0);
        
        sideNavLayout.setShowResizeBar(true);

        SideNavTree sideNav = new SideNavTree();
        sideNav.addLeafClickHandler(new LeafClickHandler() {
            public void onLeafClick(LeafClickEvent event) {
                TreeNode node = event.getLeaf();
                showTestCase(node);
            }
        });

        sideNavLayout.addMember(sideNav);
 
        return sideNavLayout;
        
	}
 
	private Canvas createMainTabs() {
		
		mainTabs = new TabSet();
		
		/*
		 * Dimensions
		 */
	    mainTabs.setWidth100();
	    mainTabs.setHeight100();

	    /*
         * Style
         */
        mainTabs.setStyleName(GuiStyles.X_BD_STYLE_0);
	 
		/*
		 * TabSet layout settings
		 */
        Layout tabProperties = new Layout();

        tabProperties.setLayoutMargin(0);
        tabProperties.setLayoutTopMargin(1);
        
        mainTabs.setPaneContainerProperties(tabProperties);
        mainTabs.setTabBarControls(TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER);

        /*
         * Initial tab (Home)
         */
        Tab tab = new Tab();   	
	    tab.setIcon("silk/house.png", 16);
 
        tab.setTitle("Home&nbsp;&nbsp;");
        tab.setWidth(80);

        /*
         * Tab content
         */
        tab.setPane(createHomeTab());
        mainTabs.addTab(tab);

        /*
         * Wrap tabset
         */
        Canvas canvas = new Canvas();
        
        canvas.setWidth100();
        canvas.setHeight100();
        /*
         * Style
         */
        canvas.setStyleName(GuiStyles.X_BD_STYLE_0);
        
        canvas.addChild(mainTabs);
        return canvas;
        
	}

   private Canvas createHomeTab() {
	   
	   VLayout layout = new VLayout();
	   layout.setShowEdges(false);

       layout.setStyleName(GuiStyles.X_BD_STYLE_0);
       
	   /*
	    * Dimensions
	    */
	   layout.setWidth100();
	   layout.setHeight100();
	   
	   HTMLPane pane = new HTMLPane();
	   
	   StringBuffer sb = new StringBuffer();
	   
	   sb.append("<div style=\"padding:24px;font-size:16px;\">Welcome to the Application Development Framework</div>");
	   
	   pane.setContents(sb.toString());
	   
	   layout.addMember(pane);
	   return layout;
	   
	}

   protected void showTestCase(TreeNode node) {
	   
        ScNode scNode = (ScNode)node;
        
        /*
         * Retrieve node identifier
         */
        String nid = scNode.getNodeID();
        
        /*
         * Tab
         */
        String tid = nid + ":tab";
        Tab tab = mainTabs.getTab(tid);
        
        if (tab == null) {
        	/*
        	 * Create new tab
        	 */
        	tab = ScFactory.getTab(nid);
        	tab.setWidth(80);
        	
        	mainTabs.addTab(tab);
        	mainTabs.selectTab(tab);
        	
        } else {
        	mainTabs.selectTab(tab);
        	
        }
        
    }

}

