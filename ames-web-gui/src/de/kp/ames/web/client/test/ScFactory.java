package de.kp.ames.web.client.test;

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

	private static String PREFIX = "function:";
	
	private static String TABLE_ICON  = "silk/table.png";
	private static String WIDGET_ICON = "silk/widget.png";

	public static Tab getTab(String nid) {

		/*
		 * Access-Layer
		 */
		if (nid.equals(PREFIX + "access:data:AccessGridImpl:leaf")) {
			return createAccessGridImpl(nid);
			
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

		} else if (nid.equals(PREFIX + "bulletin:widget:BoardImpl:leaf")) {
			return createBoardImpl(nid);
			
		} else if (nid.equals(PREFIX + "bulletin:widget:BulletinImpl:leaf")) {
			return createBulletinImpl(nid);

		} else if (nid.equals(PREFIX + "bulletin:widget:CommentsViewer:leaf")) {
			return createCommentsViewer(nid);
		
		} else if (nid.equals(PREFIX + "bulletin:widget:ContactsImpl:leaf")) {
			return createContactsImpl(nid);
		
		} else if (nid.equals(PREFIX + "bulletin:widget:DetailImpl:leaf")) {
			return createDetailImpl(nid);
		
		} else if (nid.equals(PREFIX + "bulletin:widget:GroupsImpl:leaf")) {
			return createGroupsImpl(nid);

		} else if (nid.equals(PREFIX + "bulletin:widget:MessageFormImpl:leaf")) {
			return createMessageFormImpl(nid);
		
		} else if (nid.equals(PREFIX + "bulletin:widget:OverviewImpl:leaf")) {
			return createOverviewImpl(nid);
		
		} else if (nid.equals(PREFIX + "bulletin:widget:UsersImpl:leaf")) {
			return createUsersImpl(nid);

		}

		/*
		 * Comm-Layer
		 */
		else if (nid.equals(PREFIX + "comm:data:CommGridImpl:leaf")) {
			return createCommGridImpl(nid);

		} else if (nid.equals(PREFIX + "comm:widget:CommViewer:leaf")) {
			return createCommViewer(nid);

		}

		/*
		 * Dms-Layer
		 */
		else if (nid.equals(PREFIX + "dms:data:DmsGridImpl:leaf")) {
			return createDmsGridImpl(nid);

		} else if (nid.equals(PREFIX + "dms:widget:DmsCreateDialog:leaf")) {
			return createDmsCreateDialog(nid);

		} else if (nid.equals(PREFIX + "dms:widget:DmsEditDialog:leaf")) {
			return createDmsEditDialog(nid);

		} else if (nid.equals(PREFIX + "dms:widget:DmsFormImpl:leaf")) {
			return createDmsFormImpl(nid);
		
		} else if (nid.equals(PREFIX + "dms:widget:DmsGetViewer:leaf")) {
			return createDmsGetViewer(nid);
		
		} else if (nid.equals(PREFIX + "dms:widget:DmsViewer:leaf")) {
			return createDmsViewer(nid);

		}

		/*
		 * Group-Layer
		 */
		else if (nid.equals(PREFIX + "group:data:CategoryGridImpl:leaf")) {
			return createCategoryGridImpl(nid);

		} else if (nid.equals(PREFIX + "group:data:GroupGridImpl:leaf")) {
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
			return createProductorFormImpl(nid);

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

		} else if (nid.equals(PREFIX + "role:widget:ResponsibilityFormImpl:leaf")) {
			return createResponsibilityFormImpl(nid);
		
		} else if (nid.equals(PREFIX + "role:widget:RoleCreateDialog:leaf")) {
			return createRoleCreateDialog(nid);
		
		} else if (nid.equals(PREFIX + "role:widget:RoleFormImpl:leaf")) {
			return createRoleFormImpl(nid);

		}

        /*
         * Rule-Layer
         */
		else if (nid.equals(PREFIX + "rule:data:RuleGridImpl:leaf")) {
			return createRuleGridImpl(nid);
			
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
		else if (nid.equals(PREFIX + "transform:data:SpecGridImpl:leaf")) {
			return createSpecGridImpl(nid);

		} else if (nid.equals(PREFIX + "transform:data:TransformGridImpl:leaf")) {
			return createTransformGridImpl(nid);

		} else if (nid.equals(PREFIX + "transform:widget:SpecCreateDialog:leaf")) {
			return createSpecCreateDialog(nid);

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

		VLayout content = AccessFactory.createAccessGridImpl();
		
		Tab tab = createTab(nid, "AccessGridImpl", TABLE_ICON, content);	
		return tab;
	
	}

	private static Tab createAccessorCreateDialog(String nid) {

		VLayout content = AccessFactory.createAccessorCreateDialog();
		
		Tab tab = createTab(nid, "AccessorCreateDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createAccessorEditDialog(String nid) {

		VLayout content = AccessFactory.createAccessorEditDialog();
		
		Tab tab = createTab(nid, "AccessorEditDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createAccessorFormImpl(String nid) {

		VLayout content = AccessFactory.createAccessorFormImpl();
		
		Tab tab = createTab(nid, "AccessorFormImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createAccessorGetViewer(String nid) {

		VLayout content = AccessFactory.createAccessorGetViewer();
		
		Tab tab = createTab(nid, "AccessorGetViewer", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createRemoteViewer(String nid) {

		VLayout content = AccessFactory.createRemoteViewer();
		
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
		
		Canvas content = new Canvas();
		
		Tab tab = createTab(nid, "BulletinImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createBoardImpl(String nid) {
		
		VLayout content = BulletinFactory.createBoardImpl();
		
		Tab tab = createTab(nid, "BoardImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createContactsImpl(String nid) {
		
		VLayout content = BulletinFactory.createContactsImpl();
		
		Tab tab = createTab(nid, "ContactsImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createCommentsViewer(String nid) {
		
		VLayout content = BulletinFactory.createCommentsViewer();
		
		Tab tab = createTab(nid, "CommentsViewer", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createDetailImpl(String nid) {
		
		VLayout content = BulletinFactory.createDetailImpl();
		
		Tab tab = createTab(nid, "DetailImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createGroupsImpl(String nid) {
		
		VLayout content = BulletinFactory.createGroupsImpl();
		
		Tab tab = createTab(nid, "GroupsImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createMessageFormImpl(String nid) {
		
		VLayout content = BulletinFactory.createMessageFormImpl();
		
		Tab tab = createTab(nid, "MessageFormImpl", WIDGET_ICON, content);	
		return tab;

	}
	
	private static Tab createOverviewImpl(String nid) {
		
		VLayout content = BulletinFactory.createOverviewImpl();
		
		Tab tab = createTab(nid, "OverviewImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createUsersImpl(String nid) {
		
		VLayout content = BulletinFactory.createUsersImpl();
		
		Tab tab = createTab(nid, "UsersImpl", WIDGET_ICON, content);	
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

	private static Tab createCommViewer(String nid) {
		
		VLayout content = CommFactory.getInstance().createCommViewer();
		
		Tab tab = createTab(nid, "CommViewer", WIDGET_ICON, content);	
		return tab;

	}

	/*
	 * Dms-Layer methods
	 */
	private static Tab createDmsGridImpl(String nid) {
		
		VLayout content = DmsFactory.createDmsGridImpl();
		
		Tab tab = createTab(nid, "DmsGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createDmsCreateDialog(String nid) {
		
		VLayout content = DmsFactory.createDmsCreateDialog();
		
		Tab tab = createTab(nid, "DmsCreateDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createDmsEditDialog(String nid) {
		
		VLayout content = DmsFactory.createDmsEditDialog();
		
		Tab tab = createTab(nid, "DmsEditDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createDmsFormImpl(String nid) {
		
		VLayout content = DmsFactory.createDmsFormImpl();
		
		Tab tab = createTab(nid, "DmsFormImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createDmsGetViewer(String nid) {
		
		VLayout content = DmsFactory.createDmsGetViewer();
		
		Tab tab = createTab(nid, "DmsGetViewer", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createDmsViewer(String nid) {
		
		VLayout content = DmsFactory.createDmsViewer();
		
		Tab tab = createTab(nid, "DmsViewer", WIDGET_ICON, content);	
		return tab;

	}
	
	/*
	 * Group-Layer methods
	 */
	private static Tab createCategoryGridImpl(String nid) {
		
		VLayout content = GroupFactory.createCategoryGridImpl();
		
		Tab tab = createTab(nid, "CategoryGridImpl", TABLE_ICON, content);	
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
		
		VLayout content = MapFactory.createLayerGridImpl();
		
		Tab tab = createTab(nid, "LayerGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createBusinessMapImpl(String nid) {
		
		VLayout content = MapFactory.createBusinessMapImpl();
		
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
		
		VLayout content = ProductFactory.createProductGridImpl();
		
		Tab tab = createTab(nid, "ProductGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createProductEditDialog(String nid) {
		
		VLayout content = ProductFactory.createProductEditDialog();
		
		Tab tab = createTab(nid, "ProductEditDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createProductorApplyDialog(String nid) {
		
		VLayout content = ProductFactory.createProductorApplyDialog();
		
		Tab tab = createTab(nid, "ProductorApplyDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createProductorCreateDialog(String nid) {
		
		VLayout content = ProductFactory.createProductorCreateDialog();
		
		Tab tab = createTab(nid, "ProductorCreateDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createProductorEditDialog(String nid) {
		
		VLayout content = ProductFactory.createProductorEditDialog();
		
		Tab tab = createTab(nid, "ProductorEditDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createProductorFormImpl(String nid) {
		
		VLayout content = ProductFactory.createProductorFormImpl();
		
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

	private static Tab createResponsibilityFormImpl(String nid) {
		
		VLayout content = RoleFactory.createResponsibilityFormImpl();
		
		Tab tab = createTab(nid, "ResponsibilityFormImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createRoleCreateDialog(String nid) {
		
		VLayout content = RoleFactory.createRoleCreateDialog();
		
		Tab tab = createTab(nid, "RoleCreateDialog", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createRoleFormImpl(String nid) {
		
		VLayout content = RoleFactory.createRoleFormImpl();
		
		Tab tab = createTab(nid, "RoleFormImpl", WIDGET_ICON, content);	
		return tab;

	}
	
	/*
	 * Rule-Layer methods
	 */
	private static Tab createRuleGridImpl(String nid) {
		
		VLayout content = RuleFactory.createRuleGridImpl();
		
		Tab tab = createTab(nid, "RuleGridImpl", TABLE_ICON, content);	
		return tab;

	}
	
	/*
	 * Symbol-Layer methods
	 */
	private static Tab createSymbolGridImpl(String nid) {
		
		VLayout content = SymbolFactory.createSymbolGridImpl();
		
		Tab tab = createTab(nid, "SymbolGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createSymbolTreeImpl(String nid) {
		
		VLayout content = SymbolFactory.createSymbolTreeImpl();
		
		Tab tab = createTab(nid, "SymbolTreeImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createSymbolViewer(String nid) {
		
		VLayout content = SymbolFactory.createSymbolViewer();
		
		Tab tab = createTab(nid, "SymbolViewer", WIDGET_ICON, content);	
		return tab;

	}
	
	/*
	 * Transform-Layer methods
	 */
	private static Tab createSpecGridImpl(String nid) {
		
		VLayout content = TransformFactory.createSpecGridImpl();
		
		Tab tab = createTab(nid, "SpecGridImpl", TABLE_ICON, content);	
		return tab;

	}

	private static Tab createTransformGridImpl(String nid) {
		
		VLayout content = TransformFactory.createTransformGridImpl();
		
		Tab tab = createTab(nid, "TransformGridImpl", WIDGET_ICON, content);	
		return tab;

	}

	private static Tab createSpecCreateDialog(String nid) {
		
		VLayout content = TransformFactory.createSpecCreateDialog();
		
		Tab tab = createTab(nid, "SpecCreateDialog", WIDGET_ICON, content);	
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

        VLayout content = UserFactory.createUserGridImpl();
		
		Tab tab = createTab(nid, "UserGridImpl", TABLE_ICON, content);	
		return tab;
	
	}

	private static Tab createUserEditDialog(String nid) {

        VLayout content = UserFactory.createUserEditDialog();
		
		Tab tab = createTab(nid, "UserEditDialog", WIDGET_ICON, content);	
		return tab;
	
	}

	private static Tab createUserFormImpl(String nid) {

        VLayout content = UserFactory.createUserFormImpl();
		
		Tab tab = createTab(nid, "UserFormImpl", WIDGET_ICON, content);	
		return tab;
	
	}

	private static Tab createUserGetViewer(String nid) {

        VLayout content = UserFactory.createUserGetViewer();
		
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
         * Style
         */
        layout.setStyleName(GuiStyles.X_BD_STYLE_0);
		return layout;
		
	}
	
}