/**
 * InventoryPanel.java
 * 
 * Christopher Hittner (c) 2015
 */
package io;

import io.content.IOButton;
import io.content.IOContent;
import io.content.IOShape;
import io.content.IOTextLabel;
import items.Inventory;
import items.Item;
import items.Loadout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * An InventoryPanel contains the panels required to represent an Inventory screen
 *
 * @author Christopher Hittner
 */
public class LoadoutPanel extends IOPanel {

    public LoadoutPanel(Loadout load, int skipped) {
        super("INV");
        
        //Provides a background.
        BlankPanel background = new BlankPanel("BKGRND", Color.BLACK);
        
        //Creates and adds buttons
        ContentPanel inventory = new ContentPanel("INV_DISP");
        ArrayList<IOContent> invContent = generateContent(load, skipped);
        for(IOContent c : invContent)
            inventory.addContent(c);
        
        //Puts the Items onto the Inventory in order.
        this.sendToTop(background);
        this.sendToTop(inventory);
    }
    
    
    /**
     * Creates the items for the interactive layer of the InventoryPanel
     * @param inv The Inventory being displayed.
     * @param itemsSkipped How many items to skip over.
     * @return The list of IOContents.
     */
    private static ArrayList<IOContent> generateContent(Loadout load, int itemsSkipped) {
        
        //Holds the list of buttons.
        ArrayList<IOContent> content = new ArrayList<>();
        
        //Adds the return to main screen button.
        content.add(new IOButton("IO_MANAGER.SET_DISPLAY[game_main]", "<-", 30, 30, 40, 40));
        
        //Null check.
        if(load == null)
            return content;
        
        //Grabs to inside Inventory.
        Inventory inv = load.getInventory();
        
        //Another null check.
        if(inv == null)
            return content;
        
        //Up button
        if(itemsSkipped > 0)
            content.add(new IOButton("IO_MANAGER.SET_DISPLAY[inventory|" + ((itemsSkipped-1)) + "]", "^"
                    , Interface.getInterface().getWidth() - 60, 30, 40, 40));
        
        //Down button
        if(itemsSkipped < inv.size()-1)
            content.add(new IOButton("IO_MANAGER.SET_DISPLAY[inventory|" + (itemsSkipped+1) + "]", "v"
                    , Interface.getInterface().getWidth() - 60, Interface.getInterface().getHeight() - 70, 40, 40));
        
        //Tracks the number of items that were skipped.
        int numInvalid = itemsSkipped;
        
        //Calculates the maximum number of items to display. Two sets of 80px margins are provided.
        int maxDisplayed = (Interface.getInterface().getHeight() - (100*2))/40;
        
        //A box that the inventory will be drawn in.
        content.add(new IOShape(new Rectangle(30, 100, Interface.getInterface().getWidth() - 60, 40*maxDisplayed), Color.WHITE));
        
        /*
         *(For each item in the list, attempt to add a Button and label for it.
         *The labels will be 40px thick. If all of the required labels are inserted, then
         *cease adding them.
        */
        for(int i = itemsSkipped; i < inv.size() && maxDisplayed < i-numInvalid; i++) {
            //Grabs the Item.
            Item item = inv.get(i);
            
            //If there is an item, take care of it.
            if(item != null) {
                //Calculates the index of the visual list to draw.
                int idx = i - numInvalid;
                
                //Labels
                IOTextLabel itemName = new IOTextLabel(item.NAME()       , 120, 110 + 40*idx, 16, Color.WHITE);
                IOTextLabel itemDesc = new IOTextLabel(item.DESCRIPTION(), 120, 125 + 40*idx, 12, Color.WHITE);
                IOShape box = new IOShape(new Rectangle(30, 100 + 40*idx, Interface.getInterface().getWidth() - 60, 40));
                
                //Buttons
                IOButton drop =  new IOButton("PLAYER.DROP[" + i + "]" , "DROP", 30, 100 + 40*idx, 40, 40);
                IOButton equip = new IOButton("PLAYER.EQUIP[" + i + "]", "EQUIP", 70, 100 + 40*idx, 40, 40);
                
                //Adds the contents required for this level.
                content.add(box);
                content.add(itemName);
                content.add(itemDesc);
                content.add(drop);
                content.add(equip);
                
                
            } else numInvalid++; // Otherwise, increase the number of skipped items because this one was skipped.
        }
        
        //Draws only if the player's inventory is empty. Basically, it tells the
        //player that his/her Inventory is empty.
        if(itemsSkipped == inv.size()) {
            content.add(new IOTextLabel("Empty", 40, 120, 16, Color.WHITE));
        }
        
        return content;
        
    }
    
    
    
    @Override
    public void clickOperation(int x, int y) {
        
    }
    
    
}
