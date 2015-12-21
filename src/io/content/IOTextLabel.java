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
    
    public IOTextLabel(String txt, int x, int y, int fontSize) {
        super(x, y, 0, fontSize);
        DISPLAY_TEXT = txt;
    }
    
    /**
     * Draw this Button
     * @param g A Graphics object to draw on.
     */
    @Override
    public void draw(Graphics g) {
        //Draws the button.
        g.fillRect(X, Y, W, H);
        Color current = g.getColor();
        //Text has the opposite color.
        g.setColor(new Color(255 - current.getRed(), 255 - current.getGreen(), 255 - current.getBlue()));
        
        g.setFont(new Font("Courier New", Font.PLAIN, H));
        //Draws the text
        g.drawString(DISPLAY_TEXT, X, Y);
        
    }

    @Override
    public void clickOperation(int x, int y) {
        
    }
}
