/**
 * BlankPanel.java
 * 
 * Christopher Hittner (c) 2015
 */
package io;

import java.awt.Color;

/**
 * Holds absolutely nothing but a blank color.
 *
 * @author Christopher Hittner
 */
public class BlankPanel extends IOPanel {
    
    private Color background;
    
    /**
     * Creates a white sheet.
     */
    public BlankPanel(String nm) {
        this(nm, Color.WHITE);
    }
    
    /**
     * Creates a screen of a solid color.
     * @param c The color of the background.
     */
    public BlankPanel(String nm, Color c) {
        super(nm);
        background = c;
    }

    @Override
    public void clickOperation(int x, int y) {
        throw new UnsupportedOperationException("io.BlankPanel.clickOperation() has not been written yet.."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
