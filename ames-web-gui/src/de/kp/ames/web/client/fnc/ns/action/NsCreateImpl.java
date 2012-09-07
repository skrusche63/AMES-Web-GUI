package de.kp.ames.web.client.fnc.ns.action;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.fnc.ns.action
 *  Module: NsCreateImpl
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #action #client #create #fnc #ns #web
 * </SemanticAssist>
 *
 */

import java.util.HashMap;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.tree.TreeNode;

import de.kp.ames.web.client.action.tree.TreeCreateImpl;
import de.kp.ames.web.client.core.activity.ActivityImpl;
import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.tree.Tree;
import de.kp.ames.web.client.core.util.UUID;
import de.kp.ames.web.client.fnc.ns.NsController;
import de.kp.ames.web.client.fnc.ns.data.NsTreeImpl;
import de.kp.ames.web.shared.constants.IconConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;

public class NsCreateImpl extends TreeCreateImpl {
	
	/**
	 * Constructor
	 * 
	 * @param tree
	 */
	public NsCreateImpl(Tree tree, TreeNode node) {	
		super(tree, node);
	}
	
	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.action.ActionImpl#execute()
	 */
	public void execute() {

		HashMap<String,String> attributes = this.getParams();

		final NsCreateImpl self = this;
		NsController controller = new NsController();
		
		controller.doCreate(attributes, node, new ActivityImpl() {
			public void execute(JSONValue jValue) {
				self.doAfterCreate(jValue);
			}
		});
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.web.client.action.tree.TreeEditImpl#doAfterEdit(com.google.gwt.json.client.JSONValue)
	 */
	@Override
	public void doAfterCreate(JSONValue jValue) {

		String[] keys = {

				JaxrConstants.RIM_NAME,
				JaxrConstants.RIM_DESC,
				JaxrConstants.RIM_SLOT

		};

		/*
		 * Build record from JSON representation
		 */
		Record record = new Record();
		
		JSONObject jNode = jValue.isObject();
		for (String key: keys) {
			record.setAttribute(key, jNode.get(key).isString().stringValue());
		}
		
		/*
		 * If there is a parent node
		 * 		add J_ID to record
		 * 		add RIM_ID to parent SUBMIT parameter
		 * 
		 * If there is no parent node, do nothing
		 */
		if (node != null) {
			/*
			 * PrimaryKey identifies parent
			 */
			record.setAttribute(JsonConstants.J_PID, node.getAttributeAsString(JsonConstants.J_ID));
			
			/*
			 * Set parameter for submit request
			 */
			((NsTreeImpl)tree).setAttribute(MethodConstants.ATTR_PARENT, node.getAttributeAsString(JaxrConstants.RIM_ID));
			
		}
		
		/*
		 * Inject additional attributes
		 */
		record.setAttribute(JsonConstants.J_IS_FOLDER, true);
		record.setAttribute(JaxrConstants.RIM_ICON, GuiConstants.ICON_DIR + IconConstants.FOLDER + GuiConstants.ICON_SUFFIX);

		/* 
		 * Create separate primaryKey "id"
		 */
		record.setAttribute(JsonConstants.J_ID, UUID.uuid());
		
		((NsTreeImpl)tree).addData(record, new DSCallback() {
			public void execute(DSResponse response, Object rawData, DSRequest request) {
				/*
				 * Make sure that the respective parent
				 * folder is open to make changes directly
				 * visible
				 */
				((NsTreeImpl)tree).openFolder(node);
			}
		});

	}

}
