/**
 * BlankPanel.java
 * 
 * Christopher Hittner (c) 2015
 */
package io;

import java.awt.Color;
import java.awt.Graphics;

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
    public void draw(Graphics g) {
        //Temporarily stored the original color and replaces it with the background color.
        Color original = g.getColor();
        g.setColor(background);
        
        //Draws the color.
        g.fillRect(0, 0, Interface.getInterface().getWidth(), Interface.getInterface().getWidth());
        
        //Gives back the old color.
        g.setColor(original);
    }

    @Override
    public void clickOperation(int x, int y) {
        throw new UnsupportedOperationException("io.BlankPanel.clickOperation() has not been written yet.."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
