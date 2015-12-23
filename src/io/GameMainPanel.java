/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import io.content.IOContent;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Christopher
 */
public class GameMainPanel extends IOPanel {

    public GameMainPanel(String nm) {
        super(nm);
        
        //Provides a background.
        BlankPanel background = new BlankPanel("BKGRND", Color.BLACK);
        
        //Content Panel
        ContentPanel ctrl = new ContentPanel("MAIN_CTRL");
        ArrayList<IOContent> controls = generateControls();
        for(IOContent ioc : controls)
            ctrl.addContent(ioc);
        
        //Adds all of the Panels.
        sendToTop(background);
        sendToTop(ctrl);
        
    }

    @Override
    public void clickOperation(int x, int y) { }

    private ArrayList<IOContent> generateControls() {
        ArrayList<IOContent> controls = new ArrayList<>();
        
        
        
        return controls;
    }
    
}
