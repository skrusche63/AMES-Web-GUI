package de.kp.ames.web.client.menu;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.menu
 *  Module: CommentMenuItem
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #comment #item #menu #web
 * </SemanticAssist>
 *
 */


import de.kp.ames.web.client.style.IconConstants;
import de.kp.ames.web.client.style.MenuConstants;

public class CommentMenuItem extends BaseMenuItem {

	/**
	 * Constructor
	 */
	public CommentMenuItem() {
		super(MenuConstants.MENU_COMMENT, IconConstants.ICON_COMMENT);
	}


}
