package de.kp.ames.web.client.fnc.scm.widget;

import java.util.ArrayList;
import java.util.HashMap;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;

import de.kp.ames.web.client.fnc.scm.control.CheckoutController;
import de.kp.ames.web.client.fnc.scm.event.SearchEventManager;
import de.kp.ames.web.client.fnc.scm.event.SearchResultConfirmedListener;
import de.kp.ames.web.client.fnc.scm.event.SearchUpdateListener;
import de.kp.ames.web.client.fnc.scm.layout.CenterportImpl;
import de.kp.ames.web.client.handler.RemoveHandler;

public class ResultPortImpl extends CenterportImpl implements SearchUpdateListener, SearchResultConfirmedListener, RemoveHandler {

	private final static String CART_TITLE = "Semantic Cart";
	private SuggestFeedbackImpl suggestFeedback;
	private ResultImpl searchResult;
	private CartImpl resultCartResult;

	private Record suggestFeedbackRecord;
	final private SectionStack sectionStack;
	private ImgButton checkoutButton;
	
	/*
	 * Reference to removable members
	 */
	private ArrayList<RemoveHandler> removables;

	public ResultPortImpl(Record record) {
		super();

		/*
		 * instantiate removables list 
		 */
		removables = new ArrayList<RemoveHandler>();

		/*
		 * remember suggestion record
		 */
		this.suggestFeedbackRecord = record;


		suggestFeedback = new SuggestFeedbackImpl(record);
		suggestFeedback.setHeight("120");
		removables.add(suggestFeedback);

		
		searchResult = new ResultImpl(record);
		removables.add(searchResult);
		
		resultCartResult = new CartImpl();
		removables.add(resultCartResult);
		
        checkoutButton = new ImgButton();  
        checkoutButton.setSize(16);  
        checkoutButton.setShowRollOver(false);  
        checkoutButton.setShowFocused(false);  
        checkoutButton.setShowDown(false);  
        
        checkoutButton.setActionType(SelectionType.BUTTON);
        checkoutButton.setSrc("silk/cart_go.png");  
        checkoutButton.setTooltip("Checkout your semantic research");
        checkoutButton.setAltText("Checkout your semantic research");
        //checkoutButton.disable(); // switches image to *_disable.png
        checkoutButton.setVisible(false);
        
        checkoutButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {

				HashMap<String,String> attributes = new HashMap<String,String>();
				new CheckoutController().doView(attributes, resultCartResult.getGridData());

			}
		});

		
		sectionStack = new SectionStack();
		sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);
		sectionStack.setWidth100();
		sectionStack.setHeight100();

		SectionStackSection sectionSuggestFeedback = new SectionStackSection("Suggestion");
		sectionSuggestFeedback.setExpanded(true);
		sectionSuggestFeedback.setCanCollapse(false);
		sectionSuggestFeedback.addItem(suggestFeedback);
		sectionStack.addSection(sectionSuggestFeedback);

		SectionStackSection sectionSearchResult = new SectionStackSection("Results");
		sectionSearchResult.setExpanded(true);
		sectionSearchResult.setCanCollapse(true);
		sectionSearchResult.addItem(searchResult);
		sectionStack.addSection(sectionSearchResult);

		SectionStackSection sectionResultCart = new SectionStackSection(CART_TITLE);
		sectionResultCart.setExpanded(false);
		sectionResultCart.setCanCollapse(true);
		sectionResultCart.setControls(checkoutButton);
		sectionResultCart.addItem(resultCartResult);
		sectionStack.addSection(sectionResultCart);
		
		this.setMembers(sectionStack);

		/*
		 * register listener
		 */
		SearchEventManager.getInstance().addSearchResultConfirmedListener(this);
		SearchEventManager.getInstance().addSearchUpdateListener(this);

	};
	

	@Override
	public void doAfterResultRecordConfirmed(Record resultRecord) {
		
		// get SectionStackSection (field does not work)
		SectionStackSection sectionResultCart = sectionStack.getSection(2);
		
		resultCartResult.addChoice(suggestFeedbackRecord, resultRecord);

		int cartCount = resultCartResult.getCartCount();

		// update section title
		sectionResultCart.setTitle(CART_TITLE + " (" + cartCount + ")");
		
		// expand on first cart item
		if (cartCount==1) {
			sectionResultCart.setExpanded(true);
			checkoutButton.setVisible(true);
		}
		
	}

	@Override
	public void doAfterSearchUpdate(Record suggestionRecord) {

		/*
		 * update suggestion record
		 */
		this.suggestFeedbackRecord = suggestionRecord;

		suggestFeedback.update(suggestionRecord);
		searchResult.update(suggestionRecord);
	}

	@Override
	public void beforeRemove() {
		/*
		 * unregister listener
		 */
		SearchEventManager.getInstance().removeSearchResultConfirmedListener(this);
		SearchEventManager.getInstance().removeSearchUpdateListener(this);

		for (RemoveHandler removable:removables) {
			removable.beforeRemove();
		}

	}


}
