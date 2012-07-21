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
                 * Upload-Layer
                 */
                new ScNode("<b>Upload</b>",  PREFIX + "upload:folder", "root", "silk/folder.png"),
                new ScNode("Data",           PREFIX + "upload:data:folder",              PREFIX + "upload:folder", "silk/folder.png"),
                new ScNode("UploadGridImpl", PREFIX + "upload:data:UploadGridImpl:leaf", PREFIX + "upload:data:folder", "silk/table.png"),
                new ScNode("Widget",         PREFIX + "upload:widget:folder",            PREFIX + "upload:folder", "silk/folder.png"),

                new ScNode("UploadCreateDialog", PREFIX + "upload:widget:UploadCreateDialog:leaf", PREFIX + "upload:widget:folder", "silk/widget.png"),
                new ScNode("UploadFormImpl",     PREFIX + "upload:widget:UploadFormImpl:leaf",     PREFIX + "upload:widget:folder", "silk/widget.png"),

                
            };
        }
        return data;

    }

    public static ScNode[] getScData() {
        return new ScData().getData();
    }
    
}
