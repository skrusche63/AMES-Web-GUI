package de.kp.ames.web.client.fnc.symbol.widget;

import java.util.HashMap;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.layout.VLayout;
import de.kp.ames.web.client.fnc.symbol.data.SymbolGridImpl;
import de.kp.ames.web.client.fnc.symbol.event.SymbolEventManager;
import de.kp.ames.web.client.fnc.symbol.event.SymbolListener;
import de.kp.ames.web.client.handler.RemoveHandler;

public class SymbolViewer extends VLayout implements RemoveHandler, SymbolListener {

	/*
	 * Reference to SymbolGrid
	 */
	private SymbolGridImpl grid;
	
	/**
	 * Contructor
	 */
	public SymbolViewer() {
		
		/*
		 * Dimensions
		 */
		setWidth100();
		setHeight100();

		/*
		 * This is an essential feature to ensure
		 * proper scrollbars, i.e vertical ones only
		 */
		this.setOverflow(Overflow.AUTO);
				
		/*
		 * Build member
		 */
		grid = new SymbolGridImpl();
		
		/*
		 * Context specific event handling
		 */
		SymbolEventManager.getInstance().addSymbolListener(this);

	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.handler.RemoveHandler#beforeRemove()
	 */
	public void beforeRemove() {
		SymbolEventManager.getInstance().removeSymbolListener(this);
	}

	/* (non-Javadoc)
	 * @see de.kp.ames.web.client.function.symbol.event.SymbolListener#onSymbolSelected(com.smartgwt.client.widgets.tree.TreeNode)
	 */
	public void onSymbolSelected(HashMap<String,String> attributes) {		
		if (grid != null) grid.reload(attributes);
	}

}
