/**
 * Loadout.java
 * 
 * Christopher Hittner (c) 2015
 */
package items;

/**
 * Holds a Creature's item set. Can be edited to incorporate clothing items.
 * 
 * @author Christopher
 */
public class Loadout {
    private Inventory inventory = new Inventory();
    
    private Item inHand = null;
    
    /**
     * Equips an item, or empties the hand slot.
     * @param slot The item's index in the Inventory.
     */
    public void equipItem(int slot) {
        //Puts the held item into the inventory.
        inventory.add(inHand);
        //Empties the hand
        inHand = null;
        //If the index is out of bounds (excluding the replaced item), then put it into the hand.
        if(slot < inventory.size()-1)
            inHand = inventory.remove(slot);
    }
    
    /**
     * Returns the currently held item.
     * @return The item held.
     */
    public Item getHeldItem() {
        return inHand;
    }
    
    /**
     * Gets the Inventory for the loadout.
     * @return The Inventory.
     */
    public Inventory getInventory() {
        return inventory;
    }
    
    
}
