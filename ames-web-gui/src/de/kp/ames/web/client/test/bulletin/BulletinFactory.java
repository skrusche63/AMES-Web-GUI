package de.kp.ames.web.client.test.bulletin;
/**
 * This Java module is part of the
 *  Application Developer Framework
 *
 *  Project: AMES-Web-GUI
 *  Package: de.kp.ames.web.client.test.bulletin
 *  Module: BulletinFactory
 *  @author krusche@dr-kruscheundpartner.de
 *
 * Add your semantic annotations within the SemanticAssist tags and
 * mark them with a leading hashtag #:
 *
 * <SemanticAssist>
 *     #bulletin #client #factory #test #web
 * </SemanticAssist>
 *
 */

/**
 *	Copyright 2012 Dr. Krusche & Partner PartG
 *
 *	AMES-Web-GUI is free software: you can redistribute it and/or 
 *	modify it under the terms of the GNU General Public License 
 *	as published by the Free Software Foundation, either version 3 of 
 *	the License, or (at your option) any later version.
 *
 *	AMES- Web-GUI is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 *  See the GNU General Public License for more details. 
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this software. If not, see <http://www.gnu.org/licenses/>.
 *
 */

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.web.client.fnc.bulletin.data.CommentGridImpl;
import de.kp.ames.web.client.fnc.bulletin.data.PostGridImpl;
import de.kp.ames.web.client.fnc.bulletin.widget.BulletinImpl;
import de.kp.ames.web.client.fnc.bulletin.widget.CommentsViewer;
import de.kp.ames.web.client.fnc.bulletin.widget.MessageFormImpl;
import de.kp.ames.web.client.fnc.bulletin.widget.MessageImpl;
import de.kp.ames.web.client.fnc.globals.FncGlobals;
import de.kp.ames.web.client.style.GuiStyles;
import de.kp.ames.web.client.test.FncFactory;
import de.kp.ames.web.client.test.ScAction;
import de.kp.ames.web.client.test.data.ScData;
import de.kp.ames.web.shared.constants.ClassificationConstants;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class BulletinFactory extends FncFactory {

	public static VLayout createCommentGridImpl() {

		VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

		/*
		 * Label
		 */
		HTMLPane pane = getTeaser("View all registered comments for a certain posting.", 40);

		/*
		 * Grid
		 */
		String posting = ScData.TEST_POSTING;		
		CommentGridImpl grid = new CommentGridImpl(posting);
		
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane, grid);
		return layout;
	
	}

	public static VLayout createPostGridImpl() {

		VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

		/*
		 * Label
		 */
		HTMLPane pane = getTeaser("View all registered postings for a certain contact.", 40);

		/*
		 * Grid
		 */
		String contact = ScData.TEST_CONTACT;
		PostGridImpl grid = new PostGridImpl(contact);
		
		grid.setMargin(24);

		grid.setWidth(480);
		grid.setHeight(480);

		grid.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane, grid);
		return layout;
	
	}

	public static VLayout createBulletinImpl() {

		String message = "Click the button to open the BulletinImpl.";
		return createDialog(message, "Show BulletinImpl", new ScAction() {
			public void execute() {
				startApp();
			}			
		});
	
	}

	private static void startApp() {
		
        final Canvas animateOutline = new Canvas();
 
        animateOutline.setBorder("1px solid #a0a0a0");
        
        /*
         * Animation start point
         */
        animateOutline.setTop(0);
        animateOutline.setLeft(0);
        
        animateOutline.setWidth(0);
        animateOutline.setHeight(0);

        animateOutline.show();
        
        animateOutline.animateRect(0, 0, Page.getWidth(), Page.getHeight(), new AnimationCallback() {
            public void execute(boolean earlyFinish) {
            	
                animateOutline.hide();
                
                final Window app = createApp();
                app.addCloseClickHandler(new CloseClickHandler() {
                	
                    public void onCloseClick(CloseClickEvent event) {
                        
                    	animateOutline.setRect(0, 0, Page.getWidth(), Page.getHeight());
                        animateOutline.show();
                        
                        app.destroy();
 
                        animateOutline.animateRect(0, 0, 0, 0, new AnimationCallback() {
                            public void execute(boolean earlyFinish) {
                                animateOutline.hide();
                            }
                        }, 500);

                    }
                });
                
                app.show();
                
            }
        }, 500);
		
	}
	
	private static Window createApp() {

		Window app = new Window();
		app.setTitle("Bulletin Board");

		/*
		 * Dimensions
		 */
		app.setWidth100();
		app.setHeight100();
		
		/*
		 * Buttons
		 */
        app.setShowMinimizeButton(false);
        app.setShowCloseButton(true);
        
        app.setCanDragReposition(false);
        app.setCanDragResize(false);
        
        app.setShowShadow(false);		
		app.addItem(new BulletinImpl());

		return app;
	}

	public static VLayout createCommentsViewer() {

		String message = "Click the button to open the CommentsViewer.";
		return createDialog(message, "Show Dialog", new ScAction() {
			public void execute() {

				String posting = ScData.TEST_POSTING;
				CommentGridImpl grid = new CommentGridImpl(posting);

				new CommentsViewer(grid);
				
			}
		});
	
	}
	
	public static VLayout createMessageImpl() {

		String message = "Click the button to open the MessageImpl.";
		return createDialog(message, "Show Dialog", new ScAction() {
			public void execute() {
				
				String type = ClassificationConstants.FNC_ID_Posting;

				String title  = FncGlobals.POSTING_TITLE;
				String slogan = FncGlobals.POSTING_SLOGAN;

				JSONObject jContact = new JSONObject();
				
				jContact.put(JaxrConstants.RIM_ID,   new JSONString(ScData.TEST_CONTACT));
				jContact.put(JaxrConstants.RIM_NAME, new JSONString(ScData.TEST_NAME));

				MessageImpl dialog = new MessageImpl(title, slogan, type, jContact);
				
			}			
		});
	
	}

	public static VLayout createMessageFormImpl() {

        VLayout layout = new VLayout();
		layout.setStyleName(GuiStyles.X_BD_STYLE_0);

        /*
         * Label
         */
        HTMLPane pane = getTeaser("This is an example of a Message Form.", 40);

        /*
         * Message Form
         */
        MessageFormImpl messageForm = new MessageFormImpl();
		messageForm.setMargin(24);
		
		/*
		 * Style
		 */
		messageForm.setBackgroundColor("#F2F2F4");
		messageForm.setStyleName(GuiStyles.X_BD_STYLE_4);

		layout.setMembers(pane,messageForm);
		return layout;
	
	}

}
