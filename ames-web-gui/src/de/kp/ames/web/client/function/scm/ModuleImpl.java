package de.kp.ames.web.client.function.scm;
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

import com.google.gwt.user.client.History;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;
import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.core.globals.GUIStyles;
import de.kp.ames.web.client.function.globals.FncGlobals;
import de.kp.ames.web.client.function.scm.event.ExplorerListener;

public class ModuleImpl extends VLayout implements ExplorerListener {

	/*
	 * Reference to tabset to manage selected
	 * source code modules and respective search
	 * results
	 */
	private TabSet tabs;
	
	/*
	 * Reference to the HOME tab
	 */
	private Tab home;
	
	public ModuleImpl() {

		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();

		/*
		 * Title
		 */
		this.setTitle(FncGlobals.SCM_MODULE);
		
		/*
		 * Tabset
		 */
		tabs = createTabs();
        tabs.setTabBarControls(TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER);

        /*
         * Home
         */

        home = new Tab();

        home.setTitle("Home");
        home.setWidth(80);

        tabs.addTab(home);
        this.setMembers(tabs);

	}

	private TabSet createTabs() {

		TabSet tabs = new TabSet();
	    Layout tabsProps = new Layout();
	    
        tabsProps.setLayoutMargin(0);
        tabsProps.setLayoutTopMargin(1);
        
        tabs.setPaneContainerProperties(tabsProps);

        tabs.setWidth100();
        tabs.setHeight100();
        
        tabs.setStyleName(GUIStyles.X_BD_STYLE_0);
        
        tabs.addTabSelectedHandler(new TabSelectedHandler() {
			public void onTabSelected(TabSelectedEvent event) {
                
				Tab selectedTab = event.getTab();
                String historyToken = selectedTab.getAttribute(CoreGlobals.HISTORY_TOKEN);
                
                if (historyToken != null) {
                    History.newItem(historyToken, false);
                
                } else {
                    History.newItem("main", false);
                }
				
			}
        });
        
        return tabs;

	}
	
	@Override
	public void onModuleSelected(TreeNode module) {
		// TODO Auto-generated method stub
		
	}

}
