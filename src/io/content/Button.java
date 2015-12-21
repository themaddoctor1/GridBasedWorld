/**
 * Button.java
 * 
 * Christopher Hittner (c) 2015
 */
package io.content;

import io.IOManager;
import java.awt.Color;
import java.awt.Graphics;

/**
 * An Object that has a position and a command that can be run.
 * 
 * @author Christopher Hittner
 */
public class Button extends IOContent {
    public final String COMMAND, DISPLAY_TEXT;
    
    
    /**
     * Creates a Button that has dimension and a command
     * @param cmd The command.
     * @param txt The text to be displayed on the Button.
     * @param x The x position of the top left corner.
     * @param y The y position of the top left corner.
     * @param w The width of the button.
     * @param h The height of the button.
     */
    public Button(String cmd, String txt, int x, int y, int w, int h) {
        super(x, y, w, h);
        
        COMMAND = cmd;
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
    }

    @Override
    public void clickOperation(int x, int y) {
        if(this.contains(x, y))
            IOManager.executeCommand(COMMAND);
    }
    
}
