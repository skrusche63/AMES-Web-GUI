package de.kp.ames.web.client.function.globals;

public class FncGlobals {

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
	 * Bulletin Board
	 */
	public static String BULLETIN_TITLE  = "Bulletin Board";
	public static String BULLETIN_SLOGAN = "Use the bulletin board to post information requests to other community members.";

	/*
	 * Comment
	 */
	public static String COMMENT_TITLE  = "Comment";
	public static String COMMENT_SLOGAN = "Use this widget to comment a certain posting.";

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
	
}
