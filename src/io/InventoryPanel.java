/**
 * InventoryPanel.java
 * 
 * Christopher Hittner (c) 2015
 */
package io;

import items.Inventory;
import items.Item;
import java.util.ArrayList;

/**
 * An InventoryPanel contains the panels required to represent an Inventory screen
 *
 * @author Christopher Hittner
 */
public class InventoryPanel  extends IOPanel {

    public InventoryPanel(Inventory inv) {
        super("INV");
        
        //Provides a background.
        BlankPanel background = new BlankPanel("BKGRND");
        this.setSubpanel(background);
        
        //Creates and adds buttons
        ButtonPanel buttons = new ButtonPanel("BTNS");
        
        
    }
    
    private static ArrayList<Button> generateButtons(Inventory inv) {
        
        //Holds the list of buttons.
        ArrayList<Button> buttons = new ArrayList<>();
        
        //Tracks the number of items that were skipped.
        int skippedItems = 0;
        
        //For each item in the list, attempt to add a Button and label for it.
        for(int i = 0; i < inv.size(); i++) {
            Item item = inv.get(i);
            
            //If there is an item, take care of it.
            if(item != null) {
                int idx = i - skippedItems;
            } else skippedItems++; // Otherwise, increase the number of skipped items because this one was skipped.
        }
        
        return buttons;
        
    }

    @Override
    public void clickOperation(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
