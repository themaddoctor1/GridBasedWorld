/**
 * IOContent.java
 * 
 * Christopher Hittner (c) 2015
 */
package io.content;

import java.awt.Graphics;

/**
 * An IOContent is used by ContentPanels to provide smaller visual segments for the graphics,
 * as well as allowing for subcomponents.
 *
 * @author Christopher Hittner
 */
public abstract class IOContent {
    //The dimensions of the content
    public final int X, Y, W, H;
    
    /**
     * Creates an IOContent object that has dimension and a command.
     * @param x The x position of the top left corner.
     * @param y The y position of the top left corner.
     * @param w The width of the button.
     * @param h The height of the button.
     */
    public IOContent(int x, int y, int w, int h) {
        X = x;
        Y = y;
        W = w;
        H = h;
    }
    
    
    /**
     * Determines whether or not a pixel is inside this.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @return 
     */
    public boolean contains(int x, int y) {
        return X <= x && X + W > x
                && Y <= y && Y + H > y;
    }
    
    /**
     * Draws this IOContent.
     * @param g The Graphics object to draw on.
     */
    public abstract void draw(Graphics g);

    public abstract void clickOperation(int x, int y);
    
}
