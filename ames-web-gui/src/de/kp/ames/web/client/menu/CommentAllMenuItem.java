package de.kp.ames.web.client.menu;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.menu
 *  Module: CommentAllMenuItem
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #all #client #comment #item #menu #web
 * </SemanticAssist>
 *
 */


import de.kp.ames.web.client.style.IconConstants;
import de.kp.ames.web.client.style.MenuConstants;

public class CommentAllMenuItem extends BaseMenuItem {

	/**
	 * Constructor
	 */
	public CommentAllMenuItem() {
		super(MenuConstants.MENU_COMMENTS, IconConstants.ICON_COMMENTS);
	}

}
