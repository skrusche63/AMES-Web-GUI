package de.kp.ames.web.client.core.util;
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

public class KeyGenerator {

	private int counter = 0;
	private static KeyGenerator instance = new KeyGenerator();
	
	private KeyGenerator() {		
	}
	
	/**
	 * @return
	 */
	public static KeyGenerator getInstance() {
		if (instance == null) instance = new KeyGenerator();
		return instance;
		
	}
	
	/**
	 * @param type
	 * @return
	 */
	public String getKey(String type) {
		counter += 1;
		return type + ":" + counter;
	}
	
}
