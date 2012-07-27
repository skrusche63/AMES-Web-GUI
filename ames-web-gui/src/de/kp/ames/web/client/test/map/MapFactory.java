package de.kp.ames.web.client.test.map;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.globals.CoreGlobals;
import de.kp.ames.web.client.fnc.map.data.LayerGridImpl;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;

public class MapFactory extends FncFactory {

	public static VLayout createLayerGridImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("View all registered WMS layer.", 40);
        
        /*
         * Access parameter
         */
        String endpoint = CoreGlobals.WMS_URL;
        ActivityImpl afterLayerActivity = new ActivityImpl() {
			public void execute() {
				SC.say("WMS Layer successfully selected.");
			}       	
        };
        
        /*
         * Grid
         */
		LayerGridImpl grid = new LayerGridImpl(endpoint, afterLayerActivity);
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane, grid);
		return layout;
	
	}

	public static VLayout createBusinessMapImpl() {

        VLayout layout = new VLayout();
        // TODO
		return layout;
	
	}

}
