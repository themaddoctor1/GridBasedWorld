/**
 * IOTextLabel.java
 * 
 * Christopher Hittner (c) 2015
 */
package io.content;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * An IOTextLabel is basically an equivalent to the drawString() method in AWT.
 * Basically, this creates a persistent String that can be displayed on an interface.
 *
 * @author Christopher Hittner
 */
public class IOTextLabel extends IOContent {
    
    public final String DISPLAY_TEXT;
    public final Color COLOR;
    
    public IOTextLabel(String txt, int x, int y, int fontSize, Color c) {
        super(x, y, 0, fontSize);
        DISPLAY_TEXT = txt;
        COLOR = c;
    }
    
    /**
     * Draw this Button
     * @param g A Graphics object to draw on.
     */
    @Override
    public void draw(Graphics g) {
        Color old = g.getColor();
        //Text has the opposite color.
        g.setColor(COLOR);
        
        g.setFont(new Font("Courier New", Font.PLAIN, H));
        //Draws the text
        g.drawString(DISPLAY_TEXT, X, Y);
        
        g.setColor(old);
        
    }

    @Override
    public void clickOperation(int x, int y) {
        
    }
}
