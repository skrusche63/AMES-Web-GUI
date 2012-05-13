package de.kp.ames.web.client.function.gui.bulletin;

import com.smartgwt.client.widgets.layout.VLayout;

public class ContactsImpl extends VLayout {

	private GroupsImpl groups;
	private UsersImpl users;
	
	public ContactsImpl() {
		
		/*
		 * Dimensions
		 */
		this.setWidth100();
		this.setHeight100();
		
		/*
		 * Set groups & users
		 */
		groups = new GroupsImpl();
		users  = new UsersImpl();
		
		/*
		 * Set Dimensions and splitter
		 */
		
		groups.setHeight("50%");
		users.setHeight("50%");
		
		/*
		 * Show splitter for groups
		 */
		groups.setShowResizeBar(true);
		
		/*
		 * Set members to contacts
		 */
		this.setMembers(groups, users);

	}
}
