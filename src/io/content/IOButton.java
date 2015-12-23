/**
 * Button.java
 * 
 * Christopher Hittner (c) 2015
 */
package io.content;

import io.IOManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * An Object that has a position and a command that can be run.
 * 
 * @author Christopher Hittner
 */
public class IOButton extends IOContent {
    public final String COMMAND, DISPLAY_TEXT;
    
    private Color border = Color.BLACK, fill = Color.WHITE, text = Color.BLACK;
    
    /**
     * Creates a Button that has dimension and a command
     * @param cmd The command.
     * @param txt The text to be displayed on the Button.
     * @param x The x position of the top left corner.
     * @param y The y position of the top left corner.
     * @param w The width of the button.
     * @param h The height of the button.
     */
    public IOButton(String cmd, String txt, int x, int y, int w, int h) {
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
        
        //Holds on to the old color
        Color old = g.getColor();
        
        //Draws the button.
        g.setColor(fill);
        g.fillRect(X, Y, W, H);
        g.setColor(border);
        g.drawRect(X, Y, W, H);
        
        //Set to the text color.
        g.setColor(text);
        
        //Generates the font
        int fontSize = (int) Math.min((W/DISPLAY_TEXT.length()) / 0.86, 0.8f * H);
        g.setFont(new Font("Courier New", Font.PLAIN, fontSize));
        
        //Calculates how much to offset the text by.
        int txtHorizOff = (int)(fontSize*0.3*DISPLAY_TEXT.length());
        int txtVertOff = fontSize/4;
        
        //Draws the text
        g.drawString(DISPLAY_TEXT, X + W/2 - txtHorizOff, Y + H/2 + txtVertOff);
        
        g.setColor(old);
    }

    @Override
    public void clickOperation(int x, int y) {
        if(this.contains(x, y))
            IOManager.executeCommand(COMMAND);
    }
    
}
