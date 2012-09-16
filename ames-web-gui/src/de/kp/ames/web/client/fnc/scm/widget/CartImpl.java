package de.kp.ames.web.client.fnc.scm.widget;

import java.util.HashMap;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.user.client.ui.NamedFrame;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.core.globals.GuiConstants;
import de.kp.ames.web.client.core.method.RequestMethodImpl;
import de.kp.ames.web.client.fnc.scm.data.CartGridImpl;
import de.kp.ames.web.client.fnc.scm.event.DownloadListener;
import de.kp.ames.web.client.fnc.scm.event.SearchEventManager;
import de.kp.ames.web.client.fnc.scm.style.GuiStyles;
import de.kp.ames.web.client.handler.RemoveHandler;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class CartImpl extends HLayout implements DownloadListener, RemoveHandler {
	
	private CartGridImpl grid;
	private DynamicForm form;

	public CartImpl() {

		this.setShowEdges(false);
		this.setStyleName(GuiStyles.X_BD_STYLE_3);
		
		this.setWidth100();
		this.setHeight100();
		
		VLayout wrapper = new VLayout();
		wrapper.setWidth100();
		wrapper.setHeight100();
		
		/*
		 * Build Grid
		 */
		grid = new CartGridImpl();

		/*
		 * A dynamic form is used to submit a Post request 
		 * with response target set to NamedFrame 
		 */
	    HiddenItem hiddenField = new HiddenItem("hiddenField");
		form = new DynamicForm();
		form.setWidth(1);
		form.setHeight(1);
		form.setFields(hiddenField);
		form.setOverflow(Overflow.HIDDEN);
		
		
		/*
		 * Hidden iFrame
		 */
		NamedFrame iFrame = new NamedFrame("downloadFrame");
		
		iFrame.setWidth("1");
		iFrame.setHeight("1");
		iFrame.setVisible(false);
		
		form.setTarget("downloadFrame");
		
		wrapper.setMembers(grid);
		
		this.setMembers(wrapper, form);
		this.addMember(iFrame);
		
		
		/*
		 * register listener
		 */
		SearchEventManager.getInstance().addDownloadListener(this);

	}

	public void addChoice(Record suggestFeedbackRecord, Record resultRecord) {
		
		String suggestionLabel = suggestFeedbackRecord.getAttribute(JsonConstants.J_TERM) + 
				" (" + suggestFeedbackRecord.getAttribute(JsonConstants.J_HYPERNYM)+ 
				")";
		/*
		 * use label instead of id, which may differ for suggestions 
		 */
		String combinedId = suggestionLabel + 
				"::" + resultRecord.getAttribute(JsonConstants.J_ID);
		
		if (this.hasCombinedId(combinedId)) return;
		
		Record record = new Record();
		record.setAttribute(JsonConstants.J_CID, combinedId);
		
		/*
		 * add suggest fields (with context term)
		 */
		record.setAttribute("suggest", suggestionLabel);

		/*
		 * add result fields
		 */
		record.setAttribute("choice", resultRecord.getAttribute(JsonConstants.J_TITLE));
		record.setAttribute(JsonConstants.J_ID, resultRecord.getAttribute(JsonConstants.J_ID));
		grid.addData(record);
	}

	private boolean hasCombinedId(String id) {
		return grid.hasCombinedId(id);
	}

	/**
	 * Delegate call to grid
	 * @return
	 */
	public int getCartCount() {
//		return grid.getRecord().length;
		return grid.getTotalRows();
	}

	/**
	 * Delegate call to grid
	 * @return
	 */
	public JSONArray getGridData() {
		return grid.getGridData();
	}


	/*
	 * (non-Javadoc)
	 * @see de.kp.ames.search.client.event.DownloadListener#doTriggerDownload()
	 */
	@Override
	public void doTriggerDownload() {

	    form.setValue("hiddenField", getGridData().toString());
	    form.setAction(getUri());
	    form.submitForm();
	}

	/**
	 * A helper method to retrieve the form action url
	 * 
	 * @return
	 */
	private String getUri() {

		/*
		 * Configure service call to provide data for Checkout Viewer
		 */
		HashMap<String, String> attributes = new HashMap<String, String>();
		attributes.put(MethodConstants.ATTR_TYPE, "download");
			
		/*
		 * Build method
		 */
		RequestMethodImpl requestMethod = new RequestMethodImpl();
		requestMethod.setName(MethodConstants.METH_APPLY);

		requestMethod.setAttributes(attributes);
		
		/*
		 * Build request uri
		 */
		return getRequestUrl() + requestMethod.toQuery();
		
	}
		
	/**
	 * Build base request url
	 * 
	 * @return
	 */
	private String getRequestUrl() {
		return GuiConstants.REG_URL + "/" + ServiceConstants.SCM_SERVICE_ID;
		
	}

	@Override
	public void beforeRemove() {
		/*
		 * unregister listener
		 */
		SearchEventManager.getInstance().removeDownloadListener(this);
		
	}

	
}
