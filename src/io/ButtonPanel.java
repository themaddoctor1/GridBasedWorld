/**
 * ButtonPanel.java
 * 
 * Christopher Hittner (c) 2015
 */
package io;

import java.util.ArrayList;

/**
 *
 * @author Christopher
 */
public class ButtonPanel extends IOPanel {
    private ArrayList<Button> buttons = new ArrayList<>();

    public ButtonPanel(String nm) {
        super(nm);
    }
    
    /**
     * Clicks the mouse at a coordinate.
     * @param x The x-coordinate.
     * @param y The y-coordinate
     */
    @Override
    public void clickOperation(int x, int y) {
        
        for(int i = 0; i < buttons.size(); i++)
            if(buttons.get(i).contains(x, y))
                IOManager.executeCommand(buttons.get(i).COMMAND);
        
    }
    
    /**
     * Adds a Button to this item.
     * @param b The button.
     */
    public void addButton(Button b) {
        buttons.add(b);
    }
    
    public int numButtons(){ return buttons.size(); }
    
    /**
     * Gets a Button from the list.
     * @param idx The index to look at.
     * @return The button at index idx.
     */
    public Button getButton(int idx) {
        return buttons.get(idx);
    }
    
    /**
     * Removes a Button from this panel.
     * @param idx The index of the button.
     * @return The button removed.
     */
    public Button removeButton(int idx) {
        return buttons.get(idx);
    }
    
}
