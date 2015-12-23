/**
 * GameMainPlayer.java
 * 
 * Christopher Hittner (c) 2015
 */
package io;

import io.content.IOButton;
import io.content.IOContent;
import java.awt.Color;
import java.util.ArrayList;

/**
 * This Panel is used as the primary menu used by the player.
 *
 * @author Christopher Hittner
 */
public class GameMainPanel extends IOPanel {

    public GameMainPanel(String nm) {
        super(nm);
        
        //Provides a background.
        BlankPanel background = new BlankPanel("BKGRND", Color.BLACK);
        
        //Content Panel
        ContentPanel ctrl = new ContentPanel("MAIN_CTRL");
        ArrayList<IOContent> controls = generateControls();
        for (IOContent ioc : controls)
            ctrl.addContent(ioc);
        
        //Adds all of the Panels.
        sendToTop(background);
        sendToTop(ctrl);
        
    }

    @Override
    public void clickOperation(int x, int y) { }

    private ArrayList<IOContent> generateControls() {
        //The componenta
        ArrayList<IOContent> controls = new ArrayList<>();
        
        //The definitions used for all of the buttons. Each one consists of s script and label.
        String[][] buttonDefs = {
            {"IO_MANAGER.SET_DISPLAY[inventory]", "Access Inventory"},
            {"PLAYER.SEARCH[]", "Search"}
        };
        
        //Puts all of the buttons into the list in order.
        for(int i = 0; i < buttonDefs.length; i++) {
            controls.add(new IOButton(buttonDefs[i][0], buttonDefs[i][1], 30, 40* (2+i), 240, 30));
        }
        
        return controls;
    }
    
}
