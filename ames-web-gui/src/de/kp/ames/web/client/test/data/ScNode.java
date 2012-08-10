package de.kp.ames.web.client.test.data;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test.data
 *  Module: ScNode
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #client #data #node #sc #test #web
 * </SemanticAssist>
 *
 */


import com.smartgwt.client.widgets.tree.TreeNode;

public class ScNode extends TreeNode {

    public ScNode(String name, String nid, String pid, String icon) {
 
    	/*
    	 * Appearance
    	 */
        setName(name);
        setIcon(icon);
        
        /*
         * Identifier
         */
    	setNodeID(nid);
        setParentNodeID(pid);

      
        if (nid.endsWith("folder")) setIsOpen(true);
 
    }


    public void setNodeID(String value) {
        setAttribute("nodeID", value);
    }

    public String getNodeID() {
        return getAttribute("nodeID");
    }

    public void setParentNodeID(String value) {
        setAttribute("parentNodeID", value);
    }

    public void setName(String name) {
        setAttribute("nodeTitle", name);
    }

    public String getName() {
        return getAttributeAsString("nodeTitle");
    }

    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    public String getIcon() {
        return getAttributeAsString("icon");
    }

    public void setIsOpen(boolean isOpen) {
        setAttribute("isOpen", isOpen);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScNode that = (ScNode) o;

        if (!getName().equals(that.getName())) return false;

        return true;
    }

    public int hashCode() {
        return getName().hashCode();
    }

}
