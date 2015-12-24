/**
 * IOImage.java
 * 
 * Christopher Hittner (c) 2015
 */
package io.content;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * IOImage is an IOContent subclass that wraps an Image object.
 *
 * @author Christopher Hittner
 */
public class IOImage extends IOContent {
    
    private final Image image;
    
    /**
     * Creates an IOImage that contains an Image
     * @param img The image to draw.
     * @param x The x-coordinate of the top-left corner.
     * @param y The y-coordinate of the top-left corner.
     */
    public IOImage(Image img, int x, int y) {
        super(x, y, img.getWidth(null), img.getHeight(null));
        image = img;
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawImage(image, X, Y, null);
    }

    @Override
    public void clickOperation(int x, int y) { }
    
}
