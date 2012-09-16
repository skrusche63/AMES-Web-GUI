package de.kp.ames.web.client.fnc.scm.widget;

import com.google.gwt.json.client.JSONValue;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.thejit.client.HyperTreeExplorer;

public class SimilarityFeedbackImpl extends VLayout {
	private HyperTreeExplorer hyperTreeExplorer;

	public SimilarityFeedbackImpl() {

		this.setWidth100();
		this.setHeight100();

		hyperTreeExplorer = new HyperTreeExplorer();

		this.setMembers(hyperTreeExplorer);

	}

	public void update(JSONValue jValue) {

		hyperTreeExplorer.loadJTree(jValue.toString());
	}

	public void update(String jValue) {

		hyperTreeExplorer.loadJTree(jValue);
		hyperTreeExplorer.resizeTree();
	}

}
