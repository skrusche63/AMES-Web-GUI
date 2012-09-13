package de.kp.ames.web.client.fnc.scm.widget;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.scm.data.ResultGridImpl;
import de.kp.ames.web.client.fnc.scm.style.GuiStyles;
import de.kp.ames.web.client.handler.RemoveHandler;

public class ResultImpl extends VLayout implements RemoveHandler {
	private ResultGridImpl grid;

	public ResultImpl(Record record) {

		this.setShowEdges(false);
		this.setStyleName(GuiStyles.X_BD_STYLE_3);
		
		this.setWidth100();
		this.setHeight100();
		
		grid = new ResultGridImpl(record);

		this.setMembers(grid);
	}

	public void update(Record record) {
		replacePlaceHolderByGrid(record);		
	}

	private void replacePlaceHolderByGrid(Record record) {
		
		ResultGridImpl grid = new ResultGridImpl(record);


		this.removeMember(this.getMember(0));
		this.addMember(grid);
		
	}

	@Override
	public void beforeRemove() {
		// TODO Auto-generated method stub
		
	}

}
