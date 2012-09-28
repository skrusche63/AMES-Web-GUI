package de.kp.ames.web.client.fnc.workshop.widget;

/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.workshop
 *  Module: WorkshopImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #case #client #show #fnc #web #workshop
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

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;

import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.widget.base.BaseApp;
import de.kp.ames.web.client.fnc.workshop.WorkshopService;

public class WorkshopImpl extends BaseApp {

	/**
	 * Constructor
	 */
	public WorkshopImpl() {
		super("ADF Workshop", "Discover your 1st App");

		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();

		/*
		 * Set members to workshop
		 */
		this.setContent(createWorkshop());

		final WorkshopImpl self = this;
		this.addDrawHandler(new DrawHandler() {

			@Override
			public void onDraw(DrawEvent event) {
				self.afterDraw();
			}
		});

	}

	protected void afterDraw() {
		/**
		 * Show workshop dialog
		 */
		WorkshopService service = new WorkshopService();
		service.doGetRequest(new ActivityImpl() {
			public void execute(String response) {
				new WorkshopDialog(response);
			}
		});

	}

	private HTMLPane createWorkshop() {

		HTMLPane workshopPane = new HTMLPane();

		/*
		 * Dimensions
		 */
		workshopPane.setWidth100();
		workshopPane.setHeight100();

		workshopPane.setContents("<H1>Congratulation, you succeeded on client side, too!</H1>");

		return workshopPane;

	}

}
