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
        ContentPanel content = new ContentPanel("MAIN_CTRL");
        ArrayList<IOContent> controls = generateControls();
        for(IOContent ioc : controls)
            content.addContent(ioc);
        
        //Adds all of the Panels.
        sendToTop(background);
        
    }

    @Override
    public void clickOperation(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ArrayList<IOContent> generateControls() {
        ArrayList<IOContent> controls = new ArrayList<>();
        
        
        
        return controls;
    }
    
}
