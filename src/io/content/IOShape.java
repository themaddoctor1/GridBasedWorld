/**
 * IOShape.java
 * 
 * Christopher Hittner (c) 2015
 */
package io.content;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

/**
 * An IOShape is a wrapper for java.awt.Shape that allows for drawing Shapes
 * using my framework.
 *
 * @author Christopher Hittner
 */
public class IOShape extends IOContent {
    
    private Shape shape;
    private Color color = Color.BLACK;
    
    /**
     * Creates the IOShape.
     * @param s The Shape to be wrapped.
     */
    public IOShape(Shape s) {
        super(0, 0, 0, 0);
        shape = s;
    }
    
    public IOShape(Shape s, Color c) {
        this(s);
        color = c;
    }
    
    @Override
    public boolean contains(int x, int y) {
        return shape.contains(x, y);
    }

    @Override
    public void draw(Graphics g) {
        Color old = g.getColor();
        g.setColor(color);
        ((Graphics2D) g).draw(shape);
        g.setColor(old);
    }

    @Override
    public void clickOperation(int x, int y) {}
    
}
