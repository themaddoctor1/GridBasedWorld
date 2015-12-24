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
            {"PLAYER.SEARCH[]", "Search"},
            {"PLAYER.ATTACK[]","Attack"}
        };
        
        //Puts all of the buttons into the list in order.
        for(int i = 0; i < buttonDefs.length; i++) {
            controls.add(new IOButton(buttonDefs[i][0], buttonDefs[i][1], 30, 40* (2+i), 240, 30));
        }
        
        int guiHeight = Interface.getInterface().getHeight();
        
        //Directional movement buttons - horizontal
        controls.add(new IOButton("PLAYER.MOVE[1|0|0]", "EAST", 210, guiHeight - (210), 80, 60));
        controls.add(new IOButton("PLAYER.MOVE[0|1|0]", "NORTH", 120, guiHeight - (260), 80, 40));
        controls.add(new IOButton("PLAYER.MOVE[-1|0|0]", "WEST", 30, guiHeight - (210), 80, 60));
        controls.add(new IOButton("PLAYER.MOVE[0|-1|0]", "SOUTH", 120, guiHeight - (140), 80, 40));
        
        //Directional movement button - vertical
        controls.add(new IOButton("PLAYER.MOVE[0|0|1]", "UP", 120, guiHeight - (210), 80, 25));
        controls.add(new IOButton("PLAYER.MOVE[0|0|-1]", "DOWN", 120, guiHeight - (175), 80, 25));
        
        return controls;
    }
    
}
