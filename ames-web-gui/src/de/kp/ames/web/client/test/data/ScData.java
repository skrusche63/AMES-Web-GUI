package de.kp.ames.web.client.test.data;

public class ScData {

	private static String PREFIX = "function:";
	
    private ScNode[] data;

    public ScData() {
    }

    private ScNode[] getData() {
        
    	if (data == null) {
            data = new ScNode[] {
            		
        		/*
        		 * Access-Layer
        		 */
                new ScNode("<b>Access</b>",        PREFIX + "access:folder", "root", "silk/folder.png"),
                new ScNode("Data",                 PREFIX + "access:data:folder",                      PREFIX + "access:folder", "silk/folder.png"),
                new ScNode("AccessGridImpl",       PREFIX + "access:data:AccessGridImpl:leaf",         PREFIX + "access:data:folder", "silk/table.png"),
                new ScNode("Widget",               PREFIX + "access:widget:folder",                    PREFIX + "access:folder", "silk/folder.png"),
                new ScNode("AccessorCreateDialog", PREFIX + "access:widget:AccessorCreateDialog:leaf", PREFIX + "access:widget:folder", "silk/widget.png"),
                new ScNode("AccessorEditDialog",   PREFIX + "access:widget:AccessorEditDialog:leaf",   PREFIX + "access:widget:folder", "silk/widget.png"),
                new ScNode("AccessorFormImpl",     PREFIX + "access:widget:AccessorFormImpl:leaf",     PREFIX + "access:widget:folder", "silk/widget.png"),
                new ScNode("AccessorGetViewer",    PREFIX + "access:widget:AccessorGetViewer:leaf",    PREFIX + "access:widget:folder", "silk/widget.png"),
                new ScNode("RemoteGetViewer",      PREFIX + "access:widget:RemoteGetViewer:leaf",      PREFIX + "access:widget:folder", "silk/widget.png"),
               
                /*
                 * Bulletin-Layer
                 */
                new ScNode("<b>Bulletin</b>", PREFIX + "bulletin:folder", "root", "silk/folder.png"),
                new ScNode("Data",            PREFIX + "bulletin:data:folder",               PREFIX + "bulletin:folder", "silk/folder.png"),
                new ScNode("CommentGridImpl", PREFIX + "bulletin:data:CommentGridImpl:leaf", PREFIX + "bulletin:data:folder", "silk/table.png"),
                new ScNode("PostGridImpl",    PREFIX + "bulletin:data:PostGridImpl:leaf",    PREFIX + "bulletin:data:folder", "silk/table.png"),
                new ScNode("Widget",          PREFIX + "bulletin:widget:folder",             PREFIX + "bulletin:folder", "silk/folder.png"),

                new ScNode("BoardImpl",       PREFIX + "bulletin:widget:BoardImpl:leaf",       PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("BulletinImpl",    PREFIX + "bulletin:widget:BulletinImpl:leaf",    PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("CommentsViewer",  PREFIX + "bulletin:widget:CommentsViewer:leaf",  PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("ContactsImpl",    PREFIX + "bulletin:widget:ContactsImpl:leaf",    PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("DetailImpl",      PREFIX + "bulletin:widget:DetailImpl:leaf",      PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("GroupsImpl",      PREFIX + "bulletin:widget:GroupsImpl:leaf",      PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("MessageFormImpl", PREFIX + "bulletin:widget:MessageFormImpl:leaf", PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("OverviewImpl",    PREFIX + "bulletin:widget:OverviewImpl:leaf",    PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("UsersImpl",       PREFIX + "bulletin:widget:UsersImpl:leaf",       PREFIX + "bulletin:widget:folder", "silk/widget.png"),

        		/*
        		 * Comm-Layer
        		 */
                new ScNode("<b>Comm</b>",  PREFIX + "comm:folder", "root", "silk/folder.png"),
                new ScNode("Data",         PREFIX + "comm:data:folder",            PREFIX + "comm:folder", "silk/folder.png"),
                new ScNode("CommGridImpl", PREFIX + "comm:data:CommGridImpl:leaf", PREFIX + "comm:data:folder", "silk/table.png"),
                new ScNode("Widget",       PREFIX + "comm:widget:folder",          PREFIX + "comm:folder", "silk/folder.png"),
                new ScNode("CommViewer",   PREFIX + "comm:widget:CommViewer:leaf", PREFIX + "comm:widget:folder", "silk/widget.png"),

        		/*
        		 * Dms-Layer
        		 */
                new ScNode("<b>Dms</b>",      PREFIX + "dms:folder", "root", "silk/folder.png"),
                new ScNode("Data",            PREFIX + "dms:data:folder",                 PREFIX + "dms:folder", "silk/folder.png"),
                new ScNode("DmsGridImpl",     PREFIX + "dms:data:DmsGridImpl:leaf",       PREFIX + "dms:data:folder", "silk/table.png"),
                new ScNode("Widget",          PREFIX + "dms:widget:folder",               PREFIX + "dms:folder", "silk/folder.png"),
                new ScNode("DmsCreateDialog", PREFIX + "dms:widget:DmsCreateDialog:leaf", PREFIX + "dms:widget:folder", "silk/widget.png"),
                new ScNode("DmsEditDialog",   PREFIX + "dms:widget:DmsEditDialog:leaf",   PREFIX + "dms:widget:folder", "silk/widget.png"),
                new ScNode("DmsFormImpl",     PREFIX + "dms:widget:DmsFormImpl:leaf",     PREFIX + "dms:widget:folder", "silk/widget.png"),
                new ScNode("DmsGetViewer",    PREFIX + "dms:widget:DmsGetViewer:leaf",    PREFIX + "dms:widget:folder", "silk/widget.png"),
                new ScNode("DmsViewer",       PREFIX + "dms:widget:DmsViewer:leaf",       PREFIX + "dms:widget:folder", "silk/widget.png"),

        		/*
        		 * Group-Layer
        		 */
                new ScNode("<b>Group</b>",      PREFIX + "group:folder", "root", "silk/folder.png"),
                new ScNode("Data",              PREFIX + "group:data:folder",                   PREFIX + "group:folder", "silk/folder.png"),
                new ScNode("CategoryGridImpl",  PREFIX + "group:data:CategoryGridImpl:leaf",    PREFIX + "group:data:folder", "silk/table.png"),
                new ScNode("GroupGridImpl",     PREFIX + "group:data:GroupGridImpl:leaf",       PREFIX + "group:data:folder", "silk/table.png"),
                new ScNode("Widget",            PREFIX + "group:widget:folder",                 PREFIX + "group:folder", "silk/folder.png"),
                new ScNode("GroupCreateDialog", PREFIX + "group:widget:GroupCreateDialog:leaf", PREFIX + "group:widget:folder", "silk/widget.png"),
                new ScNode("GroupEditDialog",   PREFIX + "group:widget:GroupEditDialog:leaf",   PREFIX + "group:widget:folder", "silk/widget.png"),
                new ScNode("GroupFormImpl",     PREFIX + "group:widget:GroupFormImpl:leaf",     PREFIX + "group:widget:folder", "silk/widget.png"),
                new ScNode("GroupGetViewer",    PREFIX + "group:widget:GroupGetViewer:leaf",    PREFIX + "group:widget:folder", "silk/widget.png"),

        		/*
        		 * Map-Layer
        		 */
                new ScNode("<b>Map</b>",      PREFIX + "map:folder", "root", "silk/folder.png"),
                new ScNode("Data",            PREFIX + "map:data:folder",                 PREFIX + "map:folder", "silk/folder.png"),
                new ScNode("LayerGridImpl",   PREFIX + "map:data:LayerGridImpl:leaf",     PREFIX + "map:data:folder", "silk/table.png"),
                new ScNode("Widget",          PREFIX + "map:widget:folder",               PREFIX + "map:folder", "silk/folder.png"),
                new ScNode("BusinessMapImpl", PREFIX + "map:widget:BusinessMapImpl:leaf", PREFIX + "map:widget:folder", "silk/widget.png"),

        		/*
        		 * Ns-Layer
        		 */
                new ScNode("<b>Ns</b>",      PREFIX + "ns:folder", "root", "silk/folder.png"),
                new ScNode("Data",           PREFIX + "ns:data:folder",                PREFIX + "ns:folder", "silk/folder.png"),
                new ScNode("NsGridImpl",     PREFIX + "ns:data:NsGridImpl:leaf",       PREFIX + "ns:data:folder", "silk/table.png"),
                new ScNode("NsTreeImpl",     PREFIX + "ns:data:NsTreeImpl:leaf",       PREFIX + "ns:data:folder", "silk/table.png"),
                new ScNode("Widget",         PREFIX + "ns:widget:folder",              PREFIX + "ns:folder", "silk/folder.png"),
                new ScNode("NsCreateDialog", PREFIX + "ns:widget:NsCreateDialog:leaf", PREFIX + "ns:widget:folder", "silk/widget.png"),
                new ScNode("NsEditDialog", 	 PREFIX + "ns:widget:NsEditDialog:leaf",   PREFIX + "ns:widget:folder", "silk/widget.png"),
                new ScNode("NsFormImpl",     PREFIX + "ns:widget:NsFormImpl:leaf",     PREFIX + "ns:widget:folder", "silk/widget.png"),
                new ScNode("NsViewer",       PREFIX + "ns:widget:NsViewer:leaf",       PREFIX + "ns:widget:folder", "silk/widget.png"),
                
        		/*
        		 * Product-Layer
        		 */
                new ScNode("<b>Product</b>",        PREFIX + "product:folder", "root", "silk/folder.png"),
                new ScNode("Data",                  PREFIX + "product:data:folder",                       PREFIX + "product:folder", "silk/folder.png"),
                new ScNode("ProductGridImpl",       PREFIX + "product:data:ProductGridImpl:leaf",         PREFIX + "product:data:folder", "silk/table.png"),
                new ScNode("Widget",                PREFIX + "product:widget:folder",                     PREFIX + "product:folder", "silk/folder.png"),
                new ScNode("ProductEditDialog",     PREFIX + "product:widget:ProductEditDialog:leaf",     PREFIX + "product:widget:folder", "silk/widget.png"),
                new ScNode("ProductFormImpl",       PREFIX + "product:widget:ProductFormImpl:leaf",       PREFIX + "product:widget:folder", "silk/widget.png"),
                new ScNode("ProductorApplyDialog",  PREFIX + "product:widget:ProductorApplyDialog:leaf",  PREFIX + "product:widget:folder", "silk/widget.png"),
                new ScNode("ProductorCreateDialog", PREFIX + "product:widget:ProductorCreateDialog:leaf", PREFIX + "product:widget:folder", "silk/widget.png"),
                new ScNode("ProductorEditDialog",   PREFIX + "product:widget:ProductorEditDialog:leaf",   PREFIX + "product:widget:folder", "silk/widget.png"),
                new ScNode("ProductorFormImpl",     PREFIX + "product:widget:ProductorFormImpl:leaf",     PREFIX + "product:widget:folder", "silk/widget.png"),

                /*
                 * Role-Layer
                 */
                new ScNode("<b>Role</b>",                PREFIX + "role:folder", "root", "silk/folder.png"),
                new ScNode("Data",                       PREFIX + "role:data:folder",                            PREFIX + "role:folder", "silk/folder.png"),
                new ScNode("RoleGridImpl",               PREFIX + "role:data:RoleGridImpl:leaf",                 PREFIX + "role:data:folder", "silk/table.png"),
                new ScNode("Widget",                     PREFIX + "role:widget:folder",                          PREFIX + "role:folder", "silk/folder.png"),

                new ScNode("ResponsibilityCreateDialog", PREFIX + "role:widget:ResponsibilityCreateDialog:leaf", PREFIX + "role:widget:folder", "silk/widget.png"),
                new ScNode("ResponsibilityFormImpl",     PREFIX + "role:widget:ResponsibilityFormImpl:leaf",     PREFIX + "role:widget:folder", "silk/widget.png"),
                new ScNode("RoleCreateDialog",           PREFIX + "role:widget:RoleCreateDialog:leaf",           PREFIX + "role:widget:folder", "silk/widget.png"),
                new ScNode("RoleFormImpl",               PREFIX + "role:widget:RoleFormImpl:leaf",               PREFIX + "role:widget:folder", "silk/widget.png"),

                /*
                 * Rule-Layer
                 */
                new ScNode("<b>Rule</b>",                PREFIX + "rule:folder", "root", "silk/folder.png"),
                new ScNode("Data",                       PREFIX + "rule:data:folder",                            PREFIX + "rule:folder", "silk/folder.png"),
                new ScNode("RuleGridImpl",               PREFIX + "rule:data:RuleGridImpl:leaf",                 PREFIX + "rule:data:folder", "silk/table.png"),
                new ScNode("Widget",                     PREFIX + "rule:widget:folder",                          PREFIX + "rule:folder", "silk/folder.png"),

                // TODO

                /*
                 * Symbol-Layer
                 */
                new ScNode("<b>Smbol</b>",   PREFIX + "symbol:folder", "root", "silk/folder.png"),
                new ScNode("Data",           PREFIX + "symbol:data:folder",              PREFIX + "symbol:folder", "silk/folder.png"),
                new ScNode("SymbolGridImpl", PREFIX + "symbol:data:SymbolGridImpl:leaf", PREFIX + "symbol:data:folder", "silk/table.png"),
                new ScNode("SymbolTreeImpl", PREFIX + "symbol:data:SymbolTreeImpl:leaf", PREFIX + "symbol:data:folder", "silk/table.png"),
                new ScNode("Widget",         PREFIX + "symbol:widget:folder",            PREFIX + "symbol:folder", "silk/folder.png"),
                new ScNode("SymbolViewer",   PREFIX + "symbol:widget:SymbolViewer:leaf", PREFIX + "symbol:data:folder", "silk/table.png"),

                /*
                 * Transform-Layer
                 */
                new ScNode("<b>Transform</b>",      PREFIX + "transform:folder", "root", "silk/folder.png"),
                new ScNode("Data",                  PREFIX + "transform:data:folder",                       PREFIX + "transform:folder", "silk/folder.png"),
                new ScNode("SpecGridImpl",          PREFIX + "transform:data:SpecGridImpl:leaf",            PREFIX + "transform:data:folder", "silk/table.png"),
                new ScNode("TransformGridImpl",     PREFIX + "transform:data:TransformGridImpl:leaf",       PREFIX + "transform:data:folder", "silk/table.png"),
                new ScNode("Widget",                PREFIX + "transform:widget:folder",                     PREFIX + "transform:folder", "silk/folder.png"),

                new ScNode("SpecCreateDialog",      PREFIX + "transform:widget:SpecCreateDialog:leaf",      PREFIX + "transform:widget:folder", "silk/widget.png"),
                new ScNode("TransformCreateDialog", PREFIX + "transform:widget:TransformCreateDialog:leaf", PREFIX + "transform:widget:folder", "silk/widget.png"),
                new ScNode("TransformFormImpl",     PREFIX + "transform:widget:TransformFormImpl:leaf",     PREFIX + "transform:widget:folder", "silk/widget.png"),
                
                /*
                 * Upload-Layer
                 */
                new ScNode("<b>Upload</b>",  PREFIX + "upload:folder", "root", "silk/folder.png"),
                new ScNode("Data",           PREFIX + "upload:data:folder",              PREFIX + "upload:folder", "silk/folder.png"),
                new ScNode("UploadGridImpl", PREFIX + "upload:data:UploadGridImpl:leaf", PREFIX + "upload:data:folder", "silk/table.png"),
                new ScNode("Widget",         PREFIX + "upload:widget:folder",            PREFIX + "upload:folder", "silk/folder.png"),

                new ScNode("UploadCreateDialog", PREFIX + "upload:widget:UploadCreateDialog:leaf", PREFIX + "upload:widget:folder", "silk/widget.png"),
                new ScNode("UploadFormImpl",     PREFIX + "upload:widget:UploadFormImpl:leaf",     PREFIX + "upload:widget:folder", "silk/widget.png"),

                /*
                 * User-Layer
                 */
                new ScNode("<b>User</b>",    PREFIX + "user:folder", "root", "silk/folder.png"),
                new ScNode("Data",           PREFIX + "user:data:folder",            PREFIX + "user:folder", "silk/folder.png"),
                new ScNode("UserGridImpl",   PREFIX + "user:data:UserGridImpl:leaf", PREFIX + "user:data:folder", "silk/table.png"),
                new ScNode("Widget",         PREFIX + "user:widget:folder",          PREFIX + "user:folder", "silk/folder.png"),

                new ScNode("UserEditDialog", PREFIX + "user:widget:UserEditDialog:leaf", PREFIX + "user:widget:folder", "silk/widget.png"),
                new ScNode("UserFormImpl",   PREFIX + "user:widget:UserFormImpl:leaf",   PREFIX + "user:widget:folder", "silk/widget.png"),
                new ScNode("UserGetViewer",  PREFIX + "user:widget:UserGetViewer:leaf",  PREFIX + "user:widget:folder", "silk/widget.png"),

                
            };
        }
        return data;

    }

    public static ScNode[] getScData() {
        return new ScData().getData();
    }
    
}