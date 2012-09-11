package de.kp.ames.web.client.test;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test
 *  Module: ScFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #factory #sc #test #web
 * </SemanticAssist>
 *
 */

import com.google.gwt.json.client.JSONObject;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;

import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.access.AccessFactory;
import de.kp.ames.web.client.test.bulletin.BulletinFactory;
import de.kp.ames.web.client.test.comm.CommFactory;
import de.kp.ames.web.client.test.dms.DmsFactory;
import de.kp.ames.web.client.test.group.GroupFactory;
import de.kp.ames.web.client.test.map.MapFactory;
import de.kp.ames.web.client.test.ns.NsFactory;
import de.kp.ames.web.client.test.product.ProductFactory;
import de.kp.ames.web.client.test.role.RoleFactory;
import de.kp.ames.web.client.test.rule.RuleFactory;
import de.kp.ames.web.client.test.symbol.SymbolFactory;
import de.kp.ames.web.client.test.transform.TransformFactory;
import de.kp.ames.web.client.test.upload.UploadFactory;
import de.kp.ames.web.client.test.user.UserFactory;

public class ScFactory {

	public static String PREFIX = "function:";
	
	private static String TABLE_ICON  = "silk/table.png";
	private static String WIDGET_ICON = "silk/widget.png";

	public static Tab getTab(String nid) {

		/*
		 * Access-Layer
		 */
		if (nid.equals(PREFIX + "access:data:AccessGridImpl:leaf")) {
			return createAccessGridImpl(nid);

		/*
		 *  asynchronous handling in ShowCaseImpl
		 */
			
//		} else if (nid.equals(PREFIX + "access:data:DatabaseGridImpl:leaf")) {
//			return createDatabaseGridImpl(nid);

		} else if (nid.equals(PREFIX + "access:widget:AccessorCreateDialog:leaf")) {
			return createAccessorCreateDialog(nid);
			
		} else if (nid.equals(PREFIX + "access:widget:AccessorEditDialog:leaf")) {
			return createAccessorEditDialog(nid);

		} else if (nid.equals(PREFIX + "access:widget:AccessorFormImpl:leaf")) {
			return createAccessorFormImpl(nid);

		} else if (nid.equals(PREFIX + "access:widget:AccessorGetViewer:leaf")) {
			return createAccessorGetViewer(nid);
		
		} else if (nid.equals(PREFIX + "access:widget:RemoteGetViewer:leaf")) {
			return createRemoteViewer(nid);

		}
       
        /*
         * Bulletin-Layer
         */        
		else if (nid.equals(PREFIX + "bulletin:data:CommentGridImpl:leaf")) {
			return createCommentGridImpl(nid);
			
		} else if (nid.equals(PREFIX + "bulletin:data:PostGridImpl:leaf")) {
			return createPostGridImpl(nid);
			
		} else if (nid.equals(PREFIX + "bulletin:widget:BulletinImpl:leaf")) {
			return createBulletinImpl(nid);

		} else if (nid.equals(PREFIX + "bulletin:widget:CommentsViewer:leaf")) {
			return createCommentsViewer(nid);

		} else if (nid.equals(PREFIX + "bulletin:widget:MessageImpl:leaf")) {
			return createMessageImpl(nid);

		} else if (nid.equals(PREFIX + "bulletin:widget:MessageFormImpl:leaf")) {
			return createMessageFormImpl(nid);

		}

		/*
		 * Comm-Layer
		 */
		else if (nid.equals(PREFIX + "comm:data:CommGridImpl:leaf")) {
			return createCommGridImpl(nid);

		} else if (nid.equals(PREFIX + "comm:widget:CommFormImpl:leaf")) {
			return createCommFormImpl(nid);

		} else if (nid.equals(PREFIX + "comm:widget:CommViewer:leaf")) {
			return createCommViewer(nid);

		}

		/*
		 * Dms-Layer
		 */
		else if (nid.equals(PREFIX + "dms:data:DmsGridImpl:leaf")) {
			return createDmsGridImpl(nid);

		}

		/*
		 * Group-Layer
		 */
		else if (nid.equals(PREFIX + "group:data:GroupGridImpl:leaf")) {
			return createGroupGridImpl(nid);

		} else if (nid.equals(PREFIX + "group:widget:GroupCreateDialog:leaf")) {
			return createGroupCreateDialog(nid);

		} else if (nid.equals(PREFIX + "group:widget:GroupEditDialog:leaf")) {
			return createGroupEditDialog(nid);
		
		} else if (nid.equals(PREFIX + "group:widget:GroupFormImpl:leaf")) {
			return createGroupFormImpl(nid);
		
		} else if (nid.equals(PREFIX + "group:widget:GroupGetViewer:leaf")) {
			return createGroupGetViewer(nid);

		}

		/*
		 * Map-Layer
		 */
		else if (nid.equals(PREFIX + "map:data:LayerGridImpl:leaf")) {
			return createLayerGridImpl(nid);

		} else if (nid.equals(PREFIX + "map:widget:BusinessMapImpl:leaf")) {
			return createBusinessMapImpl(nid);

		}

		/*
		 * Ns-Layer
		 */
		else if (nid.equals(PREFIX + "ns:data:NsGridImpl:leaf")) {
			return createNsGridImpl(nid);

		} else if (nid.equals(PREFIX + "ns:data:NsTreeImpl:leaf")) {
			return createNsTreeImpl(nid);

		} else if (nid.equals(PREFIX + "ns:widget:NsCreateDialog:leaf")) {
			return createNsCreateDialog(nid);

		} else if (nid.equals(PREFIX + "ns:widget:NsEditDialog:leaf")) {
			return createNsEditDialog(nid);
		
		} else if (nid.equals(PREFIX + "ns:widget:NsFormImpl:leaf")) {
			return createNsFormImpl(nid);
		
		} else if (nid.equals(PREFIX + "ns:widget:NsViewer:leaf")) {
			return createNsViewer(nid);

		}
       
		/*
		 * Product-Layer
		 */
		else if (nid.equals(PREFIX + "product:data:ProductGridImpl:leaf")) {
			return createProductGridImpl(nid);

		} else if (nid.equals(PREFIX + "product:widget:ProductEditDialog:leaf")) {
			return createProductEditDialog(nid);

		} else if (nid.equals(PREFIX + "product:widget:ProductFormImpl:leaf")) {
			return createProductFormImpl(nid);

		} else if (nid.equals(PREFIX + "product:widget:ProductorApplyDialog:leaf")) {
			return createProductorApplyDialog(nid);

		} else if (nid.equals(PREFIX + "product:widget:ProductorCreateDialog:leaf")) {
			return createProductorCreateDialog(nid);

		} else if (nid.equals(PREFIX + "product:widget:ProductorEditDialog:leaf")) {
			return createProductorEditDialog(nid);
		
		} else if (nid.equals(PREFIX + "product:widget:ProductorFormImpl:leaf")) {
			return createProductorFormImpl(nid);

		}

        /*
         * Role-Layer
         */
		else if (nid.equals(PREFIX + "role:data:RoleGridImpl:leaf")) {
			return createRoleGridImpl(nid);

		} else if (nid.equals(PREFIX + "role:widget:ResponsibilityCreateDialog:leaf")) {
			return createResponsibilityCreateDialog(nid);

		}

        /*
         * Rule-Layer
         */
		else if (nid.equals(PREFIX + "rule:data:RuleGridImpl:leaf")) {
			return createRuleGridImpl(nid);

		} else if (nid.equals(PREFIX + "rule:widget:EvaluationEditDialog:leaf")) {
			return createEvaluationEditDialog(nid);
			
		} else if (nid.equals(PREFIX + "rule:widget:ReasonerApplyDialog:leaf")) {
			return createReasonerApplyDialog(nid);
			
		} else if (nid.equals(PREFIX + "rule:widget:ReasonerCreateDialog:leaf")) {
			return createReasonerCreateDialog(nid);
		
		} else if (nid.equals(PREFIX + "rule:widget:ReasonerEditDialog:leaf")) {
			return createReasonerEditDialog(nid);

		} else if (nid.equals(PREFIX + "rule:widget:ReasonerFormImpl:leaf")) {
			return createReasonerFormImpl(nid);
	
		}
		
        /*
         * Symbol-Layer
         */
		else if (nid.equals(PREFIX + "symbol:data:SymbolGridImpl:leaf")) {
			return createSymbolGridImpl(nid);

		} else if (nid.equals(PREFIX + "symbol:data:SymbolTreeImpl:leaf")) {
			return createSymbolTreeImpl(nid);

		} else if (nid.equals(PREFIX + "symbol:widget:SymbolViewer:leaf")) {
			return createSymbolViewer(nid);

		}

        /*
         * Transform-Layer
         */
		else if (nid.equals(PREFIX + "transform:data:TransformGridImpl:leaf")) {
			return createTransformGridImpl(nid);

		} else if (nid.equals(PREFIX + "transform:widget:TransformCreateDialog:leaf")) {
			return createTransformCreateDialog(nid);

		} else if (nid.equals(PREFIX + "transform:widget:TransformFormImpl:leaf")) {
			return createTransformFormImpl(nid);

		}
		
		/*
		 * Upload-Layer
		 */
        else if (nid.equals(PREFIX + "upload:data:UploadGridImpl:leaf")) {
			return createUploadGridImpl(nid);
			
		} else if (nid.equals(PREFIX + "upload:widget:UploadCreateDialog:leaf")) {
			return createUploadCreateDialog(nid);
			
		} else if (nid.equals(PREFIX + "upload:widget:UploadFormImpl:leaf")) {
			return createUploadFormImpl(nid);
			
		}

        /*
         * User-Layer
         */
		else if (nid.equals(PREFIX + "user:data:UserGridImpl:leaf")) {
			return createUserGridImpl(nid);

		} else if (nid.equals(PREFIX + "user:widget:UserEditDialog:leaf")) {
			return createUserEditDialog(nid);

		} else if (nid.equals(PREFIX + "user:widget:UserFormImpl:leaf")) {
			return createUserFormImpl(nid);

		} else if (nid.equals(PREFIX + "user:widget:UserGetViewer:leaf")) {
			return createUserGetViewer(nid);

		}
        
		return null;

	}

	/*
	 * Access-Layer methods
	 */
	private static Tab createAccessGridImpl(String nid) {

		VLayout content = AccessFactory.getInstance().createAccessGridImpl();
		
		Tab tab = createTab(nid, "AccessGridImpl", TABLE_ICON, content);	
		return tab;
	
	}

	public static Tab createDatabaseGridImpl(String nid, JSONObject jDatabase) {

		VLayout content = AccessFactory.getInstance().createDatabaseGridImpl(jDatabase);
		
		Tab tab = createTab(nid, "DatabaseGridImpl", TABLE_ICON, content);	
		return tab;
	
	}


	private static Tab createAccessorCreateDialog(String nid) {

		VLayout content = AccessFactory.getInstance().createAccessorCreateDialog();
		
		Tab tab = createTab(nid, "AccessorCreateDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createAccessorEditDialog(String nid) {

		VLayout content = AccessFactory.getInstance().createAccessorEditDialog();
		
		Tab tab = createTab(nid, "AccessorEditDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createAccessorFormImpl(String nid) {

		VLayout content = AccessFactory.getInstance().createAccessorFormImpl();
		
		Tab tab = createTab(nid, "AccessorFormImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createAccessorGetViewer(String nid) {

		VLayout content = AccessFactory.getInstance().createAccessorGetViewer();
		
		Tab tab = createTab(nid, "AccessorGetViewer", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createRemoteViewer(String nid) {

		VLayout content = AccessFactory.getInstance().createRemoteViewer();
		
		Tab tab = createTab(nid, "RemoteViewer", WIDGET_ICON, content);	
		return tab;
	
	}

	/* 
	 * Bulletin-Layer methods
	 */
	private static Tab createCommentGridImpl(String nid) {
		
		VLayout content = BulletinFactory.createCommentGridImpl();
		
		Tab tab = createTab(nid, "CommentGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createPostGridImpl(String nid) {
		
		VLayout content = BulletinFactory.createPostGridImpl();
		
		Tab tab = createTab(nid, "PostGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createBulletinImpl(String nid) {
		
		VLayout content = BulletinFactory.createBulletinImpl();
		
		Tab tab = createTab(nid, "BulletinImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createCommentsViewer(String nid) {
		
		VLayout content = BulletinFactory.createCommentsViewer();
		
		Tab tab = createTab(nid, "CommentsViewer", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createMessageImpl(String nid) {
		
		VLayout content = BulletinFactory.createMessageImpl();
		
		Tab tab = createTab(nid, "MessageImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createMessageFormImpl(String nid) {
		
		VLayout content = BulletinFactory.createMessageFormImpl();
		
		Tab tab = createTab(nid, "MessageFormImpl", WIDGET_ICON, content);	
		return tab;

	}

	/*
	 * Comm-Layer methods
	 */
	private static Tab createCommGridImpl(String nid) {
		
		VLayout content = CommFactory.getInstance().createCommGridImpl();
		
		Tab tab = createTab(nid, "CommGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createCommFormImpl(String nid) {
		
		VLayout content = CommFactory.getInstance().createCommFormImpl();
		
		Tab tab = createTab(nid, "CommFormImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createCommViewer(String nid) {
		
		VLayout content = CommFactory.getInstance().createCommViewer();
		
		Tab tab = createTab(nid, "CommViewer", WIDGET_ICON, content);	
		return tab;

	}

	/*
	 * Dms-Layer methods
	 */
	private static Tab createDmsGridImpl(String nid) {
		
		VLayout content = DmsFactory.getInstance().createDmsGridImpl();
		
		Tab tab = createTab(nid, "DmsGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createGroupGridImpl(String nid) {
		
		VLayout content = GroupFactory.createGroupGridImpl();
		
		Tab tab = createTab(nid, "GroupGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createGroupCreateDialog(String nid) {
		
		VLayout content = GroupFactory.createGroupCreateDialog();
		
		Tab tab = createTab(nid, "GroupCreateDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createGroupEditDialog(String nid) {
		
		VLayout content = GroupFactory.createGroupEditDialog();
		
		Tab tab = createTab(nid, "GroupEditDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createGroupFormImpl(String nid) {
		
		VLayout content = GroupFactory.createGroupFormImpl();
		
		Tab tab = createTab(nid, "GroupFormImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createGroupGetViewer(String nid) {
		
		VLayout content = GroupFactory.createGroupGetViewer();
		
		Tab tab = createTab(nid, "GroupGetViewer", WIDGET_ICON, content);	
		return tab;

	}

	/*
	 * Map-Layer methods
	 */
	private static Tab createLayerGridImpl(String nid) {
		
		VLayout content = MapFactory.getInstance().createLayerGridImpl();
		
		Tab tab = createTab(nid, "LayerGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createBusinessMapImpl(String nid) {
		
		VLayout content = MapFactory.getInstance().createBusinessMapImpl();
		
		Tab tab = createTab(nid, "BusinessMapImpl", WIDGET_ICON, content);	
		return tab;

	}

	/*
	 * Ns-Layer methods
	 */
	private static Tab createNsGridImpl(String nid) {

		VLayout content = NsFactory.createNsGridImpl();
		
		Tab tab = createTab(nid, "NsGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createNsTreeImpl(String nid) {
		
		VLayout content = NsFactory.createNsTreeImpl();
		
		Tab tab = createTab(nid, "NsTreeImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createNsCreateDialog(String nid) {
		
		VLayout content = NsFactory.createNsCreateDialog();
		
		Tab tab = createTab(nid, "NsCreateDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createNsEditDialog(String nid) {
		
		VLayout content = NsFactory.createNsEditDialog();
		
		Tab tab = createTab(nid, "NsEditDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createNsFormImpl(String nid) {
		
		VLayout content = NsFactory.createNsFormImpl();
		
		Tab tab = createTab(nid, "NsFormImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createNsViewer(String nid) {
		
		VLayout content = NsFactory.createNsViewer();
		
		Tab tab = createTab(nid, "NsViewer", WIDGET_ICON, content);	
		return tab;

	}

	/*
	 * Product-Layer methods
	 */
	private static Tab createProductGridImpl(String nid) {
		
		VLayout content = ProductFactory.getInstance().createProductGridImpl();
		
		Tab tab = createTab(nid, "ProductGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createProductEditDialog(String nid) {
		
		VLayout content = ProductFactory.getInstance().createProductEditDialog();
		
		Tab tab = createTab(nid, "ProductEditDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createProductorApplyDialog(String nid) {
		
		VLayout content = ProductFactory.getInstance().createProductorApplyDialog();
		
		Tab tab = createTab(nid, "ProductorApplyDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createProductorCreateDialog(String nid) {
		
		VLayout content = ProductFactory.getInstance().createProductorCreateDialog();
		
		Tab tab = createTab(nid, "ProductorCreateDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createProductorEditDialog(String nid) {
		
		VLayout content = ProductFactory.getInstance().createProductorEditDialog();
		
		Tab tab = createTab(nid, "ProductorEditDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createProductFormImpl(String nid) {
		
		VLayout content = ProductFactory.getInstance().createProductFormImpl();
		
		Tab tab = createTab(nid, "ProductFormImpl", WIDGET_ICON, content);	
		return tab;

	}
	private static Tab createProductorFormImpl(String nid) {
		
		VLayout content = ProductFactory.getInstance().createProductorFormImpl();
		
		Tab tab = createTab(nid, "ProductorFormImpl", WIDGET_ICON, content);	
		return tab;

	}
		
	/*
	 * Role-Layer method
	 */
	private static Tab createRoleGridImpl(String nid) {
		
		VLayout content = RoleFactory.createRoleGridImpl();
		
		Tab tab = createTab(nid, "RoleGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createResponsibilityCreateDialog(String nid) {
		
		VLayout content = RoleFactory.createResponsibilityCreateDialog();
		
		Tab tab = createTab(nid, "ResponsibilityCreateDialog", WIDGET_ICON, content);	
		return tab;

	}
	
	/*
	 * Rule-Layer methods
	 */
	private static Tab createRuleGridImpl(String nid) {
		
		VLayout content = RuleFactory.getInstance().createRuleGridImpl();
		
		Tab tab = createTab(nid, "RuleGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createReasonerFormImpl(String nid) {
		
		VLayout content = RuleFactory.getInstance().createReasonerFormImpl();
		
		Tab tab = createTab(nid, "ReasonerFormImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createReasonerEditDialog(String nid) {
		
		VLayout content = RuleFactory.getInstance().createReasonerEditDialog();
		
		Tab tab = createTab(nid, "ReasonerEditDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createReasonerCreateDialog(String nid) {
		
		VLayout content = RuleFactory.getInstance().createReasonerCreateDialog();
		
		Tab tab = createTab(nid, "ReasonerCreateDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createReasonerApplyDialog(String nid) {
		
		VLayout content = RuleFactory.getInstance().createReasonerApplyDialog();
		
		Tab tab = createTab(nid, "ReasonerApplyDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createEvaluationEditDialog(String nid) {
		
		VLayout content = RuleFactory.getInstance().createEvaluationEditDialog();
		
		Tab tab = createTab(nid, "EvaluationEditDialog", WIDGET_ICON, content);	
		return tab;

	}


	/*
	 * Symbol-Layer methods
	 */
	private static Tab createSymbolGridImpl(String nid) {
		
		VLayout content = SymbolFactory.getInstance().createSymbolGridImpl();
		
		Tab tab = createTab(nid, "SymbolGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createSymbolTreeImpl(String nid) {
		
		VLayout content = SymbolFactory.getInstance().createSymbolTreeImpl();
		
		Tab tab = createTab(nid, "SymbolTreeImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createSymbolViewer(String nid) {
		
		VLayout content = SymbolFactory.getInstance().createSymbolViewer();
		
		Tab tab = createTab(nid, "SymbolViewer", WIDGET_ICON, content);	
		return tab;

	}
	
	/*
	 * Transform-Layer methods
	 */
	private static Tab createTransformGridImpl(String nid) {
		
		VLayout content = TransformFactory.createTransformGridImpl();
		
		Tab tab = createTab(nid, "TransformGridImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createTransformCreateDialog(String nid) {
		
		VLayout content = TransformFactory.createTransformCreateDialog();
		
		Tab tab = createTab(nid, "TransformCreateDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createTransformFormImpl(String nid) {
		
		VLayout content = TransformFactory.createTransformFormImpl();
		
		Tab tab = createTab(nid, "TransformFormImpl", WIDGET_ICON, content);	
		return tab;

	}
		
	/*
	 * Upload-Layer methods
	 */
	private static Tab createUploadGridImpl(String nid) {
		
		VLayout content = UploadFactory.getInstance().createUploadGridImpl();
		
		Tab tab = createTab(nid, "UploadGridImpl", TABLE_ICON, content);	
		return tab;

	}
	
	private static Tab createUploadCreateDialog(String nid) {
		
        VLayout content = UploadFactory.getInstance().createUploadCreateDialog();		
		
		Tab tab = createTab(nid, "UploadCreateDialog", WIDGET_ICON, content);	
		return tab;

	}
	
	private static Tab createUploadFormImpl(String nid) {

        VLayout content = UploadFactory.getInstance().createUploadFormImpl();
		
		Tab tab = createTab(nid, "UploadFormImpl", WIDGET_ICON, content);	
		return tab;
	
	}
	
	/*
	 * User-Layer methods
	 */
	private static Tab createUserGridImpl(String nid) {

        VLayout content = UserFactory.getInstance().createUserGridImpl();
		
		Tab tab = createTab(nid, "UserGridImpl", TABLE_ICON, content);	
		return tab;
	
	}

	private static Tab createUserEditDialog(String nid) {

        VLayout content = UserFactory.getInstance().createUserEditDialog();
		
		Tab tab = createTab(nid, "UserEditDialog", WIDGET_ICON, content);	
		return tab;
	
	}

	private static Tab createUserFormImpl(String nid) {

        VLayout content = UserFactory.getInstance().createUserFormImpl();
		
		Tab tab = createTab(nid, "UserFormImpl", WIDGET_ICON, content);	
		return tab;
	
	}

	private static Tab createUserGetViewer(String nid) {

        VLayout content = UserFactory.getInstance().createUserGetViewer();
		
		Tab tab = createTab(nid, "UserGetViewer", WIDGET_ICON, content);	
		return tab;
	
	}

	
	/*
	 * Basic methods
	 */
	private static Tab createTab(String id, String name, String icon, Canvas canvas) {
		
		Tab tab = new Tab();
		tab.setID(id + ":tab");
		
		tab.setCanClose(true);

        String imgHTML = Canvas.imgHTML(icon, 16, 16);
        tab.setTitle("<span>" + imgHTML + "&nbsp;" + name + "</span>");

		VLayout layout = createVLayout();
 		layout.setMembers(canvas);
		
		tab.setPane(layout);
		return tab;

	}
	
	private static VLayout createVLayout() {

		VLayout layout = new VLayout();
	
		/*
		 * Dimensions
		 */
		layout.setWidth100();
		layout.setHeight100();
		
        /*
         * Style
         */
        layout.setStyleName(GuiStyles.X_BD_STYLE_0);
		return layout;
		
	}
	
}
