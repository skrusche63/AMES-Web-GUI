package de.kp.ames.web.client.fnc.globals;

import de.kp.ames.web.client.core.globals.GUIGlobals;

public class FncGlobals {
	
	public static String ADF_EDITOR = "ADF - Editor";
	public static String ADF_VIEWER = "ADF - Viewer";
	
	/*
	 * Classification Nodes
	 */
	public static String FNC_ID = "urn:oasis:names:tc:ebxml-regrep:FNC";
	
	public static String FNC_ID_App = FNC_ID   + ":App";	
	public static String FNC_ID_Field = FNC_ID + ":Field";
	
	/*
	 * Classification of bulletin board
	 */
	public static String FNC_APP_ID_Bulletin = FNC_ID_App + ":Bulletin";	
	/*
	 * Classification of desktop
	 */
	public static String FNC_APP_ID_Desktop = FNC_ID_App + ":Desktop";	
	/*
	 * Classification of online help
	 */
	public static String FNC_APP_ID_Help = FNC_ID_App + ":Help";
	/*
	 * Classification of portal
	 */
	public static String FNC_APP_ID_Portal = FNC_ID_App + ":Portal";
	/*
	 * Classification of Source Code Management System
	 */
	public static String FNC_APP_ID_ScmSys = FNC_ID_App + ":ScmSys";
	/*
	 * Classification of ShowCase
	 */
	public static String FNC_APP_ID_ShowCase = FNC_ID_App + ":ShowCase";
	
	/*
	 * Help
	 */
	public static String HELP_TITLE  = "Online Help";
	public static String HELP_SLOGAN = "Use the online help to answer your questions.";

	
	/*
	 * Disclaimer
	 */
	public static String DISCLAIMER_TITLE  = "Disclaimer";
	public static String DISCLAIMER_SLOGAN = "Please read this disclaimer carefully.";


	/*
	 * Access-Layer
	 */
	public static String ACCESS_C_TITLE  = GUIGlobals.APP_TITLE + ": Accessor Editor";;
	public static String ACCESS_C_SLOGAN = "Use this widget to create a new accessor.";

	public static String ACCESS_E_TITLE  = GUIGlobals.APP_TITLE + ": Accessor Editor";;
	public static String ACCESS_E_SLOGAN = "Use this widget to edit a certain accessor.";

	public static String ACCESS_G_TITLE  = GUIGlobals.APP_TITLE + ": Accessor Viewer";
	public static String ACCESS_G_SLOGAN = "Use this widget to view a certain accessor.";

	/*
	 * Bulletin-Layer
	 */
	public static String BULLETIN_TITLE  = "Bulletin Board";
	public static String BULLETIN_SLOGAN = "Use the bulletin board to post information requests to other community members.";

	public static String COMMENT_TITLE  = "Comment";
	public static String COMMENT_SLOGAN = "Use this widget to comment a certain posting.";

	public static String COMMENT_G_TITLE  = GUIGlobals.APP_TITLE + ": Comment Viewer";
	public static String COMMENT_G_SLOGAN = "Use this widget to view posting specific comments.";

	public static String COMMENTS_V_TITLE = "View comments";

	public static String CODES_LABEL    = "<b>Codes</b>";
	public static String GROUPS_LABEL   = "<b>Groups</b>";
	public static String SYMBOLS_LABEL  = "<b>Symbols</b>";
	public static String USERS_LABEL    = "<b>Users</b>";
	public static String POSTINGS_LABEL = "<b>Postings</b>";
	
	/*
	 * Comm-Layer
	 */

	public static String COMM_V_TITLE  = GUIGlobals.APP_TITLE + ": Comm Viewer";
	public static String COMM_V_SLOGAN = "Use this widget to view a certain communication object.";

	public static String COMM_V_CHAT = "View Chat Message";
	public static String COMM_V_MAIL = "View Mail Message";
	
	/*
	 * Dms-Layer
	 */
	public static String DMS_C_TITLE  = GUIGlobals.APP_TITLE + ": Dms Editor";
	public static String DMS_C_SLOGAN = "Use this widget to create a Dms entry.";

	public static String DMS_E_TITLE  = GUIGlobals.APP_TITLE + ": Dms Editor";
	public static String DMS_E_SLOGAN = "Use this widget to edit a certain Dms entry.";

	public static String DMS_G_TITLE   = GUIGlobals.APP_TITLE + ": Dms Viewer";
	public static String DMS_G_SLOGAN = "Use this widget to view a certain Dms Entry.";

	/*
	 * Group-Layer
	 */

	public static String GROUP_C_TITLE  = GUIGlobals.APP_TITLE + ": Group Editor";
	public static String GROUP_C_SLOGAN = "Use this widget to create a new group.";

	public static String GROUP_E_TITLE  = GUIGlobals.APP_TITLE + ": Group Editor";
	public static String GROUP_E_SLOGAN = "Use this widget to edit a certain group.";
	
	public static String GROUP_G_TITLE  = GUIGlobals.APP_TITLE + ": Group Viewer";
	public static String GROUP_G_SLOGAN = "Use this widget to view group specific information.";

	/*
	 * Map-Layer
	 */
	public static String MAP_TITLE 	  = "Map Layer Selector";

	public static String MAP_C_TITLE  = GUIGlobals.APP_TITLE + ": " + MAP_TITLE;
	public static String MAP_C_SLOGAN = "Use this widget to select a map layer.";
	
	public static String LAYER_ERROR = "Please select one layer.";

	/*
	 * Ns-Layer
	 */
	public static String NS_C_TITLE  = GUIGlobals.APP_TITLE + ": Ns Editor";;
	public static String NS_C_SLOGAN = "Use this widget to create a new namespace.";

	public static String NS_E_TITLE  = GUIGlobals.APP_TITLE + ": Ns Editor";;
	public static String NS_E_SLOGAN = "Use this widget to edit a certain namespace.";

	public static String NS_G_TITLE  = GUIGlobals.APP_TITLE + ": NS Viewer";
	public static String NS_G_SLOGAN = "Use this widget to view a certain namespace.";

	/*
	 * Posting
	 */
	public static String POSTING_TITLE  = "Posting";
	public static String POSTING_SLOGAN = "Use this widget to post a certain message.";

	/*
	 * Source Code Management System
	 */
	public static String SCM_TITLE  = "Source Code Management";
	public static String SCM_SLOGAN = "Use the SCM System to discover the source code of this information system.";

	public static String SCM_EXPLORER = "Package Explorer";
	public static String SCM_MODULE   = "Module Viewer";

	/*
	 * Symbol-Layer
	 */
	public static String SYMBOL_V_TITLE  = GUIGlobals.APP_TITLE + ": Symbol Viewer";
	public static String SYMBOL_V_SLOGAN = "Use this widget to assign symbols to information objects.";
	
	/*
	 * Transform-Layer
	 */
	public static String SPEC_C_TITLE  = GUIGlobals.APP_TITLE + ": Specification Editor";;
	public static String SPEC_C_SLOGAN = "Use this widget to add a new specification.";

	public static String TRANSFORM_C_TITLE  = GUIGlobals.APP_TITLE + ": Transformator Editor";;
	public static String TRANSFORM_C_SLOGAN = "Use this widget to create a new transformator.";

	/*
	 * Upload-Layer
	 */
	public static String UPLOAD_TITLE = "Upload Editor";
	public static String UPLOAD_C_TITLE  = GUIGlobals.APP_TITLE + ": " + UPLOAD_TITLE;
	public static String UPLOAD_C_SLOGAN = "Use this widget to upload files to the server cache.";

	public static String UPLOAD_SUCCESS_MESSAGE = "File Upload has been successfully performed.";
	public static String UPLOAD_ERROR_MESSAGE   = "File Upload failed due to a server-side error.";
	
	/*
	 * User-Layer
	 */

	public static String USER_E_TITLE  = GUIGlobals.APP_TITLE + ": User Editor";;
	public static String USER_E_SLOGAN = "Use this widget to edit a certain user.";

	public static String USER_G_TITLE  = GUIGlobals.APP_TITLE + ": User Viewer";
	public static String USER_G_SLOGAN = "Use this widget to view user specific information.";

	/*
	 * Confirm delete messages
	 */
	public static String CONFIRM_DELETE_PREFIX   = "Do you really want to delete the selected ";

	public static String CONFIRM_ACCESSOR_DELETE = CONFIRM_DELETE_PREFIX + "<b>Accessor</b>?";
	public static String CONFIRM_CACHE_DELETE    = CONFIRM_DELETE_PREFIX + "<b>Cache Entry</b>?";
	public static String CONFIRM_DMS_DELETE      = CONFIRM_DELETE_PREFIX + "<b>File</b>?";
	public static String CONFIRM_GROUP_DELETE    = CONFIRM_DELETE_PREFIX + "<b>Group</b>?";
	public static String CONFIRM_NS_DELETE       = CONFIRM_DELETE_PREFIX + "<b>Namespace</b>?";
	public static String CONFIRM_PRODUCT_DELETE  = CONFIRM_DELETE_PREFIX + "<b>Product</b> or <b>Productor</b>?";
	public static String CONFIRM_ROLE_DELETE     = CONFIRM_DELETE_PREFIX + "<b>Responsibility</b> or <b>Role</b>?";

	/*
	 * Form submit message
	 */
	public static String FORM_ERROR = "Please evaluate the provided form data.";
	
}
