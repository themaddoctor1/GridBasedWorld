/**
 * ContentPanel.java
 * 
 * Christopher Hittner (c) 2015
 */
package io;

import io.content.*;
import java.util.ArrayList;

/**
 * A ContentPanel has subcomponents that allow for this to be customizable.
 *
 * @author Christopher Hittner
 */
public class ContentPanel extends IOPanel {
    
    private ArrayList<IOContent> content;
    
    /**
     * Creates a ContentPanel with a name.
     * @param nm The name of the created ContentPanel.
     */
    public ContentPanel(String nm) {
        super(nm);
        content = new ArrayList<>();
    }
    
    @Override
    public void clickOperation(int x, int y) {
        
        for(int i = 0; i < content.size(); i++)
            content.get(i).clickOperation(x, y);
        
    }
    
    /**
     * Adds a content to this item.
     * @param c The item to add.
     */
    public void addContent(IOContent c) {
        content.add(c);
    }
    
    public int numContents(){ return content.size(); }
    
    /**
     * Gets an IOContent from the list.
     * @param idx The index to look at.
     * @return The item at index idx.
     */
    public IOContent getButton(int idx) {
        return content.get(idx);
    }
    
    /**
     * Removes an IOCOntent from this panel.
     * @param idx The index of the button.
     * @return The item removed.
     */
    public IOContent removeButton(int idx) {
        return content.get(idx);
    }
    
}
