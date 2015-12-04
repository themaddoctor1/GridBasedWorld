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
public class BlankPanel {
    
    private Color background;
    
    /**
     * Creates a white sheet.
     */
    public BlankPanel() {
        this(Color.WHITE);
    }
    
    /**
     * Creates a screen of a solid color.
     * @param c The color of the background.
     */
    public BlankPanel(Color c) {
        background = c;
    }
    
}
