package de.kp.ames.web.client.fnc.scm;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.scm
 *  Module: ExplorerImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #explorer #fnc #scm #web
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

import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.globals.FncGlobals;

/**
 * ExplorerImpl supports a tree-based access to hierarchically
 * organized ExternalLinks; each ExternalLink instance represents
 * a source code module managed through Git
 */
public class ExplorerImpl extends VLayout {

	private ExplorerTree tree;
	public ExplorerImpl() {

		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();

		this.setTitle(FncGlobals.SCM_EXPLORER);
		
		/*
		 * Member
		 */
		tree = new ExplorerTree();
		this.setMembers(tree);
		
	}

}
