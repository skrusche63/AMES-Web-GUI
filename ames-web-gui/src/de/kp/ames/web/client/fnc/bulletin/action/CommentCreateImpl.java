package de.kp.ames.web.client.fnc.bulletin.action;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.bulletin.action
 *  Module: CommentCreateImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #bulletin #client #comment #create #fnc #web
 * </SemanticAssist>
 *
 */


import java.util.HashMap;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.Record;
import de.kp.ames.web.client.action.grid.GridCreateImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.grid.Grid;
import de.kp.ames.web.client.fnc.bulletin.BulletinController;

public class CommentCreateImpl extends GridCreateImpl {

	/*
	 * Reference to posting
	 */
	private Record posting;

	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public CommentCreateImpl(Grid grid, Record record) {
		super(grid);
		
		this.posting = record;
		
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();

		final CommentCreateImpl self = this;		
		BulletinController controller = new BulletinController();
		
		controller.doCreate(attributes, this.posting, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.doAfterCreate(jValue);
			}			
		});

	}

}
