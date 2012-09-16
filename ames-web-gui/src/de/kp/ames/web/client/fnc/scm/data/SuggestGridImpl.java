package de.kp.ames.web.client.fnc.scm.data;

import java.util.HashMap;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.events.KeyDownEvent;
import com.smartgwt.client.widgets.events.KeyDownHandler;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;

import de.kp.ames.web.client.core.grid.RemoteGridImpl;
import de.kp.ames.web.client.fnc.scm.control.SuggestController;
import de.kp.ames.web.client.fnc.scm.handler.SuggestRecordHandlerImpl;
import de.kp.ames.web.client.fnc.scm.model.SuggestObject;
import de.kp.ames.web.client.fnc.scm.style.GuiStyles;
import de.kp.ames.web.client.model.core.DataObject;
import de.kp.ames.web.shared.constants.JsonConstants;
import de.kp.ames.web.shared.constants.MethodConstants;
import de.kp.ames.web.shared.constants.ServiceConstants;

public class SuggestGridImpl extends RemoteGridImpl {

	private String query;


	/**
	 * @param query
	 */
	public SuggestGridImpl(String query) {
		super(ServiceConstants.SCM_SERVICE_ID);

		/*
		 * Set query
		 */
		this.query = query;

		initialize();

	}


	private void initialize() {
		/*
		 * No border style
		 */
		this.setStyleName(GuiStyles.X_BD_STYLE_4);

		this.setHeight100();
		this.setWidth100();

		this.setLeaveScrollbarGap(false);
		this.setSelectionType(SelectionStyle.SINGLE);
		this.setShowHeader(false);
		
		this.setFixedRecordHeights(false);
		this.setWrapCells(true);

		/*
		 * Register data
		 */
		attributes = new HashMap<String,String>();
		attributes.put(MethodConstants.ATTR_TYPE, "suggest");
		attributes.put(JsonConstants.J_QUERY, this.query);


		/*
		 * Create data object
		 */
		this.dataObject = createDataObject();

		/*
		 * Create data source
		 */
		this.createScGridDS();

		/*
		 * Create grid fields
		 */
		this.setFields(createGridFields());
		
		/*
		 * add keydown handler
		 */
		final SuggestGridImpl self = this;
		this.addKeyDownHandler(new KeyDownHandler() {
			
			@Override
			public void onKeyDown(KeyDownEvent event) {
				self.afterKeyDown(event);
				
			}
		});

		/*
		 * Add Record Handler
		 */
		SuggestRecordHandlerImpl recordHandler = new SuggestRecordHandlerImpl(this);
		this.addRecordHandler(recordHandler);
	}
	
	@Override
	public void afterSelectionChanged(SelectionEvent event) {
		// do nothing on single select
	}


	@Override
	public String getDetailFieldName() {
		// suppress detail field expansion option
		return null;
	}


	/*
	 * Grid get focus from TextWidget with Arrow_Down
	 */
	public void focusToSuggestGrid() {

		if (this.getResultSet().isEmpty())
			return;

		this.focus();

		if (this.getSelectedRecords().length == 0) {
			/*
			 * nothing selected yet, select first in row if records are
			 * available there must be a group header first because of this we
			 * select second record, which contains first suggestion
			 */
			this.selectSingleRecord(1);
		}

	}

	/*
	 * KeyDown is called for each single Key
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.kp.ames.search.client.widget.grid.GridImpl#afterKeyDown(com.smartgwt
	 * .client.widgets.events.KeyDownEvent)
	 */
	public void afterKeyDown(KeyDownEvent event) {
		// has: event.cancel();
		String key = EventHandler.getKey();

		/*
		 * KeyDown is called before navigation to next record finished
		 * selectedRecord is in that case the last or start position
		 */
		if (key.equals("Arrow_Left") || key.equals("Arrow_Right")) {
			// move focus up to text widget
			SuggestController.getInstance().focusToSearchBox();
		}
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.kp.ames.search.client.core.grid.Grid#afterRecordDoubleClick(com.smartgwt
	 * .client.widgets.grid.events.RecordDoubleClickEvent)
	 */
	@Override
	public void afterRecordDoubleClick(RecordDoubleClickEvent event) {
		// does not have event.cancel();
		Record record = event.getRecord();

		this.recordHandler.doSelect(record);
	}

	/**
	 * @return
	 */
	private DataObject createDataObject() {
		return new SuggestObject();
	}

}
