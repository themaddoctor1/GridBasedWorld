/**
 * Inventory.java
 * 
 * Christopher Hittner (c) 2015
 */

package items;

import java.util.ArrayList;
import java.util.List;

/**
 * An Inventory holds a set of Items, and is utilized by a Creature
 * to keep track of its Items.
 * 
 * @author Christopher Hittner
 */
public class Inventory {
    private final ArrayList<Item> contents;
    /**
     * Creates an Item with no items to manage.
     */
    public Inventory() {
        contents = new ArrayList<>();
    }
    
    /**
     * Creates an Item based off of an arbitrary set of parameters.
     * @param items The parameters.
     */
    public Inventory(Item... items) {
        
        //Allows the default constructor to execute so that the ArrayList can be created.
        this();
        
        //Adds all of the items.
        for(int i = 0; i < items.length; i++)
            contents.add(items[i]);
    }
    
    /**
     * Creates an Item based off of a List object.
     * @param items The list of items to manage.
     */
    public Inventory(List<Item> items) {
        //Creates the Inventory using an array of the contents.
        this((Item[]) items.toArray());
        
    }
    
    /**
     * Gets the number of contents that this Object is overseeing.
     * @return The size of the list of contents.
     */
    public int size() {
        return contents.size();
    }
    
    /**
     * Gets the Item object at a certain position in the list.
     * @param index The index to retrieve.
     * @return The requested Item object.
     */
    public Item get(int index) {
        return contents.get(index);
    }
    
    /**
     * Removes the Item object at a given index in the list.
     * @param index The index to get.
     * @return The removed object.
     */
    public Item remove(int index) {
        return contents.remove(index);
    }
    
    /**
     * Adds an item to the list of managed Items.
     * @param cc The Item to add.
     */
    public void add(Item cc) {
        contents.add(cc);
    }
}
