package de.kp.ames.web.client.core.clas.action;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.clas.action
 *  Module: ClasDeleteImpl
 *  @author spex66@gmx.net
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #core #delete #clas #classification #web
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

import com.smartgwt.client.data.Record;

import de.kp.ames.web.client.action.grid.GridDeleteImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.clas.ClasController;
import de.kp.ames.web.client.core.grid.Grid;

public class ClasDeleteImpl extends GridDeleteImpl {

	/**
	 * Constructor
	 * 
	 * @param grid
	 * @param record
	 */
	public ClasDeleteImpl(Grid grid, Record record) {
		super(grid, record);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		ClasController controller = new ClasController();	
		controller.doDelete(this.params, grid, record, new ActivityImpl() {
			public void execute() {
				/*
				 * No action invoked for local delete			
				 */
			}
		});

	}

}
