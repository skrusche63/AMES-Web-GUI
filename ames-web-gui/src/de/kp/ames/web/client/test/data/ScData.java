package de.kp.ames.web.client.test.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test.data
 *  Module: ScData
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #data #sc #test #web
 * </SemanticAssist>
 *
 */


import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.data.Record;

import de.kp.ames.web.shared.constants.JaxrConstants;
import de.kp.ames.web.shared.constants.JsonConstants;

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
                new ScNode("DatabaseGridImpl",     PREFIX + "access:data:DatabaseGridImpl:leaf",       PREFIX + "access:data:folder", "silk/table.png"),
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

                new ScNode("BulletinImpl",    PREFIX + "bulletin:widget:BulletinImpl:leaf",    PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("CommentsViewer",  PREFIX + "bulletin:widget:CommentsViewer:leaf",  PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("MessageImpl",     PREFIX + "bulletin:widget:MessageImpl:leaf",     PREFIX + "bulletin:widget:folder", "silk/widget.png"),
                new ScNode("MessageFormImpl", PREFIX + "bulletin:widget:MessageFormImpl:leaf", PREFIX + "bulletin:widget:folder", "silk/widget.png"),

        		/*
        		 * Comm-Layer
        		 */
                new ScNode("<b>Comm</b>",  PREFIX + "comm:folder", "root", "silk/folder.png"),
                new ScNode("Data",         PREFIX + "comm:data:folder",              PREFIX + "comm:folder", "silk/folder.png"),
                new ScNode("CommGridImpl", PREFIX + "comm:data:CommGridImpl:leaf",   PREFIX + "comm:data:folder", "silk/table.png"),
                new ScNode("Widget",       PREFIX + "comm:widget:folder",            PREFIX + "comm:folder", "silk/folder.png"),
                new ScNode("CommFormImpl", PREFIX + "comm:widget:CommFormImpl:leaf", PREFIX + "comm:widget:folder", "silk/widget.png"),
                new ScNode("CommViewer",   PREFIX + "comm:widget:CommViewer:leaf",   PREFIX + "comm:widget:folder", "silk/widget.png"),

        		/*
        		 * Dms-Layer
        		 */
                new ScNode("<b>Dms</b>",      PREFIX + "dms:folder", "root", "silk/folder.png"),
                new ScNode("Data",            PREFIX + "dms:data:folder",                 PREFIX + "dms:folder", "silk/folder.png"),
                new ScNode("DmsGridImpl",     PREFIX + "dms:data:DmsGridImpl:leaf",       PREFIX + "dms:data:folder", "silk/table.png"),

        		/*
        		 * Group-Layer
        		 */
                new ScNode("<b>Group</b>",      PREFIX + "group:folder", "root", "silk/folder.png"),
                new ScNode("Data",              PREFIX + "group:data:folder",                   PREFIX + "group:folder", "silk/folder.png"),
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
 
                /*
                 * Rule-Layer
                 */
                new ScNode("<b>Rule</b>",                PREFIX + "rule:folder", "root", "silk/folder.png"),
                new ScNode("Data",                       PREFIX + "rule:data:folder",                            PREFIX + "rule:folder", "silk/folder.png"),
                new ScNode("RuleGridImpl",               PREFIX + "rule:data:RuleGridImpl:leaf",                 PREFIX + "rule:data:folder", "silk/table.png"),
                new ScNode("Widget",                     PREFIX + "rule:widget:folder",                          PREFIX + "rule:folder", "silk/folder.png"),

                new ScNode("EvaluationEditDialog",       PREFIX + "rule:widget:EvaluationEditDialog:leaf",       PREFIX + "rule:widget:folder", "silk/widget.png"),
                new ScNode("ReasonerApplyDialog",        PREFIX + "rule:widget:ReasonerApplyDialog:leaf",  	     PREFIX + "rule:widget:folder", "silk/widget.png"),
                new ScNode("ReasonerCreateDialog",       PREFIX + "rule:widget:ReasonerCreateDialog:leaf",       PREFIX + "rule:widget:folder", "silk/widget.png"),
                new ScNode("ReasonerEditDialog",         PREFIX + "rule:widget:ReasonerEditDialog:leaf",         PREFIX + "rule:widget:folder", "silk/widget.png"),
                new ScNode("ReasonerFormImpl",           PREFIX + "rule:widget:ReasonerFormImpl:leaf",           PREFIX + "rule:widget:folder", "silk/widget.png"),

                /*
                 * Symbol-Layer
                 */
                new ScNode("<b>Symbol</b>",  PREFIX + "symbol:folder", "root", "silk/folder.png"),
                new ScNode("Data",           PREFIX + "symbol:data:folder",              PREFIX + "symbol:folder", "silk/folder.png"),
                new ScNode("SymbolGridImpl", PREFIX + "symbol:data:SymbolGridImpl:leaf", PREFIX + "symbol:data:folder", "silk/table.png"),
                new ScNode("SymbolTreeImpl", PREFIX + "symbol:data:SymbolTreeImpl:leaf", PREFIX + "symbol:data:folder", "silk/table.png"),
                new ScNode("Widget",         PREFIX + "symbol:widget:folder",            PREFIX + "symbol:folder", "silk/folder.png"),
                new ScNode("SymbolViewer",   PREFIX + "symbol:widget:SymbolViewer:leaf", PREFIX + "symbol:widget:folder", "silk/table.png"),

                /*
                 * Transform-Layer
                 */
                new ScNode("<b>Transform</b>",      PREFIX + "transform:folder", "root", "silk/folder.png"),
                new ScNode("Data",                  PREFIX + "transform:data:folder",                       PREFIX + "transform:folder", "silk/folder.png"),
                new ScNode("TransformGridImpl",     PREFIX + "transform:data:TransformGridImpl:leaf",       PREFIX + "transform:data:folder", "silk/table.png"),
                new ScNode("Widget",                PREFIX + "transform:widget:folder",                     PREFIX + "transform:folder", "silk/folder.png"),

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
    
    /*
     * Test data used with the Show case application
     */
    
    /*
     * Access-Layer
     */
    // name:"IMAP Accessor" alias:"arwanitis@app6.org"
	public static String TEST_MAIL_ACCESSOR 	= "urn:uuid:a36418de-e197-498e-b354-d9054f3a5c70";
    // name:"Plone WebDAV" uri:"http://localhost:1980/Plone/adf-davshare/"
    public static String TEST_WEBDAV_ACCESSOR 	= "urn:uuid:d7b1b643-4b49-451b-a70b-e6586b4f02ec";
    // name:"Postgres Test" sql:"select personname_lastname from user_"
    public static String TEST_DATABASE_ACCESSOR = "urn:uuid:06e9c056-9330-425c-960a-e90cd03647fe";

    public static JSONObject getJsonAccessor() {

    	JSONObject jAccessor = new JSONObject();

    	jAccessor.put(JaxrConstants.RIM_NAME,  new JSONString("Accessor name"));
    	jAccessor.put(JaxrConstants.RIM_DESC,  new JSONString("Accessor description"));

    	return jAccessor;
    	
    }
    
    public static Record getRecordMail() {
    	
    	Record record = new Record();
    	// first mail in its folder
    	record.setAttribute(JsonConstants.J_ID, 0);
    	// this mail has no attachment
    	record.setAttribute(JsonConstants.J_ATTACHMENT, false);
    	
    	return record;
    	
    }
    
    public static JSONObject getJsonDatabase() {
    	
    	JSONObject jDatabase = new JSONObject();
    	
    	/*
    	 * Columns
    	 */
    	JSONArray jColumns = new JSONArray();
    	
    	jColumns.set(0, new JSONString("Column #1"));
    	jColumns.set(1, new JSONString("Column #2"));
    	jColumns.set(2, new JSONString("Column #3"));
    	
    	jDatabase.put("columns", jColumns);
    	
    	/*
    	 * Rows
    	 */
    	JSONArray jRows = new JSONArray();
    	JSONObject jRow = new JSONObject();
    	
    	jRow.put("Column #1", new JSONString("Data #1"));
       	jRow.put("Column #2", new JSONString("Data #2"));
       	jRow.put("Column #3", new JSONString("Data #3"));
           	
    	jRows.set(0, jRow);
    	jDatabase.put("records", jRows);
    	
    	return jDatabase;
    	
    }
    
    /*
     * Bulletin-Layer
     */
    public static String TEST_CONTACT = "urn:uid:de:kp:samltest";
    public static String TEST_NAME    = "Test User";
    public static String TEST_POSTING = "urn:de:kp:ames:posting:84f7212b-933e-4f5a-b74f-e5417de30533";
    
    /*
     * Group-Layer
     */
    public static String TEST_USER = "urn:uid:de:kp:samltest";
    public static String TEST_GROUP = "urn:freebxml:registry:Organization:freebXMLRegistry";
    
    public static JSONObject getJsonTestGroup() {

    	JSONObject jGroup = new JSONObject();
    	
    	/*
    	 * Id
    	 */
    	jGroup.put(JaxrConstants.RIM_ID,  new JSONString("urn:de:kp:ames:community:test1"));
    	/*
    	 * Group Name
    	 */
    	jGroup.put(JaxrConstants.RIM_NAME,  new JSONString("Group name"));
    	jGroup.put(JaxrConstants.RIM_EMAIL, new JSONString("email@address"));

    	jGroup.put(JaxrConstants.RIM_DESC,  new JSONString("Group description"));

    	/*
    	 * Postal Address
    	 */
    	jGroup.put(JaxrConstants.RIM_COUNTRY,           new JSONString("Country"));
    	jGroup.put(JaxrConstants.RIM_STATE_OR_PROVINCE, new JSONString("State or Province"));
    	jGroup.put(JaxrConstants.RIM_POSTAL_CODE,       new JSONString("Postal code"));
    	jGroup.put(JaxrConstants.RIM_CITY, 		       new JSONString("City"));
    	jGroup.put(JaxrConstants.RIM_STREET,            new JSONString("Street"));
    	jGroup.put(JaxrConstants.RIM_STREET_NUMBER,     new JSONString("Street Number"));

    	/*
    	 * Telephone Number
    	 */
    	jGroup.put(JaxrConstants.RIM_COUNTRY_CODE, 	 new JSONString("Country code"));
    	jGroup.put(JaxrConstants.RIM_AREA_CODE, 	  	 new JSONString("Area code"));
    	jGroup.put(JaxrConstants.RIM_PHONE_NUMBER, 	 new JSONString("Number"));
		jGroup.put(JaxrConstants.RIM_PHONE_EXTENSION, new JSONString("Extension"));

		return jGroup;
    
    }
    
    /*
     * Ns-Layer
     */
     
    public static JSONObject getJsonNamespace() {

    	JSONObject jNamespace = new JSONObject();

    	jNamespace.put(JaxrConstants.RIM_NAME,  new JSONString("Namespace name"));
    	jNamespace.put(JaxrConstants.RIM_DESC,  new JSONString("Namespace description"));

    	return jNamespace;
    	
    }

    /*
     * Product-Layer
     */
    public static String TEST_PRODUCTOR = "";
    
    public static String TEST_PRODUCTOR_NAME = "Productor name";
    public static String TEST_PRODUCTOR_DESC = "Productor description";

    public static JSONObject getJsonProduct() {

    	JSONObject jProduct = new JSONObject();

    	jProduct.put(JaxrConstants.RIM_NAME,  new JSONString("Product name"));
    	jProduct.put(JaxrConstants.RIM_DESC,  new JSONString("Product description"));

    	return jProduct;
    	
    }

    public static JSONObject getJsonProductor() {

    	JSONObject jProductor = new JSONObject();

    	jProductor.put(JaxrConstants.RIM_NAME,  new JSONString("Productor name"));
    	jProductor.put(JaxrConstants.RIM_DESC,  new JSONString("Productor description"));

    	return jProductor;
    	
    }

    /*
     * Role-Layer
     */
    // Arwanitis (PKCS#12)
	public static final String TEST_ROLE_SOURCE = "urn:uid:de:kp:samltest";
	// Disaster Management
	public static final String TEST_ROLE_TARGET = "urn:de:kp:ames:community:7df3f455-0ca7-4bc5-b458-8b13bfe60b4f"; 

    
    /*
     * Rule-Layer
     */
    public static String TEST_REASONER = "";
    
    public static String TEST_REASONER_NAME = "Reasoner name";
    public static String TEST_REASONER_DESC = "Reasoner description";


    public static JSONObject getJsonEvaluation() {

    	JSONObject jEvaluation = new JSONObject();

    	jEvaluation.put(JaxrConstants.RIM_NAME,  new JSONString("Evaluation name"));
    	jEvaluation.put(JaxrConstants.RIM_DESC,  new JSONString("Evaluation description"));

    	return jEvaluation;
    	
    }

    public static JSONObject getJsonReasoner() {

    	JSONObject jReasoner = new JSONObject();

    	jReasoner.put(JaxrConstants.RIM_NAME,  new JSONString("Reasoner name"));
    	jReasoner.put(JaxrConstants.RIM_DESC,  new JSONString("Reasoner description"));

    	return jReasoner;
    	
    }
    
    /*
     * User-Layer
     */
    
    public static JSONObject getJsonTestUser() {
 
    	JSONObject jUser = new JSONObject();
    	
    	/*
    	 * Person Name
    	 */
    	jUser.put(JaxrConstants.RIM_FIRST_NAME,  new JSONString("First name"));
    	jUser.put(JaxrConstants.RIM_MIDDLE_NAME, new JSONString("Middle name"));

    	jUser.put(JaxrConstants.RIM_LAST_NAME, new JSONString("Last name"));
    	jUser.put(JaxrConstants.RIM_EMAIL,    new JSONString("email@address"));

    	/*
    	 * Postal Address
    	 */
    	jUser.put(JaxrConstants.RIM_COUNTRY,           new JSONString("Country"));
    	jUser.put(JaxrConstants.RIM_STATE_OR_PROVINCE, new JSONString("State or Province"));
    	jUser.put(JaxrConstants.RIM_POSTAL_CODE,       new JSONString("Postal code"));
    	jUser.put(JaxrConstants.RIM_CITY, 		       new JSONString("City"));
    	jUser.put(JaxrConstants.RIM_STREET,            new JSONString("Street"));
    	jUser.put(JaxrConstants.RIM_STREET_NUMBER,     new JSONString("Stree Number"));

    	/*
    	 * Telephone Number
    	 */
    	jUser.put(JaxrConstants.RIM_COUNTRY_CODE, 	 new JSONString("Country code"));
    	jUser.put(JaxrConstants.RIM_AREA_CODE, 	  	 new JSONString("Area code"));
    	jUser.put(JaxrConstants.RIM_PHONE_NUMBER, 	 new JSONString("Number"));
		jUser.put(JaxrConstants.RIM_PHONE_EXTENSION, new JSONString("Extension"));
    	
    	return jUser;
    
    }
    
    
}
