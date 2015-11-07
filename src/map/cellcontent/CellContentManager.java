/**
 * CellCOntentManager.java
 * 
 * Christopher Hittner (c) 2015
 */
package map.cellcontent;

import java.util.ArrayList;
import java.util.List;

/**
 * A CellContentManager manages a set of CellContents for a Cell by holding onto
 * them in a list for when the Cell that is using the object needs them.
 *
 * @author Christopher Hittner
 */
public class CellContentManager {
    private final ArrayList<CellContent> contents;
    /**
     * Creates a CellContentManager with no items to manage.
     */
    public CellContentManager() {
        contents = new ArrayList<>();
    }
    
    /**
     * Creates a CellContentManager based off of an arbitrary set of parameters.
     * @param items The parameters.
     */
    public CellContentManager(CellContent... items) {
        
        //Allows the default constructor to execute so that the ArrayList can be created.
        this();
        
        //Adds all of the items.
        for(int i = 0; i < items.length; i++)
            contents.add(items[i]);
    }
    
    /**
     * Creates a CellContentManager based off of a List object.
     * @param items The list of items to manage.
     */
    public CellContentManager(List<CellContent> items) {
        //Creates the CellContentManager using an array of the contents.
        this((CellContent[]) items.toArray());
        
    }
    
    /**
     * Gets the number of contents that this Object is overseeing.
     * @return The size of the list of contents.
     */
    public int size() {
        return contents.size();
    }
    
    /**
     * Gets the CellContent object at a certain position in the list.
     * @param index The index to retrieve.
     * @return The requested CellContent object.
     */
    public CellContent get(int index) {
        return contents.get(index);
    }
    
    /**
     * Removes the CellContent object at a given index in the list.
     * @param index The index to get.
     * @return The removed object.
     */
    public CellContent remove(int index) {
        return contents.remove(index);
    }
    
    /**
     * Adds an item to the list of managed CellContents.
     * @param cc The CellContent to add.
     */
    public void add(CellContent cc) {
        contents.add(cc);
    }
    
}
