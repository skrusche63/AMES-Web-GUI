package de.kp.ames.web.client.core.slot;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.core.slot
 *  Module: SlotController
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #controller #core #slot #web
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

import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.core.slot.data.SlotGridImpl;

public class SlotController {

	/**
	 * Constructor
	 */
	public SlotController() {	
	}
	
	/**
	 * Create new slot entry
	 * 
	 * @param grid
	 */
	public void doCreate(Grid grid) {
		
		SlotGridImpl slotGrid = (SlotGridImpl)grid;
		slotGrid.newSlot();
		
	}
	
	/**
	 * Delete a certain slot entry
	 * 
	 * @param grid
	 * @param record
	 */
	public void doDelete(Grid grid, Record record) {
		
		SlotGridImpl slotGrid = (SlotGridImpl)grid;
		slotGrid.deleteSlot(record);
		
	}
}
