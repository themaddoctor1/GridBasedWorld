/**
 * IOManager.java
 * 
 * Christopher Hittner (c) 2015
 */
package io;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * A class that manages all of the IO for an Interface.
 * 
 * @author Christopher Hittner
 */
public class IOManager {
    
    private IOPanel topPanel = null;
    
    /**
     * Adds an IOPanel to the IOManager.
     * @param io The panel.
     */
    public void addIOPanel(IOPanel io) {
        if(topPanel == null)
            topPanel = io;
        else
            topPanel.sendToTop(io);
    }
    
    /**
     * Executes a command within the game.
     * @param cmd THe command to execute.
     */
    public static void executeCommand(String cmd) {
        throw new UnsupportedOperationException("io.IOManager.executeCommand() has not been written.");
    }
    
    /**
     * Draws the IO.
     * @param g A Graphics object.
     */
    public void draw(Graphics g) {
        try {
            topPanel.draw(g);
        } catch(NullPointerException npe) { }
    }
    
}
