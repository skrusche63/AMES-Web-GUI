package de.kp.ames.web.client.test.data;

import com.smartgwt.client.widgets.tree.TreeNode;

public class ScNode extends TreeNode {

    public ScNode(String name, String nodeID, String parentNodeID, String icon, boolean enabled, String idSuffix) {
 
    	if (enabled) {
            setName(name);
        
    	} else {
            setName("<span style='color:808080'>" + name + "</span>");
        }
        
    	setNodeID(nodeID.replace("-", "_") + idSuffix);
        setThumbnail("thumbnails/" + nodeID.replace("-", "_") + ".gif");
        
        setParentNodeID(parentNodeID.replace("-", "_") + idSuffix);
        setIcon(icon);
       
        if(nodeID.equals("featured-category") || nodeID.equals("new-category")) {
            setIsOpen(true);
        }

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

    public void setThumbnail(String thumbnail) {
        setAttribute("thumbnail", thumbnail);
    }

    public String getThumbnail() {
        return getAttributeAsString("thumbnail");
    }

    public void setIsOpen(boolean isOpen) {
        setAttribute("isOpen", isOpen);
    }

    public void setIconSrc(String iconSrc) {
        setAttribute("iconSrc", iconSrc);
    }

    public String getIconSrc() {
        return getAttributeAsString("iconSrc");
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
