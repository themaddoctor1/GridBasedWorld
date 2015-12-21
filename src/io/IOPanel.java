/**
 * IOPanel.java
 * 
 * Christopher Hittner (c) 2015
 */
package io;

import java.awt.Graphics;

/**
 * A class that is used for IO subprocessing.
 *
 * @author Christopher Hittner
 */
public abstract class IOPanel {
    
    private IOPanel subpanel = null;
    public final String NAME;
    
    /**
     * Creates an IOPanel with a name.
     * @param nm The name of the new IOPanel.
     */
    public IOPanel (String nm) {
        NAME = nm;
    }
    
    
    /**
     * Runs mouse click operations.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public abstract void clickOperation(int x, int y);
    
    /**
     * Processes a click, and then sends the news to its child.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public final void mouseClicked(int x, int y) {
        //Ordering ensures that the item on top goes first. The idea is that items
        //on top are drawn first because the top item will be at the end of the
        //IOPanel chain (Linked List?)
        try {
            subpanel.mouseClicked(x, y);
        } catch(NullPointerException npe) {}
        
        clickOperation(x, y);
        
    }
    
    /**
     * Provides this subpanel with a new subpanel.
     * @param subpanel The new subpanel.
     */
    public final void setSubpanel(IOPanel subpanel) {
        this.subpanel = subpanel;
    }
    
    /**
     * Moves an IOPanel to the top of the set.
     * @param io The IOPanel.
     */
    public void sendToTop(IOPanel io) {
        if(subpanel == null)
            setSubpanel(io);
        else
            subpanel.sendToTop(io);
    }
    
    /**
     * Draws the IOPanel.
     * @param g A Graphics object.
     */
    public final void drawPanel(Graphics g) {
        //Draws this.
        draw(g);
        
        //Then, draw the thing on top of this.
        if(subpanel != null)
            subpanel.drawPanel(g);
    }
    
    /**
     * Draws the contents. By default, there is nothing, so the method should be
     * overridden in order to create content.
     * @param g The Graphics object that is used to draw.
     */
    protected void draw(Graphics g) { }
    
}
