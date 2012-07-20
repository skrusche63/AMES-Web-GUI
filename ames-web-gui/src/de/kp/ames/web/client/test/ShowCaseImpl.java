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
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tree.events.LeafClickEvent;
import com.smartgwt.client.widgets.tree.events.LeafClickHandler;

import de.kp.ames.web.client.core.widget.base.BaseApp;

public class ShowCaseImpl extends BaseApp {
	/**
	 * Constructor
	 */
	public ShowCaseImpl() {
		super("ADF Showcase", "Use this application to discovery the Application Development Framework");
		
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();

		/*
		 * Set style (TODO)
		 */
		this.setStyleName("tabSetContainer");

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
        sideNavLayout.setWidth(185);
        sideNavLayout.setHeight100();

        sideNavLayout.setShowResizeBar(true);

        SideNavTree sideNav = new SideNavTree();
        sideNav.addLeafClickHandler(new LeafClickHandler() {
            public void onLeafClick(LeafClickEvent event) {
                //TreeNode node = event.getLeaf();
                //showSample(node);
            }
        });

        sideNavLayout.addMember(sideNav);
 
        return sideNavLayout;
        
	}
 
	private Canvas createMainTabs() {
		
		TabSet mainTabs = new TabSet();
		
		/*
		 * Dimensions
		 */
	    mainTabs.setWidth100();
	    mainTabs.setHeight100();
	 
		/*
		 * TabSet layout settings
		 */
        Layout tabProperties = new Layout();

        tabProperties.setLayoutMargin(0);
        tabProperties.setLayoutTopMargin(1);
        
        mainTabs.setPaneContainerProperties(tabProperties);

        /*
        mainTabSet.addTabSelectedHandler(new TabSelectedHandler() {
            public void onTabSelected(TabSelectedEvent event) {
                Tab selectedTab = event.getTab();
                String historyToken = selectedTab.getAttribute("historyToken");
                if (historyToken != null) {
                    History.newItem(historyToken, false);
                } else {
                    History.newItem("main", false);
                }
            }
        });
		*/

        mainTabs.setTabBarControls(TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER);

        /*
         * Initial tab (Home)
         */
        Tab tab = new Tab();
 
        tab.setTitle("Home&nbsp;&nbsp;");
        tab.setWidth(80);

        /*
         * Tab content (TODO)
         */
 
        mainTabs.addTab(tab);

        /*
         * Wrap batset
         */
        Canvas canvas = new Canvas();
        
        canvas.setWidth100();
        canvas.setHeight100();
        
        canvas.addChild(mainTabs);
        return canvas;
        
	}
	
}

