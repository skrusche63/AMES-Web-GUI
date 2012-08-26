package de.kp.ames.web.client.test.map;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test.map
 *  Module: MapFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #factory #map #test #web
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

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.fnc.map.data.LayerGridImpl;
import de.kp.ames.web.client.fnc.map.event.MapEventManager;
import de.kp.ames.web.client.fnc.map.event.MapListener;
import de.kp.ames.web.client.fnc.map.widget.LayerGridSelectDialog;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;

public class MapFactory extends FncFactory implements MapListener {

	/*
	 * Reference to Map layout
	 */
	private VLayout mapLayout;
	
	private static MapFactory instance = new MapFactory();
	
	private MapFactory() {
		MapEventManager.getInstance().addMapListener(this);
	}
	
	public static MapFactory getInstance() {
		if (instance == null) instance = new MapFactory();
		return instance;
	}

	public VLayout createLayerGridImpl() {

		VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

		/*
		 * Label
		 */
		HTMLPane pane = getTeaser("View all registered WMS layer.", 40);

		/*
		 * Grid
		 */
		LayerGridImpl grid = new LayerGridImpl(GuiConstants.WMS_URL, new ActivityImpl() {
			public void execute() {
				// No activity required as this is a local operation
			}
		});
		
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane, grid);
		return layout;

	}

	public VLayout createBusinessMapImpl() {

		mapLayout = new VLayout();
		
		/*
		 * Dimensions
		 */
		mapLayout.setWidth100();
		mapLayout.setHeight100();
		
		mapLayout.setStyleName(GuiStyles.X_BD_STYLE_0);
		
		
		String message = "Click the button to open the LayerGridSelectDialog.";
		mapLayout.addMember(createDialog(message, new ScAction() {
			public void execute() {
				/*
				 * Layer selector
				 */
				new LayerGridSelectDialog();

			}

		}));
		
		return mapLayout;
		
	}
	
	private void replacePlaceHolder(Canvas canvas) {

		mapLayout.removeMember(mapLayout.getMember(0));
		mapLayout.addMember(canvas);
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.fnc.map.event.MapListener#onMap(com.smartgwt.client.widgets.Canvas)
	 */
	public void onMap(Canvas canvas) {
		replacePlaceHolder(canvas);
		
	}


}
